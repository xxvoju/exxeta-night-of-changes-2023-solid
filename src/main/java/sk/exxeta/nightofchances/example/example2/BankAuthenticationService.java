package sk.exxeta.nightofchances.example.example2;

import sk.exxeta.nightofchances.example.example2.api.AuthenticationService;
import sk.exxeta.nightofchances.example.example2.api.UserProfileDTO;

import java.util.UUID;

public class BankAuthenticationService implements AuthenticationService {

    @Override
    public boolean login(String username, String password) {
        /*  */
        return true;
    }

    @Override
    public void logout(String username) {
        /* disable session and do some cleanup */
    }

    @Override
    public UUID register(String username, String password, String email) {
        throw new UnsupportedOperationException("You can not register online, " +
                "you should get your login information from the bank.");
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
        /*
         * update the profile information
         * do some complicated logic here
         **/
    }
}
