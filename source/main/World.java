package main;

import java.util.HashSet;
import main.TriggerEvent.Trigger;
import map.Map;
import math.Point2;

public class World {

    //fields
    private Map map;
    private HashSet<TriggerEvent> triggers = new HashSet<>();
    private Point2<Integer> window;

    //constructors
    public World(int windowWidth, int windowHeight) {
        this.window = new Point2<>(windowWidth, windowHeight);
    }

    public World() {
        this(640, 480);
    }

    //methods
    public Map getMap() {
        return map;
    }

    public Point2<Integer> getWindow() {
        return window;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setWindow(Point2<Integer> window) {
        this.window = window;
    }

    public synchronized void addTriggerToStack(TriggerEvent t) {
        if (t.getTrigger() != Trigger.NULL) {
            triggers.add(t);
        }
    }

    public synchronized void update() {
        triggers.add(new TriggerEvent(this, Trigger.UPDATE));
        Main.getView().handleTriggers(triggers);
        triggers.clear();
        Main.getView().update();
    }
}