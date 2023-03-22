package sk.exxeta.nightofchances.example.example2;

import sk.exxeta.nightofchances.example.example2.api.AuthenticationService;
import sk.exxeta.nightofchances.example.example2.api.UserProfileDTO;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EShopAuthenticationService implements AuthenticationService {
    private final Map<String, String> userPasswords = new HashMap<>();
    private final Map<String, UserProfileDTO> users = new HashMap<>();

    @Override
    public boolean login(String username, String password) {
        String userPassword = userPasswords.get(username);
        return userPassword.equals(password);
    }

    @Override
    public void logout(String username) {
        /* disable session and do some cleanup */
    }

    @Override
    public UUID register(String username, String password, String email) {
        userPasswords.put(username, password);
        UUID id = UUID.randomUUID();
        users.put(username, new UserProfileDTO(id, username, email));
        return id;
    }

    @Override
    public String getTokenForPasswordReset(String username){
        /* some complicated token generation logic */
        String token = "" + UUID.randomUUID();
        System.out.println("Token generated for " + username + ": " + token);
        return token;
    }

    @Override
    public void resetPassword(String username, String password, String token) {
        /* some complicated restoration logic */
        System.out.println("Restoring password for " + username);
    }

    @Override
    public void updateProfile(String username, UserProfileDTO profile) {
        if (users.containsKey(username)) {
            throw new RuntimeException("User not found");
        }
        UserProfileDTO originalUserProfile = users.get(username);
        users.put(username, new UserProfileDTO(originalUserProfile.id(),
                originalUserProfile.username(), profile.email(), profile.phone(),
                profile.addressLine1(), profile.addressLine2(), profile.addressLine3()));
    }
}
