import java.util.Date;

public class Education implements Comparable<Education> {
    private int startDate, endDate;
    private String institutionName, educationLevel;
    private double meanGPA;

    public Education(int startDate, int endDate, String institutionName, String educationLevel, double meanGPA) throws InvalidDatesException {
        if( endDate < startDate ) {
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
        if(o.meanGPA == 0 || this.meanGPA == 0) {
            return this.startDate > o.startDate? 1: 0;
        }
        if(o.endDate == this.endDate) {
            return this.meanGPA < o.meanGPA? 0: 1;
        }
        return this.endDate < o.endDate? 0: 1;
    }
}
