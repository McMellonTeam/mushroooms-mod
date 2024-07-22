package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Fertilizable;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

public class FleurBerries extends Block implements Fertilizable {
    public static final IntProperty AGE = Properties.AGE_3;
    private static final VoxelShape SHAPE = Block.createCuboidShape(2d, 0d, 2d, 14d, 28d, 14d);

    public FleurBerries(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return ModBlocks.FLEUR_BERRIES.getDefaultState().with(Properties.AGE_3, Random.create().nextBetween(0, 3));
    }


    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return state.get(AGE) <= 3;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        int i = state.get(AGE);
        if (i < 3) {
            world.setBlockState(pos, state.with(AGE, i + 1));
        }
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isIn(BlockTags.DIRT);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.PASS;
        if ((player.getMainHandStack().getItem() == Items.BONE_MEAL || player.getOffHandStack().getItem() == Items.BONE_MEAL)) {
            if (state.get(AGE) == 3) {
                Block.dropStacks(state, world, pos);
            }
            return ActionResult.PASS;
        }
        if (state.get(AGE) != 0) {
            int f = 1;
            world.setBlockState(pos, state.with(AGE, 0));
            this.dropExperience((ServerWorld) world, pos, 1);
            world.playSound(null, pos, SoundEvents.BLOCK_CAVE_VINES_BREAK, SoundCategory.BLOCKS, state.get(AGE), 1.0f);
            if (player.getOffHandStack().getItem() == Items.SHEARS || player.getMainHandStack().getItem() == Items.SHEARS) {
                f = 2;
            }
            Block.dropStack(world, pos, new ItemStack(ModItems.YELLOW_BERRIES, f * state.get(AGE)));
            return ActionResult.SUCCESS;
        }
        return ActionResult.PASS;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (Random.create().nextInt(10) != 0) return;
        if (state.get(AGE) == 3) return;
        world.setBlockState(pos, state.with(AGE, state.get(AGE) + 1));
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }
}
