package Company;
import People.*;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;

public class Finance extends Department {
    @Override
    public double getTotalSalaryBudget() {
        double total = 0;
        for (Employee employee: getEmployees()) {
            Experience exp = employee.resume.getExperiences().experiences.get(0);
            long year = ChronoUnit.YEARS.between(exp.getStartDate(),LocalDate.now());
            if(year < 1) {
                total = total + employee.getSalary() + employee.getSalary()*0.1;
            } else {
                total = total + employee.getSalary() + employee.getSalary()*0.16;
            }
        }
        return total;
    }
    public String getName(){
        return "Finance";
    }
    @Override
    public String toString() {
        return "\nFinance" + super.toString();
    }
}
