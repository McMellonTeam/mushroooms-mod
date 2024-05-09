package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;
import net.rodofire.mushrooomsmod.world.features.configuredfeatures.ModConfiguredFeatures;

public class CustomLuminescentBlueMushroomFeature extends CustomLuminescentBlueMushroom {

    public CustomLuminescentBlueMushroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }

    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.BLUE_LUMINESCENT_MUSHROOM_TREE_KEY;
    }

    @Override
    protected int getCapSize(int capSize) {
        return Random.create().nextBetween(capSize - 1, capSize);
    }


    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int large) {
        for (int i = y - 3; i <= y; ++i) {
            int j = i < y ? large : large - 1;
            for (int l = -j; l <= j; ++l) {
                for (int m = -j; m <= j; ++m) {
                    boolean bl6;
                    boolean bl = l == -j;
                    boolean bl2 = l == j;
                    boolean bl3 = m == -j;
                    boolean bl4 = m == j;
                    boolean bl5 = bl || bl2;
                    boolean bl7 = bl6 = bl3 || bl4;
                    if (i < y && bl5 == bl6) continue;
                    mutable.set(start, l, i, m);
                    if (world.getBlockState(mutable).isOpaqueFullCube(world, mutable)) continue;
                    BlockState blockState = config.capProvider.get(random, start);
                    this.setBlockState(world, mutable, blockState);
                }
            }
        }
    }
}
