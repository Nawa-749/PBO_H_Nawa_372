public class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
<<<<<<< HEAD
        super(nama, nim);
=======
        super(nama, nim); // Call the constructor of the parent class
>>>>>>> d34c4fda6f917d6c4f1604517c6c51b50ca85eb4
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        if (username.equals(inputUsername) && password.equals(inputPassword)) {
            return true;
        } else {
            return false;
        }
    }
<<<<<<< HEAD
=======
    // Override displayInfo method
>>>>>>> d34c4fda6f917d6c4f1604517c6c51b50ca85eb4
    @Override
    public void displayInfo() {
        System.out.println("Login Admin Berhasil!");
        System.out.println("Informasi Admin:");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Username: " + username);
    }
}