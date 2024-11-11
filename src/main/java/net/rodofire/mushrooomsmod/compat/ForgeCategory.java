package net.rodofire.mushrooomsmod.compat;

import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.LinkedList;
import java.util.List;

public class ForgeCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE =
            Identifier.of(MushrooomsMod.MOD_ID, "textures/gui/forge_gui.png");
    public static final CategoryIdentifier<ForgeDisplay> FORGE_EMPOWERING =
            CategoryIdentifier.of(MushrooomsMod.MOD_ID, "forge_empowering");

    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return FORGE_EMPOWERING;
    }

    @Override
    public Text getTitle() {
        return Text.literal("Forge Crushing");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.FORGE_BLOCK.asItem().getDefaultStack());
    }

    @Override
    public int getDisplayHeight() {
        return 90;
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        List<Widget> widgets = new LinkedList<>();
        Point startPoint = new Point(bounds.getCenterX() - 87, bounds.getCenterY() - 35);
        widgets.add(Widgets.createTexturedWidget(TEXTURE,
                new Rectangle(startPoint.x, startPoint.y, 175, 182)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 26, startPoint.y + 33))
                .entries(display.getInputEntries().getFirst()));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 134, startPoint.y + 33))
                .markOutput().entries(display.getOutputEntries().getFirst()));
        return widgets;
    }
}
