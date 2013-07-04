package math;

 // @author Jarrod

public class TypeDimension {

    //fields
    private int x;
    private int y;
    private int w;
    private int h;

    //constructors
    public TypeDimension(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public TypeDimension(int w, int h) {
        this(0, 0, w, h);
    }

    public TypeDimension() {
        this(0, 0, 0, 0);
    }

    //methods

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

}