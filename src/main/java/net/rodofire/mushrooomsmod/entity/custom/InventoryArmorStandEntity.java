package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.util.Arm;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

public class InventoryArmorStandEntity extends LivingEntity implements GeoEntity {
    protected static final TrackedData<Boolean> CAN_USE = DataTracker.registerData(InventoryArmorStandEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final DefaultedList<ItemStack> heldItems = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private final DefaultedList<ItemStack> armorItems = DefaultedList.ofSize(4, ItemStack.EMPTY);
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(36, ItemStack.EMPTY);
    private int lefttickusage;

    public InventoryArmorStandEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public Iterable<ItemStack> getArmorItems() {
        return this.armorItems;
    }

    @Override
    public ItemStack getEquippedStack(EquipmentSlot slot) {
        switch (slot.getType()) {
            case HAND: {
                return this.heldItems.get(slot.getEntitySlotId());
            }
            case ARMOR: {
                return this.armorItems.get(slot.getEntitySlotId());
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void equipStack(EquipmentSlot slot, ItemStack stack) {
        this.processEquippedStack(stack);
        switch (slot.getType()) {
            case HAND: {
                this.onEquipStack(slot, this.heldItems.set(slot.getEntitySlotId(), stack), stack);
                break;
            }
            case ARMOR: {
                this.onEquipStack(slot, this.armorItems.set(slot.getEntitySlotId(), stack), stack);
            }
        }
    }

    @Override
    public Arm getMainArm() {
        return Arm.RIGHT;
    }

    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        if (!this.canUse()) return;
        System.out.println(player.getInventory().getStack(0) + "  " + player.getInventory().getStack(35) + "  " + player.getInventory().getStack(36));
        //Get player inventory and store it and give the previous inventory to the player
        for (int i = 0; i < 36; i++) {
            ItemStack stack = player.getInventory().getStack(i);
            ItemStack stack2 = this.inventory.get(i);
            this.inventory.set(i, stack);
            player.getInventory().setStack(i, stack2);
        }
        //get Armor Slots
        for (int i = 0; i < 4; i++) {
            ItemStack stack = player.getInventory().getStack(i + 36);
            ItemStack stack2 = this.armorItems.get(i);
            this.armorItems.set(i, stack);
            player.getInventory().setStack(i + 36, stack2);
        }
        /*ItemStack stack = player.getInventory().getStack(45);
        ItemStack stack2 = player.getInventory().getStack(45);
        ItemStack stack1 = this.heldItems.get(0);
        this.heldItems.set(0, stack);
        player.getInventory().setStack(45, stack1);
        this.heldItems.set(1, stack2);
        player.getInventory().setStack(9, stack2);*/
        System.out.println(this.heldItems);
        System.out.println(this.armorItems);
        System.out.println(this.inventory);
        this.setUse(false);
        this.lefttickusage = 400;
    }

    @Override
    public void tick() {
        if (this.lefttickusage > 0) {
            --this.lefttickusage;
            if (this.lefttickusage == 0) {
                this.setUse(true);
            }
        }
        super.tick();
    }

    public boolean canUse() {
        return this.dataTracker.get(CAN_USE);
    }

    public void setUse(boolean bl) {
        this.dataTracker.set(CAN_USE, bl);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(CAN_USE, true);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private PlayState predicate(AnimationState<GeoAnimatable> geoAnimatableAnimationState) {
        if (!this.canUse()) {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.inventory_armor_stand.entity_collision", Animation.LoopType.HOLD_ON_LAST_FRAME));
        } else {
            geoAnimatableAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.inventory_armor_stand.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        return super.writeNbt(nbt);

    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        NbtList nbtList = new NbtList();
    }
}
