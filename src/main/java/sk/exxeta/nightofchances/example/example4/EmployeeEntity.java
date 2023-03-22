package sk.exxeta.nightofchances.example.example4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO:
 *  1. Rewrite the implementation to make the Employee management SRP compliant, while supporting the operations:
 *  - 'persistence' - create & delete Employee,  list all employees and find a specific employee by name
 *  - report hours for the HR department
 *  - send payment to the user
 *  - print employee properties
 */
public class EmployeeEntity {
    private static final List<EmployeeEntity> employeesList = new ArrayList<>();
    private String name;
    private double dailyWage;
    private String bankAccount;

    public EmployeeEntity(String name, double dailyWage, String bankAccount) {
        this.name = name;
        this.dailyWage = dailyWage;
        this.bankAccount = bankAccount;
    }

    /**
     * Calculates the payment as dailyWage * days-worked
     * <p>
     * TODO:
     *  there is a request from the accounting to calculate the daily rate
     *  after the 20th day in a month with an additional bonus of 50%
     */
    public double calculatePay(LocalDate monthOfYear) {
        return dailyWage * calculateDaysWorked(monthOfYear);
    }

    public void sendPayment(LocalDate monthOfYear) {
        System.out.println("Sending payment for user '" + name + "' in ammount '" + this.calculatePay(monthOfYear) + "' to '" + bankAccount + "' for month: " + monthOfYear.getMonth());
    }

    /**
     * determines the number of days in a month, when the employee worked regular hours
     */
    private int calculateDaysWorked(LocalDate monthOfYear) {

        return (monthOfYear.getMonth().maxLength() * 5) / 7;
    }

    public EmployeeEntity employeeCalled(String name) {
        return employeesList.stream().filter(e -> e.name.equals(name)).findFirst().orElse(null);
    }

    public void save() {
        employeesList.add(this);
    }

    public List<EmployeeEntity> getAll() {
        return new ArrayList<>(employeesList);
    }

    public void delete(String name) {
        employeesList.removeIf(e -> e.name.equals(name));
    }


    public void displayEmployeeDetails() {
        LocalDate month = LocalDate.now();
        StringBuilder sb = new StringBuilder();
        sb.append("Employee: ").append(this.name).append("\n")
                .append("Bank account: ").append(bankAccount).append("\n")
                .append("Salary: ").append(this.calculatePay(month)).append("\n");
        System.out.println(sb);
    }

}


