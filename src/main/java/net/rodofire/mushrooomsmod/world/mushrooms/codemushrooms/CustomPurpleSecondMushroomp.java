package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;


public abstract class CustomPurpleSecondMushroomp extends Feature<ModMushroomFeatureConfig> {
    public CustomPurpleSecondMushroomp(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    public static boolean canGenerate(World world, Random random, ModMushroomFeatureConfig config, ArrayList<Vec3i> trunkcoordinates,ArrayList<Vec3i> capcoordinates, BlockPos pos) {
        for (int i = 0; i < trunkcoordinates.size() / 3; i++) {
            Vec3i vec = trunkcoordinates.get(i);
            pos.add(vec);
            BlockState blockState = world.getBlockState(pos);
            if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES)) continue;
            return false;
        }
        for (int i = 0; i < capcoordinates.size() / 3; i++) {
            Vec3i vec = capcoordinates.get(i);
            pos.add(vec);
            BlockState blockState = world.getBlockState(pos);
            if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES)) continue;
            return false;
        }
        return true;
    }

    @Override
    public boolean generate(FeatureContext<ModMushroomFeatureConfig> context) {
        World world = (World) context.getWorld();
        BlockPos pos = context.getOrigin();
        ModMushroomFeatureConfig config = context.getConfig();
        Random random = context.getRandom();
        BlockPos.Mutable mutable = new BlockPos.Mutable();

        ArrayList<Vec3i> trunkcoordinates = getTrunkCoordinates(world, pos, mutable = pos.mutableCopy(), config, random);
        ArrayList<Vec3i> capcoordinates = getCapCoordinates(world, pos, mutable = pos.mutableCopy(), config, random, trunkcoordinates);

        if (!canGenerate(world, random, config,trunkcoordinates, capcoordinates, pos)) return false;

        this.poseCoordinates(world, pos, mutable, config, random, trunkcoordinates, capcoordinates);
        return true;
    }

    public abstract ArrayList<Vec3i> getTrunkCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random);
    public abstract ArrayList<Vec3i> getCapCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random,ArrayList<Vec3i> trunkcoordinates);

    public abstract void poseCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random, ArrayList<Vec3i> trunkcoordinates,ArrayList<Vec3i> Capcoordinates);
}
