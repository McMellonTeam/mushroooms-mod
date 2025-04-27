package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.*;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Arm;
import net.minecraft.util.Util;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.rodofire.mushrooomsmod.item.ModItems;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimationState;

public class InventoryArmorStandEntity extends LivingEntity implements GeoEntity {
    protected static final TrackedData<Boolean> CAN_USE = DataTracker.registerData(InventoryArmorStandEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    protected final DefaultedList<ItemStack> heldItems = DefaultedList.ofSize(2, ItemStack.EMPTY);
    protected final DefaultedList<ItemStack> armorItems = DefaultedList.ofSize(4, ItemStack.EMPTY);
    protected final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(36, ItemStack.EMPTY);
    private int lefttickusage;
    public long lastHitTime;
    private boolean invisible;


    public InventoryArmorStandEntity(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
        this.bodyYaw = ((int) (this.bodyYaw / 45.0f)) * 45.0f;
        this.headYaw = ((int) (this.headYaw / 45.0f)) * 45.0f;
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
    public void kill() {
        this.remove(Entity.RemovalReason.KILLED);
        this.emitGameEvent(GameEvent.ENTITY_DIE);
    }


    @Override
    public void setYaw(float yaw) {
        yaw = ((int) (yaw / 45.0f)) * 45.0f;
        super.setYaw(yaw);
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
        return switch (slot.getType()) {
            case HAND -> this.heldItems.get(slot.getEntitySlotId());
            case HUMANOID_ARMOR -> this.armorItems.get(slot.getEntitySlotId());
            default -> ItemStack.EMPTY;
        };
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

    @Override
    public void setHeadYaw(float headYaw) {
        headYaw = ((int) (headYaw / 45.0f)) * 45.0f;
        super.setHeadYaw(headYaw);
    }

    @Override
    public void setBodyYaw(float bodyYaw) {
        bodyYaw = ((int) (bodyYaw / 45.0f)) * 45.0f;
        super.setBodyYaw(bodyYaw);
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
    public void refreshPositionAndAngles(double x, double y, double z, float yaw, float pitch) {
        super.refreshPositionAndAngles(x, y, z, yaw, pitch);
        this.setHeadYaw(yaw);
        this.setBodyYaw(yaw);
    }

    @Override
    protected void updatePostDeath() {
        if (++this.deathTime >= 1 && !this.getWorld().isClient() && !this.isRemoved()) {
            this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_DEATH_PARTICLES);
            this.remove(Entity.RemovalReason.KILLED);
        }
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
    public boolean damage(DamageSource source, float amount) {
        if (this.isRemoved()) {
            return false;
        } else if (this.getWorld() instanceof ServerWorld serverWorld) {
            if (source.isIn(DamageTypeTags.BYPASSES_INVULNERABILITY)) {
                this.kill();
                return false;
            } else if (this.isInvulnerableTo(source) || this.invisible) {
                return false;
            } else if (source.isIn(DamageTypeTags.IS_EXPLOSION)) {
                this.onBreak(serverWorld, source);
                this.kill();
                return false;
            } else if (source.isIn(DamageTypeTags.IGNITES_ARMOR_STANDS)) {
                if (this.isOnFire()) {
                    this.updateHealth(serverWorld, source, 0.15F);
                } else {
                    this.setOnFireFor(5.0F);
                }

                return false;
            } else if (source.isIn(DamageTypeTags.BURNS_ARMOR_STANDS) && this.getHealth() > 0.5F) {
                this.updateHealth(serverWorld, source, 4.0F);
                return false;
            } else {
                boolean bl = source.isIn(DamageTypeTags.CAN_BREAK_ARMOR_STAND);
                boolean bl2 = source.isIn(DamageTypeTags.ALWAYS_KILLS_ARMOR_STANDS);
                if (!bl && !bl2) {
                    return false;
                } else {
                    if (source.getAttacker() instanceof PlayerEntity playerEntity && !playerEntity.getAbilities().allowModifyWorld) {
                        return false;
                    }

                    this.addVelocity(new Vec3d(0,0.3,0));
                    this.velocityDirty = true;

                    if (source.isSourceCreativePlayer()) {
                        this.playBreakSound();
                        this.spawnBreakParticles();
                        this.kill();
                        return true;
                    } else {
                        long l = serverWorld.getTime();
                        if (l - this.lastHitTime > 5L && !bl2) {
                            serverWorld.sendEntityStatus(this, EntityStatuses.HIT_ARMOR_STAND);
                            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, source.getAttacker());
                            this.lastHitTime = l;
                        } else {
                            this.breakAndDropItem(serverWorld, source);
                            this.spawnBreakParticles();
                            this.kill();
                        }

                        return true;
                    }
                }
            }
        } else {
            return false;
        }
    }

    private void breakAndDropItem(ServerWorld world, DamageSource damageSource) {
        ItemStack itemStack = new ItemStack(ModItems.INVENTORY_ARMOR_STAND);
        itemStack.set(DataComponentTypes.CUSTOM_NAME, this.getCustomName());
        Block.dropStack(this.getWorld(), this.getBlockPos(), itemStack);
        this.onBreak(world, damageSource);
    }

    @Override
    public void handleStatus(byte status) {
        if (status == EntityStatuses.HIT_ARMOR_STAND) {
            if (this.getWorld().isClient) {
                this.getWorld().playSound(this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ARMOR_STAND_HIT, this.getSoundCategory(), 0.3F, 1.0F, false);
                this.lastHitTime = this.getWorld().getTime();
            }
        } else {
            super.handleStatus(status);
        }
    }

    private void spawnBreakParticles() {
        if (this.getWorld() instanceof ServerWorld) {
            ((ServerWorld)this.getWorld())
                    .spawnParticles(
                            new BlockStateParticleEffect(ParticleTypes.BLOCK, Blocks.OAK_PLANKS.getDefaultState()),
                            this.getX(),
                            this.getBodyY(0.6666666666666666),
                            this.getZ(),
                            10,
                            (double)(this.getWidth() / 4.0F),
                            (double)(this.getHeight() / 4.0F),
                            (double)(this.getWidth() / 4.0F),
                            0.05
                    );
        }
    }

    private void updateHealth(ServerWorld world, DamageSource damageSource, float amount) {
        float f = this.getHealth();
        f -= amount;
        if (f <= 0.5F) {
            this.onBreak(world, damageSource);
            this.kill();
        } else {
            this.setHealth(f);
            this.emitGameEvent(GameEvent.ENTITY_DAMAGE, damageSource.getAttacker());
        }
    }

    private void playBreakSound() {
        this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(), SoundEvents.ENTITY_ARMOR_STAND_BREAK, this.getSoundCategory(), 1.0F, 1.0F);
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_ARMOR_STAND_BREAK;
    }

    @Override
    public ItemStack getPickBlockStack() {
        return new ItemStack(ModItems.INVENTORY_ARMOR_STAND);
    }

    protected void writeCommonNbt(NbtCompound nbt) {
        NbtList nbtList = new NbtList();
        NbtList nbtList2 = new NbtList();
        NbtList nbtList3 = new NbtList();
        for (ItemStack itemStack : this.armorItems) {
            nbtList3.add(itemStack.encodeAllowEmpty(this.getRegistryManager()));
        }
        nbt.put("ArmorItems", nbtList);

        for (ItemStack itemStack : this.heldItems) {
            nbtList3.add(itemStack.encodeAllowEmpty(this.getRegistryManager()));
        }
        nbt.put("HeldItem", nbtList2);

        for (ItemStack itemStack : this.inventory) {
            nbtList3.add(itemStack.encodeAllowEmpty(this.getRegistryManager()));
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

    private void onBreak(ServerWorld world, DamageSource damageSource) {
        this.playBreakSound();
        this.drop(world, damageSource);

        for (ItemStack itemStack : this.inventory) {
            this.dropStack(itemStack);
        }
        for (ItemStack itemStack : this.armorItems) {
            this.dropStack(itemStack);
        }
        for (ItemStack itemStack : this.heldItems) {
            this.dropStack(itemStack);
        }
    }

    @Override
    public void takeKnockback(double strength, double x, double z) {
    }
}
