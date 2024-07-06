package net.rodofire.mushrooomsmod.block.entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ForgeBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    public ForgeBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FORGE_BLOCK_ENTITY, pos, state);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt,inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        inventory.clear();
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    public ItemStack getInventory() {
        return inventory.get(inventory.size() - 1);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }

    public ArrayList<ItemStack> getRenderStack() {
        ArrayList<ItemStack> itemStacks = new ArrayList<>();
        if (inventory.get(0).getCount() == 0 && inventory.get(1).getCount() == 0) itemStacks.add(ItemStack.EMPTY);
        else if (inventory.get(0).getCount() != 0 && inventory.get(1).getCount() == 0) itemStacks.add(inventory.get(0));
        else if (inventory.get(1).getCount() != 0 && inventory.get(0).getCount() == 0) itemStacks.add(inventory.get(1));
        else {
            itemStacks.add(inventory.get(0));
            itemStacks.add(inventory.get(1));
        }
        return itemStacks;
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
