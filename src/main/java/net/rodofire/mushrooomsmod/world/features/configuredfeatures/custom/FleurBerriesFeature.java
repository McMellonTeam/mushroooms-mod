package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class FleurBerriesFeature extends Feature<DefaultFeatureConfig> {
    public FleurBerriesFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockState state = ModBlocks.FLEUR_BERRIES.getDefaultState();
        BlockPos pos = context.getOrigin();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int a = 0; a <= 55; a++) {
            mutable.set(pos, Random.create().nextBetween(-9, 9), Random.create().nextBetween(-3, 3), Random.create().nextBetween(-9, 9));
            if (state.canPlaceAt(world, mutable.down()) && world.getBlockState(mutable).isAir() && world.getBlockState(mutable.up()).isAir()) {
                world.setBlockState(mutable, state.with(Properties.AGE_3, Random.create().nextBetween(0, 3)), 2);
            }
        }
        return true;
    }
}
