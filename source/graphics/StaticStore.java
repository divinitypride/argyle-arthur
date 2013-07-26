package graphics;

 // @author Jarrod

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;
import unit.Unit;

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
            return (BufferedImage) images.get(binding);
        } else {
            BufferedImage img = ImageIO.read(new File("images\\" + binding + ".png"));
            images.put(binding, img);
            return img;
        }
    }

    public BufferedImage getSprite(Unit unit, int part) throws IOException {
        String binding = unit.getBinding() + "\\" + unit.getParts()[part].getBinding();
        System.out.println(binding);
        return getSprite(binding);
    }

}