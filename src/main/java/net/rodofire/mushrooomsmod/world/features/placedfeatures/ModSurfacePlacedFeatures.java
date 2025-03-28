package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import net.minecraft.block.Blocks;
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
    //tree
    public static final RegistryKey<PlacedFeature> CHERRY_BLOSSOM_TREE = registerKey("cherry_blossom_tree_feature");
    public static final RegistryKey<PlacedFeature> PELTOGYNE_TREE = registerKey("peltology_tree");
    public static final RegistryKey<PlacedFeature> COLORFUL_TREE = registerKey("colorful_tree");
    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE = registerKey("pink_luminescent_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_TREE = registerKey("blue_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_TREE = registerKey("purple_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_TREE = registerKey("green_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM_TREE = registerKey("orange_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_TREE = registerKey("red_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_TREE = registerKey("brown_mushrooom_tree");

    //Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM = registerKey("pink_luminescent_mushroom");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM = registerKey("luminescent_mushroom");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM = registerKey("blue_mushroom");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM = registerKey("green_mushroom");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM = registerKey("purple_mushroom");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM = registerKey("orange_mushroom");
    public static final RegistryKey<PlacedFeature> YELLOW_MUSHROOM = registerKey("yellow_mushroom");

    //Flowers Mushrooms
    public static final RegistryKey<PlacedFeature> STERILE_BLUE_MUSHROOM = registerKey("sterile_blue_mushroom");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red");

    //flowers
    public static final RegistryKey<PlacedFeature> OCULAE = registerKey("oculae");
    public static final RegistryKey<PlacedFeature> CYANUS_RUBENS = registerKey("cyanus_rubens");
    public static final RegistryKey<PlacedFeature> SOL_OCCIDENTIS = registerKey("sol_occidentis");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FLOWERS = registerKey("mushroom_flowers");
    public static final RegistryKey<PlacedFeature> RED_LUMERIA = registerKey("red_lumeria");
    public static final RegistryKey<PlacedFeature> PREHISTO_PINK_SCHROOM = registerKey("prehisto_pink_schroom");
    public static final RegistryKey<PlacedFeature> PREHISTURPLE_SCHROOM = registerKey("prehisturple");
    public static final RegistryKey<PlacedFeature> PREHISTO_BLUE_SCHROOM = registerKey("prehisto_blue");
    public static final RegistryKey<PlacedFeature> PREHISTO_GREEN_SCHROOM = registerKey("prehisto_green");


    public static final RegistryKey<PlacedFeature> YELLOW_PERENNIAL = registerKey("yellow_perennial");
    public static final RegistryKey<PlacedFeature> PINK_PERENNIAL = registerKey("pink_perennial");
    public static final RegistryKey<PlacedFeature> BLUE_PERENNIAL = registerKey("blue_perennial");
    public static final RegistryKey<PlacedFeature> GREEN_PERENNIAL = registerKey("green_perennial");
    public static final RegistryKey<PlacedFeature> LUMINESCENT_PERENNIAL = registerKey("luminescent_perennial");
    public static final RegistryKey<PlacedFeature> ORANGE_PERENNIAL = registerKey("orange_perennial");
    public static final RegistryKey<PlacedFeature> PURPLE_PERENNIAL = registerKey("purple_perennial");

    public static final RegistryKey<PlacedFeature> SMALL_PATCH_YELLOW_PERENNIAL = registerKey("small_patch_yellow_perennial");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_PINK_PERENNIAL = registerKey("small_patch_pink_perennial");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_BLUE_PERENNIAL = registerKey("small_patch_blue_perennial");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_GREEN_PERENNIAL = registerKey("small_patch_green_perennial");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_LUMINESCENT_PERENNIAL = registerKey("small_patch_luminescent_perennial");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_ORANGE_PERENNIAL = registerKey("small_patch_orange_perennial");
    public static final RegistryKey<PlacedFeature> SMALL_PATCH_PURPLE_PERENNIAL = registerKey("small_patch_purple_perennial");


    public static final RegistryKey<PlacedFeature> RED_QUINCE = registerKey("red_quince");
    public static final RegistryKey<PlacedFeature> YELLOW_QUINCE = registerKey("yellow_quince");
    public static final RegistryKey<PlacedFeature> TINY_LILAC = registerKey("tiny_lilac");
    public static final RegistryKey<PlacedFeature> YELICE = registerKey("yelice");
    public static final RegistryKey<PlacedFeature> FLAMESTHYSIA = registerKey("flamesthysia");
    public static final RegistryKey<PlacedFeature> APAGANTHE = registerKey("apaganthe");
    public static final RegistryKey<PlacedFeature> PINK_HEATER = registerKey("pink_heater");
    public static final RegistryKey<PlacedFeature> WYSTERIA = registerKey("wysteria");
    public static final RegistryKey<PlacedFeature> BLUEBELL = registerKey("bluebell");
    public static final RegistryKey<PlacedFeature> VIPERIN = registerKey("viperin");
    public static final RegistryKey<PlacedFeature> HIBISCUS = registerKey("hibiscus");
    public static final RegistryKey<PlacedFeature> DIANTHUS = registerKey("dianthus");
    public static final RegistryKey<PlacedFeature> CYCAS = registerKey("cycas");
    public static final RegistryKey<PlacedFeature> ARUM = registerKey("arum");
    public static final RegistryKey<PlacedFeature> HYDRANGEA = registerKey("hydrangea");
    public static final RegistryKey<PlacedFeature> ANEMONE = registerKey("anemone");
    public static final RegistryKey<PlacedFeature> JACYNTHE = registerKey("jacynthe");
    public static final RegistryKey<PlacedFeature> ACONIT = registerKey("aconit");
    public static final RegistryKey<PlacedFeature> PERVENCHE = registerKey("pervenche");
    public static final RegistryKey<PlacedFeature> PICK_BLUE = registerKey("pick_blue");

    //Grass
    public static final RegistryKey<PlacedFeature> TINY_GRASS = registerKey("tiny_grass");
    public static final RegistryKey<PlacedFeature> GRASS = registerKey("grass");

    //Bush
    public static final RegistryKey<PlacedFeature> BUSH_SURFACE = registerKey("bush_surface");
    public static final RegistryKey<PlacedFeature> COLORFUL_BUSH = registerKey("colorful_bush");

    //terrain
    public static final RegistryKey<PlacedFeature> SAKURA_ARCH = registerKey("arch");
    public static final RegistryKey<PlacedFeature> SAKURA_ROCK_STRAIGHT = registerKey("sakura_rock_straight_placed");
    public static final RegistryKey<PlacedFeature> SAKURA_ROCK_FLAT = registerKey("sakura_rock_flat_placed");
    public static final RegistryKey<PlacedFeature> SPIRAL_MUSHROOM_FEATURE = registerKey("spiral_mushroom_feature");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //tree
        register(context, CHERRY_BLOSSOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.CHERRY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.2f, 2), Blocks.CHERRY_SAPLING));
        register(context, PELTOGYNE_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PELTOGYNE_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.2f, 2), ModBlocks.PELTOGYNE_SAPLING));
        register(context, COLORFUL_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COLORFUL_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), Blocks.OAK_SAPLING));

        //Mushrooms
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.LUMINESCENT_PINK_MUSHROOM));
        register(context, BLUE_MUSHROOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_MUSHROOM_TREE_WG), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.2f, 3), ModBlocks.BLUE_MUSHROOM));
        register(context, GREEN_MUSHROOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_MUSHROOM_TREE), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_MUSHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_MUSHROOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_MUSHROOM_TREE_WG), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BROWN_MUSHROOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_MUSHROOM_TREE, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STERILE_BLUE_MUSHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_MUSHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM), RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers
        register(context, OCULAE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OCULAE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CYANUS_RUBENS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SOL_OCCIDENTIS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_FLOWERS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_LUMERIA, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_LUMERIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PREHISTURPLE_SCHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_GREEN_SCHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_BLUE_SCHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_PINK_SCHROOM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, YELLOW_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GREEN_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUMINESCENT_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, SMALL_PATCH_YELLOW_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_YELLOW_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_PINK_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PINK_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_BLUE_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_BLUE_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_GREEN_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_GREEN_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_ORANGE_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_ORANGE_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_PURPLE_PERENNIAL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PURPLE_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, YELLOW_QUINCE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_QUINCE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_QUINCE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TINY_LILAC, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_LILAC), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELICE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELICE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, FLAMESTHYSIA, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, APAGANTHE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APAGANTHE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_HEATER, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_HEATER), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WYSTERIA, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WYSTERIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUEBELL, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBELL), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, VIPERIN, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIPERIN), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HIBISCUS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HIBISCUS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DIANTHUS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIANTHUS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());
        register(context, CYCAS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYCAS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ARUM, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARUM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HYDRANGEA, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ANEMONE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ANEMONE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, JACYNTHE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACYNTHE), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ACONIT, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACONIT), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PERVENCHE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERVENCHE), CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PICK_BLUE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PICK_BLUE), CountPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Grass
        register(context, TINY_GRASS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_GRASSS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GRASS, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Bush
        register(context, BUSH_SURFACE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BUSH), CountPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, COLORFUL_BUSH, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.COLORFUL_BUSH), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //terrain
        register(context, SAKURA_ARCH, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAKURA_ARCH), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SAKURA_ROCK_STRAIGHT, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_STRAIGHT), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SAKURA_ROCK_FLAT, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_FLAT), RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SPIRAL_MUSHROOM_FEATURE, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SPIRAL_MUSHROOM), CountPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MushrooomsMod.MOD_ID, name));
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
