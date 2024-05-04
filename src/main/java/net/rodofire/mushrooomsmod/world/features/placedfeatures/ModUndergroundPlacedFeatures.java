package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

import java.util.List;

public class ModUndergroundPlacedFeatures {
    //Mushrooms
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BROWN_MUSHROOM_UNDERGROUNG_PLACED_KEY = registerKey("brown_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> RED_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("red_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> FERTILE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("fertile_red_mushroom_underground_placed_key");

    //Mushrooms Flowers
    public static final RegistryKey<PlacedFeature> MUSHROOM_SIDE_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY = registerKey("mushroom_side_blue_luminescent_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_RED_UNDERGROUND_PLACED_KEY = registerKey("mushroom_small_red_underground_placed_key");
    public static final RegistryKey<PlacedFeature> MUSHROOM_SMALL_BROWN_UNDERGROUND_PLACED_KEY = registerKey("mushroom_small_brown_underground_placed_key");

    //Huge Mushrooms
    public static final RegistryKey<PlacedFeature> HUGE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("huge_red_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> HUGE_BROWN_MUSHROOM_UNDERGROUND_PLACED_KEY = registerKey("huge_brown_mushroom_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_mushroom_tree_underground_placed_key");


    //Flowers
    public static final RegistryKey<PlacedFeature> PLATUM_PLACED_KEY = registerKey("platum_placed_key");
    public static final RegistryKey<PlacedFeature> SAPHIRA_FLORENS_PLACED_KEY = registerKey("saphira_florens_placed_key");
    public static final RegistryKey<PlacedFeature> NOCTULICA_PLACED_KEY = registerKey("noctulica_placed_key");
    public static final RegistryKey<PlacedFeature> TURQUOSUM_STILUS_PLACED_KEY = registerKey("turquosum_stilus_placed_key");
    public static final RegistryKey<PlacedFeature> FUTIALI_PLACED_KEY = registerKey("futiali_placed_key");
    public static final RegistryKey<PlacedFeature> CYANEA_PLACED_KEY = registerKey("cyanea_placed_key");

    //Vines
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_UP_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_vines_underground_placed_key");
    public static final RegistryKey<PlacedFeature> BLUE_LUMINESCENT_VINES_DOWN_UNDERGROUND_PLACED_KEY = registerKey("blue_luminescent_vines_down_underground_placed_key");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        //Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_KEY), CountPlacementModifier.of(20), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_BROWN_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_BROWN_KEY), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SMALL_RED_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SMALL_RED_KEY), CountPlacementModifier.of(50), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, BROWN_MUSHROOM_UNDERGROUNG_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BROWN_MUSHROOM_KEY), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, RED_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.RED_MUSHROOM_KEY), CountPlacementModifier.of(33), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, MUSHROOM_SIDE_BLUE_LUMINESCENT_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.MUSHROOM_SIDE_BLUE_LUMINESCENT_KEY), CountPlacementModifier.of(60), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Flowers
        register(context, TURQUOSUM_STILUS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.TURQUOSUM_STILUS_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, NOCTULICA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.NOCTULICA_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, SAPHIRA_FLORENS_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.SAPHIRA_FLORENS_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, FUTIALI_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FUTIALI_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, PLATUM_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.PLATUM_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, CYANEA_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.CYANEA_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Vines
        register(context, BLUE_LUMINESCENT_VINES_UP_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_UP_KEY), CountPlacementModifier.of(11), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, BLUE_LUMINESCENT_VINES_DOWN_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_VINES_DOWN_KEY), CountPlacementModifier.of(7), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());

        //Huge Mushrooms
        register(context, BLUE_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_KEY), CountPlacementModifier.of(140), SquarePlacementModifier.of(), ModPlacedFeatures.DEEPSLATE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_BROWN_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), CountPlacementModifier.of(140), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, HUGE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), CountPlacementModifier.of(140), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
        register(context, FERTILE_RED_MUSHROOM_UNDERGROUND_PLACED_KEY, configuredFeatureRegistryEntryLookup.getOrThrow(ModConfiguredFeatures.FERTILE_RED_MUSHROOM_KEY), CountPlacementModifier.of(140), SquarePlacementModifier.of(), ModPlacedFeatures.STONE_LEVEL, BiomePlacementModifier.of());
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
