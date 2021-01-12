package Interface;

import javax.swing.*;
import java.awt.*;

public class ProfilePage implements  Mediator{
    SearchButton searchButton;
    TextBox textBox;
    SearchBar searchBar;
    public ProfilePage() {

    }

    public static void main(String[] args) {
       Mediator mediator = new ProfilePage();
       mediator.registerComponent(new SearchButton());
       mediator.registerComponent(new TextBox());
       mediator.registerComponent(new SearchBar());
       mediator.createGUI();
    }

    @Override
    public void registerComponent(Component component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "SearchButton":
                searchButton = (SearchButton)component;
                break;
            case "TextBox":
                textBox = (TextBox)component;
                break;
            case "SearchBar":
                searchBar = (SearchBar)component;
                break;
        }
    }

    @Override
    public void createGUI() {
        JFrame profile = new JFrame("Profile");
        JPanel up = new JPanel();
        JPanel center = new JPanel();
        up.add(searchBar);
        searchBar.setPreferredSize(new Dimension(100,25));
        up.add(searchButton);
        textBox.setPreferredSize(new Dimension(300,300));
        up.setSize(600, 300);
        up.setLayout(new FlowLayout());
        center.add(textBox);
        profile.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        profile.setLayout(new BorderLayout());
        profile.add(up, BorderLayout.NORTH);
        profile.add(center, BorderLayout.CENTER);
        profile.setSize(1000, 100);
        profile.setVisible(true);
        profile.pack();
    }
}
