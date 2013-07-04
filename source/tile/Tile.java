package tile;

 // @author Jarrod
import graphics.IDrawable;
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.World;
import static math.PointMath.*;

public class Tile implements IDrawable {

    //enums

    //fields
    private World world;
    private String name;
    private String imageBinding;
    private BufferedImage image;
    private long location;

    //constructors
    public Tile(World world, String name, String imageBinding, int x, int y) throws IOException {
        this.world = world;
        this.name = name;
        this.imageBinding = imageBinding;
        this.location = point(x, y);
        image = world.getStaticStore().getSprite(imageBinding);
    }

    //methods
    public World getWorld() {
        return world;
    }

    public String getName() {
        return name;
    }

    public String getImageBinding() {
        return imageBinding;
    }

    public BufferedImage getImage() {
        return image;
    }

    @Override
    public int getX() {
        return x(location);
    }

    @Override
    public int getY() {
        return y(location);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageBinding(String imageBinding) {
        this.imageBinding = imageBinding;
    }

}
