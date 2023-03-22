package sk.exxeta.nightofchances.example.example1.utils;

import java.io.InputStream;

public class EmailService {
    public void send(String employeeEmail, String payrollsEmail, InputStream inputStream) {
        System.out.println("Payroll file sent to employee to address: " + employeeEmail + " and a copy was sent to company payroll register: " + payrollsEmail);
    }
}
