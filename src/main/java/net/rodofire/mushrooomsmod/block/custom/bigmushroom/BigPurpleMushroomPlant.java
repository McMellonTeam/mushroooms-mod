package net.rodofire.mushrooomsmod.block.custom.bigmushroom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.ModItems;

public class BigPurpleMushroomPlant extends CropBlock implements Fertilizable {
    public static int MAX_AGE = 3;
    public static Block stage0;
    public static Block stage1;
    public static Block stage2;
    public static Block stage3;
    public static final IntProperty AGE = Properties.AGE_3;

    public BigPurpleMushroomPlant(Settings settings, Block stage0, Block stage1, Block stage2, Block stage3) {
        super(settings);
    }


    public void applyGrowth(World world, BlockPos pos, BlockState state) {
        int j;
        int i = this.getAge(state) + this.getGrowthAmount(world);
        if (i > (j = this.getMaxAge())) {
            i = j;
        }
        world.setBlockState(pos, this.withAge(i), Block.NOTIFY_LISTENERS);
    }

    protected int getGrowthAmount(World world) {
        return MathHelper.nextInt(world.random, 1, 1);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        ItemStack itemStack = player.getMainHandStack();
        if (itemStack.getItem() == ModItems.PURPLE_MUSHROOM_POWDER) {
            world.setBlockState(pos, getAgeToBlockstate(getAge(state)), Block.NOTIFY_LISTENERS);
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }


    public static BlockState getAgeToBlockstate(int age) {
        if (age == 0) {
            return ModBlocks.TINY_PURPLE_MUSHROOM.getDefaultState();
        } else if (age == 1) {
            return ModBlocks.LITTLE_PURPLE_MUSHROOM.getDefaultState();
        } else if (age == 2) {
            return ModBlocks.MEDIUM_PURPLE_MUSHROOM.getDefaultState();
        } else {
            return ModBlocks.BIG_PURPLE_MUSHROOM.getDefaultState();
        }
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        this.applyGrowth(world, pos, state);
    }

    @Override
    public ItemConvertible getSeedsItem() {
        return ModItems.BIG_PURPLE_MUSHROOM_SEED;
    }

    @Override
    public IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK) || blockState.isOf(ModBlocks.COMPRESSED_PURPLE_MUSHROOM)) {
            return true;
        }
        return world.getBaseLightLevel(pos, 0) < 13 && this.canPlantOnTop(blockState, world, blockPos);
    }

    protected final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{Block.createCuboidShape(5, 0, 5, 10, 5, 10), Block.createCuboidShape(3, 0, 3, 13, 12, 13), Block.createCuboidShape(4, 0, 4, 12, 16, 12), Block.createCuboidShape(3, 0, 3, 13, 22, 13)};


    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[this.getAge(state)];
    }
}
