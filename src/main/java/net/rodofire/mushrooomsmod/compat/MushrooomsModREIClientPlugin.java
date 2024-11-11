package net.rodofire.mushrooomsmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.recipe.ForgeRecipe;
import net.rodofire.mushrooomsmod.screen.ForgeScreen;

public class MushrooomsModREIClientPlugin implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new ForgeCategory());

        registry.addWorkstations(ForgeCategory.FORGE_EMPOWERING, EntryStacks.of(ModBlocks.FORGE_BLOCK));
    }

    /*@Override
    public void registerDisplays(DisplayRegistry registry) {
        //registry.registerDisplayGenerator(ForgeRecipe.class, ForgeRecipe.Type.INSTANCE);
    }*/

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                ForgeScreen.class,
                ForgeCategory.FORGE_EMPOWERING);
    }
}
