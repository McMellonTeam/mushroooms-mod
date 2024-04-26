package net.rodofire.mushrooomsmod.world.mushrooms.codemushrooms;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.ModBlocks;
import net.rodofire.mushrooomsmod.feature.mushroomfeature.ModMushroomFeatureConfig;
import net.minecraft.util.math.random.Random;

import java.util.ArrayList;


public abstract class CustomPurpleSecondMushroomp extends Feature<ModMushroomFeatureConfig> {
    public CustomPurpleSecondMushroomp(Codec<ModMushroomFeatureConfig> configCodec) {
        super(configCodec);
    }

    public static boolean canGenerate(World world, Random random, ModMushroomFeatureConfig config, ArrayList<Vec3i> trunkcoordinates,ArrayList<Vec3i> capcoordinates, BlockPos pos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i < trunkcoordinates.size(); i++) {
            Vec3i vec = trunkcoordinates.get(i);
            mutable.set(pos, vec);
            BlockState blockState = world.getBlockState(mutable);
            if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES)||blockState.isOf(ModBlocks.BIG_PURPLE_MUSHROOM)) continue;
            return false;
        }
        for (int i = 0; i < capcoordinates.size(); i++) {
            Vec3i vec = capcoordinates.get(i);
            mutable.set(pos, vec);
            BlockState blockState = world.getBlockState(mutable);
            if (blockState.isAir() || blockState.isIn(BlockTags.LEAVES)||blockState.isOf(ModBlocks.BIG_PURPLE_MUSHROOM)) continue;
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
        int maxheight = 25;
        int minheight = 11;
        int cap = Random.create().nextBetween(2,3);

        ArrayList<Vec3i> trunkcoordinates = getTrunkCoordinates( mutable = pos.mutableCopy(), config, random,maxheight,minheight, cap);
        ArrayList<Vec3i> capcoordinates = getCapCoordinates(world, pos, mutable = pos.mutableCopy(), config, random, trunkcoordinates, cap);

        if (!canGenerate(world, random, config,trunkcoordinates, capcoordinates, pos)) return false;

        this.poseCoordinates(world, pos, mutable, config, random, trunkcoordinates, capcoordinates);
        return true;
    }

    public abstract ArrayList<Vec3i> getTrunkCoordinates( BlockPos pos,  ModMushroomFeatureConfig config, Random random, int maxheight, int minheight, int cap);
    public abstract ArrayList<Vec3i> getCapCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random,ArrayList<Vec3i> trunkcoordinates, int cap);

    public abstract void poseCoordinates(World world, BlockPos pos, BlockPos.Mutable mutable, ModMushroomFeatureConfig config, Random random, ArrayList<Vec3i> trunkcoordinates,ArrayList<Vec3i> Capcoordinates);
}
