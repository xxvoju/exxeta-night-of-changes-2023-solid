package sk.exxeta.nightofchances.refactored.example2.api;

public interface PasswordResetService {
    String getTokenForPasswordReset(String username);
    void resetPassword(String username, String password, String token);
}
