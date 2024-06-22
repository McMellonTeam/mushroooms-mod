package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;

public class GenLines {
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
}
