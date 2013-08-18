package entity;

// @author Jarrod
import math.Point2;
import math.Point3;

public class EntityVillager extends Entity {

    //fields
    private static String name = "Villager";
    private static float speed = 0.5f;
    private static Point2<Integer> imageOffset = new Point2<>(8, 32);
    private static String[] imageBinding = {
        "entities\\npcs\\villager\\villager_01"};

    //constructors
    public EntityVillager(Point3<Float> location) {
        super(name, imageBinding, imageOffset, speed, location);
    }

    public EntityVillager() {
        super(name, imageBinding, imageOffset, speed, new Point3<>(0f, 0f, 0f));
    }
    //methods
}
