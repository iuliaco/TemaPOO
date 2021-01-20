package Interface;

import Application.Test;
import Company.*;
import People.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPage implements MediatorManager, ActionListener {

    HireButton hireButton;
    RequestsText requestsText;
    RequestsList requestsList;
    JFrame manager;
    @Override
    public void registerComponent(ComponentManager component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "HireButton":
                hireButton = (HireButton) component;
                break;
            case "RequestsList":
                requestsList = (RequestsList) component; this.requestsList.addListSelectionListener(listSelectionEvent -> {
                Request request = (Request)requestsList.getSelectedValue();
                if (request != null) {
                    displayUser();
                } else {
                }
            });
                break;
            case "RequestsText":
                requestsText = (RequestsText) component;
                break;
        }
    }

    @Override
    public void createGUI() {
        requestsList.setCellRenderer(new RequestsListRenderer());
        manager = new JFrame("Manager");
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel down = new JPanel();
        JButton adminPage = new JButton("Admin Page");
        JButton profilePage = new JButton("Profile Page");
        JButton notificationsPage = new JButton("Notifications Page");
        down.add(adminPage);
        down.add(notificationsPage);
        down.add(profilePage);
        adminPage.addActionListener(this);
        profilePage.addActionListener(this);
        notificationsPage.addActionListener(this);
        JScrollPane scrollRequestList = new JScrollPane(requestsList);
        left.add(scrollRequestList);
        scrollRequestList.setPreferredSize(new Dimension(300,300));
        left.add(hireButton);
        hireButton.setPreferredSize(new Dimension(75,25));
        left.setSize(400, 300);
        left.setLayout(new FlowLayout());
        JScrollPane requestsTextList = new JScrollPane(requestsText);
        right.add(requestsTextList);
        requestsTextList.setPreferredSize(new Dimension(300, 300));
        manager.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        manager.setLayout(new BorderLayout());
        manager.add(left, BorderLayout.WEST);
        manager.add(right, BorderLayout.EAST);
        manager.add(down, BorderLayout.SOUTH);
        manager.setSize(1000, 900);
        manager.setVisible(true);
        manager.pack();
    }

    @Override
    public void displayUser() {
        requestsText.setText(requestsList.getCurrentElement().toStringMax());
    }

    @Override
    public void hireUser() {
        Request request = requestsList.getCurrentElement();
        Job job = (Job) request.getKey();
        User user = (User) request.getValue1();
        Application app = Application.getInstance();
        Company company = app.getCompany(job.getCompany());
        Department jobDept = null;
        for (Department department: company.getDepartments()) {
            if(department.getJobs().contains(job)) {
                jobDept = department;
                break;
            }
        }
        if (app.getUsers().contains(user) && job.getNoPositions() > 0) {
            job.setNoPositions(job.getNoPositions() - 1);
            Employee newEmployee = user.convert();
            if(app.remove(user) == false) {
                System.err.println("Nu am putut gasi utilizatorul pe care vreti sa-l stergeti.");
            }
            newEmployee.setCompany(job.getCompany());
            newEmployee.setSalary(job.getSalary());
            company.add(newEmployee, jobDept);
            for (Company comp: app.getCompanies()) {
                comp.removeObserver(user);
            }
            requestsText.setText(jobDept.toString());
        } else {
            requestsText.setText("A aparut o eroare la angajare.");
        }
        requestsList.deleteElement();

    }

    @Override
    public void setElementsList(ListModel list) {

        this.requestsList.setModel(list);
        this.requestsList.repaint();
    }

    public static void main(String[] args) {
        DefaultListModel<Request<Job, Consumer>> requests = new DefaultListModel<>();
        Test.main(args);
        Application app = Application.getInstance();
        String company = "Google";
        for (Request req: app.getCompany(company).getManager().getRequests()) {
            requests.addElement(req);
        }
        MediatorManager mediator = new ManagerPage();
        mediator.registerComponent(new HireButton());
        mediator.registerComponent(new RequestsText());
        mediator.registerComponent(new RequestsList(requests));
        mediator.createGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Request<Job, Consumer>> requests = new DefaultListModel<>();
        JButton button = (JButton) e.getSource();
        if(button.getText().equals("Profile Page")) {
            MediatorProfile userPage = new ProfilePage();
            userPage.registerComponent(new SearchButton());
            userPage.registerComponent(new TextBox());
            userPage.registerComponent(new SearchBar());
            manager.dispose();
            userPage.createGUI();
        }
        if(button.getText().equals("Notifications Page")) {
            MediatorProfile userPage = new NotificationsPage();
            userPage.registerComponent(new SearchButton());
            userPage.registerComponent(new NotificationsList(new DefaultListModel()));
            userPage.registerComponent(new SearchBar());
            manager.dispose();
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
            manager.dispose();
            mediator.createGUI();
        }
    }
}
