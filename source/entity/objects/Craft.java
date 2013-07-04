package entity.objects;

 // @author Jarrod

import entity.Entity;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import main.TriggerEvent;
import main.World;
import static math.PointMath.*;
import math.TypeDimension;

public class Craft extends Entity {

    private static final String imageBinding = "entities\\test_image";
    private static String name = "Craft";
    private static int originX = 16;
    private static int originY = 16;
    private static int speed = 4;
    private static TypeDimension bounds = new TypeDimension(32, 32);

    public Craft(World world, int x, int y) throws IOException {
        super(world, name, imageBinding, bounds, originX, originY, x, y, speed);
    }

    public Craft(World world) throws IOException {
        this(world, 0, 0);
    }

    @Override
    public void update() {
        super.updateLocation();
    }

    @Override
    public void trigger(HashSet<TriggerEvent> triggers) {
        for(Iterator<TriggerEvent> ir = triggers.iterator(); ir.hasNext();) {
                TriggerEvent trigger = ir.next();
                switch (trigger.getTrigger()) {
                    case MOUSE_LEFT:
                        if (pointIntersectsEntity(trigger.getPointX(), trigger.getPointY())) {
                            if (getWorld().getSelectedEntities().contains(this)) {
                                getWorld().deselectEntity(this);
                            } else {
                                getWorld().selectEntity(this);
                                System.out.println("Selected");
                            }
                        } else {
                            setTargetLocation(point(trigger.getPointX(), trigger.getPointY()));
                        }
                    case UPDATE:
                        if (getWorld().getSelectedEntities().contains(this)) {
                            updateLocation();
                        }
                }
        }
    }

}
