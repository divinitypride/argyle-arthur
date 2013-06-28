package main;

import entity.Entity;
import java.util.HashSet;
import java.util.Iterator;
import type.TypeDimension;

public class Room {

	//fields
        private String name;
        private int roomTimer;
        private HashSet<Entity> entities;
        private TypeDimension focus = new TypeDimension();
        private TypeDimension dimensions = new TypeDimension();
	
	//constructors
        public Room(String name, int roomTimer, int worldWidth, int worldHeight, int fx, int fy, int fw, int fh) {
            this.name = name;
            this.roomTimer = roomTimer;
            entities = new HashSet();
            focus.setX(fx);
            focus.setY(fy);
            focus.setW(fw);
            focus.setH(fh);
            dimensions.setW(worldWidth);
            dimensions.setH(worldHeight);
	}
        
        public Room(String name, int roomTimer, int worldWidth, int worldHeight, int fw, int fh) {
            this.name = name;
            this.roomTimer = roomTimer;
            entities = new HashSet();
            focus.setW(fw);
            focus.setH(fh);
            dimensions.setW(worldWidth);
            dimensions.setH(worldHeight);
	}
        
        public Room(String name, int roomTimer, int worldWidth, int worldHeight) {
            this.name = name;
            this.roomTimer = roomTimer;
            entities = new HashSet();
            focus.setW(640);
            focus.setH(480);
            dimensions.setW(worldWidth);
            dimensions.setH(worldHeight);
	}
        
	public Room(String name, int roomTimer) {
            this.name = name;
            this.roomTimer = roomTimer;
            entities = new HashSet();
            focus.setW(640);
            focus.setH(480);
            dimensions.setW(640);
            dimensions.setH(480);
	}
	
	//methods        
        public synchronized HashSet<Entity> getSet() {
            return (HashSet<Entity>) entities.clone();
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
         
         public synchronized void add(Entity entity) {
            entities.add(entity);
        }
        
        public synchronized void remove(Entity entity) {
            entities.remove(entity);
        }
        
        public synchronized void update() {
            for (Iterator<Entity> it = entities.iterator(); it.hasNext();) {
                Entity entity = it.next();
                entity.update();
            }
        }
	
	public synchronized void printRoom() {
            for (Iterator<Entity> it = entities.iterator(); it.hasNext();) {
                Entity entity = it.next();
                System.out.println(entity.toString());
            }
	}
	
}