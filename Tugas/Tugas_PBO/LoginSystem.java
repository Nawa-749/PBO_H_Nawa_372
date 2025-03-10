import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

                if (adminUsername.equals("Admin010") && adminPassword.equals("Password010")) {
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

                if (mahasiswaNama.equals("Nawa Istiqomah") && mahasiswaNim.equals("202410370110372")) {
                    System.out.println("Login Mahasiswa berhasil!");
                    System.out.println("Nama: " + mahasiswaNama);
                    System.out.println("NIM: " + mahasiswaNim);
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.")
                }
                break;

            default:
                System.out.println("Pilihan tidak valid.");
                break;
        }

        scanner.close();
    }
}
