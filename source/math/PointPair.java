package math;

 // @author Jarrod

public class PointPair<T> {

    //fields
    private T point1;
    private T point2;

    //constructors
    public PointPair(T point1, T point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    //methods
    public T getPointOne() {
        return point1;
    }

    public T getPointTwo() {
        return point2;
    }

}
