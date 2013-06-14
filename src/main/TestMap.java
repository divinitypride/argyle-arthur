package main;

import com.jme3.app.SimpleApplication;
import com.jme3.audio.AudioNode;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.bullet.util.CollisionShapeFactory;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.FogFilter;
import com.jme3.scene.Geometry;
import exception.NoSuchAssetException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMap extends SimpleApplication
  implements ActionListener {

    private Geometry sceneModel;
    private BulletAppState bulletAppState;
    private Player player;
    private Vector3f walkDirection = new Vector3f();
    private AudioNode audioNature;
    private StaticStore staticStore;

    public TestMap() {
    }

    public void simpleInitApp() {
        player = new Player(1.5f, 6.0f, 1, 100f, 1.0f, 10f, 20f, 20f, 0.8f,
          new Vector3f(32f, 128f, 32f));

        // Set up Physics
        staticStore = new StaticStore();
        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().enableDebug(assetManager);

        viewPort.setBackgroundColor(new ColorRGBA(0.73f, 0.91f, 1.0f, 1.0f));

        FilterPostProcessor filter = new FilterPostProcessor(assetManager);
        filter.addFilter(createFog(new ColorRGBA(0.9f, 0.9f, 0.9f, 1.0f), 512, 1.0f));
        viewPort.addProcessor(filter);

        flyCam.setMoveSpeed(player.getSpeed());
        initKeys();
        initLight();
        try {
            initAudio();
        } catch (NoSuchAssetException ex) {
            Logger.getLogger(TestMap.class.getName()).log(Level.SEVERE, null, ex);
        }

        sceneModel = (Geometry) assetManager.loadModel("Models/map_test/map_test.j3o");
        System.out.println("Models/map_test/map_test.j3o");
        sceneModel.setLocalScale(1f);

        RigidBodyControl sceneShape = new RigidBodyControl(CollisionShapeFactory.createMeshShape(sceneModel), 0);
        sceneModel.addControl(sceneShape);

        rootNode.attachChild(sceneModel);
        bulletAppState.getPhysicsSpace().add(sceneModel);
        bulletAppState.getPhysicsSpace().add(player.getCharacterControl());
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
        audioNature = createAudioNode("Audio/6-10-13.ogg", true);
    }

    public FogFilter createFog(ColorRGBA fogColor, float fogDistance, float fogDensity) {
        FogFilter fog = new FogFilter();
        fog.setFogColor(fogColor);
        fog.setFogDistance(fogDistance);
        fog.setFogDensity(fogDensity);
        return fog;
    }

    private AudioNode createAudioNode(String file, Boolean doStream) {
        AudioNode audioNode = new AudioNode(assetManager, file, doStream);
        return audioNode;
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
        if (staticStore.getKeyState("Space")) {

            player.jump();
        }
        player.setWalkDirection(walkDirection);
        cam.setLocation(player.getCharacterControl().getPhysicsLocation());

        if (audioNature.getStatus() == AudioNode.Status.Stopped) {
            audioNature = createAudioNode("Audio/6-10-13.ogg", true);
            audioNature.play();
        }
    }
}