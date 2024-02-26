package net.rodofire.mushrooomsmod.block.custom;

import net.rodofire.mushrooomsmod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class MushrooomBlock extends Block implements Fertilizable {
    public static Block fermentedblock;
    public static final VoxelShape SHAPE = createCuboidShape(0,0,0,16,16,16);
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    public MushrooomBlock(Block fermentedblock,Settings settings) {
        super(settings);
        this.fermentedblock=fermentedblock;
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return false;
    }


    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        System.out.println("can grow");
        return hasMushrooms(world, pos);
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos,fermentedblock.getDefaultState());
    }

    public boolean hasMushrooms(World world, BlockPos pos){
        System.out.println("has msuhrooms");
        BlockPos.Mutable mutable = pos.mutableCopy();
        for (int i =-3;i<=3;++i){
            for(int j = -3;j<=3;++j) {
                for(int k =-3; k<=3;++k) {
                    mutable.set(pos, i,j,k );
                    BlockState blockState = world.getBlockState(mutable);
                    if(blockState.isIn(ModTags.Blocks.MUSHROOM_PLANT)) {
                        System.out.println("on");
                        return true;
                    }
                }
            }
        }
        System.out.println("false");
        return false;
    }
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        System.out.println("neighbour update");
        canGrow(world,world.getRandom(),pos,state);
    }



}
