package tile;

 // @author Jarrod
public class TileFlatMeadow extends TileFlat {

    //fields
    private static String name = "Meadow";
    private static String imageBinding = "tiles\\tile_grass_02";

    //constructor
    private TileFlatMeadow() {
        super(name, imageBinding);
    }

    public static TileFlatMeadow getInstance() {
        return TileFlatMeadowHolder.INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private static class TileFlatMeadowHolder {
        private static final TileFlatMeadow INSTANCE = new TileFlatMeadow();
    }

    //methods

}
