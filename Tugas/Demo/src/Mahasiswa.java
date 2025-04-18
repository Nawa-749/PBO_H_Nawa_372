public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim); // Call the constructor of the parent class
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