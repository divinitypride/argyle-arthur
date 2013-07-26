package unit;

 // @author Jarrod
import unit.part.Part;



public abstract class Unit {

    //fields
    private String name;
    private String binding;
    private int speed;
    private Part[] parts;

    //constructors
    public Unit(String name, String binding, int speed, Part[] parts) {
        this.name = name;
        this.binding = binding;
        this.speed = speed;
        this.parts = parts;
    }

    //methods
    public String getName() {
        return name;
    }

    public String getBinding() {
        return binding;
    }

    public int getSpeed() {
        return speed;
    }

    public Part[] getParts() {
        return parts;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

}
