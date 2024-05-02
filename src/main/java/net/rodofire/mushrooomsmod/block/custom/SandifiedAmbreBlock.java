package net.rodofire.mushrooomsmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SandifiedAmbreBlock extends BlockBrushableBlock {

    public SandifiedAmbreBlock(Settings settings, Block block) {
        super(settings, block);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.sandified_ambre"));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
