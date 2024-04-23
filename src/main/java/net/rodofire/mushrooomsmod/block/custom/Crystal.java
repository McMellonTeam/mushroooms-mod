package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class Crystal extends Block {
    public Crystal(Settings settings) {
        super(settings);
    }

    public static final DirectionProperty VERTICAL_DIRECTION = Properties.VERTICAL_DIRECTION;
    public static final IntProperty STAGE = Properties.AGE_1;

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE,VERTICAL_DIRECTION);
    }


    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        Direction direction = getDirection((World) world,pos,state.get(VERTICAL_DIRECTION));
        return canPlace(direction, world, pos);
    }

    public boolean canPlace(Direction direction, WorldView world, BlockPos pos) {
        if (direction==null) return false;
        BlockState blockState = world.getBlockState(pos.offset(direction.getOpposite()));
        System.out.println("blockState: "+blockState);
        return blockState.isOf(ModBlocks.BLUE_CRYSTAL) || world.getBlockState(pos.offset(direction.getOpposite())).isOpaqueFullCube(world, pos);
    }

    public Direction getDirection(World world, BlockPos pos,Direction direction) {
        Direction direction2;
        if (canPlace(direction, world, pos)) {
            direction2 = direction;
        }else if (canPlace(direction.getOpposite(), world, pos)) {
            direction2 = direction.getOpposite();
        }else{
            return null;
        }
        return direction2;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        System.out.println(state);
        canPlaceAt(state, world, pos);
        setBlockstate(world,pos,state,state.get(VERTICAL_DIRECTION));
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    public void setBlockstate(World world, BlockPos pos, BlockState state, Direction dir) {
        if (world.getBlockState(pos.offset(dir.getOpposite())).getBlock() == this) {
            world.setBlockState(pos, state.with(STAGE, 1).with(VERTICAL_DIRECTION,getDirection(world,pos,dir)));
        } else world.setBlockState(pos, state.with(STAGE, 0).with(VERTICAL_DIRECTION,getDirection(world,pos,dir)));
    }

}
