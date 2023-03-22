package sk.exxeta.nightofchances.refactored.example1.salarycalculator;

import sk.exxeta.nightofchances.refactored.example1.EmployeeType;

public class SalaryCalculatorFactory {
    public SalaryCalculator getInstance(EmployeeType employeeType) {
        return switch (employeeType) {
            case COMMISSIONED -> new CommissionedSalaryCalculator();
            case HOURLY -> new HourlySalaryCalculator();
            case SALARIED -> new SalariedSalaryCalculator();
            default -> throw new RuntimeException(
                    "Unsupported employee type provided: " + employeeType);
        };
    }
}
