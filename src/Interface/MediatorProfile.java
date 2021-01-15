package Interface;
import People.*;

public interface MediatorProfile {
    void registerComponent(Component component);
    void createGUI();
    void displayUser();
    Consumer searchUser(String name);
}
