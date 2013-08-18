package main;

import graphics.GWindow;
import graphics.StaticStore;
import graphics.game.MainGameView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import map.MapTest01;
import interfaces.IView;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static World WORLD = new World();
    private static GWindow gWindow;
    public static StaticStore STORE = new StaticStore();
    private static IView view = new MainGameView();

    public static void main(String[] args) throws IOException {
        initWorld();
        initGraphics();
        initSettings();
    }

    private static void initWorld() throws IOException {
        WORLD.setMap(MapTest01.newInstance());
    }

    private static void initGraphics() {
        gWindow = new GWindow();
        gWindow.setVisible(true);
    }

    private static void initSettings() {
        LOGGER.setLevel(Level.FINEST);
    }

    public static IView getView() {
        return view;
    }

    public static void setView(IView view) {
        Main.view = view;
    }
}