package Company;
import People.*;

public class IT extends Department{
    @Override
    public double getTotalSalaryBudget() {
        double total = 0;
        for (Employee employee: getEmployees()) {
            total = total + employee.getSalary();
        }
        return total;
    }
    public String getName(){
        return "IT";
    }
    @Override
    public String toString() {
        return "\nIT" + super.toString();
    }
}
