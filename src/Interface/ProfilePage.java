package Interface;

import Application.*;
import People.*;
import javax.swing.*;
import java.awt.*;

public class ProfilePage implements MediatorProfile {
    SearchButton searchButton;
    TextBox textBox;
    SearchBar searchBar;
    public ProfilePage() {

    }

    public static void main(String[] args) {
       MediatorProfile mediator = new ProfilePage();
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
        textBox.setPreferredSize(new Dimension(400,700));
        up.setSize(800, 300);
        up.setLayout(new FlowLayout());
        center.add(textBox);
        profile.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        profile.setLayout(new BorderLayout());
        profile.add(up, BorderLayout.NORTH);
        profile.add(center, BorderLayout.CENTER);
        profile.setSize(1000, 900);
        profile.setVisible(true);
        profile.pack();
    }

    @Override
    public void displayUser() {
        System.out.println(searchBar.getText()  + "dsaasd");
        Consumer user = this.searchUser(searchBar.getText());
        textBox.setText(user.toString());
    }

    @Override
    public Consumer searchUser(String name) {
        String[] args = new String[0];
        Test.main(args);
        Application app = Application.getInstance();
        String[] fullName = name.split(" ");
        Consumer user = app.getPerson(fullName[0], fullName[1]);
        textBox.setText("Yessss");
        System.out.println(name + " - " + fullName);
        return user;
    }
}
