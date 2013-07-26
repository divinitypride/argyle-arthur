package tile;

 // @author Jarrod
public class TileFlatGrassland extends TileFlat {

    //fields
    private static String name = "Grassland";
    private static String imageBinding = "tiles\\tile_grass_03";

    //constructor
    private TileFlatGrassland() {
        super(name, imageBinding);
    }

    public static TileFlatGrassland getInstance() {
        return TileFlatGrasslandHolder.INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private static class TileFlatGrasslandHolder {
        private static final TileFlatGrassland INSTANCE = new TileFlatGrassland();
    }

    //methods

}
