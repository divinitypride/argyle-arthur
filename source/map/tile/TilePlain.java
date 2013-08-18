package map.tile;

// @author Jarrod
public class TilePlain extends Tile {

    //fields
    private static String name = "Plain";
    private static String[] imageBinding = {
        "textures\\ground\\wheat\\wheat_01",
        "textures\\ground\\wheat\\wheat_02",
        "textures\\ground\\wheat\\wheat_03",
        "textures\\ground\\wheat\\wheat_04"};

    //constructor
    public TilePlain() {
        super(name, imageBinding);
    }

    //methods
    @Override
    public TilePlain newInstance() {
        return new TilePlain();
    }
}
