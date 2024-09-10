package net.rodofire.mushrooomsmod.item.Custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.entity.ModEntities;
import net.rodofire.mushrooomsmod.entity.custom.InventoryArmorStandEntity;
import net.rodofire.mushrooomsmod.entity.custom.LockedInventoryArmorStand;

import java.util.UUID;
import java.util.function.Consumer;

public class KeyItem extends Item {
    public KeyItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        World world = entity.getEntityWorld();
        if (world.isClient) return ActionResult.PASS;
        ServerWorld worldServer = (ServerWorld) world;

        NbtCompound nbt = stack.getOrCreateNbt();

        if (!nbt.contains(("uuid"))) nbt.putUuid("uuid", UUID.randomUUID());

        if (entity instanceof InventoryArmorStandEntity) {
            //if the type is locked inventory, the player uuid will be added if
            if (entity instanceof LockedInventoryArmorStand inv) {
                if (inv.getKeyUUID() != null) {
                    if (inv.getKeyUUID().equals(nbt.getUuid("uuid")) && !inv.canPlayerUse(user))
                        inv.addAutorizedPlayer(user.getUuid());
                } else {
                    inv.addAutorizedPlayer(user.getUuid());
                    inv.setKeyUUID(nbt.getUuid("uuid"));
                }
            } else {
                DefaultedList<DefaultedList<ItemStack>> inventory = ((InventoryArmorStandEntity) entity).getInventory();
                System.out.println(inventory);
                BlockPos pos = entity.getBlockPos();
                float f = entity.getBodyYaw();
                entity.remove(Entity.RemovalReason.DISCARDED);
                Consumer<LockedInventoryArmorStand> consumer = EntityType.copier(worldServer, stack, user);
                LockedInventoryArmorStand newEntity = ModEntities.LOCKED_INVENTORY_ARMOR_STAND.create(worldServer, nbt, consumer, pos, SpawnReason.SPAWN_EGG, true, true);
                if (newEntity == null) {
                    return ActionResult.FAIL;
                }
                newEntity.setInventory(inventory);
                newEntity.setKeyUUID(nbt.getUuid("uuid"));
                newEntity.refreshPositionAndAngles(entity.getX(), entity.getY(), entity.getZ(), f, 0.0f);
                worldServer.spawnEntityAndPassengers(newEntity);
            }
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
