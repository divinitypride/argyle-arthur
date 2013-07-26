package main;


import graphics.GWindow;
import graphics.StaticStore;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import map.MapTest01;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static World WORLD = new World();
    private static GWindow gWindow;
    public static StaticStore STORE = new StaticStore();

    public static void main(String[] args) throws IOException {
        initWorld();
        initGraphics();
        initSettings();
    }

    private static void initWorld() throws IOException {
        WORLD.setMap(new MapTest01());
    }

    private static void initGraphics() {
        gWindow = new GWindow();
        gWindow.setVisible(true);
    }

    private static void initSettings() {
        LOGGER.setLevel(Level.FINEST);
    }

}