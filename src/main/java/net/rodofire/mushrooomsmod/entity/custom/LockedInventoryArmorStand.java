package net.rodofire.mushrooomsmod.entity.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtElement;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LockedInventoryArmorStand extends InventoryArmorStandEntity {
    private final List<UUID> autorizedPlayers = new ArrayList<>();
    private UUID keyUUID;

    public LockedInventoryArmorStand(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    public UUID getKeyUUID() {
        return keyUUID;
    }

    public void setKeyUUID(UUID keyUUID) {
        System.out.println("uuid: " + this.keyUUID);
        this.keyUUID = keyUUID;
        System.out.println("uuid: " + this.keyUUID);
    }

    public void addAutorizedPlayer(UUID uuid) {
        autorizedPlayers.add(uuid);
    }

    public List<UUID> getAutorizedPlayers() {
        return autorizedPlayers;
    }

    @Override
    public boolean canPlayerUse(PlayerEntity entity) {
        return autorizedPlayers.contains(entity.getUuid());
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        writeCommonNbt(nbt);
        NbtList nbtList4 = new NbtList();
        for (UUID uuid : autorizedPlayers) {
            NbtCompound nbtCompound2 = new NbtCompound();
            nbtCompound2.putUuid("uuid", uuid);

            nbtList4.add(nbtCompound2);
        }

        nbt.put("player_uuid", nbtList4);

        NbtCompound keyCompound = new NbtCompound();

        if (keyUUID != null)
            keyCompound.putUuid("key_uuid_most", keyUUID);

        nbt.put("key_uuid", keyCompound);
    }


    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        readCommonNbt(nbt);
        if (nbt.contains("player_uuid")) {
            NbtList nbtList = nbt.getList("player_uuid", NbtElement.COMPOUND_TYPE);
            for (int i = 0; i < nbtList.size(); ++i) {
                this.autorizedPlayers.add(i, nbtList.getCompound(i).getUuid("uuid"));
            }
        }
        if (nbt.contains("key_uuid")) {
            NbtCompound nbtCompound = nbt.getCompound("key_uuid");
            keyUUID = nbtCompound.getUuid("key_uuid_most");
        }
    }
}
