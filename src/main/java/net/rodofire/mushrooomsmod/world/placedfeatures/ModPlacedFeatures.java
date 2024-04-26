package net.rodofire.mushrooomsmod.world.placedfeatures;

import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

public class ModPlacedFeatures {
    public static final PlacementModifier DEEPSLATE_LEVEL = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(8));
    public static final PlacementModifier STONE_LEVEL = HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.getTop());
}
