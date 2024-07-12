package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.rodofire.mushrooomsmod.block.entity.BoostingMushroomBlockEntity;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BoostingMushroom extends BlockWithEntity {
    public BoostingMushroom(Settings settings) {
        super(settings);
    }

    private static final VoxelShape SHAPE = Block.createCuboidShape(3, 0, 3, 13, 14, 13);


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!canPlaceAt(state, world, pos)) return Blocks.AIR.getDefaultState();
        return state;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isOpaqueFullCube(world, pos.down());
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity) {
            world.playSound(null, pos, ModSounds.BOOST_MUSHROOM, SoundCategory.BLOCKS, 2f, (float) Random.create().nextBetween(1, 30) / 10);
            entity.addVelocity(0.0D, 2D, 0.0D);
            ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 120));
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        world.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        world.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
        world.addParticle(ParticleTypes.SPORE_BLOSSOM_AIR, (double) pos.getX() + random.nextDouble(), (double) pos.getY() + random.nextDouble(), (double) pos.getZ() + random.nextDouble(), 0.0, 0.0, 0.0);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BoostingMushroomBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.boosting_mushroom").formatted(Formatting.BLUE));

        super.appendTooltip(stack, world, tooltip, options);
    }
}
