package resource;

 // @author Jarrod

import area.Area;
import com.jme3.app.Application;
import com.jme3.audio.AudioNode;
import exception.NoSuchAssetException;
import java.util.HashMap;

public class StaticStore extends Application {

    private HashMap<String, Area> areas = new HashMap();
    private HashMap<String, AudioNode> audio = new HashMap();
    private HashMap<String, Boolean> keys = new HashMap();
    
    public StaticStore() {
        
    }
    
    public Area getArea(String binding) throws NoSuchAssetException {
        if (areas.get(binding) != null) {
            return areas.get(binding);
        } else {
            throw new NoSuchAssetException();
        }
    }
    
    public void setArea(String binding, Area area) {
        areas.put(binding, area);
    }
    
    public AudioNode getAudio(String binding) throws NoSuchAssetException {
        if (audio.get(binding) != null) {
            return audio.get(binding);
        } else {
            throw new NoSuchAssetException();
        }
    }
    
    public void setAudio(String binding, String path) {
        audio.put(binding, new AudioNode(assetManager, path));
    }
    
    public void setKeyState(String binding, boolean state) {
        keys.put(binding, state);
    }
    
    public boolean getKeyState(String binding) {
        if (keys.get(binding) != null) {
            return keys.get(binding);
        } else {
            keys.put(binding, false);
            return false;
        }
    }
    
}