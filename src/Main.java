
import main.Application;
import resource.StaticStore;



 public class Main {
    
    public static void main(String[] args) {
        StaticStore staticStore = new StaticStore();
        staticStore.setAudio("Audio/frost.wav", null);
        Application app = new Application(staticStore);
        app.start();
    }
 }