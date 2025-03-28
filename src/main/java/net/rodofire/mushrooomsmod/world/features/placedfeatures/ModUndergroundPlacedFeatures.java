package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModUndergroundPlacedFeatures {
    //Mushrooms
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM = registerKey("blue_luminescent_mushroom_underground");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM = registerKey("brown_mushroom_underground");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM = registerKey("red_mushroom_underground");
    public static final RegistryKey<PlacedFeature> FERTILE_RED_MUSHROOM = registerKey("fertile_red_mushroom_underground");
    public static final RegistryKey<PlacedFeature> RED_LUMERIA = registerKey("red_lumeria_underground");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FLOWERS = registerKey("mushroom_flowers_underground");

    //Tree
    public static final RegistryKey<PlacedFeature> OAK_TREE = registerKey("oak_tree_underground");
    public static final RegistryKey<PlacedFeature> AZALEA_TREE = registerKey("alazea_tree_underground");
    public static final RegistryKey<PlacedFeature> OAK_BERRIES_TREE = registerKey("oak_berries_tree_underground");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_TREE = registerKey("blue_luminescent_tree_underground");

    //Mushrooms Flowers
    public static final RegistryKey<PlacedFeature> MUSHROOM_SIDE_BLUE_LUMINESCENT = registerKey("mushroom_side_blue_luminescent_underground");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red_underground");
    public static final RegistryKey<PlacedFeature> MUSHROOM_YELLOW = registerKey("mushroom_yellow_underground");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown_underground");
    public static final RegistryKey<PlacedFeature> MUSHROOM_DEATH_TRUMPET = registerKey("mushroom_death_trumpet_underground");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FERTILE_RED_FLOWER = registerKey("mushroom_fertile_red_flower_underground");

    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> HUGE_RED_MUSHROOM = registerKey("huge_red_mushroom_underground");
    public static final RegistryKey<PlacedFeature> HUGE_BROWN_MUSHROOM = registerKey("huge_brown_mushroom_underground");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_TREE = registerKey("blue_luminescent_mushroom_tree_underground");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_TREE = registerKey("purple_mushroom_tree_underground");
    public static final RegistryKey<PlacedFeature> HUGE_PURPLE_MUSHROOM_TREE = registerKey("huge_purple_mushroom_tree_underground");
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_TREE = registerKey("pink_luminescent_mushroom_tree_underground");


    //Flowers
    public static final RegistryKey<PlacedFeature> PLATUM = registerKey("platum_underground");
    public static final RegistryKey<PlacedFeature> SAPHIRA_FLORENS = registerKey("saphira_underground_florens_placed_underground");
    public static final RegistryKey<PlacedFeature> NOCTULICA = registerKey("noctulica_underground");
    public static final RegistryKey<PlacedFeature> TURQUOSUM_STILUS = registerKey("turquosum_stilus_underground");
    public static final RegistryKey<PlacedFeature> FUTIALI = registerKey("futiali_underground");
    public static final RegistryKey<PlacedFeature> CYANEA = registerKey("cyanea_underground");
    public static final RegistryKey<PlacedFeature> YELLOW_QUINCE = registerKey("yellow_quince_underground");
    public static final RegistryKey<PlacedFeature> RED_QUINCE = registerKey("red_quince_underground");
    public static final RegistryKey<PlacedFeature> PINK_HEATER = registerKey("pink_heater_underground");
    public static final RegistryKey<PlacedFeature> OCULAE = registerKey("oculae_underground");
    public static final RegistryKey<PlacedFeature> CYCAS = registerKey("cycas_underground");
    public static final RegistryKey<PlacedFeature> RAPANGE_FLOWERS = registerKey("rapange_flowers_underground");
    public static final RegistryKey<PlacedFeature> FLEUR_BERRIES = registerKey("fleur_berries_underground");
    public static final RegistryKey<PlacedFeature> YELICE = registerKey("yelice_underground");
    public static final RegistryKey<PlacedFeature> DEEP_YELICE = registerKey("deep_yelice_underground");

    //Grass
    public static final RegistryKey<PlacedFeature> TINY_GRASS = registerKey("tiny_grass_underground");
    public static final RegistryKey<PlacedFeature> GRASS = registerKey("grass_underground");
    public static final RegistryKey<PlacedFeature> DEEP_GRASS = registerKey("deep_grass_underground");
    public static final RegistryKey<PlacedFeature> DEEP_TALL_GRASS = registerKey("deep_tall_grass_underground");
    public static final RegistryKey<PlacedFeature> GRASS_BLUE_LUMINESCENT = registerKey("grass_blue_luminescent_underground");
    public static final RegistryKey<PlacedFeature> TALL_GRASS_BLUE_LUMINESCENT = registerKey("tall_grass_blue_luminescent_underground");

    //Vines
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_UP = registerKey("blue_luminescent_vines_underground");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_DOWN = registerKey("blue_luminescent_vines_down_underground");
    public static final RegistryKey<PlacedFeature> HANGING_ROOTS = registerKey("hanging_roots_underground");
    public static final RegistryKey<PlacedFeature> GLOW_LICHEN = registerKey("glow_lichen_underground");
    public static final RegistryKey<PlacedFeature> VINES = registerKey("vines_underground");

    //bushes
    public static final RegistryKey<PlacedFeature> CAVE_BUSH = registerKey("cave_bush_underground");
    public static final RegistryKey<PlacedFeature> CAVE_TOP_BUSH = registerKey("cave_top_bush_underground");

    //Crystal
    public static final RegistryKey<PlacedFeature> RED_CRYSTAL = registerKey("red_crystal_underground");
    public static final RegistryKey<PlacedFeature> BLUE_CRYSTAL = registerKey("blue_crystal_underground");
    public static final RegistryKey<PlacedFeature> WHITE_CRYSTAL = registerKey("white_crystal_underground");
    public static final RegistryKey<PlacedFeature> RED_CRYSTAL_PILLAR = registerKey("red_crystal_pillar_underground");
    public static final RegistryKey<PlacedFeature> BLUE_CRYSTAL_PILLAR = registerKey("blue_crystal_pillar_underground");
    public static final RegistryKey<PlacedFeature> WHITE_CRYSTAL_PILLAR = registerKey("white_crystal_pillar_underground");
    public static final RegistryKey<PlacedFeature> CRYSTAL_BLUE = registerKey("crystal_blue_underground");

    //Ore
    public static final RegistryKey<PlacedFeature> RHYOLITE = registerKey("rhyolite_underground");
    public static final RegistryKey<PlacedFeature> AMBER_MINERAL = registerKey("amber_mineral_underground");

    //terrain
    public static final RegistryKey<PlacedFeature> ROCKY_STALACTITE = registerKey("rocky_stalactite_underground");
    public static final RegistryKey<PlacedFeature> MOSSY_STALACTITE = registerKey("mossy_stalactite_underground");
    public static final RegistryKey<PlacedFeature> HUGE_STALACTITE = registerKey("huge_stalactite_underground");
    public static final RegistryKey<PlacedFeature> TINY_PUDDLE = registerKey("tiny_puddle_underground");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        RegistryEntryLookup<ConfiguredFeature<?, ?>> registererFeature = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        //Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM), CountPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_YELLOW, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_MUSHROOM), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_DEATH_TRUMPET, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED), CountPlacementModifier.of(60), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, BROWN_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.BROWN_MUSHROOM), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.RED_MUSHROOM), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_LUMERIA, registererFeature.getOrThrow(ModConfiguredFeatures.RED_LUMERIA), CountPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS), CountPlacementModifier.of(18), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_FERTILE_RED_FLOWER, registererFeature.getOrThrow(ModConfiguredFeatures.MUSHROOM_RED_FERTILE_FLOWER), CountPlacementModifier.of(12), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());

        //Flowers
        register(context, TURQUOSUM_STILUS, registererFeature.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, NOCTULICA, registererFeature.getOrThrow(ModConfiguredFeatures.NOCTULICA), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, SAPHIRA_FLORENS, registererFeature.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, FUTIALI, registererFeature.getOrThrow(ModConfiguredFeatures.FUTIALI), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, PLATUM, registererFeature.getOrThrow(ModConfiguredFeatures.PLATUM), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, CYANEA, registererFeature.getOrThrow(ModConfiguredFeatures.CYANEA), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, YELLOW_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_QUINCE, registererFeature.getOrThrow(ModConfiguredFeatures.RED_QUINCE), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, PINK_HEATER, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_HEATER), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, OCULAE, registererFeature.getOrThrow(ModConfiguredFeatures.OCULAE), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, CYCAS, registererFeature.getOrThrow(ModConfiguredFeatures.CYCAS), CountPlacementModifier.of(29), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RAPANGE_FLOWERS, registererFeature.getOrThrow(ModConfiguredFeatures.RAPANGE_FLOWERS), CountPlacementModifier.of(24), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, FLEUR_BERRIES, registererFeature.getOrThrow(ModConfiguredFeatures.FLEUR_BERRIES), CountPlacementModifier.of(14), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, YELICE, registererFeature.getOrThrow(ModConfiguredFeatures.YELICE), CountPlacementModifier.of(25), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, DEEP_YELICE, registererFeature.getOrThrow(ModConfiguredFeatures.YELICE), CountPlacementModifier.of(55), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());

        //Grass
        register(context, GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS), CountPlacementModifier.of(45), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, DEEP_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.DENSE_GRASS), CountPlacementModifier.of(160), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, DEEP_TALL_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.DENSE_TALL_GRASS), CountPlacementModifier.of(160), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, TINY_GRASS, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_GRASSS), CountPlacementModifier.of(14), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, GRASS_BLUE_LUMINESCENT, registererFeature.getOrThrow(ModConfiguredFeatures.GRASS_BLUE_LUMINESCENT), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, TALL_GRASS_BLUE_LUMINESCENT, registererFeature.getOrThrow(ModConfiguredFeatures.TALL_GRASS_BLUE_LUMINESCENT), CountPlacementModifier.of(7), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Vines
        register(context, BLUE_LUMINESCENT_VINES_UP, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_UP), CountPlacementModifier.of(9), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_VINES_DOWN, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_DOWN), CountPlacementModifier.of(7), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, HANGING_ROOTS, registererFeature.getOrThrow(ModConfiguredFeatures.HANGING_ROOT), CountPlacementModifier.of(80), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, GLOW_LICHEN, registererFeature.getOrThrow(UndergroundConfiguredFeatures.GLOW_LICHEN), CountPlacementModifier.of(130), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, VINES, registererFeature.getOrThrow(ModConfiguredFeatures.VINES), CountPlacementModifier.of(230), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());

        //bushes
        register(context, CAVE_BUSH, registererFeature.getOrThrow(ModConfiguredFeatures.CAVE_BUSH), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, CAVE_TOP_BUSH, registererFeature.getOrThrow(ModConfiguredFeatures.CAVE_TOP_BUSH), CountPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());


        //Huge Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE), CountPlacementModifier.of(140), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_BROWN_MUSHROOM, registererFeature.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), CountPlacementModifier.of(165), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_RED_MUSHROOM, registererFeature.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), CountPlacementModifier.of(170), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, FERTILE_RED_MUSHROOM, registererFeature.getOrThrow(ModConfiguredFeatures.FERTILE_RED_MUSHROOM), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, PURPLE_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PURPLE_MUSHROOM_TREE), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.PINK_LUMINESCENT_MUSHROOM_TREE), CountPlacementModifier.of(240), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Tree
        register(context, OAK_TREE, registererFeature.getOrThrow(TreeConfiguredFeatures.OAK), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(90, 1f, 45), Blocks.OAK_SAPLING));
        register(context, OAK_BERRIES_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.OAK_BERRIES_TREE), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(240, 1f, 10), ModBlocks.OAK_BERRIES_SAPLING));
        register(context, AZALEA_TREE, registererFeature.getOrThrow(TreeConfiguredFeatures.AZALEA_TREE), ModPlacedFeatures.undergroundStoneLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(230, 1f, 6), Blocks.AZALEA));
        register(context, BLUE_LUMINESCENT_TREE, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_TREE), ModPlacedFeatures.undergroundDeepslateLevelTreeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(150, 1f, 6), ModBlocks.BLUE_LUMINESCENT_SAPPLING));


        //Crystal
        register(context, RED_CRYSTAL, registererFeature.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL), CountPlacementModifier.of(40), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_CRYSTAL, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL), CountPlacementModifier.of(40), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, WHITE_CRYSTAL, registererFeature.getOrThrow(ModConfiguredFeatures.WHITE_CRYSTAL), CountPlacementModifier.of(40), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_CRYSTAL_PILLAR, registererFeature.getOrThrow(ModConfiguredFeatures.RED_CRYSTAL_PILLAR), CountPlacementModifier.of(13), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_CRYSTAL_PILLAR, registererFeature.getOrThrow(ModConfiguredFeatures.BLUE_CRYSTAL_PILLAR), CountPlacementModifier.of(13), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, WHITE_CRYSTAL_PILLAR, registererFeature.getOrThrow(ModConfiguredFeatures.WHITE_CRYSTAL_PILLAR), CountPlacementModifier.of(13), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, CRYSTAL_BLUE, registererFeature.getOrThrow(ModConfiguredFeatures.CRYSTAL_BLUE), CountPlacementModifier.of(26), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());

        //Ore
        register(context, RHYOLITE, registererFeature.getOrThrow(ModConfiguredFeatures.RHYOLITE),
                ModOrePlacement.modifiersWithCount(12, // Veins per Chunk
                        HeightRangePlacementModifier.uniform(YOffset.fixed(10), YOffset.fixed(80))));

        register(context, AMBER_MINERAL, registererFeature.getOrThrow(ModConfiguredFeatures.AMBER_MINERAL), RarityFilterPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());

        //terrain
        register(context, ROCKY_STALACTITE, registererFeature.getOrThrow(ModConfiguredFeatures.ROCKY_STALACTITE), CountPlacementModifier.of(30), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, MOSSY_STALACTITE, registererFeature.getOrThrow(ModConfiguredFeatures.MOSSY_STALACTITE), CountPlacementModifier.of(18), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_STALACTITE, registererFeature.getOrThrow(ModConfiguredFeatures.HUGE_STALACTITE), CountPlacementModifier.of(25), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, ModPlacedFeatures.SOLID_STATE_CAVE, BiomePlacementModifier.of());
        register(context, TINY_PUDDLE, registererFeature.getOrThrow(ModConfiguredFeatures.TINY_PUDDLE), CountPlacementModifier.of(250), SquarePlacementModifier.of(), ModPlacedFeatures.CAVE_LEVEL, BiomePlacementModifier.of());

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
