package net.rodofire.mushrooomsmod.block.entity;

import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.rodofire.mushrooomsmod.block.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

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
}
