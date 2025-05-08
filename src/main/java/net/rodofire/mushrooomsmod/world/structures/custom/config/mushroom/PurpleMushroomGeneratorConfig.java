package net.rodofire.mushrooomsmod.world.structures.custom.config.mushroom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import fr.rodofire.ewc.blockdata.blocklist.DividedBlockListManager;
import fr.rodofire.ewc.structure.config.StructureGeneratorConfig;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;

public record PurpleMushroomGeneratorConfig(DividedBlockListManager trunk, BlockPos[] end) implements StructureGeneratorConfig<PurpleMushroomGeneratorConfig> {
    public static final Codec<PurpleMushroomGeneratorConfig> CODEC = RecordCodecBuilder.create((instance) -> instance.group(
            DividedBlockListManager.CODEC.fieldOf("trunk").forGetter(PurpleMushroomGeneratorConfig::trunk),
            Codec.list(BlockPos.CODEC).fieldOf("end_pos").forGetter(purpleMushroomGeneratorConfig -> Arrays.asList(purpleMushroomGeneratorConfig.end))
    ).apply(instance, (trunk, endList) ->
            new PurpleMushroomGeneratorConfig(trunk, endList.toArray(new BlockPos[0]))
    ));
}
