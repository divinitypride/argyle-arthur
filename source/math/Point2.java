package math;

 // @author Jarrod

public class Point2<T> {

    //fields
    private T x;
    private T y;

    //constructors
    public Point2(T x, T y) {
        this.x = x;
        this.y = y;
    }

    public Point2(T[] t) {
        this.x = t[0];
        this.y = t[1];
    }

    public Point2(Point2<T> t) {
        this(t.getX(), t.getY());
    }

    //methods
    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void set(Point2<T> t1) {
        this.x = t1.getX();
        this.y = t1.getY();
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

}
