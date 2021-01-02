import java.util.ArrayList;

public abstract class Department {
    private ArrayList<Employee> employees;
    private ArrayList<Job> availableJobs;

    public Department() {
        employees = new ArrayList<>();
        availableJobs = new ArrayList<>(availableJobs);
    }

    public abstract double getTotalSalaryBudget();

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


}