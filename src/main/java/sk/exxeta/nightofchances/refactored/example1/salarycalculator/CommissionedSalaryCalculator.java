package sk.exxeta.nightofchances.refactored.example1.salarycalculator;

import sk.exxeta.nightofchances.refactored.example1.Employee;

import java.time.LocalDate;

public class CommissionedSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary(Employee employee, LocalDate month) {
        /* some really complicated calculation */
        return 1200.0;
    }
}
