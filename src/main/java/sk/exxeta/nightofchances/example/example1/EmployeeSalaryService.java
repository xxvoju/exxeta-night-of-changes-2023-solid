package sk.exxeta.nightofchances.example.example1;

import sk.exxeta.nightofchances.example.example1.utils.EmailService;
import sk.exxeta.nightofchances.example.example1.utils.ExcelExporter;
import sk.exxeta.nightofchances.example.example1.utils.PdfExporter;
import sk.exxeta.nightofchances.example.example1.utils.StateAuthorityApi;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class EmployeeSalaryService {
    /**
     * - Calculates employee salary,
     * - generates a payroll file
     * - sends payroll file to the employee and the payroll register
     */
    public void processEmployeeSalary(Employee employee) {
        System.out.println("Started processing employee salary of : " + employee.name());
        double salary = 0;
        LocalDate month = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        switch (employee.type()) {
            case COMMISSIONED -> salary = calculateCommissionedSalary(employee, month);
            case HOURLY -> salary = calculateHourlySalary(employee, month);
            case SALARIED -> salary = calculateSalariedSalary(employee, month);
        }
        System.out.println("Salary of " + employee.name() + " calculated to " + salary);
        StateAuthorityApi.send(employee.personalIdentificationNumber(),
                LocalDate.now().withDayOfMonth(1).minusDays(1),
                salary);

        String exportPdf;
        if (EmployeeType.COMMISSIONED.equals(employee.type())) {
            PdfExporter exporter = new PdfExporter();
            exportPdf = exporter.exportSalaryToPdf(employee, salary);
        } else {
            ExcelExporter exporter = new ExcelExporter();
            exportPdf = exporter.exportSalary(salary, employee);
        }
        EmailService emailService = new EmailService();
        try (InputStream inputStream = new FileInputStream(exportPdf)) {
            emailService.send(employee.email(), "payrolls@acme.com", inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to send payroll to employee: " + employee.name(), e);
        }
        System.out.println("Successfully processed employee salary of: " + employee.name());
    }

    private double calculateHourlySalary(Employee employee, LocalDate month) {
        /* some super complicated calculation of the salary */
        return 1500;
    }

    private double calculateSalariedSalary(Employee employee, LocalDate month) {
        /* some super complicated calculation of the salary */
        return 1200;
    }

    private double calculateCommissionedSalary(Employee employee, LocalDate month) {
        /* some super complicated calculation of the salary */
        return 2000;
    }
}
