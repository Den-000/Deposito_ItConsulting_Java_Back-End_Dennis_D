package model.factory.accountFactory;

import model.accountModel.*;

public class AdminFactory extends AccountFactory {

    public Account createAccount(String username, String email, String password) {
        return new Admin(username, email, password);
    }
    
}
