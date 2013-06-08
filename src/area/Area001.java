package area;

import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import main.Player;

/**
 *
 * @author Jarrod
 */
public class Area001 extends Area {

    public Area001() {
        setSceneModelPath("Scenes/map_001.j3o");
        setSceneModelScale(8f);
        setBackgroundColor(new ColorRGBA(0.7f, 0.8f, 1f, 1f));
        super.setTerrain(getSceneModelPath(), getSceneModelScale());
        super.setFog(new ColorRGBA(0.9f, 0.9f, 0.9f, 1.0f), 512, 1.5f);
        super.setPlayer(new Player(1.5f, 6f, 1, 100f, 1f, 10f, 20f, 20f, 0.8f, 
          new Vector3f(0f, 128f, 0f)));
    }
    
    @Override
    public void initArea() {
        
    }
    
    @Override
    public Node initLight() {
        Node lightNode = new Node();
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.7f));
        lightNode.addLight(al);
        return lightNode;
    }
    
}
