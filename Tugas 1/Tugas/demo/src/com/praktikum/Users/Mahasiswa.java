package com.praktikum.Users;
import com.praktikum.Main.LoginSystem;
import com.praktikum.models.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.InputMismatchException;

public class Mahasiswa extends User {
    private String nim;

    public Mahasiswa(String nama, String nim) {
        super(nama);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public boolean login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama: ");
        String inputNama = scanner.nextLine();
        System.out.print("Masukkan NIM: ");
        String inputNim = scanner.nextLine();

        return this.nama.equals(inputNama) && this.nim.equals(inputNim);
    }

    @Override
    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("\n=== MENU MAHASISWA ===");
            System.out.println("1. Laporkan Barang Hilang/Temuan");
            System.out.println("2. Lihat Laporan Barang");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (pilihan) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
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

    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("\n=== LAPORKAN BARANG ===");
            System.out.print("Nama barang: ");
            String itemName = scanner.nextLine();

            System.out.print("Deskripsi barang: ");
            String description = scanner.nextLine();

            System.out.print("Lokasi ditemukan/hilang: ");
            String location = scanner.nextLine();

            Item newItem = new Item(itemName, description, location);
            LoginSystem.reportedItems.add(newItem);

            System.out.println("Laporan barang '" + itemName + "' berhasil disimpan!");

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan saat menyimpan laporan!");
        }
    }

    public void viewReportedItems() {
        System.out.println("\n=== LAPORAN BARANG ===");

        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        Iterator<Item> iterator = LoginSystem.reportedItems.iterator();
        int index = 1;

        System.out.println("Daftar barang yang dilaporkan:");
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if ("Reported".equals(item.getStatus())) {
                System.out.println(index++ + ". " + item.toString());
            }
        }

        if (index == 1) {
            System.out.println("Semua barang sudah ditandai sebagai diambil.");
        }
    }
}