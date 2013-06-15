
import com.jme3.system.AppSettings;
import main.TestMap;



 public class Main {

    public static void main(String[] args) {
        TestMap app = new TestMap();
        app.setShowSettings((false));
        AppSettings settings = new AppSettings(true);
        settings.setResolution(800, 600);
        settings.setBitsPerPixel(32);
        settings.setSamples(16);
        app.setSettings(settings);
        app.start();
    }
 }