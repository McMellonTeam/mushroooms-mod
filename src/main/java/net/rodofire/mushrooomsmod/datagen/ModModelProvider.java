package net.rodofire.mushrooomsmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        //Blocks
        //Mushrooms Blocks
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PURPLE_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.ORANGE_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.ORANGE_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.YELLOW_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.YELLOW_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.BLUE_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.GREEN_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.PINK_LUMINESCENT_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.RED_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.RED_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.RED_FERMENTED_MUSHROOM_BLOCK);

        generator.registerSimpleCubeAll(ModBlocks.BROWN_ALTERED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BROWN_DEGRADATED_MUSHROOM_BLOCK);
        generator.registerSimpleCubeAll(ModBlocks.BROWN_FERMENTED_MUSHROOM_BLOCK);




        generator.registerSimpleCubeAll(ModBlocks.TRANSPARENT_MUSHROOM_STEM);
        generator.registerSimpleCubeAll(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM);
        generator.registerSimpleCubeAll(ModBlocks.GREEN_MUSHROOM_STEM);
        generator.registerSimpleCubeAll(ModBlocks.COMPRESSED_PURPLE_MUSHROOM);

        //Soft Blocks
        generator.registerSimpleCubeAll(ModBlocks.COMPRESSED_DIRT);
        generator.registerSimpleCubeAll(ModBlocks.LIGHT_COMPRESSED_DIRT);

        //Hard Blocks
        generator.registerSimpleCubeAll(ModBlocks.RHYOLITE);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE);

        //Potted Flowers
        generator.registerFlowerPotPlant(ModBlocks.BLUE_MUSHROOM, ModBlocks.POTTED_BLUE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.GREEN_MUSHROOM, ModBlocks.POTTED_GREEN_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PURPLE_MUSHROOM, ModBlocks.POTTED_PURPLE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.BLUE_LUMINESCENT_MUSHROOM, ModBlocks.POTTED_BLUE_LUMINESCENT_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.LUMINESCENT_PINK_MUSHROOM, ModBlocks.POTTED_LUMINESCENT_PINK_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.OCULAE, ModBlocks.POTTED_OCULAE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.CYANEA, ModBlocks.POTTED_CYANEA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.CYANUS_RUBENS, ModBlocks.POTTED_CYANUS_RUBENS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.SOL_OCCIDENTIS, ModBlocks.POTTED_SOL_OCCIDENTIS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.FUTIALI, ModBlocks.POTTED_FUTIALI, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.NOCTULICA, ModBlocks.POTTED_NOCTULICA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTORIC_ROSE, ModBlocks.POTTED_PREHISTORIC_ROSE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTO_PINK_SCHROOM, ModBlocks.POTTED_PREHISTO_PINK_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTO_BLUE_SCHROOM, ModBlocks.POTTED_PREHISTO_BLUE_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTURPLE_SCHROOM, ModBlocks.POTTED_PREHISTURPLE_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PREHISTO_GREEN_SCHROOM, ModBlocks.POTTED_PREHISTO_GREEN_SCHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ORANGE_PERENNIAL, ModBlocks.POTTED_ORANGE_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.BLUE_PERENNIAL, ModBlocks.POTTED_BLUE_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PURPLE_PERENNIAL, ModBlocks.POTTED_PURPLE_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.GREEN_PERENNIAL, ModBlocks.POTTED_GREEN_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.LUMINESCENT_PERENNIAL, ModBlocks.POTTED_LUMINESCENT_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELLOW_PERENNIAL, ModBlocks.POTTED_YELLOW_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PINK_PERENNIAL, ModBlocks.POTTED_PINK_PERENNIAL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.RED_QUINCE, ModBlocks.POTTED_RED_QUINCE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELLOW_QUINCE, ModBlocks.POTTED_YELLOW_QUINCE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELICE, ModBlocks.POTTED_YELICE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.FLAMESTHYSIA, ModBlocks.POTTED_FLAMESTHYSIA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.APAGANTHE, ModBlocks.POTTED_APAGANTHE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.WYSTERIA, ModBlocks.POTTED_WYSTERIA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.BLUEBELL, ModBlocks.POTTED_BLUEBELL, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.VIPERIN, ModBlocks.POTTED_VIPERIN, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.HIBISCUS, ModBlocks.POTTED_HIBISCUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.PLATUM, ModBlocks.POTTED_PLATUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.DIANTHUS, ModBlocks.POTTED_DIANTHUS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.CYCAS, ModBlocks.POTTED_CYCAS, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ARUM, ModBlocks.POTTED_ARUM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.HYDRANGEA, ModBlocks.POTTED_HYDRANGEA, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ANEMONE, ModBlocks.POTTED_ANEMONE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.JACYNTHE, ModBlocks.POTTED_JACYNTHE, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.YELLOW_MUSHROOM, ModBlocks.POTTED_YELLOW_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.ORANGE_MUSHROOM, ModBlocks.POTTED_ORANGE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Potted Flowers Mushrooms
        generator.registerFlowerPotPlant(ModBlocks.STERILE_BLUE_MUSHROOM, ModBlocks.POTTED_STERILE_BLUE_MUSHROOM, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.MUSHROOM_SMALL_BROWN, ModBlocks.POTTED_MUSHROOM_SMALL_BROWN, BlockStateModelGenerator.TintType.NOT_TINTED);
        generator.registerFlowerPotPlant(ModBlocks.MUSHROOM_SMALL_RED, ModBlocks.POTTED_MUSHROOM_SMALL_RED, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Grass
        generator.registerTintableCross(ModBlocks.TINY_GRASS, BlockStateModelGenerator.TintType.NOT_TINTED);

        //Lights
        generator.registerLantern(ModBlocks.RED_LANTERN);
        generator.registerLantern(ModBlocks.GREEN_LANTERN);
        generator.registerTorch(ModBlocks.GREEN_TORCH, ModBlocks.WALL_GREEN_TORCH);

        //Construction Blocks
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE_BRICKS);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE_MEDIUM_BRICKS);
        generator.registerSimpleCubeAll(ModBlocks.LAVA_BLACKSTONE_TINY_BRICKS);

        //Spawn Eggs
        generator.registerParentedItemModel(ModItems.GROKI_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));
        generator.registerParentedItemModel(ModItems.BOLETE_COW_SPAWN_EGG, ModelIds.getMinecraftNamespacedItem("template_spawn_egg"));

        //Crystals
        generator.registerSimpleCubeAll(ModBlocks.PINK_CRYSTAL_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BAGUETTE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIG_GREEN_MUSHROOM_SEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.BIG_PURPLE_MUSHROOM_SEED, Models.GENERATED);
        itemModelGenerator.register(ModItems.CAERULEA_VOLUBILIS_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.HYMNE_URSS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.HYMNE_FRANCAIS_MUSIC_DISC, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_MUSHROOM_VINES_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PINK_CRYSTAL_ITEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.CRUSHED_DIAMOND, Models.GENERATED);
        itemModelGenerator.register(ModItems.LUMINESCENT_SCHROOM_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.PURPLE_MUSHROOM_POWDER, Models.GENERATED);
    }

}
