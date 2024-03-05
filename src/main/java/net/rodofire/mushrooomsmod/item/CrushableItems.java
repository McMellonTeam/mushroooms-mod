package net.rodofire.mushrooomsmod.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.rodofire.mushrooomsmod.util.ModTags;

public class CrushableItems extends Item {
     Item crushed;
    public CrushableItems(Item crushed,Settings settings) {
        super(settings);
        this.crushed=crushed;
    }
    public static ItemStack getCrushed(ItemStack stack){
        if (stack.getItem().equals(Items.DIAMOND))return ModItems.CRUSHED_DIAMOND.asItem().getDefaultStack();
        return null;
    }

}
