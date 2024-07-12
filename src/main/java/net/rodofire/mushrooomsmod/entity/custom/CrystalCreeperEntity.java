package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.block.custom.StraightCrystal;
import net.rodofire.mushrooomsmod.sound.ModSounds;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class CrystalCreeperEntity extends CustomCreeperEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private int interact;
    private static final int RADIUS = 6;

    /*public CrystalCreeperEntity(EntityType<? extends CreeperEntity> entityType, World world) {
        super(entityType, world);
    }*/

    public CrystalCreeperEntity(EntityType<? extends CustomCreeperEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_creeper.walk", Animation.LoopType.LOOP));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.crystal_creeper.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    //custom explosion
    @Override
    protected void explode() {
        if (!this.getWorld().isClient) {
            float f = this.shouldRenderOverlay() ? 2.0f : 1.0f;
            this.dead = true;
            placeCrystal(this.getWorld(), this.getBlockPos(), RADIUS, f, random);
            this.discard();
            this.spawnEffectsCloud();
        }
    }


    private void placeCrystal(World world, BlockPos pos, int radius, float f, Random random) {
        BlockState blockState = world.getBlockState(pos.down());

        //place crystal if entity is standing on deepslate
        if (blockState.getBlock() == Blocks.DEEPSLATE || blockState.getBlock() == Blocks.COBBLED_DEEPSLATE) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            mutable.set(pos);
            for (int i = 0; i < radius * radius; i++) {
                mutable.set(pos, random.nextBetween(-radius, radius), random.nextBetween(-radius, radius), random.nextBetween(-radius, radius));
                if (world.getBlockState(mutable.down()).isOpaqueFullCube(world, mutable.down()) && world.getBlockState(mutable).isAir()) {
                    Block block = getCrystal();

                    //place crystal column if block is a StraightCrystal
                    if (block instanceof StraightCrystal) {
                        StraightCrystal.generateStraightCrystal(world, mutable, block.getDefaultState(), Random.create().nextBetween(1, 8));
                    } else {
                        world.setBlockState(mutable, block.getDefaultState());
                    }
                }
            }
            world.playSound(null, pos, ModSounds.PINK_CRYSTAL_BREAK, SoundCategory.HOSTILE,2.0f,1.0f);
            return;
        }
        //normal explosion
        this.getWorld().createExplosion(this, this.getX(), this.getY(), this.getZ(), (float) radius * f, World.ExplosionSourceType.MOB);
    }

    private Block getCrystal() {
        return switch (Random.create().nextBetween(0, 3)) {
            case 0 -> ModBlocks.RED_CRYSTAL;
            case 1 -> ModBlocks.WHITE_CRYSTAL;
            //case 2 -> ModBlocks.
            default -> ModBlocks.BLUE_CRYSTAL;
        };
    }
}
