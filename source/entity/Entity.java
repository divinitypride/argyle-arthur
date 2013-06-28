package entity;

import java.awt.event.MouseEvent;
import java.awt.image.*;
import java.io.*;
import java.util.HashSet;
import javax.vecmath.Vector2f;
import main.TriggerEvent;
import main.World;
import type.TypeDimension;

public class Entity implements IEntity {

    //fields
    private World world;
    private String name;
    private String imageBinding;
    private BufferedImage image;
    private TypeDimension bounds;
    private float originX;
    private float originY;
    private float x;
    private float y;
    private float speed;
    private Vector2f targetLocation;

	//constructors
    public Entity(World world, String name, String imgPath, TypeDimension bounds, float originX, float originY, float x, float y, float speed) throws IOException {
        this.world = world;
        this.name = name;
        this.imageBinding = imgPath;
        this.bounds = bounds;
        this.originX = originX;
        this.originY = originY;
        this.x = x;
        this.y = y;
        this.speed = speed;
        image = world.getStaticStore().getSprite(imgPath);
    }

    public Entity(World world, String name, String imgPath, TypeDimension bounds, float originX, float originY, float x, float y) throws IOException {
        this(world, name, imgPath, bounds, originX, originY, x, y, 0);
    }

    public Entity(World world, String name, String imgPath, TypeDimension bounds, float originX, float originY) throws IOException {
        this(world, name, imgPath, bounds, originX, originY, 0, 0, 0);
    }

    public Entity(World world) throws IOException {
        this(world, "", "", new TypeDimension(), 0, 0, 0, 0, 0);
    }

	//methods
	public String getName() {
            return name;
        }

        public String getImageBinding() {
            return imageBinding;
	}

	public BufferedImage getImage() {
            return image;
	}

        public float getOriginX() {
            return originX;
	}

	public float getOriginY() {
            return originY;
	}

	public float getX() {
            return x;
	}

	public float getY() {
            return y;
	}

        public float getSpeed() {
            return speed;
        }

        public World getWorld() {
            return world;
        }

        public TypeDimension getBounds() {
            return bounds;
        }

        public Vector2f getTargetLocation() {
            return targetLocation;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setImageBinding(String path) {
            this.imageBinding = path;
        }

        public void setImage() throws IOException {
            image = world.getStaticStore().getSprite(getImageBinding());
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }

        public void setTargetLocation(Vector2f targetLocation) {
            this.targetLocation = targetLocation;
        }

        public boolean pointIntersectsEntity(int x, int y) {
            if (x > getX() - getOriginX()
              && x < getX() - getOriginX() + getBounds().getW()
              && y > getY() - getOriginY()
              && y < getY()- getOriginY() + getBounds().getH()) {
                return true;
            } else {
                return false;
            }
        }

    @Override
    public void update() {

    }

    @Override
    public void paint() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void trigger(HashSet<TriggerEvent> triggers) {

    }

}