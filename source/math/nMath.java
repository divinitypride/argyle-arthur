package math;

// @author Jarrod
import static java.lang.Math.*;

public class nMath {

    //fields
    //constructors
    //methods
    public static int maxValue(int[][] array) {
        int value = 0;
        for (int j = 0; j < array.length; j += 1) {
            for (int k = 0; k < array[0].length; k += 1) {
                if (array[j][k] > value) {
                    value = array[j][k];
                }
            }
        }
        return value;
    }

    public static Point2<Integer> rotate(Point2<Integer> point, double angle) {
        int x = point.getX();
        int y = point.getY();
        point.setX((int) (x * cos(toRadians(angle) - y * sin(toRadians(angle)))));
        point.setY((int) (x * sin(toRadians(angle) + y * cos(toRadians(angle)))));
        return point;
    }
}
