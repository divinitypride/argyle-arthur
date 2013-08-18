package graphics.game;

// @author Jarrod
import graphics.GWindow;
import interfaces.IView;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.Main;
import main.TriggerEvent;
import map.Map;
import map.MapCharacter;
import map.tile.Tile;
import unit.Entity;

public class MainGameView implements IView {

    //fields
    //constructors
    //methods
    @Override
    public void update() {
        if (Main.WORLD.getMap() instanceof MapCharacter) {
            MapCharacter map = (MapCharacter) Main.WORLD.getMap();
            Entity character = map.getCharacter();
            if (Main.STORE.getKey(KeyEvent.VK_LEFT)) {
                character.setLocation(character.getLocation().setX(character.getLocation().getX() - character.getSpeed()));
            }

            if (Main.STORE.getKey(KeyEvent.VK_RIGHT)) {
                character.setLocation(character.getLocation().setX(character.getLocation().getX() + character.getSpeed()));
            }

            if (Main.STORE.getKey(KeyEvent.VK_UP)) {
                character.setLocation(character.getLocation().setY(character.getLocation().getY() - character.getSpeed()));
            }

            if (Main.STORE.getKey(KeyEvent.VK_DOWN)) {
                character.setLocation(character.getLocation().setY(character.getLocation().getY() + character.getSpeed()));
            }
        }
        Main.WORLD.getMap().update();
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Map map = Main.WORLD.getMap();
        Tile[][] tileMap = map.getTileMap();
        HashSet<Entity> units = map.getEntities();
        for (int j = 0; j < map.getDimensions().getX(); j += 1) {
            for (int k = 0; k < map.getDimensions().getY(); k += 1) {
                for (int l = 0; l < map.getDimensions().getZ() + 1; l += 1) {
                    try {
                        g2d.drawImage(map.getTileMap()[j][k].getImage(), j * 32 - map.getFocus().getX(), k * 32 - map.getFocus().getY(), 32, 32, null);
                    } catch (IOException ex) {
                        Logger.getLogger(GWindow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        Iterator<Entity> it = units.iterator();
        for (; it.hasNext();) {
            Entity entity = it.next();
            try {
                g2d.drawImage(entity.getImage(), entity.getLocation().getX() - entity.getImageOrigin().getX() - map.getFocus().getX(),
                        entity.getLocation().getY() - entity.getImageOrigin().getY() - map.getFocus().getY(), null);
            } catch (IOException ex) {
                Logger.getLogger(MainGameView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    @Override
    public void handleTriggers(HashSet<TriggerEvent> triggers) {
        for (TriggerEvent t : triggers) {
        }
    }
}
