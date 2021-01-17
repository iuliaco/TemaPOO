package Interface;

import javax.swing.*;

public interface MediatorManager {
    void registerComponent(ComponentManager component);
    void createGUI();
    void displayUser();
    void hireUser();
    void setElementsList(ListModel list);
}
