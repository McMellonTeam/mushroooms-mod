package net.rodofire.mushrooomsmod.world.structures.custom.config.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.rodofire.easierworldcreator.shape.block.rotations.Rotator;

public record YellowMushroomGeneratorConfig(BlockPos start, BlockPos end, boolean flat, int radius, Rotator rotator) {
    public static final Codec<YellowMushroomGeneratorConfig> CODEC = RecordCodecBuilder.create((instance) ->
            instance.group(
                    BlockPos.CODEC.fieldOf("start").forGetter(YellowMushroomGeneratorConfig::start),
                    BlockPos.CODEC.fieldOf("end").forGetter(YellowMushroomGeneratorConfig::end),
                    Codec.BOOL.fieldOf("flat").forGetter(YellowMushroomGeneratorConfig::flat),
                    Codec.INT.fieldOf("radius").forGetter(YellowMushroomGeneratorConfig::radius),
                    Rotator.CODEC.fieldOf("rotator").forGetter(YellowMushroomGeneratorConfig::rotator)
            ).apply(instance, YellowMushroomGeneratorConfig::new));
}
