package net.rodofire.mushrooomsmod.world.configuredfeatures.custom;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class BushFeature extends Feature<DefaultFeatureConfig> {

    public BushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    //Simple Code to create a bush

    public boolean canGenerate(World world, BlockPos pos, int large, int height) {
        for (int i = 0; i < large; i++) {
            for (int j = 0; j < height; j++) {
                for (int k = 0; k < large; k++) {
                    BlockState blockState = world.getBlockState(pos.add(i, j, k));
                    if (blockState.isAir() || blockState.isOf(Blocks.GRASS) || blockState.isOf(Blocks.TALL_GRASS))
                        continue;
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        World world = (World) context.getWorld();
        BlockPos pos = context.getOrigin();
        int large = Random.create().nextBetween(2, 4);
        int height = Random.create().nextBetween(2, 3);
        if (!canGenerate(world, pos, large, height) ) return false;
        BlockState blockState = world.getBlockState(pos);
        generateBottom(world,pos.add(large / 2, 0, large / 2),large,blockState);
        for (int i = 0; i < large; i++) {
            for (int j = 1; j < height; j++) {
                for (int k = 0; k < large; k++) {
                    if (world.getBlockState(pos.add(i, j, k)) == blockState && Random.create().nextBetween(0, 1) == 0)
                        world.setBlockState(pos.add(i, j, k), blockState, 2);
                }
            }
        }
        return true;
    }
    public void generateBottom(World world, BlockPos pos, int large,  BlockState block) {
        world.setBlockState(pos, block);
        generateSides(world,pos,large,block,pos.add(1,0,0), -1,1);
        generateSides(world,pos,large,block,pos.add(0,0,1), 1,-1);
        generateSides(world,pos,large,block,pos.add(0,0,-1), -1,1);
        generateSides(world,pos,large,block,pos.add(-1,0,0), 1,1);
    }

    public void generateSides(World world, BlockPos pos, int large, BlockState block, Vec3i offset, int directionx, int directionz) {
        if (offset.getX() > large || offset.getZ() > large) return;
        if (world.getBlockState(pos.add(offset.getX() + directionx, 0, offset.getZ() + directionz)).getBlock() == block.getBlock() && Random.create().nextBetween(0, 1) == 0) {
            world.setBlockState(pos.add(offset), block);
            int i = 1;
            while (world.getBlockState(pos.down(-i)).isAir()) {
                world.setBlockState(pos.down(i), block);
                ++i;
            }
        }
        generateSides(world, pos, large,  block, offset.add(directionx, 0,0), directionx, directionz);
        generateSides(world, pos, large,  block, offset.add(0, 0,directionz), directionx, directionz);
    }
}
