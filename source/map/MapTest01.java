package map;

// @author Jarrod
import java.util.LinkedList;
import java.util.Queue;
import map.generator.Generator;
import map.generator.GeneratorTileBase;
import map.tile.TilePlain;
import math.Point3;
import entity.Entity;
import entity.EntityVillager;

public class MapTest01 extends MapCharacter {

    //fields
    private Queue<Generator> generatorList;

    //constructors
    private MapTest01(Entity character) {
        super(25, 25, 1, character);
        addEntity(character);
        generatorList = new LinkedList<>();
        generatorList.add(new GeneratorTileBase(new TilePlain()));
        //generatorList.add(new GeneratorRiver());
    }

    //methods
    public static MapTest01 newInstance() {
        Entity character = new EntityVillager(new Point3(32, 32, 1));
        MapTest01 map = new MapTest01(character);
        for (Generator generator : map.getGeneratorList()) {
            generator.generate(map);
        }
        return map;
    }

    private Queue<Generator> getGeneratorList() {
        return generatorList;
    }
}
