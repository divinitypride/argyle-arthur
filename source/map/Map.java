package map;

// @author Jarrod
import java.util.HashSet;
import java.util.Iterator;
import map.tile.Tile;
import math.Point3;
import entity.Entity;
import static math.nMath.*;

public abstract class Map {

    //constants
    //fields
    private Tile[][] tileMap;
    private int[][] heightMap;
    private HashSet<Entity> entities;
    private Point3<Integer> dimensions;
    private Point3<Integer> focus;
    private int zoom;

    //constructors
    public Map(int length, int width, int height) {
        tileMap = new Tile[length][width];
        heightMap = new int[length][height];
        entities = new HashSet<>();
        this.dimensions = new Point3<>(length, width, height);
        this.focus = new Point3<>(0, 0, 0);
        this.zoom = 1;
    }

    public Map(Tile[][] tileMap, int[][] heightMap) {
        this.tileMap = tileMap;
        this.dimensions = new Point3<>(tileMap.length, tileMap[0].length, maxValue(heightMap));
        entities = new HashSet<>();
        this.focus = new Point3<>(0, 0, 0);
        this.zoom = 1;
    }

    public Map(Tile[][] tileMap, int[][] heightMap, HashSet<Entity> units) {
        this(tileMap, heightMap);
        this.entities = units;
    }

    //methods
    public Tile[][] getTileMap() {
        return tileMap;
    }

    public int[][] getHeightMap() {
        return heightMap;
    }

    public HashSet<Entity> getEntities() {
        return entities;
    }

    public Point3<Integer> getDimensions() {
        return dimensions;
    }

    public Point3<Integer> getFocus() {
        return focus;
    }

    public int getZoom() {
        return zoom;
    }

    public void setTileMap(Tile[][] tileMap) {
        this.tileMap = tileMap;
        this.dimensions = new Point3<>(tileMap.length, tileMap[0].length, maxValue(heightMap));
    }

    public void setHeightMap(int[][] heightMap) {
        this.heightMap = heightMap;
        this.dimensions = new Point3<>(tileMap.length, tileMap[0].length, maxValue(heightMap));
    }

    public void setEntities(HashSet<Entity> units) {
        this.entities = units;
    }

    public void setFocus(Point3<Integer> focus) {
        this.focus = focus;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public synchronized void update() {
        Iterator<Entity> it = entities.iterator();
        for (; it.hasNext();) {
            it.next().update();
        }
    }
}
