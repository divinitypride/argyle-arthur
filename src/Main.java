
 
import area.Area;
import area.Area001;
import com.jme3.app.SimpleApplication;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.collision.shapes.CollisionShape;
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
import com.jme3.scene.Node;
import resource.StaticStore;
 
public class Main extends SimpleApplication
  implements ActionListener {
 
    private Geometry sceneModel;
    private BulletAppState bulletAppState;
    private RigidBodyControl landscape;
    private CharacterControl player;
    private Vector3f walkDirection = new Vector3f();
    private Area area = new Area001();
  
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
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
        setUpKeys();
        setUpLight();
 
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
 
    private void setUpLight() {
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(1.7f));
        rootNode.addLight(al);
    }
 
    private void setUpKeys() {
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
 
    public void onAction(String binding, boolean value, float tpf) {
        StaticStore.get().setKeyState(binding, value);
    }
 
    @Override
    public void simpleUpdate(float tpf) {
        Vector3f camDir = cam.getDirection().clone().multLocal(0.2f);
        Vector3f camLeft = cam.getLeft().clone().multLocal(0.2f);
        walkDirection.set(0, 0, 0);
        if (StaticStore.get().getKeyState("Left"))  { walkDirection.addLocal(camLeft); }
        if (StaticStore.get().getKeyState("Right")) { walkDirection.addLocal(camLeft.negate()); }
        if (StaticStore.get().getKeyState("Up"))    { walkDirection.addLocal(camDir); }
        if (StaticStore.get().getKeyState("Down"))  { walkDirection.addLocal(camDir.negate()); }
        if (StaticStore.get().getKeyState("Space")) { player.jump();}
        player.setWalkDirection(walkDirection);
        cam.setLocation(player.getPhysicsLocation());
    }
}