package net.rodofire.mushrooomsmod.util;

import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;

public class WorldGenUtil {
    public static void generateCircle(StructureWorldAccess world, Random random, int largex, BlockState state, BlockPos pos) {
        generateOval(world, random, largex, largex, state, pos, false);
    }

    public static void generateOval(StructureWorldAccess world, Random random, int largex, int largez, BlockState state, BlockPos pos, boolean force) {
        int large = Math.max(largex, largez);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = 0; i<=large; i++) {
            for (double j = -Math.PI; j<=Math.PI; j+=Math.PI/(4*i)) {
                double x = largex * ((double) i /large) * Math.cos(j);
                double z = largez * ((double) i /large) * Math.sin(j);
                mutable.set(pos, (int) x, 0, (int) z);

                if(!force){
                    if (world.getBlockState(mutable).isAir())
                        world.setBlockState(mutable, state, 2);
                    continue;
                }
                world.setBlockState(mutable, state, 2);
            }
        }
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
                    double x = largex * ((double) i /large) * Math.cos(j) * Math.cos(k);
                    double z = largez * ((double) i /large) *Math.sin(j) * Math.cos(k);
                    double y = largey * ((double) i /large) *Math.sin(k);

                    mutable.set(pos, (int) x, (int) y, (int) z);
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

    public static Direction getRandomDirection(){
        return switch (Random.create().nextBetween(0,5)){
            case 0 -> Direction.WEST;
            case 1 -> Direction.EAST;
            case 2 -> Direction.NORTH;
            case 3 -> Direction.SOUTH;
            case 4 -> Direction.UP;
            default -> Direction.DOWN;
        };
    }

    public static Direction getRandomVerticalDirection(){
        return switch (Random.create().nextBetween(0,1)){
            case 0 -> Direction.UP;
            default -> Direction.DOWN;
        };
    }

    public static Direction getRandomHorizontalDirection(){
        return switch (Random.create().nextBetween(0,3)){
            case 0 -> Direction.WEST;
            case 1 -> Direction.EAST;
            case 2 -> Direction.NORTH;
            default -> Direction.SOUTH;
        };
    }

    public static int getRandomOpposite(){
        return (Random.create().nextBetween(0,1) == 0) ? 1 : -1;
    }

    //based on the Bresenham algorithm
    public static void drawLine(StructureWorldAccess world, BlockPos start, BlockPos end, BlockState state) {
        drawLine(world, start, end, state, false);
    }
    public static void drawLine(StructureWorldAccess world, BlockPos start, BlockPos end, BlockState state, boolean force) {
        int x1 = start.getX();
        int y1 = start.getY();
        int z1 = start.getZ();
        int x2 = end.getX();
        int y2 = end.getY();
        int z2 = end.getZ();

        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int dz = Math.abs(z2 - z1);

        int xs = x1 < x2 ? 1 : -1;
        int ys = y1 < y2 ? 1 : -1;
        int zs = z1 < z2 ? 1 : -1;

        if (dx >= dy && dx >= dz) {
            int p1 = 2 * dy - dx;
            int p2 = 2 * dz - dx;
            while (x1 != x2) {
                x1 += xs;
                if (p1 >= 0) {
                    y1 += ys;
                    p1 -= 2 * dx;
                }
                if (p2 >= 0) {
                    z1 += zs;
                    p2 -= 2 * dx;
                }
                p1 += 2 * dy;
                p2 += 2 * dz;
                BlockPos currentPos = new BlockPos(x1, y1, z1);
                BlockState currentState = world.getBlockState(currentPos);
                if (!force) {
                    if (currentState.isAir() || currentState.isIn(BlockTags.FLOWERS)) {
                        world.setBlockState(currentPos, state, 2);
                    }
                    continue;
                }
                world.setBlockState(currentPos, state, 2);
            }
        } else if (dy >= dx && dy >= dz) {
            int p1 = 2 * dx - dy;
            int p2 = 2 * dz - dy;
            while (y1 != y2) {
                y1 += ys;
                if (p1 >= 0) {
                    x1 += xs;
                    p1 -= 2 * dy;
                }
                if (p2 >= 0) {
                    z1 += zs;
                    p2 -= 2 * dy;
                }
                p1 += 2 * dx;
                p2 += 2 * dz;
                BlockPos currentPos = new BlockPos(x1, y1, z1);
                BlockState currentState = world.getBlockState(currentPos);
                if (!force) {
                    if (currentState.isAir() || currentState.isIn(BlockTags.FLOWERS)) {
                        world.setBlockState(currentPos, state, 2);
                    }
                    continue;
                }
                world.setBlockState(currentPos, state, 2);
            }
        } else {
            int p1 = 2 * dy - dz;
            int p2 = 2 * dx - dz;
            while (z1 != z2) {
                z1 += zs;
                if (p1 >= 0) {
                    y1 += ys;
                    p1 -= 2 * dz;
                }
                if (p2 >= 0) {
                    x1 += xs;
                    p2 -= 2 * dz;
                }
                p1 += 2 * dy;
                p2 += 2 * dx;
                BlockPos currentPos = new BlockPos(x1, y1, z1);
                BlockState currentState = world.getBlockState(currentPos);
                if (!force) {
                    if (currentState.isAir() || currentState.isIn(BlockTags.FLOWERS)) {
                        world.setBlockState(currentPos, state, 2);
                    }
                    continue;
                }
                world.setBlockState(currentPos, state, 2);
            }
        }
    }

    public static int getSign(int a){
        return (a<0) ? -1 : 1;
    }
    public static int getSign(double a){
        return (a<0) ? -1 : 1;
    }
    public static int getSign(float a){
        return (a<0) ? -1 : 1;
    }


}
