package main;


import entity.objects.Craft;
import graphics.GWindow;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static World world;
    private static GWindow gWindow;

    public static void main(String[] args) throws IOException {
        initWorld();
        initGraphics();
        initSettings();
    }

    private static void initWorld() throws IOException {
        world = new World("Test");
        world.addEntity(new Craft(world, 16, 16));
    }

    private static void initGraphics() {
        gWindow = new GWindow(world);
        gWindow.setVisible(true);
    }

    private static void initSettings() {
        LOGGER.setLevel(Level.FINEST);
    }

}