package sk.exxeta.nightofchances.refactored.example2.api;

import java.util.UUID;

public interface RegistrationService {
    UUID register(String username, String password, String email);
}
