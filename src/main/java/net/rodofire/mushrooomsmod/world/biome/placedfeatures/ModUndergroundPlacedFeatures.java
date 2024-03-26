package net.rodofire.mushrooomsmod.world.biome.placedfeatures;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.*;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.ModConfiguredFeatures;

import java.util.List;

public class ModUndergroundPlacedFeatures {

    public static final RegistryKey<PlacedFeature> PLATUM_PLACED_KEY = registerKey("platum_placed_key");

    public static final RegistryKey<PlacedFeature> SAPHIRA_FLORENS_PLACED_KEY = registerKey("saphira_florens_placed_key");

    public static final RegistryKey<PlacedFeature> NOCTULICA_PLACED_KEY = registerKey("noctulica_placed_key");

    public static final RegistryKey<PlacedFeature> TURQUOSUM_STILUS_PLACED_KEY = registerKey("turquosum_stilus_placed_key");

    public static final RegistryKey<PlacedFeature> FUTIALI_PLACED_KEY = registerKey("futiali_placed_key");

    public static final RegistryKey<PlacedFeature> CYANEA_PLACED_KEY = registerKey("cyanea_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_PLACED_KEY = registerKey("blue_luminescent_vines_placed_key");

    //Vines

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, TURQUOSUM_STILUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS_KEY), CountPlacementModifier.of(17), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());
        register(context, NOCTULICA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOCTULICA_KEY), CountPlacementModifier.of(17), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());
        register(context, SAPHIRA_FLORENS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS_KEY), CountPlacementModifier.of(17), SquarePlacementModifier.of(), PlacedFeatures.FOUR_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());
        register(context, FUTIALI_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FUTIALI_KEY), CountPlacementModifier.of(17), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());
        register(context, PLATUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLATUM_KEY), CountPlacementModifier.of(17), SquarePlacementModifier.of(), PlacedFeatures.FOUR_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());
        register(context, CYANEA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANEA_KEY), CountPlacementModifier.of(17), SquarePlacementModifier.of(), PlacedFeatures.FOUR_ABOVE_AND_BELOW_RANGE, BiomePlacementModifier.of());

        //Vines
        register(context, BLUE_LUMINESCENT_VINES_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_KEY), CountPlacementModifier.of(22), SquarePlacementModifier.of(), PlacedFeatures.BOTTOM_TO_120_RANGE, BiomePlacementModifier.of());

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
