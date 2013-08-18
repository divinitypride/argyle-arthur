package map;

// @author Jarrod
import map.generator.GeneratorRiver;
import map.generator.GeneratorTileBase;
import map.tile.TilePlain;
import math.Point3;
import unit.Entity;
import unit.EntityVillager;

public class MapTest01 extends MapCharacter {

    //fields
    //constructors
    private MapTest01(Entity character) {
        super(25, 25, 1, character);
    }

    //methods
    public static MapTest01 newInstance() {
        Entity character = new EntityVillager(new Point3(32, 32, 1));
        MapTest01 map = new MapTest01(character);
        GeneratorTileBase gTileBase = GeneratorTileBase.getInstance();
        GeneratorRiver gRiver = GeneratorRiver.getInstance();
        gTileBase.generate(map, new TilePlain());
        gRiver.generate(map);
        map.addEntity(character);
        return map;
    }
}
