package net.rodofire.mushrooomsmod.recipe.book;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;

public class ModBooksCategory {
    public static final RecipeBookCategory FORGING = register("forging");

    public static RecipeBookCategory register(String id) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, Identifier.of(MushrooomsMod.MOD_ID, id), new RecipeBookCategory());
    }

    public static void registerModBooksCategory(){
        MushrooomsMod.LOGGER.info("Registering Book Category");
    }
}
