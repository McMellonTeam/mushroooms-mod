package net.rodofire.mushrooomsmod.worldgenutil;

import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class WorldGenUtil {

    public static Direction getRandomDirection() {
        return switch (Random.create().nextBetween(0, 5)) {
            case 0 -> Direction.WEST;
            case 1 -> Direction.EAST;
            case 2 -> Direction.NORTH;
            case 3 -> Direction.SOUTH;
            case 4 -> Direction.UP;
            default -> Direction.DOWN;
        };
    }

    public static Direction getRandomVerticalDirection() {
        return switch (Random.create().nextBetween(0, 1)) {
            case 0 -> Direction.UP;
            default -> Direction.DOWN;
        };
    }

    public static Direction getRandomHorizontalDirection() {
        return switch (Random.create().nextBetween(0, 3)) {
            case 0 -> Direction.WEST;
            case 1 -> Direction.EAST;
            case 2 -> Direction.NORTH;
            default -> Direction.SOUTH;
        };
    }

    public static int getRandomOpposite() {
        return (Random.create().nextBetween(0, 1) == 0) ? 1 : -1;
    }


    public static int getSign(int a) {
        return (a < 0) ? -1 : 1;
    }

    public static int getSign(double a) {
        return (a < 0) ? -1 : 1;
    }

    public static int getSign(float a) {
        return (a < 0) ? -1 : 1;
    }


}
