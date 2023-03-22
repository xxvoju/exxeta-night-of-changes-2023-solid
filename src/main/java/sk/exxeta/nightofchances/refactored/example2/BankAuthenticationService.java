package sk.exxeta.nightofchances.refactored.example2;

import sk.exxeta.nightofchances.refactored.example2.api.LoginService;
import sk.exxeta.nightofchances.refactored.example2.api.PasswordResetService;
import sk.exxeta.nightofchances.refactored.example2.api.ProfileUpdateService;
import sk.exxeta.nightofchances.refactored.example2.api.UserProfileDTO;

import java.util.UUID;

public class BankAuthenticationService implements LoginService, ProfileUpdateService, PasswordResetService {

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
