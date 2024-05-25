package net.rodofire.mushrooomsmod.item.Custom;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CrushableItems extends Item {
    Item crushed;

    public CrushableItems(Item crushed, Settings settings) {
        super(settings);
        this.crushed = crushed;
    }

    public static ItemStack getCrushed(ItemStack stack) {
        Item item = stack.getItem();
        if (stack.getItem().equals(Items.DIAMOND)) return ModItems.CRUSHED_DIAMOND.asItem().getDefaultStack();
        return null;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.crushable_items"));
        super.appendTooltip(stack, world, tooltip, context);
    }
}
