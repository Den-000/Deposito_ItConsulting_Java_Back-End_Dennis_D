package controller.facade;

import controller.service.AccountDAO;
import model.accountModel.Account;
import model.factory.accountFactory.*;

public class AuthFacade {

    private final AccountDAO accountDAO = new AccountDAO();

    public Account login(String email, String password) {

        Account accountFound = accountDAO.findByEmail(email);

        if (accountFound == null) return null;
        if (!accountFound.getPassword().equals(password)) return null;

        AccountFactory factory;

        if (accountFound.getRole().equalsIgnoreCase("ADMIN")) {
            factory = new AdminFactory();
        } else {
            factory = new UserFactory();
        }

        return factory.createAccount(
                accountFound.getUsername(),
                accountFound.getEmail(),
                accountFound.getPassword()
        );
    }

    public Account register(String username, String email, String password) {

        AccountFactory factory = new UserFactory();

        Account newAccount = factory.createAccount(username, email, password);
        accountDAO.create(newAccount);

        return newAccount;
    }
}