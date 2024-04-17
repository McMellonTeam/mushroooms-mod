package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;

import java.util.ArrayList;

public class CustomPurpleSecondMushroompFeature extends CustomPurpleSecondMushroomp{

    public CustomPurpleSecondMushroompFeature(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    @Override
    public ArrayList<Vec3i> getTrunkCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random) {
        return null;
    }

    @Override
    public ArrayList<Vec3i> getCapCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random, ArrayList<Vec3i> trunkcoordinates) {
        return null;
    }

    @Override
    public void poseCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random, ArrayList<Vec3i> trunkcoordinates, ArrayList<Vec3i> capcoordinates) {
        BlockState blockState = config.stemProvider.get(random, pos);
        for (int i = 0; i < trunkcoordinates.size(); i++) {
            mutable.set(trunkcoordinates.get(i));
            world.setBlockState(mutable, blockState);
        }

        blockState = config.capProvider.get(random, pos);
        for (int i = 0; i < capcoordinates.size(); i++) {
            mutable.set(capcoordinates.get(i));
            world.setBlockState(mutable, blockState);
        }
    }


}
