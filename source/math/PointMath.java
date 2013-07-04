package math;

 // @author Jarrod

public final class PointMath  {

    //methods
    public static long point(int x, int y) {
        return (((long)x) << 32 | y);
    }

    public static int x(long point) {
        return (int)(point >> 32);
    }

    public static int y(long point) {
        return (int) point;
    }

}
