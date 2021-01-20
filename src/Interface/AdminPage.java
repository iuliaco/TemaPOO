package Interface;

import Application.Test;
import Company.*;
import People.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPage implements MediatorAdmin, ActionListener {
    CompanyList companyList;
    CompanyText companyText;
    DepartamentList departamentList;
    EmployeeList employeeList;
    JobList jobList;
    SalaryButton salaryButton;
    SalaryText salaryText;
    UserList userList;
    UserText userText;
    JFrame admin;

    @Override
    public void registerComponent(ComponentAdmin component) {
        component.setMediator(this);
        switch (component.getName()) {
            case "CompanyList":
                companyList = (CompanyList) component;
                this.companyList.addListSelectionListener(listSelectionEvent -> {
                Company company = (Company) companyList.getSelectedValue();
                if (company != null) {
                    DefaultListModel<Department> departaments = new DefaultListModel<Department>();
                    for (Department dept: company.getDepartments()){
                        departaments.addElement(dept);
                    }
                    setElementsDepartamentList(departaments);
                    setElementsEmployeeList(new DefaultListModel());
                    setElementsJobList(new DefaultListModel());
                }
                });
                break;
            case "DepartamentList":
                departamentList = (DepartamentList) component;
                this.departamentList.addListSelectionListener(listSelectionEvent -> {
                Department departament = (Department) departamentList.getSelectedValue();
                if (departament != null) {
                    DefaultListModel<Employee> emp = new DefaultListModel<>();
                    for (Employee em: departament.getEmployees()) {
                        emp.addElement(em);
                    }
                    DefaultListModel<Job> jobs = new DefaultListModel<Job>();
                    for (Job job: departament.getJobs()) {
                        jobs.addElement(job);
                    }
                    setElementsJobList(jobs);
                    setElementsEmployeeList(emp);
                } else {
                }
            });
                break;
            case "CompanyText":
                companyText = (CompanyText) component;
                break;
            case "EmployeeList":
                employeeList = (EmployeeList) component;
                this.employeeList.addListSelectionListener(listSelectionEvent -> {
                    Employee emp = (Employee) employeeList.getSelectedValue();
                    if (emp != null) {
                        companyText.setText(emp.toString());
                    } else {
                    }
                });
                break;
            case "JobList":
                jobList = (JobList) component;
                this.jobList.addListSelectionListener(listSelectionEvent -> {
                Job job = (Job)jobList.getSelectedValue();
                if (job != null) {
                    companyText.setText(job.toString());
                } else {
                }
                });
                break;
            case "SalaryText":
                salaryText = (SalaryText) component;
                break;
            case "SalaryButton":
                salaryButton = (SalaryButton) component;
                break;
            case "UserList":
                userList = (UserList) component;
                this.userList.addListSelectionListener(listSelectionEvent -> {
                User user = (User)userList.getSelectedValue();
                if (user != null) {
                    displayUser();
                } else {
                }
                });
                break;
            case "UserText":
                userText = (UserText) component;
                break;

        }
    }

    @Override
    public void createGUI() {
        companyList.setCellRenderer(new CompanyListRenderer());
        jobList.setCellRenderer(new JobListRenderer());
        departamentList.setCellRenderer(new DepartamentListRenderer());
        employeeList.setCellRenderer(new EmployeeListRenderer());
        userList.setCellRenderer(new UserListRenderer());
        admin = new JFrame("Admin");
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel center = new JPanel();
        JScrollPane scrollUserList = new JScrollPane(userList);
        JScrollPane scrollCompanyList = new JScrollPane(companyList);
        JScrollPane scrollDepartamentList = new JScrollPane(departamentList);
        JScrollPane scrollEmployeeList = new JScrollPane(employeeList);
        JScrollPane scrollJobList = new JScrollPane(jobList);
        JScrollPane scrollUserText = new JScrollPane(userText);
        JScrollPane scrollCompanyText = new JScrollPane(companyText);
        left.add(scrollUserList);
        left.add(Box.createRigidArea(new Dimension(0, 5)));
        scrollUserList.setPreferredSize(new Dimension(300,300));
        left.add(scrollUserText);
        scrollUserText.setPreferredSize(new Dimension(300,300));
        left.setSize(400, 700);
        left.setLayout(new BoxLayout(left, BoxLayout.PAGE_AXIS));
        center.add(scrollCompanyList);
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        scrollCompanyList.setPreferredSize(new Dimension(300,150));
        center.add(scrollDepartamentList);
        center.add(Box.createRigidArea(new Dimension(0, 5)));
        scrollEmployeeList.setPreferredSize(new Dimension(300,250));
        center.add(scrollEmployeeList);
        scrollDepartamentList.setPreferredSize(new Dimension(300,150));
        center.setSize(400, 700);
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        //
        right.add(scrollJobList);
        right.add(Box.createRigidArea(new Dimension(0, 5)));
        scrollJobList.setPreferredSize(new Dimension(300,150));
        JPanel salary = new JPanel();
        salary.add(salaryButton);
        salary.add(salaryText);
        salaryText.setPreferredSize(new Dimension(125,25));
        right.add(salary);
        right.add(Box.createRigidArea(new Dimension(0, 5)));
        scrollDepartamentList.setPreferredSize(new Dimension(300,250));
        right.add(scrollCompanyText);
        scrollCompanyText.setPreferredSize(new Dimension(300,300));
        right.setSize(400, 700);
        right.setLayout(new BoxLayout(right, BoxLayout.PAGE_AXIS));
        JPanel down = new JPanel();
        JButton managerPage = new JButton("Manager Page");
        JButton profilePage = new JButton("Profile Page");
        JButton notificationsPage = new JButton("Notifications Page");
        down.add(managerPage);
        down.add(notificationsPage);
        down.add(profilePage);
        managerPage.addActionListener(this);
        profilePage.addActionListener(this);
        notificationsPage.addActionListener(this);
        admin.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        admin.setLayout(new BorderLayout());
        admin.add(left, BorderLayout.WEST);
        admin.add(center, BorderLayout.CENTER);
        admin.add(right, BorderLayout.EAST);
        admin.add(down, BorderLayout.SOUTH);
        admin.setSize(1000, 900);
        admin.setVisible(true);
        admin.pack();
    }


    @Override
    public void showSalaryTotal() {
        Department departament = (Department) departamentList.getSelectedValue();
        if(departament != null)
            salaryText.setText(departament.getTotalSalaryBudget() + " lei");
        else
            salaryText.setText("Nu ati ales niciun departament.");
    }

    @Override
    public void displayUser() {
        User user = (User)userList.getSelectedValue();
        userText.setText(user.toString());
    }

    @Override
    public void setElementsUserList(ListModel list) {
        this.userList.setModel(list);
        this.userList.repaint();
    }
    public void setElementsCompanyList(ListModel list) {
        this.companyList.setModel(list);
        this.companyList.repaint();
    }
    public void setElementsDepartamentList(ListModel list) {
        this.departamentList.setModel(list);
        this.departamentList.repaint();
    }
    public void setElementsEmployeeList(ListModel list) {
        this.employeeList.setModel(list);
        this.employeeList.repaint();
    }
    public void setElementsJobList(ListModel list) {
        this.jobList.setModel(list);
        this.jobList.repaint();
    }


    public static void main(String[] args) {
        DefaultListModel<Request<Job, Consumer>> requests = new DefaultListModel<>();
        Test.main(args);
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
        mediator.createGUI();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultListModel<Request<Job, Consumer>> requests = new DefaultListModel<>();
        JButton button = (JButton) e.getSource();
        if(button.getText().equals("Manager Page")) {
            MediatorManager manager = new ManagerPage();
            Application app = Application.getInstance();
            Company com = (Company) companyList.getSelectedValue();
            String company;
            if(com == null)
                company = "Google";
            else
                company = com.getName();
            for (Request req: app.getCompany(company).getManager().getRequests()) {
                requests.addElement(req);
            }
            manager.registerComponent(new HireButton());
            manager.registerComponent(new RequestsText());
            manager.registerComponent(new RequestsList(requests));
            admin.dispose();
            manager.createGUI();
        }
        if(button.getText().equals("Profile Page")) {
            MediatorProfile userPage = new ProfilePage();
            userPage.registerComponent(new SearchButton());
            userPage.registerComponent(new TextBox());
            userPage.registerComponent(new SearchBar());
            admin.dispose();
            userPage.createGUI();
        }
        if(button.getText().equals("Notifications Page")) {
            MediatorProfile userPage = new NotificationsPage();
            userPage.registerComponent(new SearchButton());
            userPage.registerComponent(new NotificationsList(new DefaultListModel()));
            userPage.registerComponent(new SearchBar());
            admin.dispose();
            userPage.createGUI();
        }
    }
}
