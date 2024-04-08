package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.rodofire.mushrooomsmod.world.configuredfeatures.ModConfiguredFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.HugeMushroomFeatureConfig;

public class CustomPurpleMushroomFeature extends CustomPurpleMushroom {
    public CustomPurpleMushroomFeature(Codec<HugeMushroomFeatureConfig> codec) {
        super(codec);
    }


    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return ModConfiguredFeatures.PURPLE_MUSHROOM_TREE_KEY;
    }

    @Override
    protected void generateCap(WorldAccess world, Random random, BlockPos start, int y, BlockPos.Mutable mutable, HugeMushroomFeatureConfig config, int i) {
        for (int j = -i; j <= i; ++j) {
            for (int k = -i; k <= i; ++k) {
                boolean bl6;
                boolean bl = j == -i;
                boolean bl2 = j == i;
                boolean bl3 = k == -i;
                boolean bl100 = k == -i+1;
                boolean bl101 = k == i-1;
                boolean bl102 = j == -i+1;
                boolean bl103 = j == i-1;
                boolean bl4 = k == i;
                boolean bl5 = bl || bl2;
                boolean bl7 = bl6 = bl3 || bl4;
                boolean bl104 = bl100 || bl101;
                boolean bl105 = bl102 || bl103;
                if (bl5 && bl6) continue;
                if (bl5 && bl104) continue;
                if (bl6 && bl105) continue;
                mutable.set(start, j, y, k);
                if (world.getBlockState(mutable).isOpaqueFullCube(world, mutable)) continue;
                BlockState blockState = config.capProvider.get(random, start);
                this.setBlockState(world, mutable, blockState);
            }
        }
    }


}
