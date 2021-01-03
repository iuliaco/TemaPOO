import java.time.Period;

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
    public int getExperienceYears() {
        int years;
        years = 0;
        for (Experience exp: this.resume.getExperiences()) {
            Period period = Period.between(exp.getStartDate(), exp.getEndDate());
            if(period.getMonths() >= 3) {
                years = years + 1;
            }
            years = years + period.getYears();
        }
        return years;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}
