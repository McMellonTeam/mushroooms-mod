package net.rodofire.mushrooomsmod.world.structures.custom.config.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.rodofire.easierworldcreator.blockdata.blocklist.DividedBlockListManager;
import net.rodofire.easierworldcreator.structure.config.StructureGeneratorConfig;

import java.util.Arrays;

public record PurpleMushroomGeneratorConfig(DividedBlockListManager trunk, BlockPos[] end) implements StructureGeneratorConfig<PurpleMushroomGeneratorConfig> {
    public static final Codec<PurpleMushroomGeneratorConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            DividedBlockListManager.CODEC.fieldOf("trunk").forGetter(PurpleMushroomGeneratorConfig::trunk),
            Codec.list(BlockPos.CODEC).fieldOf("end_pos").forGetter(purpleMushroomGeneratorConfig -> Arrays.asList(purpleMushroomGeneratorConfig.end))
    ).apply(instance, (trunk, endList) ->
            new PurpleMushroomGeneratorConfig(trunk, endList.toArray(new BlockPos[0]))
    ));
}
