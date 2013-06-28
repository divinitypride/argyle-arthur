package graphics;

 // @author Jarrod

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class StaticStore {

    private HashMap images = new HashMap();

    public StaticStore() {

    }

    public void decache(String imgPath) throws IOException {
        if (images.get(imgPath) != null) {
            images.remove(getSprite(imgPath));
        }
    }

    public BufferedImage getSprite(String binding) throws IOException {
        if (images.get(binding) != null) {
            System.out.println("Retrieved:" + binding);
            return (BufferedImage) images.get(binding);
        } else {
            System.out.println("Loaded:" + binding);
            BufferedImage img = ImageIO.read(new File("images\\" + binding + ".png"));
            images.put(binding, img);
            return img;
        }
    }

}