import java.util.ArrayList;

public class Job {
    private String job, company;
    private Boolean isOpen;
    private Constraint graduationYear, yearsOfExperience, meanGPA;
    private final ArrayList<User> candidates;
    private int numberOfPlaces;
    private double salary;

    public Job(String job, String company, Boolean isOpen, Constraint graduationYear, Constraint yearsOfExperience, Constraint meanGPA, int numberOfPlaces, double salary) {
        this.candidates = new ArrayList<User>();
        this.job = job;
        this.company = company;
        this.isOpen = isOpen;
        this.graduationYear = graduationYear;
        this.yearsOfExperience = yearsOfExperience;
        this.meanGPA = meanGPA;
        this.numberOfPlaces = numberOfPlaces;
        this.salary = salary;
    }

    public void apply(User user) {

    }
    public boolean meetsRequirments(User user) {
        return graduationYear.checkDate(user.getGraduationYear()) && yearsOfExperience.checkDate(user.getExperienceYears()) && meanGPA.check(user.meanGPA());
    }

    public ArrayList<User> getCandidates() {
        return candidates;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public Constraint getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(Constraint graduationYear) {
        this.graduationYear = graduationYear;
    }

    public Constraint getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Constraint yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Constraint getMeanGPA() {
        return meanGPA;
    }

    public void setMeanGPA(Constraint meanGPA) {
        this.meanGPA = meanGPA;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
