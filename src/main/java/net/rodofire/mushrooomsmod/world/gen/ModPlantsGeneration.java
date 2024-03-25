package net.rodofire.mushrooomsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.rodofire.mushrooomsmod.world.ModPlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.rodofire.mushrooomsmod.world.biome.overworld.ModOverworldBiomes;

public class ModPlantsGeneration {
    public static void generateFlowers() {
        //Flowers Mushrooms
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.STERILE_BLUE_MUSHROOM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MUSHROOM_SMALL_BROWN_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MUSHROOM_SMALL_RED_PLACED_KEY);

        /*BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.OCULAE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CYANUS_RUBENS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CYANEA_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SOL_OCCIDENTIS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FUTIALI_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.MUSHROOM_FLOWERS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_LUMERIA_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TURQUOSUM_STILUS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.NOCTULICA_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.SAPHIRA_FLORENS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PREHISTO_GREEN_SCHROOM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PREHISTO_BLUE_SCHROOM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PREHISTURPLE_SCHROOM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PREHISTO_PINK_SCHROOM_PLACED_KEY);*/

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELLOW_PERENNIAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GREEN_PERENNIAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_PERENNIAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ORANGE_PERENNIAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.LUMINESCENT_PERENNIAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINK_PERENNIAL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModOverworldBiomes.COLORFUL_PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PURPLE_PERENNIAL_PLACED_KEY);

        /*BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.RED_QUINCE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELLOW_QUINCE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TINY_LILAC_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.YELICE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FLAMESTHYSIA_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.APAGANTHE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PINK_HEATER_PLACED_KEY);*/
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.SWAMP, BiomeKeys.MANGROVE_SWAMP), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.WYSTERIA_PLACED_KEY);
        /*BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUEBELL_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.VIPERIN_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HIBISCUS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PLATUM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.DIANTHUS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CYCAS_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ARUM_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.HYDRANGEA_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ANEMONE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.JACYNTHE_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.ACONIT_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.PERVENCHE_PLACED_KEY);*/
    }

    public static void generateGrass(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TINY_GRASS_PLACED_KEY);
    }

    public static void generateVines() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_LUMINESCENT_VINES_PLACED_KEY);
    }
}
