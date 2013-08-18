package math;

// @author Jarrod
public final class Point2<T> {

    //fields
    private final T x;
    private final T y;

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

    public Point2<T> setX(T x) {
        return new Point2<>(x, getY());
    }

    public Point2<T> setY(T y) {
        return new Point2<>(getX(), y);
    }

    @Override
    public String toString() {
        return x.toString() + " " + y.toString();
    }
}
