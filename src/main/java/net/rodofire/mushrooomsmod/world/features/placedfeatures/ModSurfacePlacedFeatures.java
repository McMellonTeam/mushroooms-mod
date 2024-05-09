package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModSurfacePlacedFeatures {
    //Very huge names but anyway
    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE_PLACED_KEY = registerKey("pink_luminescent_mushrooom_tree_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_TREE_PLACED_KEY = registerKey("blue_mushrooom_tree_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_TREE_PLACED_KEY = registerKey("purple_mushrooom_tree_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_TREE_PLACED_KEY = registerKey("green_mushrooom_tree_placed_key");

    //Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_PLACED_KEY = registerKey("pink_luminescent_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_PLACED_KEY = registerKey("luminescent_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_PLACED_KEY = registerKey("blue_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_PLACED_KEY = registerKey("green_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_PLACED_KEY = registerKey("purple_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM_PLACED_KEY = registerKey("orange_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_MUSHROOM_PLACED_KEY = registerKey("yellow_mushroom_placed_key");

    //Flowers Mushrooms
    public static final RegistryKey<PlacedFeature> STERILE_BLUE_MUSHROOM_PLACED_KEY = registerKey("sterile_blue_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN_PLACED_KEY = registerKey("mushroom_small_brown_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED_PLACED_KEY = registerKey("mushroom_small_red_placed_key");

    //flowers
    public static final RegistryKey<PlacedFeature> OCULAE_PLACED_KEY = registerKey("oculae_placed_key");
    public static final RegistryKey<PlacedFeature> CYANUS_RUBENS_PLACED_KEY = registerKey("cyanus_rubens_placed_key");
    public static final RegistryKey<PlacedFeature> SOL_OCCIDENTIS_PLACED_KEY = registerKey("sol_occidentis_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FLOWERS_PLACED_KEY = registerKey("mushroom_flowers_placed_key");
    public static final RegistryKey<PlacedFeature> RED_LUMERIA_PLACED_KEY = registerKey("red_lumeria_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTO_PINK_SCHROOM_PLACED_KEY = registerKey("prehisto_pink_schroom_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTURPLE_SCHROOM_PLACED_KEY = registerKey("prehisturple_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTO_BLUE_SCHROOM_PLACED_KEY = registerKey("prehisto_blue_placed_key");
    public static final RegistryKey<PlacedFeature> PREHISTO_GREEN_SCHROOM_PLACED_KEY = registerKey("prehisto_green_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_PERENNIAL_PLACED_KEY = registerKey("yellow_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> PINK_PERENNIAL_PLACED_KEY = registerKey("pink_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_PERENNIAL_PLACED_KEY = registerKey("blue_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_PERENNIAL_PLACED_KEY = registerKey("green_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> LUMINESCENT_PERENNIAL_PLACED_KEY = registerKey("luminescent_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> ORANGE_PERENNIAL_PLACED_KEY = registerKey("orange_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_PERENNIAL_PLACED_KEY = registerKey("purple_perennial_placed_key");
    public static final RegistryKey<PlacedFeature> RED_QUINCE_PLACED_KEY = registerKey("red_quince_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_QUINCE_PLACED_KEY = registerKey("yellow_quince_placed_key");
    public static final RegistryKey<PlacedFeature> TINY_LILAC_PLACED_KEY = registerKey("tiny_lilac_placed_key");
    public static final RegistryKey<PlacedFeature> YELICE_PLACED_KEY = registerKey("yelice_placed_key");
    public static final RegistryKey<PlacedFeature> FLAMESTHYSIA_PLACED_KEY = registerKey("flamesthysia_placed_key");
    public static final RegistryKey<PlacedFeature> APAGANTHE_PLACED_KEY = registerKey("apaganthe_placed_key");
    public static final RegistryKey<PlacedFeature> PINK_HEATER_PLACED_KEY = registerKey("pink_heater_placed_key");
    public static final RegistryKey<PlacedFeature> WYSTERIA_PLACED_KEY = registerKey("wysteria_placed_key");
    public static final RegistryKey<PlacedFeature> BLUEBELL_PLACED_KEY = registerKey("bluebell_placed_key");
    public static final RegistryKey<PlacedFeature> VIPERIN_PLACED_KEY = registerKey("viperin_placed_key");
    public static final RegistryKey<PlacedFeature> HIBISCUS_PLACED_KEY = registerKey("hibiscus_placed_key");
    public static final RegistryKey<PlacedFeature> DIANTHUS_PLACED_KEY = registerKey("dianthus_placed_key");
    public static final RegistryKey<PlacedFeature> CYCAS_PLACED_KEY = registerKey("cycas_placed_key");
    public static final RegistryKey<PlacedFeature> ARUM_PLACED_KEY = registerKey("arum_placed_key");
    public static final RegistryKey<PlacedFeature> HYDRANGEA_PLACED_KEY = registerKey("hydrangea_placed_key");
    public static final RegistryKey<PlacedFeature> ANEMONE_PLACED_KEY = registerKey("anemone_placed_key");
    public static final RegistryKey<PlacedFeature> JACYNTHE_PLACED_KEY = registerKey("jacynthe_placed_key");
    public static final RegistryKey<PlacedFeature> ACONIT_PLACED_KEY = registerKey("aconit_placed_key");
    public static final RegistryKey<PlacedFeature> PERVENCHE_PLACED_KEY = registerKey("pervenche_placed_key");

    //Grass
    public static final RegistryKey<PlacedFeature> TINY_GRASS_PLACED_KEY = registerKey("tiny_grass_placed_key");

    //Bush
    public static final RegistryKey<PlacedFeature> BUSH_SURFACE_PLACED_KEY = registerKey("bush_surface_placed_key");
    public static final RegistryKey<PlacedFeature> COLORFUL_BUSH_SURFACE_PLACED_KEY = registerKey("colorful_bush_placed_key");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //Mushrooms
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.LUMINESCENT_PINK_MUSHROOM));

        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STERILE_BLUE_MUSHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_KEY), RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers
        register(context, OCULAE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OCULAE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CYANUS_RUBENS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SOL_OCCIDENTIS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_FLOWERS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_LUMERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_LUMERIA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PREHISTURPLE_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_GREEN_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_BLUE_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_PINK_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, YELLOW_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GREEN_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUMINESCENT_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELLOW_QUINCE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE_KEY), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, RED_QUINCE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_QUINCE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TINY_LILAC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_LILAC_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELICE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELICE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, FLAMESTHYSIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, APAGANTHE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APAGANTHE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_HEATER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_HEATER_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WYSTERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WYSTERIA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUEBELL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBELL_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, VIPERIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIPERIN_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HIBISCUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HIBISCUS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DIANTHUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIANTHUS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CYCAS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYCAS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ARUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARUM_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HYDRANGEA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ANEMONE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ANEMONE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, JACYNTHE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACYNTHE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ACONIT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACONIT_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PERVENCHE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERVENCHE_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Grass
        register(context, TINY_GRASS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_GRASSS_KEY), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Bush
        register(context, BUSH_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BUSH_KEY), CountPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, COLORFUL_BUSH_SURFACE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COLORFUL_BUSH_KEY), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(MushrooomsMod.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
