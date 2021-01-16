package People;

import java.time.Period;

public class Employee extends Consumer {
    private String company;
    private int salary;
    public Employee(Consumer.Resume resume) {
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
        for (Experience exp: this.resume.getExperiences().experiences) {
            Period period = Period.between(exp.getStartDate(), exp.getEndDate());
            if(period.getMonths() >= 3) {
                years = years + 1;
            }
            years = years + period.getYears();
        }
        return years;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{\n" +
                "resume='" + resume + '\'' +
                ", salary=" + salary +
                ", company=" + company +
//                ", acquaintances=" + acquaintances +
                "} ";
    }
}
