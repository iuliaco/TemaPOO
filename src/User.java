import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class User extends Consumer {
    List<String> companies;
    public User(Resume resume) {
        super(resume);
        companies = new ArrayList<String>();
    }
    public User(Resume resume, List<String> companies) {
        super(resume);
        this.companies = companies;

    }

    public Employee convert() {
        Employee em;
        em = new Employee(this.resume);
        return em;
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
    public Double getTotalScore() {
        Double score = (double) getExperienceYears();
        score = score * 1.5;
        score = score + meanGPA();
        return score;
    }
}
