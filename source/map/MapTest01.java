package map;

 // @author Jarrod
import tile.Tile;
import unit.Unit;
import unit.UnitVillagerDebug;



public class MapTest01 extends Map {

    //fields
    private static Tile[][][] tileMap = {{{Map.TILE_FLAT_MEADOW, Map.TILE_FLAT_MEADOW, Map.TILE_FLAT_GRASSLAND}},
        {{ Map.TILE_FLAT_PLAIN, Map.TILE_FLAT_GRASSLAND, Map.TILE_FLAT_PLAIN}},
        {{ Map.TILE_FLAT_GRASSLAND, Map.TILE_FLAT_MEADOW, Map.TILE_FLAT_PLAIN}}};

    private static Unit[][][] unitMap = {{{Map.UNIT_NULL, Map.UNIT_NULL, Map.UNIT_NULL}},
        {{ Map.UNIT_NULL, new UnitVillagerDebug(), Map.UNIT_NULL}},
        {{ Map.UNIT_NULL, Map.UNIT_NULL, Map.UNIT_NULL}}};

    //constructors
    public MapTest01() {
        super(tileMap, unitMap);
    }

    //methods

}
