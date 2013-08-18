/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map.generator;

import map.Map;
import map.tile.Tile;

/**
 *
 * @author Jarrod
 */
public class GeneratorTileBase extends Generator {

    //fields
    //constructor
    private GeneratorTileBase() {
    }

    //methods
    public void generate(Map map, Tile tile) {
        Tile[][] tileMap = new Tile[map.getTileMap().length][map.getTileMap()[0].length];
        for (int j = 0; j < tileMap.length; j += 1) {
            for (int k = 0; k < tileMap[0].length; k += 1) {
                tileMap[j][k] = tile.newInstance();
            }
        }
        map.setTileMap(tileMap);
    }

    public static GeneratorTileBase getInstance() {
        return GeneratorTileBaseHolder.INSTANCE;
    }

    private static class GeneratorTileBaseHolder {

        private static final GeneratorTileBase INSTANCE = new GeneratorTileBase();
    }
}
