package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Arm;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

public class InventoryArmorStandEntity extends LivingEntity implements GeoEntity {
    protected static final TrackedData<Boolean> CAN_USE = DataTracker.registerData(InventoryArmorStandEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected final DefaultedList<ItemStack> heldItems = DefaultedList.ofSize(2, ItemStack.EMPTY);
    protected final DefaultedList<ItemStack> armorItems = DefaultedList.ofSize(4, ItemStack.EMPTY);
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(36, ItemStack.EMPTY);
    private int lefttickusage;

    public InventoryArmorStandEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public DefaultedList<DefaultedList<ItemStack>> getInventory() {
        DefaultedList<DefaultedList<ItemStack>> inventoryLists = DefaultedList.ofSize(3, DefaultedList.of());

        inventoryLists.set(0, heldItems);
        inventoryLists.set(1, armorItems);
        inventoryLists.set(2, inventory);

        return inventoryLists;
    }

    public void setInventory(DefaultedList<DefaultedList<ItemStack>> inventory) {
        DefaultedList<ItemStack> held = inventory.get(0);
        DefaultedList<ItemStack> armor = inventory.get(1);
        DefaultedList<ItemStack> base = inventory.get(2);
        for (int i = 0; i < held.size(); i++) {
            heldItems.set(i, held.get(i));
        }
        for (int i = 0; i < armor.size(); i++) {
            armorItems.set(i, armor.get(i));
        }
        for (int i = 0; i < base.size(); i++) {
            this.inventory.set(i, base.get(i));
        }
    }


    @Override
    public boolean shouldRenderName() {
        return false;
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
            case HUMANOID_ARMOR: {
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
            case HUMANOID_ARMOR: {
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
        if (player.getBlockPos().getX() != this.getBlockPos().getX() || player.getBlockPos().getY() != this.getBlockPos().getY() || player.getBlockPos().getZ() != this.getBlockPos().getZ())
            return;
        if (!this.canUse()) return;
        if (!this.canPlayerUse(player)) return;
        //Get player inventory and store it and give the previous inventory to the player
        for (int i = 1; i < 36; i++) {
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
        ItemStack pstack = player.getInventory().getStack(0);
        ItemStack pstack2 = player.getInventory().getStack(40);
        ItemStack istack = this.heldItems.get(0);
        ItemStack istack2 = this.heldItems.get(1);
        this.heldItems.set(0, pstack);
        this.heldItems.set(1, pstack2);
        player.getInventory().setStack(0, istack);
        player.getInventory().setStack(40, istack2);
        this.setUse(false);
        this.lefttickusage = 160;
    }

    public boolean canPlayerUse(PlayerEntity entity) {
        return true;
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

    @Override
    protected void pushAway(Entity entity) {
    }

    public boolean canUse() {
        return this.dataTracker.get(CAN_USE);
    }

    public void setUse(boolean bl) {
        this.dataTracker.set(CAN_USE, bl);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(CAN_USE, true);
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

    protected void writeCommonNbt(NbtCompound nbt) {
        NbtList nbtList = new NbtList();
        NbtList nbtList2 = new NbtList();
        NbtList nbtList3 = new NbtList();
        for (ItemStack itemStack : this.armorItems) {
            if (itemStack != null && !itemStack.isEmpty())
                nbtList3.add(itemStack.toNbt(this.getRegistryManager()));
        }
        nbt.put("ArmorItems", nbtList);

        for (ItemStack itemStack : this.heldItems) {
            if (itemStack != null && !itemStack.isEmpty())
                nbtList3.add(itemStack.toNbt(this.getRegistryManager()));
        }
        nbt.put("HeldItem", nbtList2);

        for (ItemStack itemStack : this.inventory) {
            if (itemStack != null && !itemStack.isEmpty())
                nbtList3.add(itemStack.toNbt(this.getRegistryManager()));
        }
        nbt.put("Inventory", nbtList3);
    }

    protected void readCommonNbt(NbtCompound nbt) {
        NbtCompound nbtCompound;
        if (nbt.contains("ArmorItems", NbtElement.LIST_TYPE)) {
            NbtList nbtList = nbt.getList("ArmorItems", NbtElement.COMPOUND_TYPE);
            for (int i = 0; i < this.armorItems.size(); ++i) {
                nbtCompound = nbtList.getCompound(i);
                this.armorItems.set(i, ItemStack.fromNbtOrEmpty(this.getRegistryManager(), nbtCompound));
            }
        }
        if (nbt.contains("HeldItem", NbtElement.LIST_TYPE)) {
            NbtList nbtList = nbt.getList("HeldItem", NbtElement.COMPOUND_TYPE);
            for (int i = 0; i < this.heldItems.size(); ++i) {
                nbtCompound = nbtList.getCompound(i);
                this.armorItems.set(i, ItemStack.fromNbtOrEmpty(this.getRegistryManager(), nbtCompound));
            }
        }
        if (nbt.contains("Inventory", NbtElement.LIST_TYPE)) {
            NbtList nbtList = nbt.getList("Inventory", NbtElement.COMPOUND_TYPE);
            for (int i = 0; i < this.inventory.size(); ++i) {
                nbtCompound = nbtList.getCompound(i);
                this.inventory.set(i, ItemStack.fromNbtOrEmpty(this.getRegistryManager(), nbtCompound));
            }
        }
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        writeCommonNbt(nbt);
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        readCommonNbt(nbt);
    }

    @Override
    public void onDeath(DamageSource damageSource) {
        World world = this.getWorld();
        if (world.isClient) return;
        if (world instanceof ServerWorld serverWorld) {
            for (ItemStack itemStack : this.inventory) {
                this.dropStack(serverWorld, itemStack);
            }
            for (ItemStack itemStack : this.armorItems) {
                this.dropStack(serverWorld, itemStack);
            }
            for (ItemStack itemStack : this.heldItems) {
                this.dropStack(serverWorld, itemStack);
            }
        }
        super.onDeath(damageSource);
    }

    @Override
    public void takeKnockback(double strength, double x, double z) {
    }
}
