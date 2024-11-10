package net.rodofire.mushrooomsmod.compat;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.recipe.RecipeEntry;
import net.rodofire.mushrooomsmod.recipe.ForgeRecipe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ForgeDisplay extends BasicDisplay {
    private RecipeEntry<ForgeRecipe> recipe;

    public ForgeDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public ForgeDisplay(RecipeEntry<ForgeRecipe> recipe) {
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getOutput()))));
        this.recipe = recipe;
    }



    private static List<EntryIngredient> getInputList(ForgeRecipe recipe) {
        if (recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        list.add(EntryIngredients.ofIngredient(recipe.getRecipeItem()));
        return list;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return ForgeCategory.FORGE_EMPOWERING;
    }
}
