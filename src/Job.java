import java.util.ArrayList;

public class Job {
    private String job, company;
    private Boolean isOpen;
    private Constraint graduationYear, yearsOfExperience, meanGPA;
    private final ArrayList<User> candidates;
    private int noPositions;
    private int salary;

    public Job(String job, String company, Boolean isOpen, Constraint graduationYear, Constraint yearsOfExperience, Constraint meanGPA, int numberOfPlaces, int salary) {
        this.candidates = new ArrayList<User>();
        this.job = job;
        this.company = company;
        this.isOpen = isOpen;
        this.graduationYear = graduationYear;
        this.yearsOfExperience = yearsOfExperience;
        this.meanGPA = meanGPA;
        this.noPositions = numberOfPlaces;
        this.salary = salary;
    }

    public void apply(User user) {

    }
    public boolean meetsRequirments(User user) {
        return graduationYear.checkDate(user.getGraduationYear()) && yearsOfExperience.checkDate(user.getExperienceYears()) && meanGPA.checkGPA(user.meanGPA());
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

    public int getNoPositions() {
        return noPositions;
    }

    public void setNoPositions(int numberOfPlaces) {
        this.noPositions = numberOfPlaces;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "\nJob{" +
                "job='" + job + '\'' +
                ", company='" + company + '\'' +
                ", isOpen=" + isOpen +
                ", graduationYear=" + graduationYear +
                ", yearsOfExperience=" + yearsOfExperience +
                ", meanGPA=" + meanGPA +
                ", candidates=" + candidates +
                ", noPositions=" + noPositions +
                ", salary=" + salary +
                '}';
    }
}
