package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.world.gen.feature.FeatureConfig;

public class ArchConfig implements FeatureConfig {
    public static final Codec<ArchConfig> CODEC = RecordCodecBuilder.create(instance -> {
        MapCodec<Integer> maxInnerRadius = Codecs.POSITIVE_INT.fieldOf("max_inner_radius");
        MapCodec<Integer> minInnerRadius = Codecs.POSITIVE_INT.fieldOf("min_inner_radius");
        MapCodec<Integer> maxOuterRadius = Codecs.POSITIVE_INT.fieldOf("max_outer_radius");
        MapCodec<Integer> minOuterRadius = Codecs.POSITIVE_INT.fieldOf("min_outer_radius");
        MapCodec<Integer> maxXRotation = Codecs.POSITIVE_INT.fieldOf("max_x_rotation");
        MapCodec<Integer> maxYRotation = Codecs.POSITIVE_INT.fieldOf("max_y_rotation");
        MapCodec<Integer> max2xRotation = Codecs.POSITIVE_INT.fieldOf("max_2x_rotation");

        return instance.group(
                maxInnerRadius.forGetter(archConfig -> archConfig.maxInnerRadius),
                minInnerRadius.forGetter(archConfig -> archConfig.minInnerRadius),
                maxOuterRadius.forGetter(archConfig -> archConfig.maxOuterRadius),
                minOuterRadius.forGetter(archConfig -> archConfig.minInnerRadius),
                maxXRotation.forGetter(archConfig -> archConfig.maxXRotation),
                maxYRotation.forGetter(archConfig -> archConfig.maxYRotation),
                max2xRotation.forGetter(archConfig -> archConfig.max2xRotation)
        ).apply(instance, ArchConfig::new);
    });

    public final int maxInnerRadius;
    public final int minInnerRadius;
    public final int maxOuterRadius;
    public final int minOuterRadius;
    public final int maxXRotation;
    public final int maxYRotation;
    public final int max2xRotation;


    public ArchConfig(final int maxInnerRadius, final int minInnerRadius, final int maxOuterRadius, final int minOuterRadius, final int maxXRotation, final int maxYRotation, final int max2xRotation) {
        this.maxInnerRadius = maxInnerRadius;
        this.minInnerRadius = minInnerRadius;
        this.maxOuterRadius = maxOuterRadius;
        this.minOuterRadius = minOuterRadius;
        this.maxXRotation = maxXRotation;
        this.maxYRotation = maxYRotation;
        this.max2xRotation = max2xRotation;
    }

}
