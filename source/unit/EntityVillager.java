package unit;

// @author Jarrod
import math.Point2;
import math.Point3;

public class EntityVillager extends Entity {

    //fields
    private static String name = "Villager";
    private static int speed = 2;
    private static Point2<Integer> imageOffset = new Point2<>(8, 32);
    private static String[] imageBinding = {
        "entities\\npcs\\villager\\villager_01"};

    //constructors
    public EntityVillager(Point3 location) {
        super(name, imageBinding, imageOffset, speed, location);
    }

    public EntityVillager() {
        super(name, imageBinding, imageOffset, speed, new Point3(0, 0, 0));
    }
    //methods
}
