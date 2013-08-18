package map;

// @author Jarrod
import java.util.HashSet;
import main.Main;
import map.tile.Tile;
import unit.Entity;

public abstract class MapCharacter extends Map {

    //fields
    private Entity character;
    private int border;

    //constructors
    public MapCharacter(int length, int width, int height, Entity character) {
        super(length, width, height);
        this.character = character;
        this.border = 128;
    }

    public MapCharacter(Tile[][] tileMap, int[][] heightMap, Entity character) {
        super(tileMap, heightMap);
        this.character = character;
        this.border = 128;
    }

    public MapCharacter(Tile[][] tileMap, int[][] heightMap, HashSet<Entity> units, Entity character) {
        super(tileMap, heightMap, units);
        this.character = character;
        this.border = 128;
    }

    //methods
    public Entity getCharacter() {
        return character;
    }

    public int getBorder() {
        return border;
    }

    public void setBorder(int border) {
        this.border = border;
    }

    @Override
    public synchronized void update() {
        super.update();
        System.out.println(character.getLocation().toString());
        System.out.println(getDimensions().toString());
        System.out.println(getFocus().toString());
        System.out.println();
        if (character.getLocation().getX() > getDimensions().getX() * 32) {
            character.setLocation(character.getLocation().setX(getDimensions().getX() * 32));
        }

        if (character.getLocation().getX() < 0) {
            character.setLocation(character.getLocation().setX(0));
        }

        if (character.getLocation().getY() > getDimensions().getY() * 32) {
            character.setLocation(character.getLocation().setY(getDimensions().getY() * 32));
        }

        if (character.getLocation().getY() < 0) {
            character.setLocation(character.getLocation().setY(0));
        }

        if (character.getLocation().getX() - getFocus().getX() > Main.WORLD.getWindow().getX() - getBorder()) {
            setFocus(getFocus().setX(character.getLocation().getX() - Main.WORLD.getWindow().getX() + getBorder()));
        }

        if (character.getLocation().getX() - getFocus().getX() < getBorder()) {
            setFocus(getFocus().setX(character.getLocation().getX() - getBorder()));
        }

        if (character.getLocation().getY() - getFocus().getY() > Main.WORLD.getWindow().getY() - getBorder()) {
            setFocus(getFocus().setY(character.getLocation().getY() - Main.WORLD.getWindow().getY() + getBorder()));
        }

        if (character.getLocation().getY() - getFocus().getY() < getBorder()) {
            setFocus(getFocus().setY(character.getLocation().getY() - getBorder()));
        }

        if (getFocus().getX() > getDimensions().getX() * 32 - Main.WORLD.getWindow().getX()) {
            setFocus(getFocus().setX(getDimensions().getX() * 32 - Main.WORLD.getWindow().getX()));
        }

        if (getFocus().getX() < 0) {
            setFocus(getFocus().setX(0));
        }

        if (getFocus().getY() > getDimensions().getY() * 32 - Main.WORLD.getWindow().getY()) {
            setFocus(getFocus().setY(getDimensions().getY() * 32 - Main.WORLD.getWindow().getY()));
        }

        if (getFocus().getY() < 0) {
            setFocus(getFocus().setY(0));
        }
    }
}
