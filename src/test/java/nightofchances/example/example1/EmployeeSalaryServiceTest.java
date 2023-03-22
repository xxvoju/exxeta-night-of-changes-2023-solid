package nightofchances.example.example1;

import org.junit.jupiter.api.Test;
import sk.exxeta.nightofchances.example.example1.Employee;
import sk.exxeta.nightofchances.example.example1.EmployeeSalaryService;
import sk.exxeta.nightofchances.example.example1.EmployeeType;

class EmployeeSalaryServiceTest {
    @Test
    void processEmployeeSalary() {
        Employee employee = new Employee(1L,
                "John Doe",
                "ID001234",
                EmployeeType.SALARIED,
                "john.doe@acme.com");

        EmployeeSalaryService salaryService = new EmployeeSalaryService();
        salaryService.processEmployeeSalary(employee);
        //TODO try to formulate assertions
        // it is pretty though to test anything
    }
}
