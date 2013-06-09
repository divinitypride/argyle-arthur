package main;
 
import area.Area;
import area.Area001;
import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.CharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.scene.Geometry;
import exception.NoSuchAssetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import resource.StaticStore;
 
public class Application extends SimpleApplication
  implements ActionListener {
 
    private Geometry sceneModel;
    private BulletAppState bulletAppState;
    private RigidBodyControl landscape;
    private CharacterControl player;
    private Vector3f walkDirection = new Vector3f();
    private Area area = new Area001();
    private StaticStore staticStore;
    private AudioNode audioNature;
  
    public Application(StaticStore staticStore) {
        this.staticStore = staticStore;
    }
 
    public void simpleInitApp() {
        // Set up Physics
        area.initArea();
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().enableDebug(assetManager);
 
        viewPort.setBackgroundColor(area.getBackgroundColor());
    
        FilterPostProcessor filter = new FilterPostProcessor(assetManager);
        filter.addFilter(area.getFog());
        viewPort.addProcessor(filter);
    
        flyCam.setMoveSpeed(area.getPlayer().getSpeed());
        initKeys();
        initLight();
        try {
            initAudio();
        } catch (NoSuchAssetException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        sceneModel = (Geometry) assetManager.loadModel(area.getSceneModelPath());
        System.out.println(area.getSceneModelPath());
        sceneModel.setLocalScale(area.getSceneModelScale());
 
        RigidBodyControl sceneShape = new RigidBodyControl(CollisionShapeFactory.createMeshShape(sceneModel), 0);
        sceneModel.addControl(sceneShape);
 
        player = area.getPlayer().getCharacterControl();

        rootNode.attachChild(sceneModel);
        bulletAppState.getPhysicsSpace().add(sceneModel);
        bulletAppState.getPhysicsSpace().add(player);
    }
 
    private void initLight() {
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.7f));
        rootNode.addLight(al);
    }
 
    private void initKeys() {
        inputManager.addMapping("Left", new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Right", new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Up", new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Down", new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Space", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addListener(this, "Left");
        inputManager.addListener(this, "Right");
        inputManager.addListener(this, "Up");
        inputManager.addListener(this, "Down");
        inputManager.addListener(this, "Space");
    }
    
    private void initAudio() throws NoSuchAssetException {
        audioNature = staticStore.getAudio("Frost");
    }
 
    public void onAction(String binding, boolean value, float tpf) {
        staticStore.setKeyState(binding, value);
    }
 
    @Override
    public void simpleUpdate(float tpf) {
        Vector3f camDir = cam.getDirection().clone().multLocal(0.2f);
        Vector3f camLeft = cam.getLeft().clone().multLocal(0.2f);
        walkDirection.set(0, 0, 0);
        if (staticStore.getKeyState("Left"))  { walkDirection.addLocal(camLeft); }
        if (staticStore.getKeyState("Right")) { walkDirection.addLocal(camLeft.negate()); }
        if (staticStore.getKeyState("Up"))    { walkDirection.addLocal(camDir); }
        if (staticStore.getKeyState("Down"))  { walkDirection.addLocal(camDir.negate()); }
        if (staticStore.getKeyState("Space")) { player.jump();}
        player.setWalkDirection(walkDirection);
        cam.setLocation(player.getPhysicsLocation());
    }
}