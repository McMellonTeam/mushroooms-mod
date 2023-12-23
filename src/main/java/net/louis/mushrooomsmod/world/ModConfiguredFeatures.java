package net.louis.mushrooomsmod.world;
import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.louis.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.louis.mushrooomsmod.world.tree.HugeBigGreenMushroom.HugeBigGreenMushroomFeature;
import net.louis.mushrooomsmod.world.tree.HugeBigRedMushroom.HugeBigRedMushroomFeature;
import net.louis.mushrooomsmod.world.tree.HugeBlueMushroom.HugeBlueMushroomFeature;
import net.louis.mushrooomsmod.world.tree.HugeGreenMushroom.HugeGreenMushroomFeature;
import net.louis.mushrooomsmod.world.tree.HugeLuminescentMushroom.HugeLuminescentMushroomFeature;
import net.louis.mushrooomsmod.world.tree.HugeLuminescentPinkMushroom.HugeLuminescentPinkMushroomFeature;
import net.louis.mushrooomsmod.world.tree.BugeBigPurpleMushroom.HugeBigMuchroomFeature;
import net.louis.mushrooomsmod.world.tree.HugePurpleMushroom.HugePurpleMushroomFeature;
import net.minecraft.block.Blocks;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModConfiguredFeatures <FC extends FeatureConfig>  {

    //huge mushrooms
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUE_MUSHROOM_KEY = registerKey("blue_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> GREEN_MUSHROOM_KEY = registerKey("green_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> PURPLE_MUSHROOM_KEY = registerKey("purple_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> LUMINESCENT_MUSHROOM_KEY = registerKey("luminescent_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> LUMINESCENT_PINK_MUSHROOM_KEY = registerKey("luminescent_pink_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIG_PURPLE_MUSHROOM_KEY = registerKey("big_purple_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIG_GREEN_MUSHROOM_KEY = registerKey("big_green_mushroom_tree");
    public static final RegistryKey<ConfiguredFeature<?,?>> BIG_RED_MUSHROOM_KEY = registerKey("big_red_mushroom_tree");

    //mushrooms
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUE_MUSHROOM_FLOWER_KEY = registerKey("blue_mushroom_flower_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> GREEN_MUSHROOM_FLOWER_KEY = registerKey("green_mushroom_flower_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PURPLE_MUSHROOM_FLOWER_KEY = registerKey("purple_mushroom_flower_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PINK_LUMINESCENT_MUSHROOM_FLOWER_KEY = registerKey("pink_luminescent_mushroom_flower_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> LUMINESCENT_MUSHROOM_FLOWER_KEY = registerKey("luminescent_mushroom_flower_key");

    //flowers
    public static final RegistryKey<ConfiguredFeature<?,?>> OCULAE_KEY = registerKey("oculae_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> FUTIALI_KEY = registerKey("futiali_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> MUSHROOM_FLOWERS_KEY = registerKey("mushroom_flowers_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_LUMERIA_KEY = registerKey("red_lumeria_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> SOL_OCCIDENTIS_KEY = registerKey("sol_occidentis_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> CYANEA_KEY = registerKey("cynea_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> CYANUS_RUBENS_KEY = registerKey("cyanus_rubens_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> NOCTULICA_KEY = registerKey("noctulica_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> TURQUOSUM_STILUS_KEY = registerKey("turquosum_stilus_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> CAERULEA_VOLUBILIS_KEY = registerKey("caerulea_volubilis_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> SAPHIRA_FLORENS_KEY = registerKey("saphira_florens_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PREHISTO_PINK_SCHROOM_KEY = registerKey("prehisto_pink_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PREHISTO_BLUE_SCHROOM_KEY = registerKey("prehisto_blue_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PREHISTO_GREEN_SCHROOM_KEY = registerKey("prehisto_green_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PREHISTURPLE_SCHROOM_KEY = registerKey("prehisturple_schroom_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> YELLOW_PERENNIAL_KEY = registerKey("yellow_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> BLUE_PERENNIAL_KEY = registerKey("blue_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> GREEN_PERENNIAL_KEY = registerKey("green_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> ORANGE_PERENNIAL_KEY = registerKey("orange_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PINK_PERENNIAL_KEY = registerKey("pink_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> PURPLE_PERENNIAL_KEY = registerKey("purple_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> LUMINESCENT_PERENNIAL_KEY = registerKey("luminescent_perennial_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> RED_QUINCE_KEY = registerKey("red_quince_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> YELLOW_QUINCE_KEY = registerKey("yellow_quince_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> TINY_LILAC_KEY = registerKey("tiny_lilac_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> YELICE_KEY = registerKey("yelice_key");
    public static final RegistryKey<ConfiguredFeature<?,?>> FLAMESTHYSIA_KEY = registerKey("flamesthysia_key");



    //Huge mushroom features
    public static final Feature<HugeMushroomFeatureConfig> HUGE_BLUE_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_blue_mushroom", new HugeBlueMushroomFeature(HugeMushroomFeatureConfig.CODEC));
    public static final Feature<HugeMushroomFeatureConfig> HUGE_PURPLE_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_purple_mushroom", new HugePurpleMushroomFeature(HugeMushroomFeatureConfig.CODEC));
    public static final Feature<HugeMushroomFeatureConfig> HUGE_GREEN_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_green_mushroom", new HugeGreenMushroomFeature(HugeMushroomFeatureConfig.CODEC));
    public static final Feature<HugeMushroomFeatureConfig> HUGE_LUMINESCENT_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_luminescent_mushroom", new HugeLuminescentMushroomFeature(HugeMushroomFeatureConfig.CODEC));

    public static final Feature<HugeMushroomFeatureConfig> HUGE_LUMINESCENT_PINK_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_luminescent_pink_mushroom", new HugeLuminescentPinkMushroomFeature(HugeMushroomFeatureConfig.CODEC));
    public static final Feature<ModMushroomFeatureConfig> HUGE_BIG_PURPLE_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_big_purple_mushroom_feature", new HugeBigMuchroomFeature(ModMushroomFeatureConfig.CODEC));
    public static final Feature<ModMushroomFeatureConfig> HUGE_BIG_GREEN_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_big_green_mushroom_feature", new HugeBigGreenMushroomFeature(ModMushroomFeatureConfig.CODEC));
    public static final Feature<ModMushroomFeatureConfig> HUGE_BIG_RED_MUSHROOM = ModConfiguredFeatures.registercustomfeature("huge_red_green_mushroom_feature", new HugeBigRedMushroomFeature(ModMushroomFeatureConfig.CODEC));






    public static void bootstrap(Registerable<ConfiguredFeature<?,?>> context){
        //huge mushrooms
        register(context, BLUE_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_BLUE_MUSHROOM, new  HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, PURPLE_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_PURPLE_MUSHROOM, new  HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 5));
        register(context, GREEN_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_GREEN_MUSHROOM, new  HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM), 20));
        register(context, LUMINESCENT_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_LUMINESCENT_MUSHROOM, new  HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_MUSHROOM_BLOCK), BlockStateProvider.of(ModBlocks.LUMINESCENT_MUSHROOM_STEM), 6));
        register(context, LUMINESCENT_PINK_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_LUMINESCENT_PINK_MUSHROOM, new  HugeMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PINK_MUSHROOM_BLOCK), BlockStateProvider.of(ModBlocks.TRANSPARENT_MUSHROOM_STEM), 4));
        register(context, BIG_PURPLE_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_BIG_PURPLE_MUSHROOM, new  ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM) ,BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BIG_GREEN_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_BIG_GREEN_MUSHROOM, new  ModMushroomFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM) ,BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        register(context, BIG_RED_MUSHROOM_KEY, ModConfiguredFeatures.HUGE_BIG_RED_MUSHROOM, new  ModMushroomFeatureConfig(BlockStateProvider.of(Blocks.RED_MUSHROOM_BLOCK), BlockStateProvider.of(Blocks.MUSHROOM_STEM) ,BlockStateProvider.of(Blocks.MUSHROOM_STEM), 4));
        //mushrooms
        register(context, BLUE_MUSHROOM_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_MUSHROOM)))));
        register(context, GREEN_MUSHROOM_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_MUSHROOM)))));
        register(context, PURPLE_MUSHROOM_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_MUSHROOM)))));
        register(context, LUMINESCENT_MUSHROOM_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_MUSHROOM)))));
        register(context, PINK_LUMINESCENT_MUSHROOM_FLOWER_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PINK_MUSHROOM)))));
        //flowers
        register(context, FUTIALI_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FUTIALI)))));
        register(context, OCULAE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.OCULAE)))));
        register(context, RED_LUMERIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_LUMERIA)))));
        register(context, MUSHROOM_FLOWERS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.MUSHROOM_FLOWERS)))));
        register(context, SOL_OCCIDENTIS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SOL_OCCIDENTIS)))));
        register(context, CYANEA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYANEA)))));
        register(context, CYANUS_RUBENS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CYANUS_RUBENS)))));
        register(context, NOCTULICA_KEY , Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.NOCTULICA)))));
        register(context, TURQUOSUM_STILUS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TURQUOSUM_STILUS)))));
        register(context, CAERULEA_VOLUBILIS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.CAERULEA_VOLUBILIS)))));
        register(context, SAPHIRA_FLORENS_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.SAPHIRA_FLORENS)))));
        register(context, PREHISTURPLE_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTURPLE_SCHROOM)))));
        register(context, PREHISTO_BLUE_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_BLUE_SCHROOM)))));
        register(context, PREHISTO_GREEN_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_GREEN_SCHROOM)))));
        register(context, PREHISTO_PINK_SCHROOM_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PREHISTO_PINK_SCHROOM)))));
        register(context, PURPLE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PURPLE_PERENNIAL)))));
        register(context, YELLOW_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_PERENNIAL)))));
        register(context, PINK_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.PINK_PERENNIAL)))));
        register(context, ORANGE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.ORANGE_PERENNIAL)))));
        register(context, BLUE_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.BLUE_PERENNIAL)))));
        register(context, GREEN_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GREEN_PERENNIAL)))));
        register(context, LUMINESCENT_PERENNIAL_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LUMINESCENT_PERENNIAL)))));
        register(context, RED_QUINCE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.RED_QUINCE)))));
        register(context, YELLOW_QUINCE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELLOW_QUINCE)))));
        register(context, TINY_LILAC_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.TINY_LILAC)))));
        register(context, YELICE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.YELICE)))));
        register(context, FLAMESTHYSIA_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(32, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.FLAMESTHYSIA)))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(MushrooomsMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
    private static <C extends FeatureConfig, F extends Feature<C>> F registercustomfeature(String name, F feature) {
        return (F)Registry.register(Registries.FEATURE, name, feature);
    }

}
