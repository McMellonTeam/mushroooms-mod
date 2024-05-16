package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class PlotiEntity extends AnimalEntity implements GeoEntity {

    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected static final TrackedData<Byte> SIT_FLAGS = DataTracker.registerData(PlotiEntity.class, TrackedDataHandlerRegistry.BYTE);
    private boolean sitting;
    public int sittingtime;
    public int unsittingtime;

    public PlotiEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(2, escapeDanger(1.7f));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.6f, 1));
        this.goalSelector.add(4, new LookAroundGoal(this));
    }

    public Goal escapeDanger(double speed){
        if (this.sitting) {
            this.setSit(false);
        }
        return new EscapeDangerGoal(this, speed);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.PLOTI.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    protected void initDataTracker() {
        this.dataTracker.startTracking(SIT_FLAGS, (byte)0);
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (!this.isSit()&&geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.walk", Animation.LoopType.LOOP));
        } else if (this.isSit() && geoAnimatableAnimationState.isMoving()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.side_walking", Animation.LoopType.LOOP));
        } else if (this.isSitting()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.sit", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else if (this.isUnsitting()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.ploti.unsit", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.groki.idle", Animation.LoopType.LOOP));
        }


        return PlayState.CONTINUE;
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("sitting", sitting);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        sitting = nbt.getBoolean("sitting");
    }

    //return if the entity is sit
    public boolean isSit(){
        return this.sitting;
    }
    public void setSit(boolean sit){
        this.sitting = sit;
    }

    @Override
    public void tick() {
        super.tick();
    }

    //return if the entity
    public boolean isSitting(){
        if (this.sittingtime!=0){
            this.sittingtime--;
            return true;
        }
        return false;
    }

    public boolean isUnsitting(){
        if (this.unsittingtime!=0){
            this.unsittingtime--;
            return true;
        }
        return false;
    }
}
