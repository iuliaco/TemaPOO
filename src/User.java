import java.time.Period;

public class User extends Consumer {

    public User(Resume resume) {
        super(resume);
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
