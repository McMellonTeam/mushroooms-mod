package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ModSimpleBlockFeatureConfig implements FeatureConfig {
    public static final Codec<ModSimpleBlockFeatureConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<BlockStateProvider> blockprovider = BlockStateProvider.TYPE_CODEC.fieldOf("blockprovider");

        return instance.group(
                blockprovider.forGetter(config -> config.blockprovider)
        ).apply(instance, ModSimpleBlockFeatureConfig::new);
    });

    public final BlockStateProvider blockprovider;

    public ModSimpleBlockFeatureConfig(final BlockStateProvider blockprovider) {
        this.blockprovider = blockprovider;
    }
}
