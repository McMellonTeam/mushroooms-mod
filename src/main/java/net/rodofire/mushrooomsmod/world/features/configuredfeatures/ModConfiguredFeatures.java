package net.rodofire.mushrooomsmod.world.features.configuredfeatures;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntryList;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.state.property.Properties;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.world.features.config.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.codetree.*;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.tree.decorator.OakBerriesTreeDecorator;

import java.util.Collections;
import java.util.List;

public class ModConfiguredFeatures<FC extends FeatureConfig> {
    //Tree
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_TREE = registerKey("blue_luminescent_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> OAK_BERRIES_TREE = registerKey("oak_berries_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PELTOGYNE_TREE = registerKey("peltogyne_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLORFUL_TREE = registerKey("colorful_tree");

    //huge mushrooms
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM_TREE = registerKey("green_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_MUSHROOM_TREE = registerKey("purple_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_MUSHROOM_TREE = registerKey("blue_luminescent_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_LUMINESCENT_MUSHROOM_TREE = registerKey("pink_luminescent_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_GREEN_MUSHROOM_TREE = registerKey("big_green_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_RED_MUSHROOM_TREE = registerKey("big_red_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_TREE = registerKey("blue_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM_TREE_WG = registerKey("blue_mushroom_tree_wg");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BIG_PURPLE_MUSHROOM_TREE = registerKey("big_purple_mushroom_tre");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_TREE = registerKey("big_orange_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM_TREE_WG = registerKey("big_orange_mushroom_tree_wg");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM_TREE = registerKey("big_yellow_mushroom_tree");

    //mushrooms
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_MUSHROOM = registerKey("blue_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_MUSHROOM = registerKey("green_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_MUSHROOM = registerKey("purple_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_LUMINESCENT_MUSHROOM = registerKey("pink_luminescent_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_MUSHROOM = registerKey("luminescent_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_MUSHROOM = registerKey("orange_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_MUSHROOM = registerKey("yellow_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_MUSHROOM = registerKey("red_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BROWN_MUSHROOM = registerKey("brown_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FERTILE_RED_MUSHROOM = registerKey("fertile_red_mushroom");

    //Flowers Mushrooms
    public static final RegistryKey<ConfiguredFeature<?, ?>> STERILE_BLUE_MUSHROOM = registerKey("sterile_blue_mushroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_SMALL_BROWN = registerKey("mushroom_small_brown");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_SMALL_RED = registerKey("mushroom_small_red");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_DEATH_TRUMPET = registerKey("mushroom_death_trumpet");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_SIDE_BLUE_LUMINESCENT = registerKey("mushroom_side_blue_luminescent");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_RED_FERTILE_FLOWER = registerKey("mushroom_red_fertile_flower");


    //flowers
    public static final RegistryKey<ConfiguredFeature<?, ?>> OCULAE = registerKey("oculae");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FUTIALI = registerKey("futiali");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MUSHROOM_FLOWERS = registerKey("mushroom_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_LUMERIA = registerKey("red_lumeria");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SOL_OCCIDENTIS = registerKey("sol_occidentis");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYANEA = registerKey("cynea");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYANUS_RUBENS = registerKey("cyanus_rubens");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NOCTULICA = registerKey("noctulica");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TURQUOSUM_STILUS = registerKey("turquosum_stilus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CAERULEA_VOLUBILIS = registerKey("caerulea_volubilis");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAPHIRA_FLORENS = registerKey("saphira_florens");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTO_PINK_SCHROOM = registerKey("prehisto_pink_schroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTO_BLUE_SCHROOM = registerKey("prehisto_blue_schroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTO_GREEN_SCHROOM = registerKey("prehisto_green_schroom");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PREHISTURPLE_SCHROOM = registerKey("prehisturple_schroom");

    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_PERENNIAL = registerKey("yellow_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_PERENNIAL = registerKey("blue_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GREEN_PERENNIAL = registerKey("green_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORANGE_PERENNIAL = registerKey("orange_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_PERENNIAL = registerKey("pink_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PURPLE_PERENNIAL = registerKey("purple_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LUMINESCENT_PERENNIAL = registerKey("luminescent_perennial");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_YELLOW_PERENNIAL = registerKey("small_patch_yellow_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_BLUE_PERENNIAL = registerKey("small_patch_blue_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_GREEN_PERENNIAL = registerKey("small_patch_green_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_ORANGE_PERENNIAL = registerKey("small_patch_orange_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_PINK_PERENNIAL = registerKey("small_patch_pink_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_PURPLE_PERENNIAL = registerKey("small_patch_purple_perennial");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SMALL_PATCH_LUMINESCENT_PERENNIAL = registerKey("small_patch_luminescent_perennial");

    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_QUINCE = registerKey("red_quince");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_QUINCE = registerKey("yellow_quince");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TINY_LILAC = registerKey("tiny_lilac");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELICE = registerKey("yelice");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLAMESTHYSIA = registerKey("flamesthysia");
    public static final RegistryKey<ConfiguredFeature<?, ?>> APAGANTHE = registerKey("apaganthe");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PINK_HEATER = registerKey("pink_heater");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WYSTERIA = registerKey("wysteria");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBELL = registerKey("bluebell");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VIPERIN = registerKey("viperin");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HIBISCUS = registerKey("hibiscus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PLATUM = registerKey("platum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DIANTHUS = registerKey("dianthus");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CYCAS = registerKey("cycas");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ARUM = registerKey("arum");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HYDRANGEA = registerKey("hydrangea");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ANEMONE = registerKey("anemone");
    public static final RegistryKey<ConfiguredFeature<?, ?>> JACYNTHE = registerKey("jacynthe");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ACONIT = registerKey("aconit");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PERVENCHE = registerKey("pervenche");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RAPANGE_FLOWERS = registerKey("rapange_flowers");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FLEUR_BERRIES = registerKey("fleur_berries");
    public static final RegistryKey<ConfiguredFeature<?, ?>> PICK_BLUE = registerKey("pick_blue");

    //Grass
    public static final RegistryKey<ConfiguredFeature<?, ?>> TINY_GRASSS = registerKey("tiny_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASS = registerKey("grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_GRASS = registerKey("dense_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> DENSE_TALL_GRASS = registerKey("dense_tall_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASS_BLUE_LUMINESCENT = registerKey("grass_blue_luminescent");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TALL_GRASS_BLUE_LUMINESCENT = registerKey("grass_tall_blue_luminescent");

    //Vines
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_VINES_UP = registerKey("blue_luminescent_vines_up");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_LUMINESCENT_VINES_DOWN = registerKey("blue_luminescent_vines_down");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HANGING_ROOT = registerKey("hanging_root");
    public static final RegistryKey<ConfiguredFeature<?, ?>> VINES = registerKey("vines");

    //Bush
    public static final RegistryKey<ConfiguredFeature<?, ?>> BUSH = registerKey("bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> COLORFUL_BUSH = registerKey("colorful_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CAVE_BUSH = registerKey("cave_bush");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CAVE_TOP_BUSH = registerKey("cave_top_bush");

    //Crystal
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_CRYSTAL = registerKey("red_crystal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_CRYSTAL = registerKey("blue_crystal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_CRYSTAL = registerKey("white_crystal");
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUE_CRYSTAL_PILLAR = registerKey("blue_crystal_pillar");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_CRYSTAL_PILLAR = registerKey("red_crystal_pillar");
    public static final RegistryKey<ConfiguredFeature<?, ?>> WHITE_CRYSTAL_PILLAR = registerKey("white_crystal_pillar");
    public static final RegistryKey<ConfiguredFeature<?, ?>> CRYSTAL_BLUE = registerKey("crystal_blue");

    //Ore
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMBER_ORE = registerKey("amber_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> RHYOLITE = registerKey("rhyolite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> AMBER_MINERAL = registerKey("amber_mineral");

    //terrain
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_ARCH = registerKey("sakura_arch");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_ROCK_STRAIGHT = registerKey("sakura_rock_straight");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SAKURA_ROCK_FLAT = registerKey("sakura_rock_flat");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ROCKY_STALACTITE = registerKey("rocky_stalactite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> MOSSY_STALACTITE = registerKey("mossy_stalactite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> HUGE_STALACTITE = registerKey("huge_stalactite");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TINY_PUDDLE = registerKey("tiny_puddle");

    public static final RegistryKey<ConfiguredFeature<?, ?>> SPIRAL_MUSHROOM = registerKey("spiral_mushroom");

    //Dev
    public static final RegistryKey<ConfiguredFeature<?, ?>> FEATURE_TESTER = registerKey("feature_teste");


    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        //tree
        register(context, BLUE_LUMINESCENT_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_LOG), new BlueLuminescentTrunkPlacer(5, 5, 4),
                BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_LEAVES), new BlueLuminescentFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(1), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, OAK_BERRIES_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG), new StraightTrunkPlacer(4, 2, 0),
                BlockStateProvider.of(ModBlocks.OAK_BERRIES_LEAVES.getDefaultState().with(Properties.BERRIES, false)), new BlobFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(0), 3),
                new TwoLayersFeatureSize(1, 0, 1)).decorators(Collections.singletonList(OakBerriesTreeDecorator.INSTANCE)).build());

        register(context, PELTOGYNE_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.PELTOGYNE_LOG), new PeltogyneTrunkPlacer(8, 4, 3),
                BlockStateProvider.of(ModBlocks.PELTOGYNE_LEAVES), new PeltogyneFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(10), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());

        register(context, COLORFUL_TREE, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(Blocks.OAK_LOG), new ColorfulTreeTrunkPlacer(6, 3, 2),
                BlockStateProvider.of(ModBlocks.PELTOGYNE_LEAVES), new ColorfulTreeFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(10), 3),
                new TwoLayersFeatureSize(1, 0, 1)).build());
        //huge mushrooms
        register(context, PURPLE_MUSHROOM_TREE, ModFeatures.HUGE_PURPLE_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 5));
        register(context, GREEN_MUSHROOM_TREE, ModFeatures.HUGE_GREEN_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 20));
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE, ModFeatures.HUGE_BLUE_LUMINESCENT_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_BLOCK), BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_MUSHROOM_STEM), 3));
        register(context, PINK_LUMINESCENT_MUSHROOM_TREE, ModFeatures.HUGE_LUMINESCENT_PINK_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_LUMINESCENT_MUSHROOM_BLOCK), BlockStateProvider.of(ModBlocks.TRANSPARENT_MUSHROOM_STEM), 4));
        register(context, BIG_PURPLE_MUSHROOM_TREE, ModFeatures.HUGE_BIG_PURPLE_MUSHROOM, new PurpleMushroomConfig(12, 26, 2, 6));
        register(context, BIG_GREEN_MUSHROOM_TREE, ModFeatures.HUGE_BIG_GREEN_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BIG_RED_MUSHROOM_TREE, ModFeatures.HUGE_BIG_RED_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.of(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BLUE_MUSHROOM_TREE, ModFeatures.HUGE_BLUE_MUSHROOM, new ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BLUE_MUSHROOM_TREE_WG, ModFeatures.HUGE_BLUE_MUSHROOM_WG, new ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, YELLOW_MUSHROOM_TREE, ModFeatures.HUGE_YELLOW_MUSHROOM, new HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, ORANGE_MUSHROOM_TREE, ModFeatures.HUGE_BIG_ORANGE_MUSHROOM, new DefaultFeatureConfig());
        register(context, ORANGE_MUSHROOM_TREE_WG, ModFeatures.HUGE_BIG_ORANGE_MUSHROOM_WG, new DefaultFeatureConfig());
        register(context, FERTILE_RED_MUSHROOM, ModFeatures.FERTILE_RED_MUSHROOM, new DefaultFeatureConfig());

        //mushrooms
        register(context, BLUE_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM)))));
        register(context, GREEN_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM)))));
        register(context, PURPLE_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM)))));
        register(context, BLUE_LUMINESCENT_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_MUSHROOM)))));
        register(context, PINK_LUMINESCENT_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PINK_MUSHROOM)))));
        register(context, RED_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.RED_MUSHROOM)))));
        register(context, BROWN_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.BROWN_MUSHROOM)))));


        //Flowers Mushrooms
        register(context, STERILE_BLUE_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.STERILE_BLUE_MUSHROOM)))));
        register(context, MUSHROOM_SMALL_BROWN, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_SMALL_BROWN)))));
        register(context, MUSHROOM_SMALL_RED, Feature.FLOWER, new RandomPatchFeatureConfig(40, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_DEATH_TRUMPET)))));
        register(context, MUSHROOM_DEATH_TRUMPET, Feature.FLOWER, new RandomPatchFeatureConfig(50, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_SMALL_RED)))));
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT, ModFeatures.SIMPLE_BLOCK, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SIDE_MUSHROOM_BLUE_LUMINESCENT)));
        register(context, MUSHROOM_RED_FERTILE_FLOWER, Feature.FLOWER, new RandomPatchFeatureConfig(50, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FERTILE_RED_MUSHROOM)))));

        //flowers
        register(context, FUTIALI, Feature.FLOWER, new RandomPatchFeatureConfig(42, 14, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FUTIALI)))));
        register(context, OCULAE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.OCULAE)))));
        register(context, RED_LUMERIA, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_LUMERIA)))));
        register(context, MUSHROOM_FLOWERS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_FLOWERS)))));
        register(context, SOL_OCCIDENTIS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SOL_OCCIDENTIS)))));
        register(context, CYANEA, Feature.FLOWER, new RandomPatchFeatureConfig(42, 14, 7, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYANEA)))));
        register(context, CYANUS_RUBENS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYANUS_RUBENS)))));
        register(context, NOCTULICA, Feature.FLOWER, new RandomPatchFeatureConfig(40, 14, 5, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.NOCTULICA)))));
        register(context, TURQUOSUM_STILUS, Feature.FLOWER, new RandomPatchFeatureConfig(40, 14, 10, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TURQUOSUM_STILUS)))));
        register(context, CAERULEA_VOLUBILIS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CAERULEA_VOLUBILIS)))));
        register(context, SAPHIRA_FLORENS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SAPHIRA_FLORENS)))));
        register(context, PREHISTURPLE_SCHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTURPLE_SCHROOM)))));
        register(context, PREHISTO_BLUE_SCHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_BLUE_SCHROOM)))));
        register(context, PREHISTO_GREEN_SCHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_GREEN_SCHROOM)))));
        register(context, PREHISTO_PINK_SCHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(37, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_PINK_SCHROOM)))));


        register(context, PURPLE_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_PERENNIAL)))));
        register(context, YELLOW_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_PERENNIAL)))));
        register(context, PINK_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_PERENNIAL)))));
        register(context, ORANGE_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_PERENNIAL)))));
        register(context, BLUE_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_PERENNIAL)))));
        register(context, GREEN_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_PERENNIAL)))));
        register(context, LUMINESCENT_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(10, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PERENNIAL)))));

        register(context, SMALL_PATCH_PURPLE_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_PERENNIAL)))));
        register(context, SMALL_PATCH_YELLOW_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_PERENNIAL)))));
        register(context, SMALL_PATCH_PINK_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_PERENNIAL)))));
        register(context, SMALL_PATCH_ORANGE_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_PERENNIAL)))));
        register(context, SMALL_PATCH_BLUE_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_PERENNIAL)))));
        register(context, SMALL_PATCH_GREEN_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_PERENNIAL)))));
        register(context, SMALL_PATCH_LUMINESCENT_PERENNIAL, Feature.FLOWER, new RandomPatchFeatureConfig(16, 3, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PERENNIAL)))));


        register(context, RED_QUINCE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_QUINCE)))));
        register(context, YELLOW_QUINCE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_QUINCE)))));
        register(context, TINY_LILAC, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TINY_LILAC)))));
        register(context, YELICE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELICE)))));
        register(context, FLAMESTHYSIA, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLAMESTHYSIA)))));
        register(context, APAGANTHE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.APAGANTHE)))));
        register(context, PINK_HEATER, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_HEATER)))));
        register(context, WYSTERIA, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WYSTERIA)))));
        register(context, BLUEBELL, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUEBELL)))));
        register(context, VIPERIN, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.VIPERIN)))));
        register(context, HIBISCUS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HIBISCUS)))));
        register(context, PLATUM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PLATUM)))));
        register(context, DIANTHUS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.DIANTHUS)))));
        register(context, CYCAS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYCAS)))));
        register(context, ARUM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ARUM)))));
        register(context, HYDRANGEA, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.HYDRANGEA)))));
        register(context, ANEMONE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ANEMONE)))));
        register(context, JACYNTHE, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.JACYNTHE)))));
        register(context, ACONIT, Feature.FLOWER, new RandomPatchFeatureConfig(32, 14, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ACONIT)))));
        register(context, PERVENCHE, Feature.FLOWER, new RandomPatchFeatureConfig(20, 6, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PERVENCHE)))));
        register(context, ORANGE_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_MUSHROOM)))));
        register(context, YELLOW_MUSHROOM, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_MUSHROOM)))));
        register(context, PICK_BLUE, Feature.FLOWER, new RandomPatchFeatureConfig(12, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PICK_BLUE)))));

        register(context, RAPANGE_FLOWERS, Feature.FLOWER, new RandomPatchFeatureConfig(64, 7, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RAPANGE_FLOWERS)))));
        register(context, FLEUR_BERRIES, ModFeatures.FLEUR_BERRIES, new DefaultFeatureConfig());
        //Grass
        register(context, TINY_GRASSS, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TINY_GRASS)))));
        register(context, GRASS_BLUE_LUMINESCENT, Feature.FLOWER, new RandomPatchFeatureConfig(43, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_GRASS)))));
        register(context, TALL_GRASS_BLUE_LUMINESCENT, Feature.FLOWER, new RandomPatchFeatureConfig(43, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_TALL_GRASS)))));
        register(context, GRASS, Feature.FLOWER, new RandomPatchFeatureConfig(40, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)))));
        register(context, DENSE_GRASS, Feature.FLOWER, new RandomPatchFeatureConfig(80, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SHORT_GRASS)))));
        register(context, DENSE_TALL_GRASS, Feature.FLOWER, new RandomPatchFeatureConfig(80, 12, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.TALL_GRASS)))));

        //vines
        register(context, BLUE_LUMINESCENT_VINES_UP, ModFeatures.BLUE_LUMINESCENT_VINES, new TwistingVinesFeatureConfig(8, 1, 20));
        register(context, BLUE_LUMINESCENT_VINES_DOWN, ModFeatures.SIMPLE_VINES, new DirectionConfig(Direction.DOWN, BlockStateProvider.of(ModBlocks.BLUE_LUMINESCENT_VINES)));
        register(context, HANGING_ROOT, ModFeatures.SIMPLE_BLOCK, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.HANGING_ROOTS)));
        register(context, VINES, ModFeatures.HANGING_VINES_GROW_FEATURES,
                new HangingGrowthFeatureConfig((VineBlock) Blocks.VINE,
                        20,
                        23,
                        false,
                        false,
                        true,
                        0.35f,
                        RegistryEntryList.of(
                                Block::getRegistryEntry,
                                Blocks.STONE,
                                Blocks.COBBLESTONE,
                                Blocks.MOSSY_COBBLESTONE,
                                Blocks.ANDESITE,
                                Blocks.DIORITE,
                                Blocks.GRANITE,
                                Blocks.DRIPSTONE_BLOCK,
                                Blocks.CALCITE,
                                Blocks.TUFF,
                                Blocks.DEEPSLATE
                        )));

        //Bush
        register(context, BUSH, ModFeatures.BUSH, new DefaultFeatureConfig());
        register(context, COLORFUL_BUSH, ModFeatures.COLORFUL_BUSH, new DefaultFeatureConfig());
        register(context, CAVE_BUSH, ModFeatures.CAVE_BUSH, new DefaultFeatureConfig());
        register(context, CAVE_TOP_BUSH, ModFeatures.CAVE_TOP_BUSH, new DefaultFeatureConfig());

        //Crystal
        register(context, RED_CRYSTAL, ModFeatures.CRYSTAL, new CrystalConfig(15, 9, BlockStateProvider.of(ModBlocks.RED_CRYSTAL)));
        register(context, BLUE_CRYSTAL, ModFeatures.CRYSTAL, new CrystalConfig(15, 9, BlockStateProvider.of(ModBlocks.BLUE_CRYSTAL)));
        register(context, WHITE_CRYSTAL, Feature.FLOWER, new RandomPatchFeatureConfig(33, 9, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_CRYSTAL)))));
        register(context, BLUE_CRYSTAL_PILLAR, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_CRYSTAL_BLOCK)));
        register(context, RED_CRYSTAL_PILLAR, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_CRYSTAL_BLOCK)));
        register(context, WHITE_CRYSTAL_PILLAR, ModFeatures.CRYSTAL_PILLAR, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.WHITE_CRYSTAL_BLOCK)));
        register(context, CRYSTAL_BLUE, Feature.FLOWER, new RandomPatchFeatureConfig(10, 10, 3, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_CRYSTAL_CLUSTER)))));

        //ore
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        RuleTest endReplacables = new BlockMatchRuleTest(Blocks.END_STONE);

        List<OreFeatureConfig.Target> netherAmberOres = List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.AMBER_ORE.getDefaultState()));
        register(context, AMBER_ORE, Feature.ORE, new OreFeatureConfig(netherAmberOres, 14));
        register(context, AMBER_MINERAL, ModFeatures.AMBER_MINERAL, new DefaultFeatureConfig());

        List<OreFeatureConfig.Target> overworldRhyoliteOre = List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.RHYOLITE.getDefaultState()));
        register(context, RHYOLITE, Feature.ORE, new OreFeatureConfig(overworldRhyoliteOre, 14));

        //terrain
        register(context, SAKURA_ARCH, ModFeatures.ARCH, new ArchConfig(10, 3, 60, 30, 30, 30, 30));
        register(context, SAKURA_ROCK_STRAIGHT, ModFeatures.SAKURA_ROCK_STRAIGHT, new DefaultFeatureConfig());
        register(context, SAKURA_ROCK_FLAT, ModFeatures.SAKURA_ROCK_FLAT, new DefaultFeatureConfig());
        register(context, ROCKY_STALACTITE, ModFeatures.ROCKY_STALACTITE, new StalactiteFeatureConfig(52));
        register(context, MOSSY_STALACTITE, ModFeatures.MOSSY_STALACTITE, new StalactiteFeatureConfig(39));
        register(context, HUGE_STALACTITE, ModFeatures.HUGE_STALACTITE, new DefaultFeatureConfig());
        register(context, SPIRAL_MUSHROOM, ModFeatures.SPIRAL_MUSHROOM, new DefaultFeatureConfig());
        register(context, TINY_PUDDLE, ModFeatures.TINY_PUDDLE, new DefaultFeatureConfig());

        //Dev
        register(context, FEATURE_TESTER, ModFeatures.FEATURE_TESTER, new ModSimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.REDSTONE_BLOCK)));


    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MushrooomsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
