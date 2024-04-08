package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;

public abstract class CustomLuminescentBlueMushroom extends Feature<HugeMushroomFeatureConfig> {
    public CustomLuminescentBlueMushroom(Codec<HugeMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    protected void generateStem(WorldAccess world, Random random, BlockPos pos, HugeMushroomFeatureConfig config, int height, BlockPos.Mutable mutablePos) {
        for (int i = 0; i < height; ++i) {
            mutablePos.set(pos).move(Direction.UP, i);
            if (world.getBlockState(mutablePos).isOpaqueFullCube(world, mutablePos)) continue;
            this.setBlockState(world, mutablePos, config.stemProvider.get(random, pos));
        }
    }

    protected int getHeight(Random random) {
        int i = random.nextInt(3) + 4;
        if (random.nextInt(12) == 0) {
            i *= 2;
        }
        return i;
    }

    protected boolean canGenerate(WorldAccess world, BlockPos pos, int height, BlockPos.Mutable mutablePos, HugeMushroomFeatureConfig config, int large) {
        BlockState blockState = world.getBlockState(pos.down());
        if (!blockState.isIn(BlockTags.DIRT) && !blockState.isIn(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return false;
        }
        for (int j = height - 3; j <= height; ++j) {
            int k = large;
            for (int l = -k; l <= k; ++l) {
                for (int m = -k; m <= k; ++m) {
                    BlockState blockState2 = world.getBlockState(mutablePos.set(pos, l, j, m));
                    if (blockState2.isAir() || blockState2.isIn(BlockTags.LEAVES))
                        continue;
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<HugeMushroomFeatureConfig> context) {
        BlockPos.Mutable mutable;
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        Random random = context.getRandom();
        HugeMushroomFeatureConfig hugeMushroomFeatureConfig = context.getConfig();
        int i = this.getHeight(random);
        int large = this.getCapSize(hugeMushroomFeatureConfig.foliageRadius);
        if (!this.canGenerate(structureWorldAccess, blockPos, i, mutable = new BlockPos.Mutable(), hugeMushroomFeatureConfig, large)) {
            return false;
        }
        this.generateCap(structureWorldAccess, random, blockPos, i, mutable, hugeMushroomFeatureConfig, large);
        this.generateStem(structureWorldAccess, random, blockPos, hugeMushroomFeatureConfig, i, mutable);
        return true;
    }

    protected abstract int getCapSize(int var1);

    protected abstract void generateCap(WorldAccess var1, Random var2, BlockPos var3, int var4, BlockPos.Mutable var5, HugeMushroomFeatureConfig var6, int large);
}
