package entity;

// @author Jarrod
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import main.Main;
import math.Point2;
import math.Point3;

public abstract class Entity {

    //fields
    protected static Random RANDOM = new Random();
    private String name;
    private String imageBinding;
    private Point2<Integer> imageOrigin;
    private float speed;
    private Point3<Float> location;

    //constructors
    public Entity(String name, String imageBinding, Point2<Integer> imageOrigin, float speed, Point3<Float> location) {
        this.name = name;
        this.imageBinding = imageBinding;
        this.imageOrigin = imageOrigin;
        this.speed = speed;
        this.location = location;
    }

    public Entity(String name, String[] imageBinding, Point2<Integer> imageOrigin, float speed, Point3<Float> location) {
        this(name, imageBinding[RANDOM.nextInt(imageBinding.length)], imageOrigin, speed, location);
    }

    //methods
    public String getName() {
        return name;
    }

    public String getImageBinding() {
        return imageBinding;
    }

    public Point2<Integer> getImageOrigin() {
        return imageOrigin;
    }

    public BufferedImage getImage() throws IOException {
        return Main.STORE.getImage(imageBinding);
    }

    public float getSpeed() {
        return speed;
    }

    public Point3<Float> getLocation() {
        return location;
    }

    public void setLocation(Point3<Float> location) {
        this.location = location;
    }

    public void setBinding(String binding) {
        this.imageBinding = binding;
    }

    public void update() {
    }
}
