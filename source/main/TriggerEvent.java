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

    //enums
    public enum Trigger {
        NULL, USER_DEFINED_0, USER_DEFINED_1, USER_DEFINED_2, USER_DEFINED_3,
        USER_DEFINED_4, USER_DEFINED_5, USER_DEFINED_6, USER_DEFINED_7,
        USER_DEFINED_8, USER_DEFINED_9, MOUSE_LEFT, MOUSE_RIGHT, MOUSE_MIDDLE

    }

    //constructors
    public TriggerEvent(Object source, Trigger t) {
        super(source);
        this.trigger = t;
    }

    public TriggerEvent(Object source, KeyEvent e) {
        super(source);
        this.trigger = getKeyToTrigger(e);
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

    public static Trigger getKeyToTrigger(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_0:
                return Trigger.USER_DEFINED_0;
            case KeyEvent.VK_1:
                return Trigger.USER_DEFINED_1;
            case KeyEvent.VK_2:
                return Trigger.USER_DEFINED_2;
            case KeyEvent.VK_3:
                return Trigger.USER_DEFINED_3;
            case KeyEvent.VK_4:
                return Trigger.USER_DEFINED_4;
            case KeyEvent.VK_5:
                return Trigger.USER_DEFINED_5;
            case KeyEvent.VK_6:
                return Trigger.USER_DEFINED_6;
            case KeyEvent.VK_7:
                return Trigger.USER_DEFINED_7;
            case KeyEvent.VK_8:
                return Trigger.USER_DEFINED_8;
            case KeyEvent.VK_9:
                return Trigger.USER_DEFINED_9;
            default:
                return Trigger.NULL;
        }
    }

    public static Trigger getMouseToTrigger (MouseEvent e) {
        switch(e.getButton()) {
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
