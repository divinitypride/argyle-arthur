package tile;

 // @author Jarrod
import java.awt.image.BufferedImage;
import java.io.IOException;
import main.Main;

public abstract class Tile {

    //fields
    private String name;
    private String imageBinding;

    //constructors
    public Tile(String name, String imageBinding) {
        this.name = name;
        this.imageBinding = imageBinding;
    }

    //methods
    public String getName() {
        return name;
    }

    public String getImageBinding() {
        return imageBinding;
    }

    public BufferedImage getImage() throws IOException {
        return Main.STORE.getSprite(imageBinding);
    }

    public void setImageBinding(String imageBinding) {
        this.imageBinding = imageBinding;
    }

}
