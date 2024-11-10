package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.custom.StraightCrystal;
import net.rodofire.mushrooomsmod.world.features.config.CrystalConfig;


public class CrystalFeature extends Feature<CrystalConfig> {
    public CrystalFeature(Codec<CrystalConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public boolean generate(FeatureContext<CrystalConfig> context) {
        CrystalConfig config = context.getConfig();
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        mutable.set(pos);
        Random random = world.getRandom();

        int width = config.spreadwidth;
        int maxheight = config.maxheight;
        BlockState blockState = config.blockprovider.get(random, pos);

        for (int i = 0; i<width; i++) {
            mutable.set(pos);
            mutable.move(Random.create().nextBetween(-width, width), Random.create().nextBetween(-width, width), Random.create().nextBetween(-width, width));
            Direction direction = getDirection(world, mutable);
            if (direction == null) continue;
            maxheight = getHeight(world, mutable, direction, maxheight);
            if (maxheight <= 0) continue;
            int height = Random.create().nextBetween(1, maxheight);
            generateColumn(world, mutable, direction, height, blockState);
        }
        return true;
    }

    public Direction getDirection(StructureWorldAccess world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        if (world.getBlockState(pos.down()).isOpaqueFullCube() && state.isAir()) return Direction.UP;
        if (world.getBlockState(pos.up()).isOpaqueFullCube() && state.isAir()) return Direction.DOWN;
        return null;
    }

    public int getHeight(StructureWorldAccess world, BlockPos pos, Direction direction, int maxheight) {
        for (int i = 0 ; i<maxheight;++i){
            if (world.getBlockState(pos.offset(direction, i)).isAir()) continue;
            return i;
        }
        return maxheight-1;
    }

    public void generateColumn(StructureWorldAccess world, BlockPos pos, Direction direction, int maxheight, BlockState state) {
        for (int i = 0 ; i<maxheight;++i){
            world.setBlockState(pos.offset(direction, i), state.with(StraightCrystal.VERTICAL_DIRECTION, direction).with(StraightCrystal.STAGE, 1), 2);
        }
        world.setBlockState(pos.offset(direction, maxheight), state.with(StraightCrystal.VERTICAL_DIRECTION, direction).with(StraightCrystal.STAGE, 0), 2);
    }
}
