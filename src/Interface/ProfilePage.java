package Interface;

import Application.*;
import Company.Company;
import People.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfilePage implements MediatorProfile, ActionListener {
    SearchButton searchButton;
    TextBox textBox;
    SearchBar searchBar;
    JFrame profile;
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
        profile = new JFrame("Profile");
        JPanel up = new JPanel();
        JPanel center = new JPanel();
        JPanel down = new JPanel();
        JButton adminPage = new JButton("Admin Page");
        JButton notificationsPage = new JButton("Notifications Page");
        down.add(adminPage);
        down.add(notificationsPage);
        adminPage.addActionListener(this);
        notificationsPage.addActionListener(this);
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
        profile.add(down, BorderLayout.SOUTH);
        profile.setSize(1000, 900);
        profile.setVisible(true);
        profile.pack();
    }

    @Override
    public void displayUser() {
        System.out.println(searchBar.getText()  + "dsaasd");
        Consumer user = this.searchUser(searchBar.getText());
        if(user == null)
            textBox.setText("Nu am putut gasi acest utilizator");
        else
            textBox.setText(user.toString());
    }

    @Override
    public Consumer searchUser(String name) {
        String[] args = new String[0];

        Application app = Application.getInstance();
        if(app.users.size() == 0) {
            Test.main(args);
        }
        String[] fullName = name.split(" ");
        Consumer user = app.getPerson(fullName[0], fullName[1]);
        textBox.setText("Yessss");
        System.out.println(name + " - " + fullName);
        return user;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();

        if(button.getText().equals("Notifications Page")) {
            MediatorProfile userPage = new NotificationsPage();
            userPage.registerComponent(new SearchButton());
            userPage.registerComponent(new NotificationsList(new DefaultListModel()));
            userPage.registerComponent(new SearchBar());
            profile.dispose();
            userPage.createGUI();

        }
        if(button.getText().equals("Admin Page")) {
            Application app = Application.getInstance();
            DefaultListModel<User> users = new DefaultListModel<>();
            for (User user: app.getUsers()) {
                users.addElement(user);
            }
            DefaultListModel<Company> companies = new DefaultListModel<>();
            for (Company company: app.getCompanies()) {
                companies.addElement(company);
            }
            MediatorAdmin mediator = new  AdminPage();
            mediator.registerComponent(new CompanyList(companies));
            mediator.registerComponent(new CompanyText());
            mediator.registerComponent(new DepartamentList(new DefaultListModel()));
            mediator.registerComponent(new SalaryButton());
            mediator.registerComponent(new UserText());
            mediator.registerComponent(new EmployeeList(new DefaultListModel()));
            mediator.registerComponent(new UserList(users));
            mediator.registerComponent(new SalaryText());
            mediator.registerComponent(new JobList(new DefaultListModel()));
            profile.dispose();
            mediator.createGUI();
        }
    }
}
