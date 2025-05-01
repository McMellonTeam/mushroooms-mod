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
    public static final RegistryKey<PlacedFeature> CRYING_GREEN_MUSHROOM_TREE = registerKey("crying_green_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM_TREE = registerKey("orange_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_TREE = registerKey("red_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_TREE = registerKey("brown_mushrooom_tree");
    public static final RegistryKey<PlacedFeature> SINUSO_SHROOM = registerKey("sinuso_shroom");

    //Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM = registerKey("pink_luminescent_mushroom");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM = registerKey("luminescent_mushroom");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM = registerKey("blue_mushroom");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM = registerKey("green_mushroom");
    public static final RegistryKey<PlacedFeature> LIGHT_GREEN_MUSHROOM = registerKey("light_green_mushroom");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM = registerKey("purple_mushroom");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM = registerKey("orange_mushroom");
    public static final RegistryKey<PlacedFeature> LIGHT_ORANGE_MUSHROOM = registerKey("light_orange_mushroom");
    public static final RegistryKey<PlacedFeature> YELLOW_MUSHROOM = registerKey("yellow_mushroom");
    public static final RegistryKey<PlacedFeature> LIGHT_YELLOW_MUSHROOM = registerKey("light_yellow_mushroom");

    public static final RegistryKey<PlacedFeature> BIG_PURPLE_MUSHROOM_PLANT = registerKey("big_purple_mushroom_plant");
    public static final RegistryKey<PlacedFeature> TINY_PURPLE_MUSHROOM = registerKey("tiny_purple_mushroom");
    public static final RegistryKey<PlacedFeature> LITTLE_PURPLE_MUSHROOM = registerKey("little_purple_mushroom");
    public static final RegistryKey<PlacedFeature> MEDIUM_PURPLE_MUSHROOM = registerKey("medium_purple_mushroom");
    public static final RegistryKey<PlacedFeature> BIG_PURPLE_MUSHROOM = registerKey("big_purple_mushroom");
    public static final RegistryKey<PlacedFeature> TINY_GREEN_MUSHROOM = registerKey("tiny_green_mushroom");
    public static final RegistryKey<PlacedFeature> LITTLE_GREEN_MUSHROOM = registerKey("little_green_mushroom");
    public static final RegistryKey<PlacedFeature> MEDIUM_GREEN_MUSHROOM = registerKey("medium_green_mushroom");
    public static final RegistryKey<PlacedFeature> BIG_GREEN_MUSHROOM = registerKey("big_green_mushroom");
    public static final RegistryKey<PlacedFeature> BIG_GREEN_MUSHROOM_PLANT = registerKey("big_green_mushroom_plant");

    //Flowers Mushrooms
    public static final RegistryKey<PlacedFeature> STERILE_BLUE_MUSHROOM = registerKey("sterile_blue_mushroom");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red");
    public static final RegistryKey<PlacedFeature> BRIGHT_YELLOW_MUSHROOM = registerKey("bright_yellow_mushroom");
    public static final RegistryKey<PlacedFeature> BUSHY_YELLOW_MUSHROOMS = registerKey("bushy_yellow_mushrooms");

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
    public static final RegistryKey<PlacedFeature> TURQUOSUM_STILUS = registerKey("turquosum_stilus");
    public static final RegistryKey<PlacedFeature> NOCTULICA = registerKey("noctulica");
    public static final RegistryKey<PlacedFeature> LIGHT_RAPANGE_FLOWERS = registerKey("fleur_berries");

    public static final RegistryKey<PlacedFeature> LIGHT_TINY_LILAC = registerKey("light_tiny_lilac");
    public static final RegistryKey<PlacedFeature> LIGHT_APAGANTHE = registerKey("light_apaganthe");
    public static final RegistryKey<PlacedFeature> LIGHT_WYSTERIA = registerKey("light_wysteria");
    public static final RegistryKey<PlacedFeature> LIGHT_BLUEBELL = registerKey("light_bluebell");
    public static final RegistryKey<PlacedFeature> LIGHT_ACONIT = registerKey("light_aconit");
    public static final RegistryKey<PlacedFeature> LIGHT_PERVENCHE = registerKey("light_pervenche");
    public static final RegistryKey<PlacedFeature> MUSHROOM_TALL_YELLOW = registerKey("tall_yellow_mushrooms");

    //Grass
    public static final RegistryKey<PlacedFeature> TINY_GRASS = registerKey("tiny_grass");
    public static final RegistryKey<PlacedFeature> GRASS = registerKey("grass");
    public static final RegistryKey<PlacedFeature> LIGHT_GRASS = registerKey("light_grass");

    //Bush
    public static final RegistryKey<PlacedFeature> BUSH_SURFACE = registerKey("bush");
    public static final RegistryKey<PlacedFeature> COLORFUL_BUSH = registerKey("colorful_bush");

    //terrain
    public static final RegistryKey<PlacedFeature> SAKURA_ARCH = registerKey("arch");
    public static final RegistryKey<PlacedFeature> SAKURA_ROCK_STRAIGHT = registerKey("sakura_rock_straight_placed");
    public static final RegistryKey<PlacedFeature> SAKURA_ROCK_FLAT = registerKey("sakura_rock_flat_placed");
    public static final RegistryKey<PlacedFeature> SPIRAL_MUSHROOM_FEATURE = registerKey("spiral_mushroom_feature");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var registererFeature = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //tree
        register(context, CHERRY_BLOSSOM_TREE, registererFeature.getOrThrow(TreeConfiguredFeatures.CHERRY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.2f, 2), Blocks.CHERRY_SAPLING));
        register(context, PELTOGYNE_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PELTOGYNE_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.2f, 2), ModBlocks.PELTOGYNE_SAPLING));
        register(context, COLORFUL_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.COLORFUL_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), Blocks.OAK_SAPLING));

        //mushrooms
        register(context, GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.GREEN_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_GREEN_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.ORANGE_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_ORANGE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_ORANGE_MUSHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELLOW_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_MUSHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_YELLOW_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_YELLOW_MUSHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, BIG_PURPLE_MUSHROOM_PLANT, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM_PLANT), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TINY_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_PURPLE_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LITTLE_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LITTLE_PURPLE_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MEDIUM_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.MEDIUM_PURPLE_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BIG_PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_PURPLE_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TINY_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_GREEN_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LITTLE_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.LITTLE_GREEN_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MEDIUM_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.MEDIUM_GREEN_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BIG_GREEN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_GREEN_MUSHROOM), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BIG_GREEN_MUSHROOM_PLANT, registererFeature.getOrThrow(ModConfiguredFeatures.BIG_GREEN_MUSHROOM_PLANT), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());


        //Mushrooms trees
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.LUMINESCENT_PINK_MUSHROOM));
        register(context, BLUE_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_MUSHROOM_TREE_WG), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(6, 0.2f, 3), ModBlocks.BLUE_MUSHROOM));
        register(context, GREEN_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.GREEN_MUSHROOM_TREE), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CRYING_GREEN_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.CRYING_GREEN_MUSHROOM_TREE), RarityFilterPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE), CountPlacementModifier.of(10), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.ORANGE_MUSHROOM_TREE_WG), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BROWN_MUSHROOM_TREE, registererFeature.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SINUSO_SHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.SINUSO_SHROOM), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_MUSHROOM_TREE, registererFeature.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.STERILE_BLUE_MUSHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM), RarityFilterPlacementModifier.of(8), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BUSHY_YELLOW_MUSHROOMS, registererFeature.getOrThrow(ModConfiguredFeatures.BUSHY_YELLOW_MUSHROOMS), RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BRIGHT_YELLOW_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BRIGHT_YELLOW_MUSHROOM), RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Flowers
        register(context, OCULAE, registererFeature.getOrThrow(ModConfiguredFeatures.OCULAE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, CYANUS_RUBENS, registererFeature.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SOL_OCCIDENTIS, registererFeature.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_LUMERIA, registererFeature.getOrThrow(ModConfiguredFeatures.RED_LUMERIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, PREHISTURPLE_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_GREEN_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_BLUE_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PREHISTO_PINK_SCHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, YELLOW_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GREEN_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LUMINESCENT_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ORANGE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PURPLE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL), RarityFilterPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, SMALL_PATCH_YELLOW_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_YELLOW_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_PINK_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PINK_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_BLUE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_BLUE_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_GREEN_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_GREEN_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_LUMINESCENT_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_ORANGE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_ORANGE_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SMALL_PATCH_PURPLE_PERENNIAL, registererFeature.getOrThrow(ModConfiguredFeatures.SMALL_PATCH_PURPLE_PERENNIAL), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());


        register(context, YELLOW_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, RED_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.RED_QUINCE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TINY_LILAC, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_LILAC), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, YELICE, registererFeature.getOrThrow(ModConfiguredFeatures.YELICE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, FLAMESTHYSIA, registererFeature.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, APAGANTHE, registererFeature.getOrThrow(ModConfiguredFeatures.APAGANTHE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PINK_HEATER, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_HEATER), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, WYSTERIA, registererFeature.getOrThrow(ModConfiguredFeatures.WYSTERIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, BLUEBELL, registererFeature.getOrThrow(ModConfiguredFeatures.BLUEBELL), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, VIPERIN, registererFeature.getOrThrow(ModConfiguredFeatures.VIPERIN), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HIBISCUS, registererFeature.getOrThrow(ModConfiguredFeatures.HIBISCUS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, DIANTHUS, registererFeature.getOrThrow(ModConfiguredFeatures.DIANTHUS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());
        register(context, CYCAS, registererFeature.getOrThrow(ModConfiguredFeatures.CYCAS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ARUM, registererFeature.getOrThrow(ModConfiguredFeatures.ARUM), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, HYDRANGEA, registererFeature.getOrThrow(ModConfiguredFeatures.HYDRANGEA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ANEMONE, registererFeature.getOrThrow(ModConfiguredFeatures.ANEMONE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, JACYNTHE, registererFeature.getOrThrow(ModConfiguredFeatures.JACYNTHE), CountPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, ACONIT, registererFeature.getOrThrow(ModConfiguredFeatures.ACONIT), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PERVENCHE, registererFeature.getOrThrow(ModConfiguredFeatures.PERVENCHE), CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, PICK_BLUE, registererFeature.getOrThrow(ModConfiguredFeatures.PICK_BLUE), CountPlacementModifier.of(12), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, TURQUOSUM_STILUS, registererFeature.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, NOCTULICA, registererFeature.getOrThrow(ModConfiguredFeatures.NOCTULICA), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_RAPANGE_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_RAPANGE_FLOWERS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        register(context, LIGHT_TINY_LILAC, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_TINY_LILAC), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_APAGANTHE, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_APAGANTHE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_WYSTERIA, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_WYSTERIA), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_BLUEBELL, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_BLUEBELL), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_ACONIT, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_ACONIT), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_PERVENCHE, registererFeature.getOrThrow(ModConfiguredFeatures.LIGHT_PERVENCHE), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, MUSHROOM_TALL_YELLOW, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_TALL_YELLOW), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

        //Grass
        register(context, TINY_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_GRASSS), RarityFilterPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacementModifier.of(16), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, LIGHT_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //Bush
        register(context, BUSH_SURFACE, registererFeature.getOrThrow(ModConfiguredFeatures.BUSH), CountPlacementModifier.of(3), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, COLORFUL_BUSH, registererFeature.getOrThrow(ModConfiguredFeatures.COLORFUL_BUSH), CountPlacementModifier.of(1), SquarePlacementModifier.of(), PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP, BiomePlacementModifier.of());

        //terrain
        register(context, SAKURA_ARCH, registererFeature.getOrThrow(ModConfiguredFeatures.SAKURA_ARCH), RarityFilterPlacementModifier.of(32), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SAKURA_ROCK_STRAIGHT, registererFeature.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_STRAIGHT), RarityFilterPlacementModifier.of(2), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SAKURA_ROCK_FLAT, registererFeature.getOrThrow(ModConfiguredFeatures.SAKURA_ROCK_FLAT), RarityFilterPlacementModifier.of(5), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());
        register(context, SPIRAL_MUSHROOM_FEATURE, registererFeature.getOrThrow(ModConfiguredFeatures.SPIRAL_MUSHROOM), CountPlacementModifier.of(4), SquarePlacementModifier.of(), PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP, BiomePlacementModifier.of());

    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MushrooomsMod.MOD_ID, name + "_surface"));
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
