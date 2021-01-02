import java.util.ArrayList;

public class Company {

    private String name;
    private Manager manager;
    private ArrayList<Department> departments;
    private ArrayList<Recruiter> recruiters;

    public Company() {
        departments = new ArrayList<>();
        recruiters = new ArrayList<>();
    }
    public Company(String name) {
        this();
        this.name = name;
    }

    public void add(Department department){
        departments.add(department);
    }

    public void add(Recruiter recruiter) {
        recruiters.add(recruiter);
    }

    public void add(Employee employee, Department department) {
        departments.get(departments.indexOf(department)).add(employee);
    }

    public void remove(Employee employee) {
        if(recruiters.contains(employee))
            recruiters.remove(employee);
        for (Department department: departments) {
            if(department.getEmployees().contains(employee))
                department.remove(employee);
        }
    }

    public void remove(Department department) {
        if (departments.contains(department)) {
            int index = departments.indexOf(department);
            for ( Employee employee: departments.get(index).getEmployees()) {
                if(recruiters.contains(employee)) {
                    recruiters.remove(employee);
                }
            }
        }
    }

    public void remove(Recruiter recruiter) {

    }

    public void move(Department source, Department destination) {

    }

    public void move(Employee employee, Department newDepartment) {

    }

    public boolean contains(Department department) {

    }

    public boolean contains(Employee employee) {
        for (Department departament: departments) {
            if(departments.contains(employee))
                return true;
        }
        return false;
    }

    public boolean contains(Recruiter recruiter) {
        if(recruiters.contains(recruiter))
            return true;
        return false;
    }

    public Recruiter getRecruiter(User user) {

    }

    public ArrayList<Job> getJobs() {
        ArrayList<Job> jobs = new ArrayList<>();
        for (Department departament: departments) {
             jobs.addAll(departament.getJobs());
        }
        return jobs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<Department> departments) {
        this.departments = departments;
    }

    public ArrayList<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(ArrayList<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }
}

