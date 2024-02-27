package net.rodofire.mushrooomsmod.block.custom.PinkLuminescentVines;

import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PinkLuminescentBodyVinesBlock extends Block implements Fertilizable {
    public static final VoxelShape SHAPE = Block.createCuboidShape(6.0, 0.0, 6.0, 8.0, 16.0, 8.0);
    public static BooleanProperty MANY_VINES = BooleanProperty.of("many_vines");



    public PinkLuminescentBodyVinesBlock(Block.Settings settings) {
        super(settings);
    }
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(MANY_VINES);
    }

    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify){
        BlockState blocAuDessus = world.getBlockState(pos.up());
        if ((blocAuDessus.getBlock() == ModBlocks.LUMINESCENT_PINK_MUSHROOM_BLOCK || blocAuDessus.getBlock() == ModBlocks.PINK_LUMINESCENT_BODY_VINES) && state.get(MANY_VINES)){

            BlockState blockState = (BlockState)state.with(MANY_VINES, false);
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);

        }
    }





    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }
    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return false;
    }
    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {

    }
}
