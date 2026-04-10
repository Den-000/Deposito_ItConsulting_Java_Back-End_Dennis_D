package model.factory.accountFactory;

import model.accountModel.Account;

public abstract class AccountFactory {
    abstract public Account createAccount(String username, String email, String password);
}
