package Company;

import People.*;
import java.util.ArrayList;

public abstract class Department {
    private ArrayList<Employee> employees;
    private ArrayList<Job> availableJobs;

    public Department() {
        employees = new ArrayList<>();
        availableJobs = new ArrayList<>();
    }

    public abstract double getTotalSalaryBudget();
    public abstract String getName();

    public void add(Employee employee){
        employees.add(employee);
    }
    public void remove(Employee employee) {
        employees.remove(employee);
    }
    public void add(Job job) {
        availableJobs.add(job);
    }

    public ArrayList<Job> getJobs() {
        return availableJobs;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public ArrayList<Job> getAvailableJobs() {
        return availableJobs;
    }

    public void setAvailableJobs(ArrayList<Job> availableJobs) {
        this.availableJobs = availableJobs;
    }

    @Override
    public String toString() {
        return "Department{" +
                "employees=" + employees +
                ", availableJobs=" + availableJobs +
                '}';
    }
}
