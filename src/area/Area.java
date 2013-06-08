package area;

import com.jme3.math.ColorRGBA;
import com.jme3.post.filters.FogFilter;
import com.jme3.scene.Node;
import main.Player;

/**
 *
 * @author Jarrod
 */
public abstract class Area {
    
    private String sceneModelPath;
    private float sceneModelScale;
    private ColorRGBA backgroundColor;
    private FogFilter fog;
    private Player player;
    
    /**
     * @return the sceneModelLocation
     */
    public String getSceneModelPath() {
        return sceneModelPath;
    }

    /**
     * @return the sceneModelScale
     */
    public float getSceneModelScale() {
        return sceneModelScale;
    }

    /**
     * @return the backgroundColor
     */
    public ColorRGBA getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * @return the fog
     */
    public FogFilter getFog() {
        return fog;
    }

    /**
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }
    
    /**
     * @param sceneModelPath the sceneModelPath to set
     */
    public void setSceneModelPath(String sceneModelPath) {
        this.sceneModelPath = sceneModelPath;
    }

    /**
     * @param sceneModelScale the sceneModelScale to set
     */
    public void setSceneModelScale(float sceneModelScale) {
        this.sceneModelScale = sceneModelScale;
    }
    
    public Area setBackgroundColor(float red, float green, float blue, float alpha) {
        backgroundColor = new ColorRGBA(red, green, blue, alpha);
        return this;
    }
    
    public Area setBackgroundColor(ColorRGBA backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }
    
    public Area setFog(ColorRGBA fogColor, float fogDistance, float fogDensity) {
        fog = new FogFilter();
        fog.setFogColor(fogColor);
        fog.setFogDistance(fogDistance);
        fog.setFogDensity(fogDensity);
        return this;
    }
    
    public Area setTerrain(String asset, float scale) {
        setSceneModelPath(asset);
        setSceneModelScale(scale);
        return this;
    }
    
    public Area setPlayer(Player player) {
        this.player = player;
        return this;
    }
    
    public void initArea() {

    }
    
    public Node initLight() {
        return null;
    }
    
    public void initKeys() {

    }

}
