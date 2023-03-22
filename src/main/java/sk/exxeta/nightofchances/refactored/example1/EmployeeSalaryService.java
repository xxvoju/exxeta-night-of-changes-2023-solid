package sk.exxeta.nightofchances.refactored.example1;

import sk.exxeta.nightofchances.refactored.example1.salarycalculator.SalaryCalculator;
import sk.exxeta.nightofchances.refactored.example1.utils.EmailService;
import sk.exxeta.nightofchances.refactored.example1.utils.ExcelExporter;
import sk.exxeta.nightofchances.refactored.example1.utils.PdfExporter;
import sk.exxeta.nightofchances.refactored.example1.utils.StateAuthorityService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class EmployeeSalaryService {
    private final SalaryCalculator salaryCalculator;
    private final EmailService emailService;
    private final PdfExporter pdfExporter;
    private final ExcelExporter excelExporter;
    private final StateAuthorityService stateAuthorityService;

    public EmployeeSalaryService(SalaryCalculator salaryCalculator, EmailService emailService,
                                 PdfExporter pdfExporter, ExcelExporter excelExporter,
                                 StateAuthorityService stateAuthorityService) {
        this.salaryCalculator = salaryCalculator;
        this.emailService = emailService;
        this.pdfExporter = pdfExporter;
        this.excelExporter = excelExporter;
        this.stateAuthorityService = stateAuthorityService;
    }

    /**
     * - Calculates employee salary,
     * - generates a payroll file
     * - sends payroll file to the employee and the payroll register
     */
    public void processEmployeeSalary(Employee employee, LocalDate month) {
        double salary = salaryCalculator.calculateSalary(employee, getFirstDayOfMonth(month));
        stateAuthorityService.reportEmployeeSalary(employee, getLastDayOfMonth(month), salary);
        String exportFileUrl = exportToFile(employee, salary);
        sendPayrollToEmployeeAndRegistry(employee, exportFileUrl);
    }

    private LocalDate getFirstDayOfMonth(LocalDate month) {
        return month.withDayOfMonth(1);
    }

    private LocalDate getLastDayOfMonth(LocalDate month) {
        return month.plusMonths(1).withDayOfMonth(1).minusDays(1);
    }

    private void sendPayrollToEmployeeAndRegistry(Employee employee, String exportPdf) {
        try (InputStream inputStream = new FileInputStream(exportPdf)) {
            emailService.send(employee.email(), "payrolls@acme.com", inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Unable to send payroll to employee: " + employee.name(), e);
        }
    }

    private String exportToFile(Employee employee, double salary) {
        if (EmployeeType.COMMISSIONED.equals(employee.type())) {
            return pdfExporter.exportSalaryToPdf(employee, salary);
        } else {
            return excelExporter.exportSalary(salary, employee);
        }
    }
}
