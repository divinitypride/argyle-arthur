package area;

import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.filters.FogFilter;
import main.Player;

/**
 *
 * @author Jarrod
 */
public class Area001 extends Area {
    
    private String sceneModelPath;
    private float sceneModelScale;
    private ColorRGBA backgroundColor;
    private FogFilter fog;
    private Player player;

    public Area001() {
        setSceneModelPath("Models/map_test/map_test.j3o");
        setSceneModelScale(1f);
        setBackgroundColor(new ColorRGBA(1.0f, 0.45f, 0.2f, 1.0f));
        super.setTerrain(getSceneModelPath(), getSceneModelScale());
        super.setFog(new ColorRGBA(0.9f, 0.9f, 0.9f, 1.0f), 512, 1.0f);
        super.setPlayer(new Player(1.5f, 6.0f, 1, 100f, 1.0f, 10f, 20f, 20f, 0.8f, 
          new Vector3f(32f, 128f, 32f)));
    }
    
    @Override
    public void initArea() {
        
    }
    
}
