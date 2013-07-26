package unit;

 // @author Jarrod
import unit.part.Part;

public class UnitVillagerDebug extends Unit {

    //fields
    private static String name = "VillagerDebug";
    private static String binding = "debug\\debug_01";
    private static int speed = 2;
    private static Part[] parts = {new Part(6, 6, 6, "body_01", 0),
        new Part(6, 6, 6, "body_02", 1), new Part(6, 6, 6, "body_03", 2)};

    //constructors
    public UnitVillagerDebug() {
        super(name, binding, speed, parts);

    }

    //methods

}
