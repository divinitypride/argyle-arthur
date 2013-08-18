package map.tile;

// @author Jarrod
public class TileWater extends Tile {

    //fields
    private static String name = "Water";
    private static String[] imageBinding = {
        "textures\\water\\water\\water_01"};

    //constructor
    public TileWater() {
        super(name, imageBinding);
    }

    //methods
    @Override
    public TileWater newInstance() {
        return new TileWater();
    }
}
