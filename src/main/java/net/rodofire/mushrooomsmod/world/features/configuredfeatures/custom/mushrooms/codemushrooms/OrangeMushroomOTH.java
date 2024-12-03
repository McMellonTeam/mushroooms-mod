package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.easierworldcreator.blockdata.blocklist.basic.DefaultBlockList;
import net.rodofire.easierworldcreator.placer.blocks.util.BlockPlaceUtil;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public abstract class OrangeMushroomOTH extends Feature<DefaultFeatureConfig> {
    protected BlockPos end;

    public OrangeMushroomOTH(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    public boolean canGenerate(StructureWorldAccess world, BlockPos pos, int large,int largeY, int height) {
        for(int i = -1; i <= 1; ++i) {
            for(int j = 1; j <= height; ++j) {
                for(int k = -1; k <= 1; ++k) {
                    if (BlockPlaceUtil.verifyBlock(world, false, null, pos.add(i, j, k))) continue;
                    return false;
                }
            }
        }
        for(int i = -large; i <= large; ++i) {
            for(int j = -largeY/2; j <= largeY; ++j) {
                for(int k = -large; k <= large; ++k) {
                    if (BlockPlaceUtil.verifyBlock(world, false, null, end.add(i, j, k))) continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random random = context.getRandom();
        System.out.println("hi");
        if (world.getBlockState(pos.east()).isOf(ModBlocks.ORANGE_MUSHROOM) || world.getBlockState(pos.north()).isOf(ModBlocks.ORANGE_MUSHROOM) || world.getBlockState(pos.south()).isOf(ModBlocks.ORANGE_MUSHROOM) || world.getBlockState(pos.west()).isOf(ModBlocks.ORANGE_MUSHROOM)) {
            int radius = random.nextBetween(5, 10);
            int radiusY = (int) ((float) random.nextBetween(20, 45) / 10 * radius + random.nextBetween(2, 6));
            int height = 3 * radiusY / 4;

            this.end = pos.up(height);
            if(!canGenerate(world, pos, radius, radiusY, height)) {
                return false;
            }

            DefaultBlockList blockList = this.getHugeTrunk(world, random, pos, radius, height);
            this.getCap(world, random, pos, radius, radiusY, blockList);
            return true;
        }
        int radius = random.nextBetween(3, 5);
        int radiusY = (int) ((float) random.nextBetween(20, 40) / 10 * radius + random.nextBetween(2, 6));
        int height = 3 * radiusY / 4;

        this.end = pos.up(height);
        if(!canGenerate(world, pos, radius, radiusY, height)) {
            return false;
        }

        DefaultBlockList blockList = this.getTrunk(world, random, pos, radius, height);
        this.getCap(world, random, pos, radius, radiusY, blockList);
        return true;
    }

    protected abstract DefaultBlockList getHugeTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height);


    protected abstract DefaultBlockList getTrunk(StructureWorldAccess world, Random random, BlockPos pos, int radius, int height);

    protected abstract void getCap(StructureWorldAccess world, Random random, BlockPos pos, int radius, int radiusY, DefaultBlockList trunk);

}
