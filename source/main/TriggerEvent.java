package main;

// @author Jarrod
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class TriggerEvent extends EventObject {

    //fields
    private Trigger trigger;
    private int pointX;
    private int pointY;
    private int key;

    //enums
    public enum Trigger {

        NULL, UPDATE, SELECTED_UPDATE,
        KEY,
        MOUSE_LEFT, MOUSE_RIGHT, MOUSE_MIDDLE,
        INTERNAL_0, INTERNAL_1, INTERNAL_2, INTERNAL_3, INTERNAL_4, INTERNAL_5,
        INTERNAL_6, INTERNAL_7
    }

    //constructors
    public TriggerEvent(Object source, Trigger t) {
        super(source);
        this.trigger = t;
    }

    public TriggerEvent(Object source, KeyEvent e) {
        super(source);
        this.trigger = Trigger.KEY;
        this.key = e.getKeyCode();
    }

    public TriggerEvent(Object source, MouseEvent e) {
        super(source);
        this.trigger = getMouseToTrigger(e);
        this.pointX = e.getX();
        this.pointY = e.getY();
    }

    //methods
    public Trigger getTrigger() {
        return trigger;
    }

    public int getPointX() {
        return pointX;
    }

    public int getPointY() {
        return pointY;
    }

    public int getKey() {
        return key;
    }

    public static Trigger getMouseToTrigger(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                return Trigger.MOUSE_LEFT;
            case MouseEvent.BUTTON2:
                return Trigger.MOUSE_RIGHT;
            case MouseEvent.BUTTON3:
                return Trigger.MOUSE_MIDDLE;
            default:
                return Trigger.NULL;
        }
    }
}
