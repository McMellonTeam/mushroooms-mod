package net.rodofire.mushrooomsmod.world.structures.custom.config.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.rodofire.easierworldcreator.shape.block.gen.SphereGen;

public record GiantYellowMushroomGeneratorConfig(SphereGen sphere, SphereGen mask, BlockPos start, BlockPos end) {
    public static final Codec<GiantYellowMushroomGeneratorConfig> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(
                    SphereGen.CODEC.fieldOf("sphere").forGetter(GiantYellowMushroomGeneratorConfig::sphere),
                    SphereGen.CODEC.fieldOf("mask").forGetter(GiantYellowMushroomGeneratorConfig::mask),
                    BlockPos.CODEC.fieldOf("start").forGetter(GiantYellowMushroomGeneratorConfig::start),
                    BlockPos.CODEC.fieldOf("end").forGetter(GiantYellowMushroomGeneratorConfig::end)
            ).apply(instance, GiantYellowMushroomGeneratorConfig::new));

}
