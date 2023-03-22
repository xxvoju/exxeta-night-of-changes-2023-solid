package sk.exxeta.nightofchances.refactored.example1.utils;

import sk.exxeta.nightofchances.refactored.example1.Employee;

import java.time.LocalDate;

public class StateAuthorityService {
    public void reportEmployeeSalary(Employee employee, LocalDate lastDayOfMonth, double salary) {
        StateAuthorityApi.send(employee.personalIdentificationNumber(),
                lastDayOfMonth,
                salary);
    }
}
