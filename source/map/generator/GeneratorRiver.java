/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package map.generator;

import java.util.Random;
import map.Map;
import map.tile.Tile;
import map.tile.TileWater;
import math.Point2;

/**
 *
 * @author Jarrod
 */
public class GeneratorRiver extends Generator {

    //fields
    private static Random RANDOM = new Random();
    private static TileWater tile = new TileWater();

    //constructor
    private GeneratorRiver() {
    }

    //methods
    public void generate(Map map) {
        Tile[][] tileMap = map.getTileMap();
        Point2<Integer> point = new Point2<>(RANDOM.nextInt(tileMap.length), RANDOM.nextInt(tileMap[0].length));
        Point2<Integer> vector = new Point2<>(RANDOM.nextInt(3) - 1, RANDOM.nextInt(3));
        boolean isFinished = false;
        while(!isFinished) {
            tileMap[point.getX()][point.getY()] = tile.newInstance();
            int subX = 0;
            int subY = 0;
            int i = RANDOM.nextInt(10);
            if (i < 3) {
                if (vector.getX() == 1) {
                    point.setX(point.getX() - 1);
                } else if (vector.getX() == 0) {
                    int j = RANDOM.nextInt(2);
                    if (j == 0) {
                        point.setX(point.getX() - 1);
                    } else {
                        point.setX(point.getX() + 1);
                    }
                } else if (vector.getX() == 1) {
                    point.setX(point.getX() + 1);
                }
                if (point.getX() > tileMap.length || point.getX() < 0) {
                    isFinished = true;
                } else {
                    tileMap[point.getX()][point.getY()] = tile.newInstance();
                }
            }
            i = RANDOM.nextInt(10);
            if (i < 3) {
                if (vector.getY() == 1) {
                    point.setY(point.getY() - 1);
                } else if (vector.getY() == 0) {
                    int j = RANDOM.nextInt(2);
                    if (j == 0) {
                        point.setY(point.getY() - 1);
                    } else {
                        point.setY(point.getY() + 1);
                    }
                } else if (vector.getY() == 1) {
                    point.setY(point.getY() + 1);
                }
                if (point.getY() > tileMap.length || point.getY() < 0) {
                    isFinished = true;
                } else {
                    tileMap[point.getX()][point.getY()] = tile.newInstance();
                }
            }
        }
    }

    public static GeneratorRiver getInstance() {
        return GeneratorRiver.GeneratorRiverHolder.INSTANCE;
    }

    private static class GeneratorRiverHolder {

        private static final GeneratorRiver INSTANCE = new GeneratorRiver();
    }
}
