package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class DirectionConfig implements FeatureConfig {
    public static final Codec<DirectionConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<Direction> directionprovider = Direction.CODEC.fieldOf("direction");
        MapCodec<BlockStateProvider> blockprovider = BlockStateProvider.TYPE_CODEC.fieldOf("blockprovider");

        return instance.group(
                directionprovider.forGetter(config -> config.directionprovider),
                blockprovider.forGetter(config -> config.blockprovider)
        ).apply(instance, DirectionConfig::new);
    });

    public final Direction directionprovider;
    public final BlockStateProvider blockprovider;

    public DirectionConfig(final Direction directionprovider, final BlockStateProvider blockprovider) {
        this.directionprovider = directionprovider;
        this.blockprovider = blockprovider;
    }

}
