package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.rock;

import com.mojang.serialization.Codec;
import fr.rodofire.ewc.blockdata.layer.BlockLayer;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.util.RockUtil;

public abstract class SakuraPlainRock extends DefaultRockFeature {
    public SakuraPlainRock(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public BlockLayer getBlockLayer(Random random, long seed) {
        return RockUtil.getRandomBlockLayer(
                random.nextBetween(3, 7),
                random.nextBetween(1, 5),
                Blocks.STONE.getDefaultState(),
                seed,
                RockUtil.getRandomStone(random, Blocks.TUFF.getDefaultState()));
    }
}
