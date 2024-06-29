package net.rodofire.mushrooomsmod.world.features.placedfeatures;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.placementmodifier.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final PlacementModifier DEEPSLATE_LEVEL = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(8));
    public static final PlacementModifier STONE_LEVEL = HeightRangePlacementModifier.uniform(YOffset.fixed(0), YOffset.belowTop(-3));
    public static final PlacementModifier AIR_LEVEL = HeightRangePlacementModifier.uniform(YOffset.belowTop(-3), YOffset.belowTop(3));
    public static final PlacementModifier CAVE_LEVEL = HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.belowTop(3));

    private static final PlacementModifier NOT_IN_SURFACE_WATER_MODIFIER = SurfaceWaterDepthFilterPlacementModifier.of(0);

    private static ImmutableList.Builder<PlacementModifier> undergorundTreeModifiersBuilder(PlacementModifier countModifier) {
        return ((ImmutableList.Builder) ImmutableList.builder().add(countModifier)).add(SquarePlacementModifier.of()).add(NOT_IN_SURFACE_WATER_MODIFIER).add(CAVE_LEVEL).add(BiomePlacementModifier.of());
    }

    public static List<PlacementModifier> undergroundTreeModifiersWithWouldSurvive(PlacementModifier modifier, Block block) {
        return ((ImmutableList.Builder) undergorundTreeModifiersBuilder(modifier).add(BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(block.getDefaultState(), BlockPos.ORIGIN)))).build();
    }
}
