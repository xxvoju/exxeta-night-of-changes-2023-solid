package sk.exxeta.nightofchances.refactored.example1;

import java.time.LocalDate;

public class SalaryCalculator {
    public double calculateSalary(Employee employee, LocalDate month) {
        return switch (employee.type()) {
            case COMMISSIONED -> calculateCommissionedPay(employee, month);
            case HOURLY -> calculateHourlyPay(employee, month);
            case SALARIED -> calculateSalariedPay(employee, month);
            default -> throw new RuntimeException("Unsupported employee type provided: " + employee.type());
        };
    }

    //TODO add some implementation
    private double calculateSalariedPay(Employee e, LocalDate month) {
        return 800.0;
    }

    private double calculateHourlyPay(Employee e, LocalDate month) {
        return 700.0;
    }

    private double calculateCommissionedPay(Employee e, LocalDate month) {
        return 1200.0;
    }
}
