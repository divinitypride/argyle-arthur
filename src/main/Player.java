package main;

import com.jme3.bullet.collision.shapes.CapsuleCollisionShape;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.math.Vector3f;

/**
 *
 * @author Jarrod
 */
public class Player {

    private CharacterControl characterControl;
    private CapsuleCollisionShape capsuleShape;
    private float speed;
    private float stepHeight;
    private float jumpSpeed;
    private float fallSpeed;
    private float gravity;
    private float maxSlope;
    private Vector3f location;
    
    public Player(float radius, float height, int axis, float speed,
      float stepHeight, float jumpSpeed, float fallSpeed, float gravity,
        float maxSlope, Vector3f location) {
        
        this.capsuleShape = new CapsuleCollisionShape(radius, height, axis);
        this.speed = speed;
        this.stepHeight = stepHeight;
        this.jumpSpeed = jumpSpeed;
        this.fallSpeed = fallSpeed;
        this.gravity = gravity;
        this.maxSlope = maxSlope;
        this.location = location;
        characterControl = new CharacterControl(this.capsuleShape, stepHeight);
        characterControl.setJumpSpeed(jumpSpeed);
        characterControl.setFallSpeed(fallSpeed);
        characterControl.setGravity(gravity);
        characterControl.setMaxSlope(maxSlope);
        characterControl.setPhysicsLocation(location);
        
    }

    /**
     * @return the capsuleShape
     */
    public CapsuleCollisionShape getCapsuleShape() {
        return capsuleShape;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @return the jumpSpeed
     */
    public float getJumpSpeed() {
        return jumpSpeed;
    }

    /**
     * @return the fallSpeed
     */
    public float getFallSpeed() {
        return fallSpeed;
    }

    /**
     * @return the gravity
     */
    public float getGravity() {
        return gravity;
    }

    /**
     * @return the maxSlope
     */
    public float getMaxSlope() {
        return maxSlope;
    }

    /**
     * @return the location
     */
    public Vector3f getLocation() {
        return location;
    }

    /**
     * @return the stepHeight
     */
    public float getStepHeight() {
        return stepHeight;
    }

    /**
     * @return the characterControl
     */
    public CharacterControl getCharacterControl() {
        return characterControl;
    }

}
