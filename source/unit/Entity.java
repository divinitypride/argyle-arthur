package unit;

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
    private int speed;
    private Point3<Integer> location;

    //constructors
    public Entity(String name, String imageBinding, Point2<Integer> imageOrigin, int speed, Point3<Integer> location) {
        this.name = name;
        this.imageBinding = imageBinding;
        this.imageOrigin = imageOrigin;
        this.speed = speed;
        this.location = location;
    }

    public Entity(String name, String[] imageBinding, Point2<Integer> imageOrigin, int speed, Point3<Integer> location) {
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
        return Main.STORE.getSprite(imageBinding);
    }

    public int getSpeed() {
        return speed;
    }

    public Point3<Integer> getLocation() {
        return location;
    }

    public void setLocation(Point3<Integer> location) {
        this.location = location;
    }

    public void setBinding(String binding) {
        this.imageBinding = binding;
    }

    public void update() {
    }
}
