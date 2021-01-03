public class Finance extends Department {
    @Override
    public double getTotalSalaryBudget() {
        double total = 0;
        for (Employee employee: getEmployees()) {
            if(employee.getExperienceYears() < 1) {
                total = total + employee.getSalary() + employee.getSalary()*0.1;
            } else {
                total = total + employee.getSalary() + employee.getSalary()*0.16;
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "\nFinance" + super.toString();
    }
}
