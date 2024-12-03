package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.comparator.DefaultBlockListComparator;
import net.rodofire.easierworldcreator.maths.MathUtil;
import net.rodofire.easierworldcreator.placer.blocks.util.BlockPlaceUtil;
import net.rodofire.easierworldcreator.shape.block.gen.LineGen;
import net.rodofire.easierworldcreator.shape.block.instanciator.AbstractBlockShapeBase;
import net.rodofire.mushrooomsmod.block.ModBlocks;

import java.util.List;
import java.util.Set;

public abstract class CustomYellowMushroomOTH extends Feature<HugeMushroomFeatureConfig> {

    public CustomYellowMushroomOTH(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected boolean canGenerate(StructureWorldAccess world, BlockPos start, BlockPos end, int large, boolean flat) {
        for (int i = -(int) ((flat ? 1.5f : 2) * large + 1); i < (int) ((flat ? 1.5f : 2) * large + 1); i++) {
            for (int j = (int) ((flat ? 1.5f : 2) * large + 1); j < (int) ((flat ? 1.5f : 2) * large + 1); j++) {
                for (int k = -large - 2; k < large + 2; k++) {
                    boolean bl = BlockPlaceUtil.verifyBlock(world, false, null, end.add(i, k, j));
                    System.out.println(bl);
                    if (bl)
                        continue;
                    return false;
                }
            }
        }
        LineGen line = new LineGen(world, start.up(2), AbstractBlockShapeBase.PlaceMoment.OTHER, end);
        List<Set<BlockPos>> posList = line.getBlockPos();
        for (Set<BlockPos> set : posList) {
            for (BlockPos pos : set) {
                if (BlockPlaceUtil.verifyBlock(world, false, null, pos)
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.north())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.south())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.east())
                        && BlockPlaceUtil.verifyBlock(world, false, null, pos.west()))
                    continue;
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos blockPos = context.getOrigin();
        StructureWorldAccess world = context.getWorld();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();

        boolean flatCap = MathUtil.getRandomBoolean(0.33f);
        int large;
        int height;

        DefaultBlockListComparator coordinates;

        BlockPos end;

        if (world.getBlockState(blockPos.east()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(blockPos.north()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(blockPos.south()).isOf(ModBlocks.YELLOW_MUSHROOM) || world.getBlockState(blockPos.west()).isOf(ModBlocks.YELLOW_MUSHROOM)) {
            height = Random.create().nextBetween(10, 20);
            large = Random.create().nextBetween(5, 9);
            end = blockPos.add(random.nextBetween(-10, 10), height, random.nextBetween(-10, 10));



            if (!this.canGenerate(world, blockPos, end, large, flatCap))
                return false;


            coordinates = this.generateHugeTrunk(world, blockPos, end, height, hugeMushroomFeatureConfig);
        } else {
            height = Random.create().nextBetween(5, 11);
            large = Random.create().nextBetween(10, 15);
            end = blockPos.add(random.nextBetween(-10, 10), height, random.nextBetween(-10, 10));



            if (!this.canGenerate(world, blockPos, end, large, flatCap))
                return false;

            coordinates = this.generateTrunk(world, blockPos, end, height, hugeMushroomFeatureConfig);
        }

        if (flatCap) {
            return this.generateFlatterCap(world, blockPos, end, hugeMushroomFeatureConfig, height, large, coordinates);
        }
        return this.generateCap(world, blockPos, end, hugeMushroomFeatureConfig, height, large, coordinates);
    }

    protected abstract DefaultBlockListComparator generateHugeTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config);

    protected abstract DefaultBlockListComparator generateTrunk(StructureWorldAccess world, BlockPos pos, BlockPos pos2, int height, HugeMushroomFeatureConfig config);

    protected abstract boolean generateCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DefaultBlockListComparator coordinates);

    protected abstract boolean generateFlatterCap(StructureWorldAccess world, BlockPos pos, BlockPos pos2, HugeMushroomFeatureConfig var6, int height, int large, DefaultBlockListComparator coordinates);
}
