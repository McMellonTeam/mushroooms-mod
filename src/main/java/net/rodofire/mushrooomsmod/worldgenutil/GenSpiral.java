package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.util.MathsUtil;

public class GenSpiral {
    public static void generateSpiral(int large, int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos) {
        generateSpiral(radius, height, turn, blockState, world, pos, false, 0);
    }

    /**
     * @param radius     the radius of the spiral
     * @param height     the height of the spiral
     * @param turn       the number of turns that de spiral is going to do
     * @param blockState the blockstate used by the spiral
     * @param world      the world
     * @param pos        the pos of the center of the spiral
     * @param force      force the blockpos (will put the block no matter what block is at the current pos)
     * @param k          the cosinus offset in degrees
     */

    public static void generateSpiral(int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos, boolean force, double k) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        if (turn <= 0) {
            MushrooomsMod.LOGGER.error("param turn can't be <= 0");
        }
        double f = (1.5 * turn);
        double a = (double) 360 / (1.5 * height);
        for (double i = 0; i < 1.5 * turn * height; i++) {
            int x = (int) (radius * MathsUtil.getFastCos(a * i + k));
            int z = (int) (radius * MathsUtil.getFastSin(a * i + k));
            int y = (int) (i / f);

            mutable.set(pos, x, y, z);
            if (!force) {
                if (!world.getBlockState(mutable).isAir()) continue;
            }
            world.setBlockState(mutable, blockState, 2);
        }
    }

    public static void generateFullSpiral(int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos) {
        generateFullSpiral(radius, height, turn, blockState, world, pos, false);
    }

    public static void generateFullSpiral(int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos, boolean force) {
        for (int i = 0; i <= radius; i++) {
            generateSpiral(i, height, turn, blockState, world, pos, force, 0);
        }
    }

    public static void generateLargeFullSpiral(int large, int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int largesquared = large * large;
        for (int i = 0; i <= large; i++) {
            for (int j = 0; j <= large; j++) {
                if (i * i + j * j <= largesquared) {
                    mutable.set(pos, i, 0, j);
                    generateSpiral(radius, height, turn, blockState, world, mutable, false, 0);
                }
            }
        }
    }
}
