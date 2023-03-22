package sk.exxeta.nightofchances.example.example2.api;

import java.util.UUID;

public interface AuthenticationService {
    boolean login(String username, String password);
    void logout(String username);
    UUID register(String username, String password, String email);
    String getTokenForPasswordReset(String username);
    void resetPassword(String username, String password, String token);
    void updateProfile(String username, UserProfileDTO profile);
}
