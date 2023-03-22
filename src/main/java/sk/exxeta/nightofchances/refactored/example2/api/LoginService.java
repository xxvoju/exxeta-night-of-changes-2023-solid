package sk.exxeta.nightofchances.refactored.example2.api;

public interface LoginService {
    boolean login(String username, String password);

    void logout(String username);
}
