package unit;

 // @author Jarrod

public class UnitNull extends Unit {

    //fields
    private static String name = "";
    private static String binding = "";
    private static int speed = 0;

    //constructor
    private UnitNull() {
        super(name, binding, speed, null);
    }

    public static UnitNull getInstance() {
        return UnitNullHolder.INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private static class UnitNullHolder {
        private static final UnitNull INSTANCE = new UnitNull();
    }

    //methods

}
