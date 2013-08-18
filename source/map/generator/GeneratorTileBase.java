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
    private Tile tile;

    //constructor
    public GeneratorTileBase(Tile tile) {
        this.tile = tile;
    }

    //methods
    @Override
    public void generate(Map map) {
        Tile[][] tileMap = new Tile[map.getTileMap().length][map.getTileMap()[0].length];
        for (int j = 0; j < tileMap.length; j += 1) {
            for (int k = 0; k < tileMap[0].length; k += 1) {
                tileMap[j][k] = tile.newInstance();
            }
        }
        map.setTileMap(tileMap);
    }
}
