package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;

public class GenCircles {
    public static void generateCircle(StructureWorldAccess world, Random random, int largex, BlockState state, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        generateOval(world, random, largex, largex, state, x, y, false);
    }

    public static void generateOval(StructureWorldAccess world, Random random, int radiusX, int radiusY, BlockState blockState, int centerX, int centerY, boolean force) {
        int x = 0;
        int y = radiusY;
        int twoASquare = 2 * radiusX * radiusX;
        int twoBSquare = 2 * radiusY * radiusY;
        int decision1 = (int) (radiusY * radiusY - radiusX * radiusX * radiusY + 0.25 * radiusX * radiusX);
        int dx = twoBSquare * x;
        int dy = twoASquare * y;

        // Region 1
        while (dx < dy) {
            placeOvalBlocks(world, blockState, centerX, centerY, x, y);
            if (decision1 < 0) {
                x++;
                dx = dx + twoBSquare;
                decision1 = decision1 + dx + radiusY * radiusY;
            } else {
                x++;
                y--;
                dx = dx + twoBSquare;
                dy = dy - twoASquare;
                decision1 = decision1 + dx - dy + radiusY * radiusY;
            }
        }

        // Region 2
        int decision2 = (int) (radiusY * radiusY * (x + 0.5) * (x + 0.5) + radiusX * radiusX * (y - 1) * (y - 1) - radiusX * radiusX * radiusY * radiusY);
        while (y >= 0) {
            placeOvalBlocks(world, blockState, centerX, centerY, x, y);
            if (decision2 > 0) {
                y--;
                dy = dy - twoASquare;
                decision2 = decision2 + radiusX * radiusX - dy;
            } else {
                y--;
                x++;
                dx = dx + twoBSquare;
                dy = dy - twoASquare;
                decision2 = decision2 + dx - dy + radiusX * radiusX;
            }
        }
    }

    public static void placeOvalBlocks(StructureWorldAccess world, BlockState blockstate, int centerX, int centerY, int x, int y) {

    }
}
