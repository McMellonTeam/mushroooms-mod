package net.rodofire.mushrooomsmod.block.entity;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class ForgeBlockEntity extends BlockEntity implements ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    public ForgeBlockEntity( BlockPos pos, BlockState state) {
        super(ModBlockEntities.FORGE_BLOCK_ENTITY,pos, state);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
    }
        @Override
    public void readNbt(NbtCompound nbt){
        super.readNbt(nbt);
        Inventories.readNbt(nbt,inventory);
    }
    public ItemStack getInventory(){
        return inventory.get(inventory.size()-1);
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    public ArrayList<ItemStack> getRenderStack(){
        ArrayList<ItemStack> itemStacks = new ArrayList<>();
        if (inventory.get(0).getCount()==0&&inventory.get(1).getCount()==0) itemStacks.add(ItemStack.EMPTY);
        else if (inventory.get(0).getCount()!=0&&inventory.get(1).getCount()==0)itemStacks.add(inventory.get(0));
        else if(inventory.get(1).getCount()!=0&&inventory.get(0).getCount()==0)itemStacks.add(inventory.get(1));
        else {
            itemStacks.add(inventory.get(0));
            itemStacks.add(inventory.get(1));
        }
        return itemStacks;
    }

    @Override
    public void markDirty() {
        world.updateListeners(pos, getCachedState(), getCachedState(), 3);
        super.markDirty();
    }
    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }
}
