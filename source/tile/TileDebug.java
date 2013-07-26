package tile;

 // @author Jarrod
public class TileDebug extends Tile {

    //fields
    private static String name = "Debug";
    private static String imageBinding = "tiles\\tile_debug";

    //constructor
    private TileDebug() {
        super(name, imageBinding);
    }

    public static TileDebug getInstance() {
        return TileDebugHolder.INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    private static class TileDebugHolder {
        private static final TileDebug INSTANCE = new TileDebug();
    }

    //methods

}
