import java.time.LocalDate;

public class Constraint {
    private LocalDate minDate, maxDate;
    private int minExperience, maxExperience;
    private Double minGPA, maxGPA;

    public Constraint(LocalDate minDate, LocalDate maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.minExperience = Integer.parseInt(null);
        this.maxExperience = Integer.parseInt(null);
        this.minGPA = null;
        this.maxGPA = null;
    }

    public Constraint(int minExperience, int maxExperience) {
        this.minDate = null;
        this.maxDate = null;
        this.minExperience = minExperience;
        this.maxExperience = maxExperience;
        this.minGPA = null;
        this.maxGPA = null;
    }

    public Constraint(Double minGPA, Double maxGPA) {
        this.minDate = null;
        this.maxDate = null;
        this.minExperience = Integer.parseInt(null);
        this.maxExperience = Integer.parseInt(null);
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

    @Override
    public String toString() {
        return "Constraint{" +
                "minDate=" + minDate +
                ", maxDate=" + maxDate +
                ", minExperience=" + minExperience +
                ", maxExperience=" + maxExperience +
                ", minGPA=" + minGPA +
                ", maxGPA=" + maxGPA +
                '}';
    }
}
