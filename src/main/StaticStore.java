package main;

import java.util.HashMap;

/**
 *
 * @author Jarrod
 */
public class StaticStore {

    private HashMap<String, Boolean> keyState = new HashMap<String, Boolean>();
    
    public StaticStore() {
        
    }
    
    public boolean getKeyState(String binding) {
        if (keyState.containsKey(binding)) {
            return keyState.get(binding);
        } else {
            setKeyState(binding, false);
            return false;
        }
    }
    
    public void setKeyState(String binding, boolean state) {
        keyState.put(binding, state);
    }
    
}
