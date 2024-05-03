package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class BlueLuminescentVines extends Block implements Fertilizable {
    public static final VoxelShape SHAPE = Block.createCuboidShape(6, 0, 6, 10, 16, 10);
    public static final IntProperty STAGE = Properties.AGE_4;

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    public BlueLuminescentVines(Settings settings) {
        super(settings);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (!canPlaceAt(state, world, pos) || world.isClient) return;
        changeBlockState((ServerWorld) world, pos.down(), state);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        while (!world.getBlockState(pos.up()).isOf(Blocks.AIR)) {
            pos = pos.up();
        }
        changeBlockState(world, pos, state);

        world.setBlockState(pos.up(), ModBlocks.CAERULEA_VOLUBILIS.getStateWithProperties(state.with(STAGE, 0)));
    }

    public void changeBlockState(ServerWorld world, BlockPos pos, BlockState state) {
        int stage = maxStage(world, pos);
        BlockPos newpos = pos;
        if (stage < 5) {
            for (int i = 1; i <= stage; ++i) {
                BlockState blockstate = world.getBlockState(newpos);
                if (blockstate.isOf(ModBlocks.CAERULEA_VOLUBILIS)) {
                    world.setBlockState(newpos, ModBlocks.CAERULEA_VOLUBILIS.getStateWithProperties(state.with(STAGE, i)));
                    newpos = newpos.down();
                }
            }
        } else {
            world.setBlockState(pos, ModBlocks.CAERULEA_VOLUBILIS.getStateWithProperties(state.with(STAGE, 1)));
        }
    }

    public Integer maxStage(ServerWorld world, BlockPos pos) {
        int stage = 0;
        for (int i = 1; i < 7; ++i) {
            BlockState blockstate = world.getBlockState(pos);
            if (blockstate.isOf(ModBlocks.CAERULEA_VOLUBILIS)) {
                stage++;
            }
            pos = pos.down();
        }
        return stage;
    }


    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(ModBlocks.CAERULEA_VOLUBILIS)) {
            return true;
        }
        return this.canPlantOnTop(blockState, world, blockPos);
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!state.canPlaceAt(world, pos)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }
}
