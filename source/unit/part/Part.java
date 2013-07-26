package unit.part;

 // @author Jarrod
import math.Point3;

public class Part {

    //fields
    private Point3<Integer> location;
    private String binding;
    private int axis;

    //constructors
    public Part(Point3<Integer> location, String binding, int axis) {
        this.location = location;
        this.binding = binding;
        this.axis = axis;
    }

    public Part(int x, int y, int z, String binding, int axis) {
        this(new Point3<>(x, y, z), binding, axis);
    }

    //methods
    public Point3<Integer> getLocation() {
        return location;
    }

    public String getBinding() {
        return binding;
    }

    public int getAxis() {
        return axis;
    }

    public void setLocation(int x, int y, int z) {
        location = new Point3(x, y, z);
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

}
