package math;

// @author Jarrod
public final class Point3<T> {

    //fields
    private final T x;
    private final T y;
    private final T z;

    //constructors
    public Point3(T x, T y, T z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point3(T[] t) {
        this.x = t[0];
        this.y = t[1];
        this.z = t[2];
    }

    public Point3(Point3<T> t) {
        this(t.getX(), t.getY(), t.getZ());
    }

    //methods
    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public T getZ() {
        return z;
    }

    public Point3<T> setX(T x) {
        return new Point3<>(x, getY(), getZ());
    }

    public Point3<T> setY(T y) {
        return new Point3<>(getX(), y, getZ());
    }

    public Point3<T> setZ(T z) {
        return new Point3<>(getX(), getY(), z);
    }

    public Point2<T> convertPoint2() {
        return new Point2<>(x, y);
    }

    @Override
    public String toString() {
        return x.toString() + " " + y.toString() + " " + z.toString();
    }
}
