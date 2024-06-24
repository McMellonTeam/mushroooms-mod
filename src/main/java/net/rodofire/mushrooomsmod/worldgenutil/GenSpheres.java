package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;

public class GenSpheres {
    public static void generateHalfSphere(StructureWorldAccess world, int largex, BlockPos pos, Direction direction, BlockState state) {
        if (direction == Direction.UP) {
            generateFullEllipsoid(world,  largex, largex, largex, pos, state, false, -largex, largex, 0, largex, -largex, largex);
            return;
        }
        if (direction == Direction.DOWN) {
            generateFullEllipsoid(world,  largex, largex, largex, pos, state, false, -largex, largex, 0, largex, -largex, largex);
            return;
        }
        if (direction == Direction.WEST) {
            generateFullEllipsoid(world,  largex, largex, largex, pos, state, false, 0, largex, -largex, largex, -largex, largex);
            return;
        }
        if (direction == Direction.EAST) {
            generateFullEllipsoid(world,  largex, largex, largex, pos, state, false, -largex, 0, -largex, largex, -largex, largex);
            return;
        }
        if (direction == Direction.NORTH) {
            generateFullEllipsoid(world,  largex, largex, largex, pos, state, false, -largex, largex, -largex, largex, -largex, 0);
            return;
        }
        generateFullEllipsoid(world,  largex, largex, largex, pos, state, false, -largex, largex, 0, largex, 0, largex);
    }

    public static void generateSphere(StructureWorldAccess world, int radius, BlockPos pos, BlockState state) {
        generateFullEllipsoid(world,  radius, radius, radius, pos, state, false, -radius, radius, -radius, radius, -radius, radius);
    }

    public static void generateSphere(StructureWorldAccess world, int radius, BlockPos pos, BlockState state, boolean force) {
        generateFullEllipsoid(world,  radius, radius, radius, pos, state, force, -radius, radius, -radius, radius, -radius, radius);
    }

    public static void generateFullElipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state) {
        generateFullEllipsoid(world, largex, largey, largez, pos, state, false, -largex, largex, -largey, largey, -largez, largez);
    }

    public static void generateFullElipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force) {
        generateFullEllipsoid(world, largex, largey, largez, pos, state, force, -largex, largex, -largey, largey, -largez, largez);
    }


    //Using carthesian coordinates beacause it have better performance than using trigonometry
    public static void generateFullEllipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force, int minx, int maxx, int miny, int maxy, int minz, int maxz) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (float x = minx; x <= maxx; x++) {
            for (float y = miny; y <= maxy; y++) {
                for (float z = minz; z <= maxz; z++) {
                    if ((x * x) / (largex * largex) + (y * y) / (largey * largey) + (z * z) / (largez * largez) <= 1) {
                        mutable.set(pos, (int) x, (int) y, (int) z);
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


    public static void generateEmptySphere(StructureWorldAccess world, int largex, BlockPos pos, BlockState state) {
        generateEmptyEllipsoid(world, largex, largex, largex, pos, state, false);
    }

    public static void generateEmptySphere(StructureWorldAccess world, int largex, BlockPos pos, BlockState state, boolean force) {
        generateEmptyEllipsoid(world, largex, largex, largex, pos, state, force);
    }

    public static void generateEmptyEllipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force) {
        int maxlarge = Math.max(largez, Math.max(largex, largey));
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (double theta = -Math.PI; theta <= Math.PI; theta += Math.PI / (4 * maxlarge)) {
            for (double phi = -Math.PI / 2; phi <= Math.PI / 2; phi += Math.PI / (4 * maxlarge)) {
                int x = (int) (largex * Math.cos(theta) * Math.cos(phi));
                int y = (int) (largey * Math.sin(phi));
                int z = (int) (largex * Math.sin(theta) * Math.cos(phi));
                mutable.set(pos, x, y, z);
                if (!force) {
                    if (!world.getBlockState(mutable).isAir()) continue;
                }
                world.setBlockState(mutable, state, 2);
            }
        }
    }
}
