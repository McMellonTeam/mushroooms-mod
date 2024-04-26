package net.rodofire.mushrooomsmod.world.configuredfeatures;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.rodofire.mushrooomsmod.block.ModBlocks;

public class ColorfulBushFeature extends Feature<DefaultFeatureConfig> {
    public ColorfulBushFeature(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

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
        if (!canGenerate(world, pos, large, height)) return false;
        BlockState blockState = getBlock().getDefaultState();
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
    }

    public Block getBlock() {
        int random = Random.create().nextBetween(0, 6);
        return switch (random) {
            case 0 -> ModBlocks.BLUE_COLORFUL_LEAVES;
            case 1 -> ModBlocks.RED_COLORFUL_LEAVES;
            case 2 -> ModBlocks.YELLOW_COLORFUL_LEAVES;
            case 3 -> ModBlocks.GREEN_COLORFUL_LEAVES;
            case 4 -> ModBlocks.ORANGE_COLORFUL_LEAVES;
            case 5 -> ModBlocks.PURPLE_COLORFUL_LEAVES;
            default -> ModBlocks.PINK_COLORFUL_LEAVES;
        };
    }
}
