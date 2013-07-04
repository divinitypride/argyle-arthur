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

    public void decache(String binding) throws IOException {
        if (images.get(binding) != null) {
            images.remove(getSprite(binding));
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