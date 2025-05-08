package com.praktikum.users;

import java.util.Scanner;
import com.praktikum.actions.MahasiswaActions;

public class Mahasiswa extends User implements MahasiswaActions {
    private String nim;
    private String nama;

    public Mahasiswa(String username, String password, String nim, String nama) {
        super(username, password);
        this.nim = nim;
        this.nama = nama;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayAppMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== MAHASISWA MENU =====");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilihan: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Logout berhasil!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (choice != 0);
    }

    @Override
    public void reportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n===== LAPOR BARANG =====");
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();

        System.out.print("Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();

        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasiBarang = scanner.nextLine();

        System.out.println("\nLaporan berhasil disimpan!");
        System.out.println("Barang: " + namaBarang);
        System.out.println("Deskripsi: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasiBarang);
        System.out.println("Pelapor: " + nama + " (" + nim + ")");
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }
}