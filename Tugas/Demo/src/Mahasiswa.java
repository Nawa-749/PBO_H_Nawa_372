public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
<<<<<<< HEAD
        super(nama, nim);
=======
        super(nama, nim); // Call the constructor of the parent class
>>>>>>> d34c4fda6f917d6c4f1604517c6c51b50ca85eb4
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return super.login(inputNama, inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa Berhasil!");
        super.displayInfo();
    }
}