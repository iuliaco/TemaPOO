package Interface;

import Application.Test;
import Company.Company;
import Company.Notification;
import People.Application;
import People.Consumer;
import People.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotificationsPage  implements MediatorProfile, ActionListener {
    SearchButton searchButton;
    TextBox textBox;
    SearchBar searchBar;
    NotificationsList notificationsList;
    JFrame profile;

    public static void main(String[] args) {
        MediatorProfile mediator = new NotificationsPage();
        mediator.registerComponent(new SearchButton());
        mediator.registerComponent(new NotificationsList(new DefaultListModel()));
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
            case "NotificationsList":
                notificationsList = (NotificationsList) component;
        }
    }

    @Override
    public void createGUI() {
        profile = new JFrame("Notifications");
        JPanel up = new JPanel();
        JPanel center = new JPanel();
        JPanel down = new JPanel();
        JButton adminPage = new JButton("Admin Page");
        JButton profilePage = new JButton("Profile Page");
        down.add(adminPage);
        down.add(profilePage);
        adminPage.addActionListener(this);
        profilePage.addActionListener(this);
        up.add(searchBar);
        searchBar.setPreferredSize(new Dimension(100,25));
        up.add(searchButton);
        notificationsList.setPreferredSize(new Dimension(600,700));
        up.setSize(800, 300);
        up.setLayout(new FlowLayout());
        center.add(notificationsList);
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
        Consumer user = (User)this.searchUser(searchBar.getText());

        if(user == null)
            setElementsNotificationsList(new DefaultListModel());
        else {
            System.out.println("s a gasit");
            DefaultListModel<Notification> notL = new DefaultListModel();
            for (Notification notification: ((User) user).getNotifications()) {
                notL.addElement(notification);
            }
            setElementsNotificationsList(notL);
        }
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
        return user;
    }

    public void setElementsNotificationsList(ListModel list) {
        this.notificationsList.setModel(list);
        this.notificationsList.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
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
        if(button.getText().equals("Profile Page")) {
            MediatorProfile userPage = new ProfilePage();
            userPage.registerComponent(new SearchButton());
            userPage.registerComponent(new TextBox());
            userPage.registerComponent(new SearchBar());
            profile.dispose();
            userPage.createGUI();
        }
    }
}

