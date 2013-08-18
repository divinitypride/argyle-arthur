package graphics;

// @author Jarrod
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.imageio.ImageIO;

public class StaticStore {

    private HashMap<String, BufferedImage> images = new HashMap<>();
    private HashMap<Integer, Boolean> keyset = new HashMap<>();

    public StaticStore() {
    }

    public boolean getKey(int keycode) {
        if (keyset.get(keycode) != null) {
            return keyset.get(keycode);
        } else {
            keyset.put(keycode, false);
            return false;
        }
    }

    public void setKey(KeyEvent e, boolean state) {
        keyset.put(e.getKeyCode(), state);
    }

    public void decache(String binding) throws IOException {
        if (images.get(binding) != null) {
            images.remove(getSprite(binding));
        }
    }

    public BufferedImage getSprite(String binding) throws IOException {
        if (images.get(binding) != null) {
            return images.get(binding);
        } else {
            BufferedImage img = ImageIO.read(new File("resources\\" + binding + ".png"));
            images.put(binding, img);
            return img;
        }
    }
}