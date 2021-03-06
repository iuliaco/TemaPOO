package People;

import java.time.LocalDate;

public class Experience implements Comparable<Experience>{
    private LocalDate startDate, endDate;
    private String position;
    private String company;

    public Experience(LocalDate startDate, LocalDate endDate, String position, String company) throws InvalidDatesException {
        if(endDate == null) {
            this.startDate = startDate;
            this.endDate = null;
            this.position = position;
            this.company = company;
        } else if( endDate.isBefore(startDate) ) {
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
            return this.company.compareTo(o.company);
        }
        if(o.endDate == this.endDate) {
            return this.company.compareTo(o.company);
        }
        return this.endDate.isAfter(o.endDate)? -1: 1;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Job: \n" +
                "Data de inceput:" + startDate + '\n' +
                "Data de sfarsit:" + endDate + '\n' +
                "Pozitia:" + position + '\n' +
                "Compania:" + company + '\n' ;
    }
}