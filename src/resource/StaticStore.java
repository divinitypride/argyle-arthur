package resource;

 // @author Jarrod

import area.Area;
import area.Area001;
import exception.NoSuchObjectException;
import java.util.HashMap;

public final class StaticStore {

    private static StaticStore staticStore = new StaticStore();
    private HashMap<String, Area> areas = new HashMap();
    private HashMap<String, Boolean> keys = new HashMap();
    
    private StaticStore() {
        setArea("Area_001", new Area001());
    }
	
    public static StaticStore get() {
        return staticStore;
    }
    
    public Area getArea(String area) throws NoSuchObjectException {
        if (areas.get(area) != null) {
            return areas.get(area);
        } else {
            throw new NoSuchObjectException();
        }
    }
    
    public void setArea(String binding, Area area) {
        areas.put(binding, area);
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