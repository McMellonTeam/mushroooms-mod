package net.rodofire.mushrooomsmod.world;

import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_PLACED_KEY = registerKey("pink_luminescent_mushrooom_placed_key");
    public static final RegistryKey<PlacedFeature> LUMINESCENT_MUSHROOM_PLACED_KEY = registerKey("luminescent_mushrooom_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_PLACED_KEY = registerKey("blue_mushrooom_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_PLACED_KEY = registerKey("purple_mushrooom_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_PLACED_KEY = registerKey("green_mushrooom_placed_key");

    //Mushrooms
    public static final RegistryKey<PlacedFeature> PINK_LUMINESCENT_MUSHROOM_FLOWER_PLACED_KEY = registerKey("pink_luminescent_mushroom_flower_placed_key");
    public static final RegistryKey<PlacedFeature> LUMINESCENT_MUSHROOM_FLOWER_PLACED_KEY = registerKey("luminescent_mushroom_flower_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_MUSHROOM_FLOWER_PLACED_KEY = registerKey("blue_mushroom_flower_placed_key");
    public static final RegistryKey<PlacedFeature> GREEN_MUSHROOM_FLOWER_PLACED_KEY = registerKey("green_mushroom_flower_placed_key");
    public static final RegistryKey<PlacedFeature> PURPLE_MUSHROOM_FLOWER_PLACED_KEY = registerKey("purple_mushroom_flower_placed_key");
    public static final RegistryKey<PlacedFeature> ORANGE_MUSHROOM_FLOWER_PLACED_KEY = registerKey("orange_mushroom_flower_placed_key");
    public static final RegistryKey<PlacedFeature> YELLOW_MUSHROOM_FLOWER_PLACED_KEY = registerKey("yellow_mushroom_flower_placed_key");

    //Flowers Mushrooms
    public static final RegistryKey<PlacedFeature> STERILE_BLUE_MUSHROOM_PLACED_KEY = registerKey("sterile_blue_mushroom_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN_PLACED_KEY = registerKey("mushroom_small_brown_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED_PLACED_KEY = registerKey("mushroom_small_red_placed_key");

    //flowers
    public static final RegistryKey<PlacedFeature> OCULAE_PLACED_KEY = registerKey("oculae_placed_key");
    public static final RegistryKey<PlacedFeature> CYANUS_RUBENS_PLACED_KEY = registerKey("cyanus_rubens_placed_key");
    public static final RegistryKey<PlacedFeature> CYANEA_PLACED_KEY = registerKey("cyanea_placed_key");
    public static final RegistryKey<PlacedFeature> SOL_OCCIDENTIS_PLACED_KEY = registerKey("sol_occidentis_placed_key");
    public static final RegistryKey<PlacedFeature> FUTIALI_PLACED_KEY = registerKey("futiali_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_FLOWERS_PLACED_KEY = registerKey("mushroom_flowers_placed_key");
    public static final RegistryKey<PlacedFeature> RED_LUMERIA_PLACED_KEY = registerKey("red_lumeria_placed_key");
    public static final RegistryKey<PlacedFeature> TURQUOSUM_STILUS_PLACED_KEY = registerKey("turquosum_stilus_placed_key");
    public static final RegistryKey<PlacedFeature> NOCTULICA_PLACED_KEY = registerKey("noctulica_placed_key");
    public static final RegistryKey<PlacedFeature> SAPHIRA_FLORENS_PLACED_KEY = registerKey("saphira_florens_placed_key");
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
    public static final RegistryKey<PlacedFeature> PLATUM_PLACED_KEY = registerKey("platum_placed_key");
    public static final RegistryKey<PlacedFeature> DIANTHUS_PLACED_KEY = registerKey("dianthus_placed_key");
    public static final RegistryKey<PlacedFeature> CYCAS_PLACED_KEY = registerKey("cycas_placed_key");
    public static final RegistryKey<PlacedFeature> ARUM_PLACED_KEY = registerKey("arum_placed_key");
    public static final RegistryKey<PlacedFeature> HYDRANGEA_PLACED_KEY = registerKey("hydrangea_placed_key");
    public static final RegistryKey<PlacedFeature> ANEMONE_PLACED_KEY = registerKey("anemone_placed_key");
    public static final RegistryKey<PlacedFeature> JACYNTHE_PLACED_KEY = registerKey("jacynthe_placed_key");
    public static final RegistryKey<PlacedFeature> ACONIT_PLACED_KEY = registerKey("aconit_placed_key");
    public static final RegistryKey<PlacedFeature> PERVENCHE_PLACED_KEY = registerKey("pervenche_placed_key");

    //Vines
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_PLACED_KEY = registerKey("blue_luminescent_vines_placed_key");


    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //Mushrooms
        register(context, PINK_LUMINESCENT_MUSHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PINK_MUSHROOM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.LUMINESCENT_PINK_MUSHROOM));

        //Flowers Mushrooms
        register(context,STERILE_BLUE_MUSHROOM_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.STERILE_BLUE_MUSHROOM_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.STERILE_BLUE_MUSHROOM));
        register(context,MUSHROOM_SMALL_BROWN_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.MUSHROOM_SMALL_BROWN));
        register(context,MUSHROOM_SMALL_RED_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.MUSHROOM_SMALL_RED));

        //Flowers
        register(context, OCULAE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OCULAE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.OCULAE));
        register(context, CYANUS_RUBENS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CYANUS_RUBENS));
        register(context, CYANEA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANEA_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CYANEA));
        register(context, SOL_OCCIDENTIS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.SOL_OCCIDENTIS));
        register(context, FUTIALI_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FUTIALI_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.FUTIALI));
        register(context, MUSHROOM_FLOWERS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.MUSHROOM_FLOWERS));
        register(context, RED_LUMERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_LUMERIA_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.RED_LUMERIA));
        register(context, TURQUOSUM_STILUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.TURQUOSUM_STILUS));
        register(context, NOCTULICA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOCTULICA_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.NOCTULICA));
        register(context, SAPHIRA_FLORENS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.SAPHIRA_FLORENS));

        register(context, PREHISTURPLE_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PREHISTURPLE_SCHROOM));
        register(context, PREHISTO_GREEN_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PREHISTO_GREEN_SCHROOM));
        register(context, PREHISTO_BLUE_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PREHISTO_BLUE_SCHROOM));
        register(context, PREHISTO_PINK_SCHROOM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PREHISTO_PINK_SCHROOM));

        register(context, YELLOW_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.YELLOW_PERENNIAL));
        register(context, PINK_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.PINK_PERENNIAL));
        register(context, BLUE_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.BLUE_PERENNIAL));
        register(context, GREEN_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.GREEN_PERENNIAL));
        register(context, LUMINESCENT_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.LUMINESCENT_PERENNIAL));
        register(context, ORANGE_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.ORANGE_PERENNIAL));
        register(context, PURPLE_PERENNIAL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.PURPLE_PERENNIAL));
        register(context, YELLOW_QUINCE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2), ModBlocks.YELLOW_QUINCE));

        register(context, RED_QUINCE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_QUINCE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.RED_QUINCE));
        register(context, TINY_LILAC_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_LILAC_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.TINY_LILAC));
        register(context, YELICE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELICE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.YELICE));
        register(context, FLAMESTHYSIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.FLAMESTHYSIA));
        register(context, APAGANTHE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.APAGANTHE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.APAGANTHE));
        register(context, PINK_HEATER_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_HEATER_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PINK_HEATER));
        register(context, WYSTERIA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.WYSTERIA_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.WYSTERIA));
        register(context, BLUEBELL_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUEBELL_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.BLUEBELL));
        register(context, VIPERIN_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.VIPERIN_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.VIPERIN));
        register(context, HIBISCUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HIBISCUS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.HIBISCUS));
        register(context, PLATUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLATUM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PLATUM));
        register(context, DIANTHUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.DIANTHUS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.DIANTHUS));
        register(context, CYCAS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYCAS_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CYCAS));
        register(context, ARUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ARUM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ARUM));
        register(context, HYDRANGEA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.HYDRANGEA_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.HYDRANGEA));
        register(context, ANEMONE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ANEMONE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ANEMONE));
        register(context, JACYNTHE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.JACYNTHE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.JACYNTHE));
        register(context, ACONIT_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ACONIT_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.ACONIT));
        register(context, PERVENCHE_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PERVENCHE_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.PERVENCHE));


        //Vines
        register(context, BLUE_LUMINESCENT_VINES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1, 0.1f, 2), ModBlocks.CAERULEA_VOLUBILIS));

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
