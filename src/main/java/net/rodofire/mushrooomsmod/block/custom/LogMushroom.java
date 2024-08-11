package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class LogMushroom extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(0, 3, 4, 8, 13, 12);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(8, 3, 4, 16, 13, 12);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(4, 3, 0, 12, 13, 8);
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(4, 3, 8, 12, 13, 16);
    public LogMushroom(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH:
                return NORTH_SHAPE;
            case SOUTH:
                return SOUTH_SHAPE;
            case WEST:
                return WEST_SHAPE;
            default:
                return EAST_SHAPE;
        }
    }

    private boolean canPlaceOn(BlockView world, BlockPos pos, Direction side) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isIn(BlockTags.LOGS);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = state.get(FACING);
        return this.canPlaceOn(world, pos.offset(direction.getOpposite()), direction) && (world.getBlockState(pos).isAir() || world.getBlockState(pos).getBlock() == this);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!canPlaceAt(state, world, pos)) return Blocks.AIR.getDefaultState();
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        World world = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        BlockState blockState = this.getDefaultState();
        Direction[] direction = ctx.getPlacementDirections();
        for (int i = 0; i < direction.length; i++) {
            Direction direction1 = direction[i];
            if (direction1.getAxis().isHorizontal()) {
                blockState = blockState.with(FACING, direction1.getOpposite());
                if (blockState.canPlaceAt(world, blockPos)) {
                    return blockState;
                }
            }
        }
        return null;
    }
}
