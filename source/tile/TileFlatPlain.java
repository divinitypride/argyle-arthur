package tile;

 // @author Jarrod
public class TileFlatPlain extends TileFlat {

    //fields
    private static String name = "Plain";
    private static String imageBinding = "tiles\\tile_grass_01";

    //constructor
    private TileFlatPlain() {
        super(name, imageBinding);
    }

    public static TileFlatPlain getInstance() {
        return TileFlatPlainHolder.INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private static class TileFlatPlainHolder {
        private static final TileFlatPlain INSTANCE = new TileFlatPlain();
    }

    //methods

}
