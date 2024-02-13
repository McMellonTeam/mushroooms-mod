package net.louis.mushrooomsmod.block.custom.PinkMushroomBlock;

import net.louis.mushrooomsmod.block.ModBlocks;
import net.louis.mushrooomsmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class PinkMushroomVinesHeadBlock extends AbstractPlantStemBlock
        implements Fertilizable,
        PinkMushroomVines{
    private static final float GROW_CHANCE = 0.11f;

    public PinkMushroomVinesHeadBlock(AbstractBlock.Settings settings) {
        super(settings, Direction.DOWN, SHAPE, false, 0.1);
        this.setDefaultState((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AGE, 0)).with(BERRIES, false));
    }

    @Override
    protected int getGrowthLength(Random random) {
        return 1;
    }

    @Override
    protected boolean chooseStemState(BlockState state) {
        return state.isAir();
    }

    @Override
    protected Block getPlant() {
        return ModBlocks.PINK_MUSHROOM_VINES_PLANT;
    }

    @Override
    protected BlockState copyState(BlockState from, BlockState to) {
        return (BlockState)to.with(BERRIES, from.get(BERRIES));
    }

    @Override
    protected BlockState age(BlockState state, Random random) {
        return (BlockState)super.age(state, random).with(BERRIES, random.nextFloat() < 0.11f);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(ModItems.PINK_MUSHROOM_VINES_ITEM);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return PinkMushroomVines.pickBerries(player, state, world, pos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(BERRIES);
    }

    @Override
    public boolean isFertilizable(WorldView world, BlockPos pos, BlockState state, boolean isClient) {
        return state.get(BERRIES) == false;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        world.setBlockState(pos, (BlockState)state.with(BERRIES, true), Block.NOTIFY_LISTENERS);
    }

}
