package sk.exxeta.nightofchances.example.example2;

import sk.exxeta.nightofchances.example.example2.api.AuthenticationService;
import sk.exxeta.nightofchances.example.example2.api.UserProfileDTO;

import java.util.UUID;

public class TaxAuthorityAuthenticationService implements AuthenticationService {

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
        throw new UnsupportedOperationException("You can not register online," +
                " you should get your login information from the TaxAuthority.");
    }

    @Override
    public String getTnForPasswordReset(String username){
        throw new UnsupportedOperationException("You can not reset your password online," +
                " you can update your login information at dedicated service stations.");
    }

    @Override
    public void resetPassword(String username, String password, String token) {
        throw new UnsupportedOperationException("You can not reset your password online," +
                " you can update your login information at dedicated service stations.");
    }

    @Override
    public void updateProfile(String username, UserProfileDTO profile) {
        throw new UnsupportedOperationException("Personal information come from state authority registry," +
                " you can not change it directly from TaxAuthority portal.");
    }
}
