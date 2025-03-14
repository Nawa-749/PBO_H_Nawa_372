public class Admin {
    private String username;
    private String password;

    public Admin() {
        this.username = "Admin010";
        this.password = "Password010";
    }

    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
}