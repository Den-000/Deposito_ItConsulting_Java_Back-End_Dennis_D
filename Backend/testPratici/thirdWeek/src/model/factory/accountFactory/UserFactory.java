package model.factory.accountFactory;

import model.accountModel.*;

public class UserFactory extends AccountFactory {

    public Account createAccount(String username, String email, String password) {
        return new User(username, email, password);
    }
    
}
