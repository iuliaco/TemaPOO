package People;

import Company.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class User extends Consumer implements Observer {
    List<String> companies;
    ArrayList<Notification> notifications;
    public User(Resume resume) {
        super(resume);
        notifications = new ArrayList<Notification>();
        companies = new ArrayList<String>();
    }
    public User(Resume resume, List<String> companies) {
        super(resume);
        this.companies = companies;

    }

    public Employee convert() {
        Employee em;
        em = new Employee(this.resume);
        for (Consumer friend: this.acquaintances) {
            friend.remove(this);
            friend.add(em);
            em.add(friend);
        }
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
        return "\nUtilizator:\n" +
                "" + resume +
                "\nCompaniile de care este interesat:" + companies + "\n" +
//                ", acquaintances=" + acquaintances +
                "";
    }

    public ArrayList<Notification> getNotifications() {
        return notifications;
    }

    @Override
    public void update(Notification notification) {
        notifications.add(notification);
    }
}
