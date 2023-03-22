package sk.exxeta.nightofchances.example.example1.utils;

import java.time.LocalDate;

public class StateAuthorityApi {
    public static void send(String personalIdentificationNumber, LocalDate lastDayOfMonth, double salary) {
        System.out.println("Citizen with ID "+personalIdentificationNumber+" received salary: "+salary+" effective until date: "+lastDayOfMonth);
    }
}
