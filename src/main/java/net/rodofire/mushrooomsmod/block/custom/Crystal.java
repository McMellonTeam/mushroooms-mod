package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class Crystal extends Block {
    public static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 16, 13);

    public Crystal(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public static final DirectionProperty VERTICAL_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final IntProperty STAGE = Properties.AGE_1;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE, VERTICAL_DIRECTION);
    }


    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = getDirection((World) world, pos, state.get(VERTICAL_DIRECTION));
        return canPlace(direction, world, pos, state);
    }

    public boolean canPlace(Direction direction, WorldView world, BlockPos pos, BlockState state) {
        if (direction == null) return false;
        BlockState blockState = world.getBlockState(pos.offset(direction.getOpposite()));
        System.out.println(blockState+" "+state);
        return state.equals(blockState) || blockState.isOpaqueFullCube(world, pos);
    }

    public Direction getDirection(World world, BlockPos pos, Direction direction) {
        Direction direction2;
        if (canPlace(direction, world, pos, world.getBlockState(pos))) {
            direction2 = direction;
        } else if (canPlace(direction.getOpposite(), world, pos, world.getBlockState(pos))) {
            direction2 = direction.getOpposite();
        } else {
            return null;
        }
        return direction2;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        System.out.println(state);
        if (!canPlaceAt(state, world, pos)) world.setBlockState(pos, Blocks.AIR.getDefaultState());
        setBlockstate(world, pos, state, state.get(VERTICAL_DIRECTION));
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    public void setBlockstate(World world, BlockPos pos, BlockState state, Direction dir) {
        if (world.getBlockState(pos.offset(dir.getOpposite())).getBlock() == this) {
            world.setBlockState(pos, state.with(STAGE, 1).with(VERTICAL_DIRECTION, getDirection(world, pos, dir)));
        } else world.setBlockState(pos, state.with(STAGE, 0).with(VERTICAL_DIRECTION, getDirection(world, pos, dir)));
    }

}
