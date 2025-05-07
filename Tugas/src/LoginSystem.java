import java.util.Scanner;

public class LoginSystem {
    public static <Mahasiswa> void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Nawa Istiqomah", "202410370110372", "admin", "password123");
        Mahasiswa mahasiswa = new Mahasiswa("Nawa Istiqomah", "2024103701103721");

        System.out.println("===== SISTEM LOGIN =====");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih opsi login (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.println("\n=== LOGIN ADMIN ===");
                System.out.print("Username: ");
                String inputUsername = scanner.nextLine();
                System.out.print("Password: ");
                String inputPassword = scanner.nextLine();

                if (admin.login(inputUsername, inputPassword)) {
                    admin.displayInfo();
                } else {
                    System.out.println("Login Admin gagal. Username atau password salah!");
                }
                break;

            case 2:
                System.out.println("\n=== LOGIN MAHASISWA ===");
                System.out.print("Nama: ");
                String inputNama = scanner.nextLine();
                System.out.print("NIM: ");
                String inputNim = scanner.nextLine();

                if (mahasiswa.login(inputNama, inputNim)) {
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login Mahasiswa gagal. Nama atau NIM salah!");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}