package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.rodofire.mushrooomsmod.block.ModBlocks;
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
        offerPressurePlateRecipe(exporter,ModItems.BAGUETTE , Items.BREAD);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BAGUETTE, 1)
                .input(Character.valueOf('#'), Items.WHEAT)
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(Items.WHEAT), conditionsFromItem(Items.WHEAT))
                .offerTo(exporter, new Identifier("baguettess_craft"));


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
        offerSingleOutputShapelessRecipe(exporter,Items.YELLOW_DYE,ModBlocks.YELLOW_QUINCE,"lyellow_quince_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.YELLOW_DYE,ModBlocks.YELLOW_PERENNIAL,"yellow_perennial_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.YELLOW_DYE,ModBlocks.YELICE,"yelice_dye_craft");

        //orange
        offerSingleOutputShapelessRecipe(exporter,Items.ORANGE_DYE,ModBlocks.SOL_OCCIDENTIS,"orange_sol_occidentis_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.ORANGE_DYE,ModBlocks.ORANGE_PERENNIAL,"orange_perennial_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.ORANGE_DYE,ModBlocks.FLAMESTHYSIA,"flamesthysia_dye_craft");

        //red
        offerSingleOutputShapelessRecipe(exporter,Items.RED_DYE,ModBlocks.PREHISTORIC_ROSE,"red_prehistoric_rose_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.RED_DYE,ModBlocks.RED_QUINCE,"red_quince_dye_craft");

        //light blue
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.LUMINESCENT_PERENNIAL,"luminescent_perennial_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.CYANEA,"cyanea_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.FUTIALI,"futiali_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.NOCTULICA,"noctulica_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.TURQUOSUM_STILUS,"turquosum_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.SAPHIRA_FLORENS,"saphira_florens_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.CAERULEA_VOLUBILIS,"caerulea_volubilis_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.LIGHT_BLUE_DYE,ModBlocks.APAGANTHE,"apaganthe_dye_craft");

        //blue
        offerSingleOutputShapelessRecipe(exporter,Items.BLUE_DYE,ModBlocks.BLUE_PERENNIAL,"blue_perennial_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.BLUE_DYE,ModBlocks.BLUEBELL,"bluebelll_dye_craft");

        //purple
        offerSingleOutputShapelessRecipe(exporter,Items.PURPLE_DYE,ModBlocks.PURPLE_PERENNIAL,"purple_perennial_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.PURPLE_DYE,ModBlocks.WYSTERIA,"wysteria_dye_craft");

        //pink
        offerSingleOutputShapelessRecipe(exporter,Items.PINK_DYE,ModBlocks.PINK_PERENNIAL,"pink_perennial_dye_craft");
        offerSingleOutputShapelessRecipe(exporter,Items.PINK_DYE,ModBlocks.PINK_HEATER,"pink_heater_dye_craft");

        //green
        offerSingleOutputShapelessRecipe(exporter,Items.GREEN_DYE,ModBlocks.GREEN_PERENNIAL,"green_perennial_dye_craft");


        //Construction Blocks
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS,ModBlocks.LAVA_BLACKSTONE_BRICKS, 4)
                .pattern("RR")
                .pattern("RR")
                .input(Character.valueOf('R'), ModBlocks.LAVA_BLACKSTONE)
                .criterion(hasItem(ModBlocks.LAVA_BLACKSTONE), conditionsFromItem(ModBlocks.LAVA_BLACKSTONE))
                .offerTo(exporter, new Identifier("lava_blackstone_bricks_craft"));

        offerPressurePlateRecipe(exporter, ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS,ModBlocks.LAVA_BLACKSTONE_BRICKS);
        offerPressurePlateRecipe(exporter, ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS,ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
    }
}
