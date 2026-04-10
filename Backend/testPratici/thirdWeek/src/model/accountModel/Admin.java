package model.accountModel;

public class Admin implements Account {
    private int id;
    private String username;
    private String email;
    private String password;
    private String role = "Admin";

    public Admin(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }
    
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean setId(int id) {
        this.id = id;
        return true;
    }

    public Boolean setUsername(String username) {
        this.username = username;
        return true;
    }

    public Boolean setEmail(String email) {
        this.email = email;
        return true;
    }

    public Boolean setPassword(String password) {
        this.password = password;
        return true;
    }

    public String getRole() {
        return role;
    }

    public Boolean setRole(String role) {
        this.role = role;
        return true;
    }
}
