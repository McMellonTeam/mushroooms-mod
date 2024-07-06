package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class SchroomStickEntity extends AnimalEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);


    private int giveup;
    private int ungavingeup;
    private int jump;

    private static final TrackedData<Boolean> GAVING_UP =
            DataTracker.registerData(SchroomStickEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> JUMPING =
            DataTracker.registerData(SchroomStickEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> UNGAVING_UP =
            DataTracker.registerData(SchroomStickEntity.class, TrackedDataHandlerRegistry.BOOLEAN);


    public SchroomStickEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return false;
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, new EscapeDangerGoal(this, 1.0f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.6f, 1));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 6.0f));
        this.goalSelector.add(5, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder setAttributes() {
        return AnimalEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.8f);
    }

    @Override
    public void tick() {
        if (!this.getWorld().isClient) {
            if (this.giveup >= 0) {
                --giveup;
                this.setVelocity(0, 0, 0);
            } else if (this.jump != 0) {
                --this.jump;
                double jumprad = 0.25f*Math.sin(this.jump * 3 * Math.PI / 65) - 0.005f*Math.sin(this.jump*Math.PI / 65);
                this.setVelocity(0.05f, jumprad, 0.05f);
                this.velocityModified = true;

                if (this.jump == 0) {
                    this.setJump(false);
                }
            } else if (this.ungavingeup != 0) {
                --this.ungavingeup;
                if (this.ungavingeup == 0) {
                    this.setUngavingUp(false);
                }
            } else if (this.getWorld().getBlockState(this.getBlockPos()).getBlock() != Blocks.WATER) {

                if (Random.create().nextBetween(0, 400) == 0 && !this.gaveUp()) {
                    this.giveup = 200;
                    this.setGiveup(true);
                } else if (Random.create().nextBetween(0, 200) == 0 && this.gaveUp()) {
                    this.ungavingeup = 200;
                    this.setGiveup(false);
                    this.setUngavingUp(true);
                } else if (Random.create().nextBetween(0, 200) == 0 && !this.gaveUp()) {
                    this.jump = 65;
                    double jumprad = Math.cos(4 * Math.PI) - Math.sin(Math.PI);
                    this.setVelocity(0.05f, jumprad, 0.05f);
                    this.velocityModified = true;
                    this.setJump(true);
                }
            }
        }
        super.tick();
    }



    @Override
    public boolean damage(DamageSource source, float amount) {
        if(this.isJumping()){
            return false;
        }
        return super.damage(source, amount);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        this.dataTracker.set(JUMPING, false);
        this.dataTracker.set(GAVING_UP, false);
        this.dataTracker.set(UNGAVING_UP, false);
    }

    public void setJump(boolean jump) {
        this.dataTracker.set(JUMPING, jump);
    }

    public void setGiveup(boolean giveup) {
        this.dataTracker.set(GAVING_UP, giveup);
    }

    public void setUngavingUp(boolean ungavingUp) {
        this.dataTracker.set(UNGAVING_UP, ungavingUp);
    }

    public boolean isJumping() {
        return this.dataTracker.get(JUMPING);
    }

    public boolean gaveUp() {
        return this.dataTracker.get(GAVING_UP);
    }

    public boolean isUnGavingUp() {
        return this.dataTracker.get(UNGAVING_UP);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (this.gaveUp()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.give_up", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (this.isJumping()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.jump", Animation.LoopType.PLAY_ONCE));
        } else if (this.isUnGavingUp()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.un_gaving_up", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.walk", Animation.LoopType.LOOP));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.schroom_stick.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    static class GiveUpGoal extends Goal {
        private final SchroomStickEntity schroomStickEntity;
        public GiveUpGoal(SchroomStickEntity schroomStickEntity) {
            this.schroomStickEntity = schroomStickEntity;
        }

        @Override
        public boolean canStart() {
            return !this.schroomStickEntity.isJumping();
        }
    }


}
