package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.world.features.config.DirectionConfig;

public class SimpleVinesFeature extends Feature<DirectionConfig> {

    public SimpleVinesFeature(Codec<DirectionConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<DirectionConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        Direction direction = context.getConfig().directionprovider;
        BlockState state = context.getConfig().blockprovider.get(random, pos);
        int maxheight = Random.create().nextBetween(0,getMaxHeight(world, pos, direction));
        if(!state.canPlaceAt(world, pos)) return false;
        if (maxheight == 0) return false;
        for (int i =0; i < maxheight; i++) {
            world.setBlockState(pos.offset(direction, i), state, 2);
        }
        return true;
    }

    public int getMaxHeight(StructureWorldAccess world, BlockPos pos, Direction direction) {
        for (int i = 0; i < 12; i++) {
            if (world.getBlockState(pos.offset(direction, i)).isAir()) continue;
            return i;
        }
        return 12;
    }
}
