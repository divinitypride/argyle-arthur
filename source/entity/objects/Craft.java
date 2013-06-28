package entity.objects;

 // @author Jarrod

import entity.Entity;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import javax.vecmath.Vector2f;
import main.TriggerEvent;
import main.World;
import type.TypeDimension;

public class Craft extends Entity {

    private static final String imageBinding = "entities\\test_image";
    private static String name = "Craft";
    private static float originX = 16;
    private static float originY = 16;
    private static TypeDimension bounds = new TypeDimension(32, 32);

    public Craft(World world, float x, float y, float dir) throws IOException {
        super(world, name, imageBinding, bounds, originX, originY, x, y, dir);
    }

    public Craft(World world, float x, float y) throws IOException {
        super(world, name, imageBinding, bounds, originX, originY, x, y, 0);
    }

    public Craft(World world) throws IOException {
        super(world, name, imageBinding, bounds, originX, originY, 0, 0, 0);
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void trigger(HashSet<TriggerEvent> triggers) {
        for(Iterator<TriggerEvent> ir = triggers.iterator(); ir.hasNext();) {
                TriggerEvent trigger = ir.next();
                switch (trigger.getTrigger()) {
                    case USER_DEFINED_1:
                        this.setX(getX() + 1);
                    case MOUSE_LEFT:
                        if (pointIntersectsEntity(trigger.getPointX(), trigger.getPointY())) {
                            if (getWorld().getSelectedEntities().contains(this)) {
                                getWorld().deselectEntity(this);
                            } else {
                                getWorld().selectEntity(this);
                            }
                        } else {
                            setTargetLocation(new Vector2f(trigger.getPointX(), trigger.getPointY()));
                        }
                }
        }
    }

}
