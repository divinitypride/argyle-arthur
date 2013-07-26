package math;

 // @author Jarrod

public class Point3<T> {

    //fields
    private T x;
    private T y;
    private T z;

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

    public void set(Point3<T> t1) {
        this.x = t1.getX();
        this.y = t1.getY();
        this.z = t1.getZ();
    }

    public void setX(T x) {
        this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    public void setZ(T z) {
        this.z = z;
    }

}
