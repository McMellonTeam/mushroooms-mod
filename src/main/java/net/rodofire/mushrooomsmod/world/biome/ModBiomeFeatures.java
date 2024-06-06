package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;

public class ModBiomeFeatures {

    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static void addBlueLuminescentCaveFlowers(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_UP_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FUTIALI_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYANEA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.NOCTULICA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TURQUOSUM_STILUS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PLATUM_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.SAPHIRA_FLORENS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_DOWN_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TALL_GRASS_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY);
    }

    public static void addMushroomCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.MUSHROOM_ISLAND_VEGETATION);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_BROWN_MUSHROOM_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BROWN_MUSHROOM_UNDERGROUNG_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_MUSHROOM_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_BROWN_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_RED_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FERTILE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HANGING_ROOTS_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_DEATH_TRUMPET_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TINY_GRASS_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_LUMERIA_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FLOWERS_UNDERGROUND_PLACED_KEY);
    }

    public static void addColorfulPlainsFeatures(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_BUSH_SURFACE_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_PERENNIAL_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_PERENNIAL_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_PERENNIAL_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LUMINESCENT_PERENNIAL_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.YELLOW_PERENNIAL_PLACED_KEY);
    }

    public static void addCrystalCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL_PILLAR_UNDERGROUND_PLACED_KEY);
    }


}
