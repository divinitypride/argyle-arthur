package main;

import java.util.HashSet;
import main.TriggerEvent.Trigger;
import map.Map;
import math.Point2;
import math.Point3;

public class World {

	//fields
        private Point3<Integer> dimensions;
        private Point3<Integer> focus;
        private Map map;
        private HashSet<TriggerEvent> triggers = new HashSet<>();
        private Point2<Integer> window;
        private float zoom;

	//constructors
        public World(int worldWidth, int worldLength, int worldHeight, int focusX, int focusY, int focusZ, int windowWidth, int windowHeight, int zoom) {
            this.dimensions = new Point3<>(worldWidth, worldLength, worldHeight);
            this.focus = new Point3<>(focusX, focusY, focusZ);
            this.window = new Point2<>(windowWidth, windowHeight);
            this.zoom = zoom;
        }

        public World(int worldWidth, int worldLength, int worldHeight, int focusX, int focusY, int focusZ, int windowWidth, int windowHeight) {
            this(worldWidth, worldLength, worldHeight, focusX, focusY, focusZ, windowWidth, windowHeight, 1);
	}

        public World(int worldWidth, int worldLength, int worldHeight, int focusX, int focusY, int focusZ) {
            this(worldWidth, worldLength, worldHeight, focusX, focusY, focusZ, 640, 480, 1);
	}

        public World(int worldWidth, int worldLength, int worldHeight) {
            this(worldWidth, worldLength, worldHeight, 0, 0, 0, 640, 480, 1);
	}

        public World() {
            this(128, 128, 128, 0, 0, 0, 640, 480, 1);
        }

    //methods
    public Point3<Integer> getDimensions() {
        return dimensions;
    }

    public Point3<Integer> getFocus() {
        return focus;
    }

    public Map getMap() {
        return map;
    }

    public Point2<Integer> getWindow() {
        return window;
    }

    public float getZoom() {
        return zoom;
    }

    public void setDimensions(Point3<Integer> dimensions) {
        this.dimensions = dimensions;
    }

    public void setFocus(Point3<Integer> focus) {
        this.focus = focus;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setWindow(Point2<Integer> window) {
        this.window = window;
    }

    public void setZoom(float zoom) {
        this.zoom = zoom;
    }

    public synchronized void addTriggerToStack(TriggerEvent t) {
        if (t.getTrigger() != Trigger.NULL) {
            triggers.add(t);
        }
    }

    public synchronized void update() {
            triggers.add(new TriggerEvent(this, Trigger.UPDATE));
            triggers.clear();
        }

}