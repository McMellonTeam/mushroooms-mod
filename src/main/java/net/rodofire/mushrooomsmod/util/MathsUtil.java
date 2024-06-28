package net.rodofire.mushrooomsmod.util;

import net.rodofire.mushrooomsmod.MushrooomsMod;

public class MathsUtil {
    //fast but unprecise, it is useful to use this when using small radius values
    private static final int FAST_TABLE_SIZE = 360;
    private static final int PRECISE_TABLE_SIZE = 3600;
    private static final double[] cosfastTable = new double[FAST_TABLE_SIZE];
    private static final double[] sinfastTable = new double[FAST_TABLE_SIZE];
    private static final double[] cospreciseTable = new double[PRECISE_TABLE_SIZE];
    private static final double[] sinpreciseTable = new double[PRECISE_TABLE_SIZE];

    static {
        for (int i = 0; i < 360; i++) {
            cosfastTable[i] = Math.cos(Math.toRadians(i));
            sinfastTable[i] = Math.sin(Math.toRadians(i));
        }
        for (int i = 0; i < 3600; i++) {
            double a = (double) i / 10;
            cospreciseTable[i] = Math.cos(Math.toRadians(a));
            sinpreciseTable[i] = Math.sin(Math.toRadians(a));
        }
    }

    public static double getFastSin(double x) {
        return sinfastTable[((int) x) % FAST_TABLE_SIZE];
    }

    public static double getFastCos(double x) {
        return cosfastTable[((int) x) % FAST_TABLE_SIZE];
    }

    public static double getPreciseSin(double x) {
        return sinpreciseTable[((int) x * 10) % PRECISE_TABLE_SIZE];
    }

    public static double getPreciseCos(double x) {
        return cospreciseTable[((int) x * 10) % PRECISE_TABLE_SIZE];
    }

    public static double getFastTan(double x) {
        if ((int) x % 180 == 90) {
            MushrooomsMod.LOGGER.error("thrown error, tan can't accept values equal to 90° +- 180° (div by 0 error)");
            return 0;
        }
        return sinfastTable[((int) x) % 360] / cosfastTable[((int) x) % 360];
    }

    public static double getPreciseTan(double x) {
        if ((int) x % 180 == 90) {
            MushrooomsMod.LOGGER.error("thrown error, tan can't accept values equal to 90° +- 180° (div by 0 error)");
            return 0;
        }
        return sinpreciseTable[((int) x * 10) % PRECISE_TABLE_SIZE] / cospreciseTable[((int) x * 10) % PRECISE_TABLE_SIZE];
    }

    public static double getlength(int x, int y, int z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public static double getLength(int x, int z) {
        return Math.sqrt(x * x + z * z);
    }

    public static void registerMaths() {
        MushrooomsMod.LOGGER.info("registering Maths");
    }
}
