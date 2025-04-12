import java.util.Scanner;

public class LoginSystem {
    // Nested Mahasiswa class
    static class Mahasiswa {
        private String nama;
        private String nim;

        public Mahasiswa() {
            this.nama = "Nawa Istiqomah";
            this.nim = "202410370110372";
        }

        public boolean login(String inputNama, String inputNim) {
            return this.nama.equals(inputNama) && this.nim.equals(inputNim);
        }

        public void displayInfo() {
            System.out.println("Nama: " + this.nama);
            System.out.println("NIM: " + this.nim);
        }
    }

    // Nested Admin class
    static class Admin {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa mahasiswa = new Mahasiswa();

        System.out.println("Pilih jenis login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan Anda: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String adminPassword = scanner.nextLine();

                if (admin.login(adminUsername, adminPassword)) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;

            case 2:
                System.out.print("Masukkan nama: ");
                String mahasiswaNama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String mahasiswaNim = scanner.nextLine();

                if (mahasiswa.login(mahasiswaNama, mahasiswaNim)) {
                    System.out.println("Login Mahasiswa berhasil!");
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        scanner.close();
    }
}