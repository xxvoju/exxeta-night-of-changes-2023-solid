package sk.exxeta.nightofchances.refactored.example1.salarycalculator;

import sk.exxeta.nightofchances.refactored.example1.Employee;

import java.time.LocalDate;

public interface SalaryCalculator {
    double calculateSalary(Employee employee, LocalDate month);
}
