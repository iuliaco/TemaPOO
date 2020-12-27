import java.time.LocalDate;
import java.util.Date;

public class Education implements Comparable<Education> {
    private LocalDate startDate, endDate;
    private String institutionName, educationLevel;
    private double meanGPA;

    public Education(LocalDate startDate, LocalDate endDate, String institutionName, String educationLevel, double meanGPA) throws InvalidDatesException {
        if( endDate.isBefore(startDate) ) {
            throw new InvalidDatesException();
        } else {
            this.startDate = startDate;
            this.endDate = endDate;
            this.institutionName = institutionName;
            this.educationLevel = educationLevel;
            this.meanGPA = meanGPA;
        }
    }

    public int compareTo(Education o) { // 1 daca this e mai mare 0 daca e o
        if(this == o) {
            return 1;
        }
        if(o.endDate == null || this.endDate == null) {
            return this.startDate.isBefore(o.startDate)? 1: -1;
        }
        if(o.endDate == this.endDate) {
            return this.meanGPA < o.meanGPA? -1: 1;
        }
        return this.endDate.isAfter(o.endDate)? -1: 1;
    }
}
