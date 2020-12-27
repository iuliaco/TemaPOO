import java.time.LocalDate;

public class Constraint {
    private LocalDate minDate, maxDate;
    private int minExperience, maxExperience;
    private Double minGPA, maxGPA;

    public Constraint(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    public Constraint(int minExperience, int maxExperience) {
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
    }

    public Constraint(Double minGPA, Double maxGPA) {
        this.minGPA = minGPA;
        this.maxGPA = maxGPA;
    }

    public boolean checkDate(int year) {
        int minYear = minDate.getYear();
        int maxYear = maxDate.getYear();
//        int year = date.getYear();
        if(minYear <= year) {
            return maxYear >= year;
        }
        return false;
    }
    public boolean check(int experience) {
        if(minExperience <= experience) {
            return maxExperience >= experience;
        }
        return false;
    }

    public boolean check(Double GPA) {
        if(minGPA <= GPA) {
            return maxGPA >= GPA;
        }
        return false;
    }
}
