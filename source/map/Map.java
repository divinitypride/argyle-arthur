package map;

 // @author Jarrod
import math.Point3;
import tile.Tile;
import tile.TileDebug;
import tile.TileFlatGrassland;
import tile.TileFlatMeadow;
import tile.TileFlatPlain;
import unit.Unit;
import unit.UnitNull;

public abstract class Map {

    //constants
    public static final Tile TILE_DEBUG = TileDebug.getInstance();
    public static final Tile TILE_FLAT_PLAIN = TileFlatPlain.getInstance();
    public static final Tile TILE_FLAT_MEADOW = TileFlatMeadow.getInstance();
    public static final Tile TILE_FLAT_GRASSLAND = TileFlatGrassland.getInstance();

    public static final Unit UNIT_NULL = UnitNull.getInstance();

    //fields
    private Tile[][][] tileMap;
    private Unit[][][] unitMap;
    private Point3<Integer> dimensions;

    //constructors
    public Map(int length, int width, int height) {
        tileMap = new Tile[length][width][height];
        unitMap = new Unit[length][width][height];
        this.dimensions = new Point3<>(length, width, height);
    }

    public Map(Tile[][][] tileMap) {
        this.tileMap = tileMap;
        this.dimensions = new Point3<>(tileMap.length, tileMap[0].length, tileMap[0][0].length);
        this.unitMap = new Unit[dimensions.getX()][dimensions.getY()][dimensions.getZ()];
    }

    public Map(Tile[][][] tileMap, Unit[][][] unitMap) {
        this.tileMap = tileMap;
        this.dimensions = new Point3<>(tileMap.length, tileMap[0].length, tileMap[0][0].length);
        this.unitMap = unitMap;
    }

    //methods
    public Tile[][][] getTileMap() {
        return tileMap;
    }

    public Unit[][][] getUnitMap() {
        return unitMap;
    }

    public Point3<Integer> getDimensions() {
        return dimensions;
    }

}
