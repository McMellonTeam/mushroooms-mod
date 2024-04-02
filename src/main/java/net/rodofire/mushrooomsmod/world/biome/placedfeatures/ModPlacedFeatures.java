package net.rodofire.mushrooomsmod.world.biome.placedfeatures;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class ModPlacedFeatures {
    public static final PlacementModifier DEEPSLATE_LEVEL = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(10));
}
