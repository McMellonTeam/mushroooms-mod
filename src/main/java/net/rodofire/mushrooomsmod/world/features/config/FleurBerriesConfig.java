package net.rodofire.mushrooomsmod.world.features.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.gen.feature.FeatureConfig;

public record FleurBerriesConfig(int tries, int horitontalSpan, int verticalSpan) implements FeatureConfig {
    public static final Codec<FleurBerriesConfig> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("tries").forGetter(FleurBerriesConfig::tries),
            Codec.INT.fieldOf("horizontal_span").forGetter(FleurBerriesConfig::horitontalSpan),
            Codec.INT.fieldOf("vertical_span").forGetter(FleurBerriesConfig::verticalSpan)
    ).apply(instance, FleurBerriesConfig::new));

}
