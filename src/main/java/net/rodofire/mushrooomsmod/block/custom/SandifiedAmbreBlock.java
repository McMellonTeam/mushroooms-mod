package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SandifiedAmbreBlock extends BlockBrushableBlock {

    public SandifiedAmbreBlock(Settings settings, Block block) {
        super(settings, block);
    }


    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(Text.translatable("tooltip.mushrooomsmod.sandified_ambre").formatted(Formatting.GOLD));
        super.appendTooltip(stack, context, tooltip, options);
    }
}
