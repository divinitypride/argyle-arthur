package entity;

import graphics.IDrawable;
import java.awt.image.*;
import java.io.*;
import static java.lang.Math.*;
import java.util.HashSet;
import main.TriggerEvent;
import main.World;
import static math.PointMath.*;
import math.TypeDimension;

public class Entity implements IEntity, IDrawable {

    //fields
    private World world;
    private String name;
    private String imageBinding;
    private BufferedImage image;
    private TypeDimension bounds;
    private long originLocation;
    private long location;
    private int speed;
    private long targetLocation;

	//constructors
    public Entity(World world, String name, String imgPath, TypeDimension bounds, int originX, int originY, int x, int y, int speed) throws IOException {
        this.world = world;
        this.name = name;
        this.imageBinding = imgPath;
        this.bounds = bounds;
        this.originLocation = point(originX, originY);
        this.location = point(x, y);
        this.targetLocation = point(x, y);
        this.speed = speed;
        image = world.getStaticStore().getSprite(imgPath);
    }

    public Entity(World world, String name, String imgPath, TypeDimension bounds, int originX, int originY, int x, int y) throws IOException {
        this(world, name, imgPath, bounds, originX, originY, x, y, 0);
    }

    public Entity(World world, String name, String imgPath, TypeDimension bounds, int originX, int originY) throws IOException {
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

        public int getOriginX() {
            return y(originLocation);
	}

	public int getOriginY() {
            return x(originLocation);
	}

	public int getX() {
            return x(location);
	}

	public int getY() {
            return y(location);
	}

        public int getSpeed() {
            return speed;
        }

        public World getWorld() {
            return world;
        }

        public TypeDimension getBounds() {
            return bounds;
        }

        public long getTargetLocation() {
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

        public void setX(int x) {
            location = point(x, y(location));
        }

        public void setY(int y) {
            location = point(x(location), y);
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public void setTargetLocation(long targetLocation) {
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
    public void updateLocation() {
        if (targetLocation != location) {
            if (x(targetLocation) > x(location)) {
                if (y(targetLocation) > y(location)) {
                    double length = sqrt(pow(x(targetLocation) - x(location), 2) + pow(y(targetLocation) - y(location), 2));
                    double conversion = (getSpeed() / length);
                    setX((int) (getX() + (x(targetLocation) - x(location)) * conversion));
                    setY((int) (getY() + (y(targetLocation) - y(location)) * conversion));
                } else if (y(targetLocation) < y(location)) {
                    double length = sqrt(pow(x(targetLocation) - x(location), 2) + pow(y(location) - y(targetLocation), 2));
                    double conversion = getSpeed() / length;
                    setX((int) (getX() + (x(targetLocation) - x(location)) * conversion));
                    setY((int) (getY() + (y(targetLocation) - y(location)) * conversion));
                } else {
                    double length = x(location) - x(targetLocation);
                    double conversion = getSpeed() / length;
                    setX((int) (getX() + (x(location) - x(targetLocation)) * conversion));
                }
            } else if (x(targetLocation) < x(location)) {
                if (y(targetLocation) > y(location)) {
                    double length = sqrt(pow(x(location) - x(targetLocation), 2) + pow(y(targetLocation) - y(location), 2));
                    double conversion = getSpeed() / length;
                    setX((int) (getX() + (x(targetLocation) - x(location)) * conversion));
                    setY((int) (getY() + (y(targetLocation) - y(location)) * conversion));
                } else if (y(targetLocation) < y(location)) {
                    double length = sqrt(pow(x(location) - x(targetLocation), 2) + pow(y(location) - y(targetLocation), 2));
                    double conversion = getSpeed() / length;
                    setX((int) (getX() + (x(targetLocation) - x(location)) * conversion));
                    setY((int) (getY() + (y(targetLocation) - y(location)) * conversion));
                } else {
                    double length = x(targetLocation) - x(location);
                    double conversion = getSpeed() / length;
                    setX((int) (getX() + (x(location) - x(targetLocation)) * conversion));
                }
            } else {
                if (y(targetLocation) > y(location)) {
                    double length = y(targetLocation) - y(location);
                    double conversion = getSpeed() / length;
                    setY((int) (getY() + (y(targetLocation) - y(location)) * conversion));
                } else if (y(targetLocation) < y(location)) {
                    double length = y(targetLocation) - y(location);
                    double conversion = getSpeed() / length;
                    setY((int) (getY() + (y(location) - y(targetLocation)) * conversion));
                }
            }
            if (abs(x(targetLocation) - x(location)) < speed) {
                setX(x(targetLocation));
            }
            if (abs(y(targetLocation) - y(location)) < speed) {
                setY(y(targetLocation));
            }
        }
    }

    @Override
    public void paint() {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void trigger(HashSet<TriggerEvent> triggers) {

    }

}