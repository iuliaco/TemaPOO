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

    public Double getTotalScore() {
        Double score;
        score = 0.0;
        for (Experience exp: this.resume.getExperiences()) {
            Period period = Period.between(exp.getStartDate(), exp.getEndDate());
            if(period.getMonths() >= 3) {
                score = score + 1;
            }
            score = score + period.getYears();
        }
        score = score * 1.5;
        score = score + meanGPA();
        return score;
    }
}
