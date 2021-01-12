package Company;
import People.*;

public class Management extends Department{
    @Override
    public double getTotalSalaryBudget() {
        double total = 0;
        for (Employee employee: getEmployees()) {
            total = total + employee.getSalary();
        }
        return total+total*16/100;
    }

    @Override
    public String toString() {
        return "\nManagement" + super.toString();
    }
}
