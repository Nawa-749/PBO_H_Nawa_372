package com.praktikum.main;

import java.util.Scanner;
import com.praktikum.users.User;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;

public class LoginSystem {
    // Database dummy untuk penyimpanan user
    private static Admin admin = new Admin("admin", "admin123");
    private static Mahasiswa mahasiswa1 = new Mahasiswa("mahasiswa1", "mhs123", "202410370110372", "Nawa Istiqomah");
    private static Mahasiswa mahasiswa2 = new Mahasiswa("mahasiswa2", "mhs456", "202410370110368", "Alfina Nil Husna");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("===== SISTEM LOGIN LOST & FOUND =====");

        while (isRunning) {
            System.out.println("\nPilih Jenis Login:");
            System.out.println("1. Login sebagai Admin");
            System.out.println("2. Login sebagai Mahasiswa");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    loginAsAdmin(scanner);
                    break;
                case 2:
                    loginAsMahasiswa(scanner);
                    break;
                case 0:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }

    private static void loginAsAdmin(Scanner scanner) {
        System.out.println("\n===== LOGIN ADMIN =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Polymorphism - menyimpan objek Admin dalam variabel bertipe User
        User user = admin;

        if (user.login(username, password)) {
            System.out.println("\nLogin berhasil sebagai Admin!");
            // Polymorphism - memanggil method dari implementasi Admin
            user.displayAppMenu();
        } else {
            System.out.println("\nLogin gagal! Username atau password salah.");
        }
    }

    private static void loginAsMahasiswa(Scanner scanner) {
        System.out.println("\n===== LOGIN MAHASISWA =====");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Cek login untuk kedua mahasiswa
        User user = null;

        if (mahasiswa1.login(username, password)) {
            user = mahasiswa1;
        } else if (mahasiswa2.login(username, password)) {
            user = mahasiswa2;
        }

        if (user != null) {
            System.out.println("\nLogin berhasil sebagai Mahasiswa!");
            // Polymorphism - memanggil method dari implementasi Mahasiswa
            user.displayAppMenu();
        } else {
            System.out.println("\nLogin gagal! Username atau password salah.");
        }
    }
}