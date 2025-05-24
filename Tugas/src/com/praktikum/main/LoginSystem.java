package com.praktikum.main;
import com.praktikum.users.*;
import com.praktikum.models.Item;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LoginSystem {
    // ArrayList static untuk menyimpan data secara global
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();

    // Inisialisasi data default
    static {
        initializeDefaultData();
    }

    private static void initializeDefaultData() {
        // Tambah admin default
        userList.add(new Admin("Admin", "admin", "admin372"));

        // Tambah mahasiswa default
        userList.add(new Mahasiswa("Nawa Istiqomah", "202410370110372"));
        userList.add(new Mahasiswa("Alfina Nil Husna", "202410370110368"));
        userList.add(new Mahasiswa("Dhea Rengganis Tri Wahyuni", "202410370110349"));

        // Tambah beberapa item laporan default untuk testing
        reportedItems.add(new Item("Powerbank Lucu", "Powerbank berbentuk roti tawar", "Gedung GKB 1, Lt. 2"));
        reportedItems.add(new Item("Payung Transparan", "Payung bening ala drama korea", "Parkiran Motor Utama"));
        reportedItems.add(new Item("Tumblr K-pop", "Tumblr bergambar idol Korea", "Kantin GKB 3"));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEM PELAPORAN BARANG HILANG/TEMUAN ===");
        System.out.println("Selamat datang!");

        while (true) {
            try {
                System.out.println("\n=== LOGIN ===");
                System.out.println("1. Login sebagai Admin");
                System.out.println("2. Login sebagai Mahasiswa");
                System.out.println("0. Keluar");
                System.out.print("Pilih jenis login: ");

                int pilihan = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (pilihan) {
                    case 1:
                        loginAsAdmin();
                        break;
                    case 2:
                        loginAsMahasiswa();
                        break;
                    case 0:
                        System.out.println("Terima kasih telah menggunakan sistem kami!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // clear invalid input
            }
        }
    }

    private static void loginAsAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== LOGIN ADMIN ===");
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Cari admin dalam userList
        for (User user : userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
                    System.out.println("Login berhasil! Selamat datang, " + admin.getNama());
                    admin.displayMenu();
                    return;
                }
            }
        }

        System.out.println("Username atau password salah!");
    }

    private static void loginAsMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== LOGIN MAHASISWA ===");
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("NIM: ");
        String nim = scanner.nextLine();

        for (User user : userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                if (mahasiswa.getNama().equals(nama) && mahasiswa.getNim().equals(nim)) {
                    System.out.println("Login berhasil! Selamat datang, " + mahasiswa.getNama());
                    mahasiswa.displayMenu();
                    return;
                }
            }
        }

        System.out.println("Nama atau NIM tidak ditemukan!");
    }
}