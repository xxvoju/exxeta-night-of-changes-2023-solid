package nightofchances.refactored.example1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sk.exxeta.nightofchances.refactored.example1.Employee;
import sk.exxeta.nightofchances.refactored.example1.EmployeeSalaryService;
import sk.exxeta.nightofchances.refactored.example1.EmployeeType;
import sk.exxeta.nightofchances.refactored.example1.salarycalculator.SalaryCalculatorFactory;
import sk.exxeta.nightofchances.refactored.example1.utils.EmailService;
import sk.exxeta.nightofchances.refactored.example1.utils.ExcelExporter;
import sk.exxeta.nightofchances.refactored.example1.utils.PdfExporter;
import sk.exxeta.nightofchances.refactored.example1.utils.StateAuthorityService;

import java.io.InputStream;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class EmployeeSalaryServiceTest {
    EmailService emailService = Mockito.mock(EmailService.class);
    PdfExporter pdfExporter = Mockito.mock(PdfExporter.class);
    ExcelExporter excelExporter = Mockito.mock(ExcelExporter.class);
    StateAuthorityService stateAuthorityService = Mockito.mock(StateAuthorityService.class);
    SalaryCalculatorFactory salaryCalculatorFactory = new SalaryCalculatorFactory();

    @Test
    void processEmployeeSalary() {
        Employee employee = new Employee(1L, "John Doe",
                "ID001234", EmployeeType.SALARIED,
                "john.doe@acme.com");
        LocalDate month = LocalDate.now();
        EmployeeSalaryService salaryService = new EmployeeSalaryService(
                salaryCalculatorFactory.getInstance(employee.type()), emailService,
                pdfExporter, excelExporter, stateAuthorityService);

        salaryService.processEmployeeSalary(employee, month);

        verify(emailService)
                .send(eq("john.doe@acme.com"),
                        eq("payrolls@acme.com"),
                        any(InputStream.class)
                );
    }
}
