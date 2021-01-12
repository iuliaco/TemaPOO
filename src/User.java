import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class User extends Consumer implements Observer {
    List<String> companies;
    ArrayList<Notification> notifications;
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
        for (Experience exp: this.resume.getExperiences().experiences) {
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

    public List<String> getCompanies() {
        return companies;
    }

    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }

    @Override
    public String toString() {
        return "\nUser{" +
                "companies=" + companies +
                ", resume=" + resume +
                ", acquaintances=" + acquaintances +
                "} ";
    }

    @Override
    public void update(Notification notification) {
        notifications.add(notification);
    }
}
