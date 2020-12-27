public class Employee extends Consumer{
    private String company;
    private Double salary;
    public Employee(Resume resume) {
        super(resume);
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
