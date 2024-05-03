package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class Crystal extends Block {
    public static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 16, 13);
    public static final DirectionProperty VERTICAL_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final IntProperty STAGE = Properties.AGE_1;

    public Crystal(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }


    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE, VERTICAL_DIRECTION);
    }

    public boolean canPlace(World world, BlockPos pos, BlockState state) {
        BlockState blockState = world.getBlockState(pos);
        Direction direction = state.get(VERTICAL_DIRECTION);
        Direction direction2 = direction.getOpposite();
        System.out.println(blockState);
        if (blockState.isOf(this)) direction2 = blockState.get(VERTICAL_DIRECTION);
        return blockState.equals(state) || direction2 == direction || blockState.isSideSolidFullSquare(world, pos, state.get(VERTICAL_DIRECTION));
    }

    public Direction getDirection(BlockState state, World world, BlockPos pos) {
        if (canPlace(world, pos.down(), state)) return Direction.UP;
        else if (canPlace(world, pos.up(), state)) return Direction.DOWN;
        return null;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = getDirection(state, (World) world, pos);
        return direction == Direction.UP || direction == Direction.DOWN;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        Direction direction2 = state.get(VERTICAL_DIRECTION);
        if (!canPlace((World) world, pos.offset(direction2.getOpposite()), state)){
            System.out.println("cant place");
            return Blocks.AIR.getDefaultState();
        }
        if (world.getBlockState(pos.offset(direction)).isOf(this)){
            return state;
        }
        System.out.println("place stage 0");
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public void updateState(World world, BlockPos pos, BlockState state, Direction direction) {
        if (world.getBlockState(pos.offset(direction.getOpposite())).isOf(this)) {
            world.setBlockState(pos.offset(direction.getOpposite()), state.with(STAGE, 1).with(VERTICAL_DIRECTION, direction));
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        Direction direction = ctx.getVerticalPlayerLookDirection().getOpposite();
        BlockPos pos = ctx.getBlockPos();
        BlockState blockState = this.getDefaultState();
        if (canPlace(world, pos.offset(direction.getOpposite()), blockState.with(VERTICAL_DIRECTION, direction))) {
            updateState(world, pos, blockState, direction);
            return blockState.with(VERTICAL_DIRECTION, direction).with(STAGE, 0);
        }
        else if (canPlace(world, pos.offset(direction), blockState.with(VERTICAL_DIRECTION, direction.getOpposite()))) {
            updateState(world, pos, blockState, direction.getOpposite());
            return blockState.with(VERTICAL_DIRECTION, direction.getOpposite()).with(STAGE, 0);
        }
        return null;
    }
}
