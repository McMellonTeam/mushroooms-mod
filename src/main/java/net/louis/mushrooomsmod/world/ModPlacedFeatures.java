package net.louis.mushrooomsmod.world;

import net.louis.mushrooomsmod.MushrooomsMod;
import net.louis.mushrooomsmod.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

import static net.louis.mushrooomsmod.world.ModConfiguredFeatures.registerKey;

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



    public static void bootstrap(Registerable<PlacedFeature> context){
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //Mushrooms
        register(context, PINK_LUMINESCENT_MUSHROOM_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PINK_MUSHROOM_KEY), VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2), ModBlocks.LUMINESCENT_PINK_MUSHROOM));

        //Flowers
        register(context,OCULAE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.OCULAE_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.OCULAE));
        register(context,CYANUS_RUBENS_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANUS_RUBENS_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.CYANUS_RUBENS));
        register(context,CYANEA_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANEA_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.CYANEA));
        register(context,SOL_OCCIDENTIS_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SOL_OCCIDENTIS_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.SOL_OCCIDENTIS));
        register(context,FUTIALI_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FUTIALI_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.FUTIALI));
        register(context,MUSHROOM_FLOWERS_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_FLOWERS_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.MUSHROOM_FLOWERS));
        register(context,RED_LUMERIA_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_LUMERIA_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.RED_LUMERIA));
        register(context,TURQUOSUM_STILUS_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.TURQUOSUM_STILUS));
        register(context,NOCTULICA_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOCTULICA_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.NOCTULICA));
        register(context,SAPHIRA_FLORENS_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.SAPHIRA_FLORENS));
        register(context,PREHISTURPLE_SCHROOM_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTURPLE_SCHROOM_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.PREHISTURPLE_SCHROOM));
        register(context,PREHISTO_GREEN_SCHROOM_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_GREEN_SCHROOM_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.PREHISTO_GREEN_SCHROOM));
        register(context,PREHISTO_BLUE_SCHROOM_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_BLUE_SCHROOM_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.PREHISTO_BLUE_SCHROOM));
        register(context,PREHISTO_PINK_SCHROOM_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PREHISTO_PINK_SCHROOM_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.PREHISTO_PINK_SCHROOM));
        register(context,YELLOW_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.YELLOW_PERENNIAL));
        register(context,PINK_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PINK_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.PINK_PERENNIAL));
        register(context,BLUE_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.BLUE_PERENNIAL));
        register(context,GREEN_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.GREEN_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.GREEN_PERENNIAL));
        register(context,LUMINESCENT_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.LUMINESCENT_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.LUMINESCENT_PERENNIAL));
        register(context,ORANGE_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.ORANGE_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.ORANGE_PERENNIAL));
        register(context,PURPLE_PERENNIAL_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PURPLE_PERENNIAL_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.PURPLE_PERENNIAL));
        register(context,YELLOW_QUINCE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELLOW_QUINCE_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.YELLOW_QUINCE));
        register(context,RED_QUINCE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_QUINCE_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.RED_QUINCE));
        register(context,TINY_LILAC_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TINY_LILAC_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.TINY_LILAC));
        register(context,YELICE_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.YELICE_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.YELICE));
        register(context,FLAMESTHYSIA_PLACED_KEY,configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FLAMESTHYSIA_KEY),VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(1,0.1f,2),ModBlocks.FLAMESTHYSIA));


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
