package main;

import entity.Entity;
import graphics.IDrawable;
import graphics.StaticStore;
import java.util.HashSet;
import java.util.Iterator;
import main.TriggerEvent.Trigger;
import math.TypeDimension;
import tile.Tile;

public class World {

	//fields
        private StaticStore staticStore;
        private String name;
        private HashSet<IDrawable> drawables = new HashSet<>();
        private HashSet<Entity> entities = new HashSet<>();
        private HashSet<Tile> tiles = new HashSet<>();
        private HashSet<TriggerEvent> triggers = new HashSet<>();
        private HashSet<Entity> selectedEntities = new HashSet<>();
        private TypeDimension focus = new TypeDimension();
        private TypeDimension dimensions = new TypeDimension();

	//constructors
        public World(String name, int worldWidth, int worldHeight, int fx, int fy, int fw, int fh) {
            this.name = name;
            focus.setX(fx);
            focus.setY(fy);
            focus.setW(fw);
            focus.setH(fh);
            dimensions.setW(worldWidth);
            dimensions.setH(worldHeight);
            staticStore = new StaticStore();
	}

        public World(String name, int worldWidth, int worldHeight, int fw, int fh) {
            this(name, worldWidth, worldHeight, 0, 0, fw, fw);
	}

        public World(String name, int worldWidth, int worldHeight) {
            this(name, worldWidth, worldHeight, 0, 0, 640, 480);
	}

	public World(String name) {
            this(name, 640, 480, 0, 0, 640, 480);
	}

	//methods
        public synchronized HashSet<IDrawable> getDrawables() {
            return (HashSet<IDrawable>) drawables.clone();
        }

        public synchronized HashSet<Entity> getEntities() {
            return (HashSet<Entity>) entities.clone();
        }

        public synchronized HashSet<Entity> getSelectedEntities() {
            return (HashSet<Entity>) selectedEntities.clone();
        }

        public int getFocusWidth() {
            return focus.getW();
        }

        public int getFocusHeight() {
            return focus.getH();
        }

        public int getFocusX() {
            return focus.getX();
        }

        public int getFocusY() {
            return focus.getY();
        }

        public int getWorldWidth() {
            return dimensions.getW();
        }

        public int getWorldHeight() {
            return dimensions.getH();
        }

        public StaticStore getStaticStore() {
            return staticStore;
        }

        public void setFocusX(int x) {
            if (x >= 0 && x <= getWorldWidth()) {
                focus.setX(x);
            } else if (x < 0) {
                focus.setX(0);
            } else if (x > getWorldWidth()) {
                focus.setX(getWorldWidth() - focus.getW());
            }
        }

        public void setFocusY(int y) {
            if (y >= 0 && y <= getWorldHeight()) {
                focus.setY(y);
            } else if (y < 0) {
                focus.setY(0);
            } else if (y > getWorldHeight()) {
                focus.setY(getWorldHeight() - focus.getY());
            }
        }

        public synchronized void addEntity(Entity entity) {
            entities.add(entity);
            drawables.add(entity);
        }

        public synchronized void removeEntity(Entity entity) {
            entities.remove(entity);
            drawables.remove(entity);
        }

        public synchronized void selectEntity(Entity entity) {
            selectedEntities.add(entity);
            entities.add(entity);
            drawables.add(entity);
        }

        public synchronized void deselectEntity(Entity entity) {
            selectedEntities.remove(entity);
            entities.remove(entity);
            drawables.remove(entity);
        }

        public synchronized void addTriggerToStack(TriggerEvent t) {
            if (t.getTrigger() != Trigger.NULL) {
                triggers.add(t);
            }
        }

        public synchronized void update() {
            triggers.add(new TriggerEvent(this, Trigger.UPDATE));
            for (Iterator<Entity> it = entities.iterator(); it.hasNext();) {
                Entity entity = it.next();
                if (!triggers.isEmpty()) {
                    entity.trigger(triggers);
                }
            }
            triggers.clear();
        }

	public synchronized void printWorld() {
            for (Iterator<Entity> it = entities.iterator(); it.hasNext();) {
                Entity entity = it.next();
                System.out.println(entity.toString());
            }
	}

}