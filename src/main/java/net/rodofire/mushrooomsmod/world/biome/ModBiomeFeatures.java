package net.rodofire.mushrooomsmod.world.biome;

import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.rodofire.mushrooomsmod.world.ModPlacedFeatures;

public class ModBiomeFeatures {
    public static void addLuminescentFlowers(GenerationSettings.LookupBackedBuilder builder){
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.BLUE_LUMINESCENT_VINES_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.FUTIALI_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.CYANEA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.NOCTULICA_PLACED_KEY);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.TURQUOSUM_STILUS_PLACED_KEY);
    }
}
