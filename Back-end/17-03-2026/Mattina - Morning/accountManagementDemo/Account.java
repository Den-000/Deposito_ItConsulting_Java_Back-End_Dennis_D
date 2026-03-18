package accountManagementDemo;

// Classe Account per memorizzare dati utente
class Account {
    private String username; // Nome utente
    private String email;    // Email dell'utente
    private String password; // Password dell'account

    // Costruttore parametrizzato
    public Account(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    // GETTER
    public String getUsername() { return username; }
    public String getEmail(){ return email; }
    public String getPassword() { return password; }

    // SETTER
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}