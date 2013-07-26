package math;

 // @author Jarrod
import static java.lang.Math.*;

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

    public static long mult(long point1, long point2) {
        return point(x(point1) * x(point2), y(point1) * y(point2));
    }

    public static long add(long point1, long point2) {
        return point(x(point1) + x(point2), y(point1) + y(point2));
    }

    public static long mult(long point, int factor) {
        return point(x(point) * factor, y(point) * factor);
    }

    public static double distance(long pointOne, long pointTwo) {
        int x1 = (int)(pointOne >> 32);
        int y1 = (int) pointOne;
        int x2 = (int)(pointTwo >> 32);
        int y2 = (int) pointTwo;
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }

}
