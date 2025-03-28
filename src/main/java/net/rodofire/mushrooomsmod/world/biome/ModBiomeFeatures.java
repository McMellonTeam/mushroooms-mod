package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.UndergroundPlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModUndergroundPlacedFeatures;

/**
 * Class to manage custom biomes related features
 */
public class ModBiomeFeatures {

    /**
     * method for the default biomes features such as ores / carvers / dungeons ...
     */
    public static void globalOverworldGeneration(GenerationSettings.LookupBackedBuilder builder) {
        DefaultBiomeFeatures.addLandCarvers(builder);
        DefaultBiomeFeatures.addAmethystGeodes(builder);
        DefaultBiomeFeatures.addDungeons(builder);
        DefaultBiomeFeatures.addMineables(builder);
        DefaultBiomeFeatures.addSprings(builder);
        DefaultBiomeFeatures.addFrozenTopLayer(builder);
    }

    public static class SurfaceBiomes {

        public static void addColorfulPlainsFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_BUSH);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.LUMINESCENT_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.YELLOW_PERENNIAL);
        }

        public static void addColorfulForestFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.COLORFUL_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_PURPLE_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_PINK_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_GREEN_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_ORANGE_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SMALL_PATCH_YELLOW_PERENNIAL);
        }

        public static void addMushroomShireFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.ORANGE_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.GREEN_MUSHROOM_TREE);
        }

        public static void addSchroomIsland2Features(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PURPLE_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.RED_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BROWN_MUSHROOM_TREE);
        }

        public static void addBlueMushroomForestFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.BLUE_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.SPIRAL_MUSHROOM_FEATURE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PERVENCHE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PICK_BLUE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.JACYNTHE);
        }

        public static void addMagicalPlainsFeatures(GenerationSettings.LookupBackedBuilder builder) {

        }

        public static void addSakuraForestFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ROCK_STRAIGHT);
            builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ROCK_FLAT);
            builder.feature(GenerationStep.Feature.TOP_LAYER_MODIFICATION, ModSurfacePlacedFeatures.SAKURA_ARCH);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.CHERRY_BLOSSOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PELTOGYNE_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.PATCH_GRASS_PLAIN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_HEATER);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.DIANTHUS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.HYDRANGEA);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_PERENNIAL);
        }
    }


    public static class UndergroundBiome {

        public static void addBlueLuminescentCaveFlowers(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_UP);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FUTIALI);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYANEA);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.NOCTULICA);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TURQUOSUM_STILUS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PLATUM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.SAPHIRA_FLORENS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_DOWN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS_BLUE_LUMINESCENT);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TALL_GRASS_BLUE_LUMINESCENT);
        }

        public static void addMushroomCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, VegetationPlacedFeatures.MUSHROOM_ISLAND_VEGETATION);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_BROWN_MUSHROOM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_RED_MUSHROOM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BROWN_MUSHROOM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_MUSHROOM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_BROWN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_SMALL_RED);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FERTILE_RED_MUSHROOM);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HANGING_ROOTS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_DEATH_TRUMPET);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TINY_GRASS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_LUMERIA);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FLOWERS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_FERTILE_RED_FLOWER);
        }

        public static void addCrystalCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.RED_CRYSTAL_PILLAR);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.BLUE_CRYSTAL_PILLAR);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.WHITE_CRYSTAL_PILLAR);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CRYSTAL_BLUE);
        }

        public static void addForestCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CAVE_VINES);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OAK_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.AZALEA_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OAK_BERRIES_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CLASSIC_VINES_CAVE_FEATURE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.OCULAE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYCAS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PINK_HEATER);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RED_QUINCE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.YELLOW_QUINCE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.RAPANGE_FLOWERS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FLEUR_BERRIES);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.YELICE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GRASS);
        }

        public static void addRockyCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.ROCKY_STALACTITE);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.HUGE_STALACTITE);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.TINY_PUDDLE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GLOW_LICHEN);
        }

        public static void addMossyCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.MOSSY_STALACTITE);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.HUGE_STALACTITE);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.TINY_PUDDLE);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CAVE_TOP_BUSH);
            builder.feature(GenerationStep.Feature.UNDERGROUND_DECORATION, ModUndergroundPlacedFeatures.CAVE_BUSH);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.GLOW_LICHEN);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.VINES);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CAVE_VINES);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_YELICE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.MUSHROOM_YELLOW);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_GRASS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.DEEP_TALL_GRASS);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, UndergroundPlacedFeatures.CLASSIC_VINES_CAVE_FEATURE);
        }

        public static void addPurpleSchroomCaveFeatures(GenerationSettings.LookupBackedBuilder builder) {
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PINK_LUMINESCENT_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PURPLE_MUSHROOM_TREE);
            builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.HUGE_PURPLE_MUSHROOM_TREE);
        }

    }

}
