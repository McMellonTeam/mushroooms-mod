package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

public class GenSpiral {
    public static void generateSpiral(int large, int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos) {
        generateSpiral(radius, height, turn, blockState, world, pos, false, 0);
    }

    public static void generateSpiral(int radius, int height, int turn, BlockState blockState, StructureWorldAccess world, BlockPos pos, boolean force, double k) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (double i = 0; i < radius * height * turn; i++) {
            int x = (int) (radius * Math.cos(i + k));
            int z = (int) (radius * Math.sin(i + k));
            int y = (int) (i / radius * turn);

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
                    mutable.set(pos, i, j, i);
                    generateSpiral(radius, height, turn, blockState, world, mutable, false, 0);
                }
            }
        }
    }
}
