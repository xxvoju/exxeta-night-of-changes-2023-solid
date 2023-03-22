package sk.exxeta.nightofchances.refactored.example2;

import sk.exxeta.nightofchances.refactored.example2.api.LoginService;

public class TaxAuthorityAuthenticationService implements LoginService {

    @Override
    public boolean login(String username, String password) {
        /*  */
        return true;
    }

    @Override
    public void logout(String username) {
        /* disable session and do some cleanup */
    }

}
