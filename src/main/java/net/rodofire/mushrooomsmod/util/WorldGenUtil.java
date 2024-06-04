package net.rodofire.mushrooomsmod.util;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;

public class WorldGenUtil {
    public static void generateCircle(StructureWorldAccess world, Random random, int largex, BlockState state, BlockPos pos) {
        generateOval(world, random, largex, largex, state, pos);
    }

    public static void generateOval(StructureWorldAccess world, Random random, int largex, int largey, BlockState state, BlockPos pos) {
        for (int i = 0; )
    }

    public static void generateHalfSphere(StructureWorldAccess world, Random random, int largex, BlockPos pos, Direction direction, BlockState state) {
        double pi = Math.PI;
        if (direction == Direction.UP) {
            generateElipsoid(world, random, largex, largex, largex, pos, state, false, 0, pi / 2, -pi, pi,0);
            return;
        }
        if (direction == Direction.DOWN) {
            generateElipsoid(world, random, largex, largex, largex, pos, state, false, pi / 2, 0, -pi, pi,0);
            return;
        }
        if (direction == Direction.WEST) {
            generateElipsoid(world, random, largex, largex, largex, pos, state, false, pi / 2, pi / 2, pi / 2, (3 * pi) / 2,0);
            return;
        }
        if (direction == Direction.EAST) {
            generateElipsoid(world, random, largex, largex, largex, pos, state, false, pi / 2, pi / 2, -pi / 2, pi / 2,0);
            return;
        }
        if (direction == Direction.NORTH) {
            generateElipsoid(world, random, largex, largex, largex, pos, state, false, pi / 2, pi / 2, -pi, 0,0);
            return;
        }

        generateElipsoid(world, random, largex, largex, largex, pos, state, false, pi / 2, pi / 2, 0, pi,0);
    }

    public static void generateSphere(StructureWorldAccess world, Random random, int largex, BlockPos pos, BlockState state) {
        generateElipsoid(world, random, largex, largex, largex, pos, state, false, Math.PI / 2, Math.PI / 2, -Math.PI, Math.PI, 0);
    }

    public static void generateSphere(StructureWorldAccess world, Random random, int largex, BlockPos pos, BlockState state, boolean force) {
        generateElipsoid(world, random, largex, largex, largex, pos, state, force, Math.PI / 2, Math.PI / 2, -Math.PI, Math.PI, 0);
    }

    public static void generateElipsoid(StructureWorldAccess world, Random random, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force, double height, double height2, double large1, double large2, int full) {
        int large = Math.max(largez, Math.max(largex, largey));
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = full; i <= large; ++i) {
            for (double j = large1; j <= large2; j += Math.PI / (4 * i)) {
                for (double k = -height; k <= height2; k += Math.PI / (4 * i)) {
                    //polar coordinates
                    double x = largex * Math.cos(j) * Math.cos(k);
                    double z = largez * Math.sin(j) * Math.cos(k);
                    double y = largey * Math.sin(k);

                    mutable.set(pos, (int) x, (int) z, (int) y);
                    if (!force) {
                        if (world.getBlockState(mutable).isAir()) {
                            world.setBlockState(mutable, state, 2);
                        }
                        continue;
                    }
                    world.setBlockState(mutable, state, 2);
                }
            }
        }
    }


}
