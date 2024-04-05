package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.datagen.recipe.ForgeRecipeBuilder;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        //Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COMPRESSED_PURPLE_MUSHROOM, 1)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input(Character.valueOf('R'), ModItems.PURPLE_MUSHROOM_POWDER)
                .criterion(hasItem(ModItems.PURPLE_MUSHROOM_POWDER), conditionsFromItem(ModItems.PURPLE_MUSHROOM_POWDER))
                .offerTo(exporter, new Identifier(("compressed_purple_mushroom_craft")));


        //Food
        offerPressurePlateRecipe(exporter, ModItems.BAGUETTE, Items.BREAD);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .input(Character.valueOf('#'), Items.WHEAT)
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier("baguettess_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .input(Character.valueOf('#'), ModBlocks.BLUE_LUMINESCENT_MUSHROOM)
                .input(Character.valueOf('C'), Items.BOWL)
                .pattern(" # ")
                .pattern("#C#")
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier("blue_luminescent_soup_craft"));


        //Lights
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_LANTERN, 1)
                .pattern("RRR")
                .pattern("RSR")
                .pattern("RRR")
                .input(Character.valueOf('R'), Items.IRON_NUGGET)
                .input(Character.valueOf('S'), ModBlocks.GREEN_TORCH)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(ModBlocks.GREEN_TORCH), conditionsFromItem(ModBlocks.GREEN_TORCH))
                .offerTo(exporter, new Identifier("green_lantern_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_LANTERN, 1)
                .pattern("RRR")
                .pattern("RSR")
                .pattern("RRR")
                .input(Character.valueOf('R'), Items.IRON_NUGGET)
                .input(Character.valueOf('S'), Blocks.REDSTONE_TORCH)
                .criterion(hasItem(Items.IRON_NUGGET), conditionsFromItem(Items.IRON_NUGGET))
                .criterion(hasItem(Blocks.REDSTONE_TORCH), conditionsFromItem(Blocks.REDSTONE_TORCH))
                .offerTo(exporter, new Identifier("red_lantern_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.GREEN_TORCH, 1)
                .pattern("RS")
                .input(Character.valueOf('R'), Blocks.TORCH)
                .input(Character.valueOf('S'), Items.GREEN_DYE)
                .criterion(hasItem(Blocks.TORCH), conditionsFromItem(Blocks.TORCH))
                .criterion(hasItem(Items.GREEN_DYE), conditionsFromItem(Items.GREEN_DYE))
                .offerTo(exporter, new Identifier("green_torch_craft"));

        //dye
        //yellow
        offerSingleOutputShapelessRecipe(exporter, Items.YELLOW_DYE, ModBlocks.YELLOW_QUINCE, "yellow_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.YELLOW_DYE, ModBlocks.YELLOW_PERENNIAL, "yellow_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.YELLOW_DYE, ModBlocks.YELICE, "yellow_dye");

        //orange
        offerSingleOutputShapelessRecipe(exporter, Items.ORANGE_DYE, ModBlocks.SOL_OCCIDENTIS, "orange_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.ORANGE_DYE, ModBlocks.ORANGE_PERENNIAL, "orange_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.ORANGE_DYE, ModBlocks.FLAMESTHYSIA, "orange_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.ORANGE_DYE, ModBlocks.HIBISCUS, "orange_dye");

        //red
        offerSingleOutputShapelessRecipe(exporter, Items.RED_DYE, ModBlocks.PREHISTORIC_ROSE, "red_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.RED_DYE, ModBlocks.RED_QUINCE, "red_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.RED_DYE, ModBlocks.OCULAE, "red_dye");

        //light blue
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.LUMINESCENT_PERENNIAL, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.CYANEA, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.FUTIALI, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.NOCTULICA, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.TURQUOSUM_STILUS, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.SAPHIRA_FLORENS, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.CAERULEA_VOLUBILIS, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.APAGANTHE, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.PLATUM, "light_blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.LIGHT_BLUE_DYE, ModBlocks.PERVENCHE, "light_blue_dye");

        //blue
        offerSingleOutputShapelessRecipe(exporter, Items.BLUE_DYE, ModBlocks.BLUE_PERENNIAL, "blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.BLUE_DYE, ModBlocks.BLUEBELL, "blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.BLUE_DYE, ModBlocks.ANEMONE, "blue_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.BLUE_DYE, ModBlocks.JACYNTHE, "blue_dye");

        //purple
        offerSingleOutputShapelessRecipe(exporter, Items.PURPLE_DYE, ModBlocks.PURPLE_PERENNIAL, "purple_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PURPLE_DYE, ModBlocks.WYSTERIA, "purple_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PURPLE_DYE, ModBlocks.TINY_LILAC, "purple_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PURPLE_DYE, ModBlocks.ACONIT, "purple_dye");

        //pink
        offerSingleOutputShapelessRecipe(exporter, Items.PINK_DYE, ModBlocks.PINK_PERENNIAL, "pink_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PINK_DYE, ModBlocks.PINK_HEATER, "pink_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PINK_DYE, ModBlocks.DIANTHUS, "pink_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PINK_DYE, ModBlocks.CYCAS, "pink_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.PINK_DYE, ModBlocks.HYDRANGEA, "pink_dye");

        //green
        offerSingleOutputShapelessRecipe(exporter, Items.GREEN_DYE, ModBlocks.GREEN_PERENNIAL, "green_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.GREEN_DYE, ModBlocks.VIPERIN, "green_dye");
        offerSingleOutputShapelessRecipe(exporter, Items.GREEN_DYE, ModBlocks.ARUM, "green_dye");


        //Construction Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVA_BLACKSTONE_BRICKS, 4)
                .pattern("RR")
                .pattern("RR")
                .input(Character.valueOf('R'), ModBlocks.LAVA_BLACKSTONE)
                .criterion(hasItem(ModBlocks.LAVA_BLACKSTONE), conditionsFromItem(ModBlocks.LAVA_BLACKSTONE))
                .offerTo(exporter, new Identifier("lava_blackstone_bricks_craft"));

        offerPressurePlateRecipe(exporter, ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS, ModBlocks.LAVA_BLACKSTONE_BRICKS);
        offerPressurePlateRecipe(exporter, ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS, ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);

        //utils
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModBlocks.FORGE_BLOCK)
                .pattern("RRR")
                .pattern(" S ")
                .pattern("SRS")
                .input(Character.valueOf('R'),Blocks.IRON_BLOCK)
                .input(Character.valueOf('S'),Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Blocks.IRON_BLOCK))
                .offerTo(exporter, new Identifier("forge_craft"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.FORGE_BLOCK)
                .pattern("S S")
                .pattern("SRS")
                .pattern(" S ")
                .input(Character.valueOf('S'), Items.IRON_INGOT)
                .input(Character.valueOf('R'), Blocks.ANVIL)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Blocks.ANVIL))
                .offerTo(exporter, new Identifier("forge_craft_with_anvil"));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.IRON_HAMMER)
                .pattern("BBB")
                .pattern("ISI")
                .pattern(" S ")
                .input(Character.valueOf('S'), Items.STICK)
                .input(Character.valueOf('B'), Blocks.IRON_BLOCK)
                .input(Character.valueOf('I'), Items.IRON_INGOT)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Blocks.IRON_BLOCK))
                .offerTo(exporter, new Identifier("hammer_craft"));


        //Forge Recipe
        new ForgeRecipeBuilder(Items.DIAMOND,ModItems.CRUSHED_DIAMOND ,1)
                .criterion(hasItem(Items.DIAMOND), conditionsFromItem(Items.DIAMOND))
                .offerTo(exporter);
    }
}
