package accountManagementDemo_consequentialSwitch;

// Classe Account per gestire i dati dell'utente
class Account {
    private String username;
    private String email;
    private String password;

    // Costruttore parametrizzato
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Setter
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}