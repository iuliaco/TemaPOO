package Company;
import People.*;

public class Marketing extends Department{
    @Override
    public double getTotalSalaryBudget() {
        double total = 0;
        for (Employee employee: getEmployees()) {
            if(employee.getSalary() < 3000) {
                total = total + employee.getSalary();
            } else if(employee.getSalary() > 5000) {
                total = total + employee.getSalary() + employee.getSalary()*0.1;
            } else {
                total = total + employee.getSalary() + employee.getSalary()*0.16;
            }
        }
        return total;
    }
    public String getName(){
        return "Marketing";
    }
    @Override
    public String toString() {
        return "\nMarketing" + super.toString();
    }
}
