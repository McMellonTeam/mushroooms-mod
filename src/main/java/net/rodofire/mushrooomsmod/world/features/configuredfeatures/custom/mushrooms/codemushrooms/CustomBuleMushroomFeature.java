package net.rodofire.mushrooomsmod.world.features.configuredfeatures.custom.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.mushrooomsmod.util.MathsUtil;
import net.rodofire.mushrooomsmod.world.features.config.ModMushroomFeatureConfig;

public class CustomBuleMushroomFeature extends CustomBlueMushroom {
    public CustomBuleMushroomFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public void generateCap(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config) {

    }

    @Override
    public void generateLargeCap(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config) {

    }

    @Override
    public void generateTrunk(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config, BlockState trunk, boolean force) {

    }

    @Override
    public void generateLargeTrunk(StructureWorldAccess world, Random random, BlockPos pos, ModMushroomFeatureConfig config, BlockState trunk, boolean force, int height, int maxlarge, int minlarge) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int u = 0; u <= height; u++) {
            for (int v = -15; v <= 15; v++) {
                double oscilations = maxlarge * MathsUtil.getFastCos((double) (u * 45) / height);
                int x = (int) (oscilations * Math.cos(v) + minlarge * MathsUtil.getFastCos(v));
                int z = (int) (oscilations * Math.sin(v) + minlarge * MathsUtil.getFastSin(v));
                mutable.set(x, u, z);

                if (!force) {
                    if (!world.getBlockState(mutable).isAir()) continue;
                }
                world.setBlockState(mutable, trunk, 2);

            }
        }
    }


}
