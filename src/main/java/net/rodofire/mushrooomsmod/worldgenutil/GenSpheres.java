package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;

public class GenSpheres {
    public static void generateHalfSphere(StructureWorldAccess world, Random random, int largex, BlockPos pos, Direction direction, BlockState state) {
        if (direction == Direction.UP) {
            generateFullSphere(world, random, largex, largex, largex, pos, state, false, -largex, largex, 0, largex, -largex, largex);
            return;
        }
        if (direction == Direction.DOWN) {
            generateFullSphere(world, random, largex, largex, largex, pos, state, false, -largex, largex, 0, largex, -largex, largex);
            return;
        }
        if (direction == Direction.WEST) {
            generateFullSphere(world, random, largex, largex, largex, pos, state, false, 0, largex, -largex, largex, -largex, largex);
            return;
        }
        if (direction == Direction.EAST) {
            generateFullSphere(world, random, largex, largex, largex, pos, state, false, -largex, 0, -largex, largex, -largex, largex);
            return;
        }
        if (direction == Direction.NORTH) {
            generateFullSphere(world, random, largex, largex, largex, pos, state, false, -largex, largex, -largex, largex, -largex, 0);
            return;
        }

        generateFullSphere(world, random, largex, largex, largex, pos, state, false, -largex, largex, 0, largex, 0, largex);
    }

    public static void generateSphere(StructureWorldAccess world, Random random, int largex, BlockPos pos, BlockState state) {
        generateFullSphere(world, random, largex, largex, largex, pos, state, false, -largex, largex, -largex, largex, -largex, largex);
    }

    public static void generateSphere(StructureWorldAccess world, Random random, int largex, BlockPos pos, BlockState state, boolean force) {
        generateFullSphere(world, random, largex, largex, largex, pos, state, force, -largex, largex, -largex, largex, -largex, largex);
    }

    //Using carthesian coordinates beacause it have better performance than using trigonometry
    public static void generateFullSphere(StructureWorldAccess world, Random random, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force, int minx, int maxx, int miny, int maxy, int minz, int maxz) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int x = minx; x <= maxx; x++) {
            for (int y = miny; y <= maxy; y++) {
                for (int z = minz; z <= maxz; z++) {

                    if (x * x / (largex * largex) + y * y / (largey * largey) + z * z / (largez * largez) <= 1) {
                        mutable.set(pos, x, y, z);
                        if (!force) {
                            if (world.getBlockState(mutable).isAir()) {
                                world.setBlockState(mutable, state, 2);
                            }
                        } else {
                            world.setBlockState(mutable, state, 2);
                        }
                    }
                }
            }
        }
    }
}
