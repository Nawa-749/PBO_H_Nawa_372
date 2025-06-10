package com.praktikum.Users;
import com.praktikum.Main.LoginSystem;
import com.praktikum.models.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.InputMismatchException;

public class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String username, String password) {
        super(nama);
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan username: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String inputPassword = scanner.nextLine();

        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Kelola Barang");
            System.out.println("2. Kelola User");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (pilihan) {
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
                        break;
                    case 0:
                        System.out.println("Berhasil logout!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // clear invalid input
                pilihan = -1; // reset pilihan
            }
        } while (pilihan != 0);
    }

    public void manageItems() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== KELOLA BARANG ===");
            System.out.println("1. Lihat Semua Laporan");
            System.out.println("2. Tandai Barang Telah Diambil");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        viewAllReports();
                        break;
                    case 2:
                        markItemAsClaimed();
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

    private void viewAllReports() {
        System.out.println("\n=== SEMUA LAPORAN BARANG ===");

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        Iterator<Item> iterator = LoginSystem.reportedItems.iterator();
        int index = 0;

        while (iterator.hasNext()) {
            Item item = iterator.next();
            System.out.println((index++) + ". " + item.toString());
        }
    }

    private void markItemAsClaimed() {
        System.out.println("\n=== TANDAI BARANG TELAH DIAMBIL ===");

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        // Tampilkan hanya barang yang statusnya "Reported"
        System.out.println("Barang yang belum diambil:");
        int reportedCount = 0;
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            Item item = LoginSystem.reportedItems.get(i);
            if ("Reported".equals(item.getStatus())) {
                System.out.println(i + ". " + item.toString());
                reportedCount++;
            }
        }

        if (reportedCount == 0) {
            System.out.println("Semua barang sudah ditandai sebagai diambil.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan nomor indeks barang yang telah diambil: ");

        try {
            int index = scanner.nextInt();
            scanner.nextLine();

            Item item = LoginSystem.reportedItems.get(index);
            if ("Reported".equals(item.getStatus())) {
                item.setStatus("Claimed");
                System.out.println("Barang '" + item.getItemName() + "' berhasil ditandai sebagai telah diambil!");
            } else {
                System.out.println("Barang tersebut sudah ditandai sebagai diambil sebelumnya.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Input harus berupa angka!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Indeks tidak valid! Pastikan memasukkan nomor yang tersedia.");
        }
    }

    public void manageUsers() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== KELOLA USER ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Lihat Semua User");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        addMahasiswa();
                        break;
                    case 2:
                        deleteMahasiswa();
                        break;
                    case 3:
                        viewAllUsers();
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama...");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }

    private void addMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan nama mahasiswa: ");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM mahasiswa: ");
            String nim = scanner.nextLine();

            // Cek apakah NIM sudah ada
            for (User user : LoginSystem.userList) {
                if (user instanceof Mahasiswa && ((Mahasiswa) user).getNim().equals(nim)) {
                    System.out.println("NIM sudah terdaftar!");
                    return;
                }
            }

            Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim);
            LoginSystem.userList.add(mahasiswaBaru);
            System.out.println("Mahasiswa '" + nama + "' berhasil ditambahkan!");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menambah mahasiswa!");
        }
    }

    private void deleteMahasiswa() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nimHapus = scanner.nextLine();

        Iterator<User> iterator = LoginSystem.userList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Mahasiswa && ((Mahasiswa) user).getNim().equals(nimHapus)) {
                iterator.remove();
                System.out.println("Mahasiswa dengan NIM '" + nimHapus + "' berhasil dihapus!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Mahasiswa dengan NIM '" + nimHapus + "' tidak ditemukan!");
        }
    }

    private void viewAllUsers() {
        System.out.println("\n=== SEMUA USER ===");

        if (LoginSystem.userList.isEmpty()) {
            System.out.println("Belum ada user terdaftar.");
            return;
        }

        Iterator<User> iterator = LoginSystem.userList.iterator();
        int index = 1;

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                System.out.println(index++ + ". [ADMIN] " + admin.getNama() + " - Username: " + admin.getUsername());
            } else if (user instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) user;
                System.out.println(index++ + ". [MAHASISWA] " + mahasiswa.getNama() + " - NIM: " + mahasiswa.getNim());
            }
        }
    }
}