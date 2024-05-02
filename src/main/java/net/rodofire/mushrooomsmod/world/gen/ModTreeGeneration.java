package net.rodofire.mushrooomsmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.rodofire.mushrooomsmod.world.features.placedfeatures.ModSurfacePlacedFeatures;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;

public class ModTreeGeneration {
    public static void generateTrees(){
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MUSHROOM_FIELDS), GenerationStep.Feature.VEGETAL_DECORATION, ModSurfacePlacedFeatures.PINK_LUMINESCENT_MUSHROOM_TREE_PLACED_KEY);
    }
}
