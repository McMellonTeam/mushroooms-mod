package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.rodofire.mushrooomsmod.MushrooomsMod;
import net.rodofire.mushrooomsmod.util.MathsUtil;

import java.util.Arrays;

public class GenSpheres {
    public static void generateHalfFullSphere(StructureWorldAccess world, int largex, BlockPos pos, Direction direction, BlockState state) {
        if (direction == Direction.UP) {
            generateFullEllipsoid(world, largex, largex, largex, pos, state, false, -largex, largex, 0, largex, -largex, largex);
            return;
        }
        if (direction == Direction.DOWN) {
            generateFullEllipsoid(world, largex, largex, largex, pos, state, false, -largex, largex, -largex, 0, -largex, largex);
            return;
        }
        if (direction == Direction.WEST) {
            generateFullEllipsoid(world, largex, largex, largex, pos, state, false, 0, largex, -largex, largex, -largex, largex);
            return;
        }
        if (direction == Direction.EAST) {
            generateFullEllipsoid(world, largex, largex, largex, pos, state, false, -largex, 0, -largex, largex, -largex, largex);
            return;
        }
        if (direction == Direction.NORTH) {
            generateFullEllipsoid(world, largex, largex, largex, pos, state, false, -largex, largex, -largex, largex, -largex, 0);
            return;
        }
        generateFullEllipsoid(world, largex, largex, largex, pos, state, false, -largex, largex, 0, largex, 0, largex);
    }

    public static void generateHalfEmptyElipsod(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, Direction direction, BlockState state) {

    }

    public static void generateSphere(StructureWorldAccess world, int radius, BlockPos pos, BlockState state) {
        generateFullEllipsoid(world, radius, radius, radius, pos, state, false, -radius, radius, -radius, radius, -radius, radius);
    }

    public static void generateSphere(StructureWorldAccess world, int radius, BlockPos pos, BlockState state, boolean force) {
        generateFullEllipsoid(world, radius, radius, radius, pos, state, force, -radius, radius, -radius, radius, -radius, radius);
    }

    public static void generateFullElipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state) {
        generateFullEllipsoid(world, largex, largey, largez, pos, state, false, -largex, largex, -largey, largey, -largez, largez);
    }

    public static void generateFullElipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force) {
        generateFullEllipsoid(world, largex, largey, largez, pos, state, force, -largex, largex, -largey, largey, -largez, largez);
    }


    //Using carthesian coordinates beacause it have better performance than using trigonometry
    public static void generateFullEllipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force, int minx, int maxx, int miny, int maxy, int minz, int maxz, Block... stateforce) {
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int largexsquared = largex * largex;
        int largeysquared = largey * largey;
        int largezsquared = largez * largez;
        if (largex > 32 || largey > 32 || largez > 32) {
            MushrooomsMod.LOGGER.warn("generating huge sphere (diameter > 64)");
        }
        for (float x = minx; x <= maxx; x++) {
            for (float y = miny; y <= maxy; y++) {
                for (float z = minz; z <= maxz; z++) {
                    if ((x * x) / (largexsquared) + (y * y) / (largeysquared) + (z * z) / (largezsquared) <= 1) {
                        mutable.set(pos, (int) x, (int) y, (int) z);
                        if (!force) {
                            BlockState state2 = world.getBlockState(mutable);
                            if (!state2.isAir() && Arrays.stream(stateforce).noneMatch(state2.getBlock()::equals))
                                continue;
                        }
                        world.setBlockState(mutable, state, 2);
                    }
                }
            }
        }
    }


    public static void generateEmptySphere(StructureWorldAccess world, int largex, BlockPos pos, BlockState state) {
        generateEmptyEllipsoid(world, largex, largex, largex, pos, state, false);
    }

    public static void generateEmptySphere(StructureWorldAccess world, int largex, BlockPos pos, BlockState state, boolean force, BlockState... stateforce) {
        generateEmptyEllipsoid(world, largex, largex, largex, pos, state, force);
    }


    //better performance when generating an empty sphere
    public static void generateEmptyEllipsoid(StructureWorldAccess world, int largex, int largey, int largez, BlockPos pos, BlockState state, boolean force, Block... stateforce) {
        int maxlarge = Math.max(largez, Math.max(largex, largey));
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (double theta = -180; theta <= 180; theta += (double) 45 / maxlarge) {
            for (double phi = -90; phi <= 90; phi += (double) 45 / maxlarge) {
                int x = (int) (largex * MathsUtil.getFastCos(theta) * MathsUtil.getFastCos(phi));
                int y = (int) (largey * MathsUtil.getFastSin(phi));
                int z = (int) (largex * MathsUtil.getFastSin(theta) * MathsUtil.getFastCos(phi));
                mutable.set(pos, x, y, z);
                if (!force) {
                    BlockState state2 = world.getBlockState(mutable);
                    if (!state2.isAir() && Arrays.stream(stateforce).noneMatch(state2.getBlock()::equals)) continue;
                }
                world.setBlockState(mutable, state, 2);
            }
            System.out.println(theta);
        }
    }
}
