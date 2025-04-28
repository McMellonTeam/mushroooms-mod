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
import net.rodofire.mushrooomsmod.world.features.config.FleurBerriesConfig;

public class FleurBerriesFeature extends Feature<FleurBerriesConfig> {
    public FleurBerriesFeature(Codec<FleurBerriesConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<FleurBerriesConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockState state = ModBlocks.FLEUR_BERRIES.getDefaultState();
        BlockPos pos = context.getOrigin();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        Random random = context.getRandom();
        FleurBerriesConfig config = context.getConfig();

        for (int a = 0; a <= config.tries(); a++) {
            mutable.set(pos, random.nextBetween(-config.horitontalSpan(), config.horitontalSpan()), random.nextBetween(-config.verticalSpan(), config.verticalSpan()), random.nextBetween(-config.horitontalSpan(), config.horitontalSpan()));
            if (state.canPlaceAt(world, mutable) && world.getBlockState(mutable).isAir() && world.getBlockState(mutable.up()).isAir()) {
                world.setBlockState(mutable, state.with(Properties.AGE_3, random.nextBetween(0, 3)), 2);
            }
        }
        return true;
    }
}
