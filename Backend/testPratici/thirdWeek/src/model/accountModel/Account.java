package model.accountModel;

public interface Account {
        int getId();
        String getUsername();
        String getEmail();
        String getPassword();
        String getRole();
        Boolean setId(int id);
        Boolean setUsername(String username);
        Boolean setEmail(String email);
        Boolean setPassword(String password);
        Boolean setRole(String role);
}
