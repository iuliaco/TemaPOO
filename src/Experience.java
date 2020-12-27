import java.time.LocalDate;

class Experience implements Comparable<Experience>{
    private LocalDate startDate, endDate;
    private String position;
    private String company;

    public Experience(LocalDate startDate, LocalDate endDate, String position, String company) throws InvalidDatesException {

        if( endDate.isBefore(startDate) ) {
            throw new InvalidDatesException();
        } else {
            this.startDate = startDate;
            this.endDate = endDate;
            this.position = position;
            this.company = company;
        }

    }

    @Override
    public int compareTo(Experience o) {
        if(this == o) {
            return 1;
        }
        if(o.endDate == null || this.endDate == null) {
            return this.startDate.isBefore(o.startDate)? 1: -1;
        }
        if(o.endDate == this.endDate) {
            return this.company.compareTo(o.company);
        }
        return this.endDate.isAfter(o.endDate)? -1: 1;
    }
}