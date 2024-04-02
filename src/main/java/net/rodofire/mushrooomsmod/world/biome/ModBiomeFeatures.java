package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.rodofire.mushrooomsmod.world.biome.placedfeatures.ModUndergroundPlacedFeatures;

public class ModBiomeFeatures {
    public static void addLuminescentFlowers(GenerationSettings.LookupBackedBuilder builder){
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_UNDERGROUND_PLACED_KEY);

        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_MUSHROOM_UNDERGROUND_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.BLUE_LUMINESCENT_VINES_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.FUTIALI_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.CYANEA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.NOCTULICA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.TURQUOSUM_STILUS_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.PLATUM_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModUndergroundPlacedFeatures.SAPHIRA_FLORENS_PLACED_KEY);
    }
}
