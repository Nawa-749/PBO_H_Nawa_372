package com.praktikum.Models;

import com.praktikum.GUI.AdminDashboard;
import com.praktikum.GUI.MahasiswaDashboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DataStore {
    public static ObservableList<MahasiswaDashboard.Laporan> laporanList = FXCollections.observableArrayList();
    public static ObservableList<AdminDashboard.Mahasiswa> mahasiswaList = FXCollections.observableArrayList();


    static {
        mahasiswaList.addAll(
                new AdminDashboard.Mahasiswa("Dhea Rengganis", "349"),
                new AdminDashboard.Mahasiswa("Alfina Nil Husna", "368"),
                new AdminDashboard.Mahasiswa("Nawa Istiqomah", "372")
        );

        laporanList.addAll(
                new MahasiswaDashboard.Laporan("Binder A5 Bergaris", "berwarna beige dengan stiker bunga kering", "Perpustakaan UMM, Lantai 3", "Reported"),
                new MahasiswaDashboard.Laporan("Jam Tangan Fossil Wanita", "berbahan kulit cokelat muda dengan bingkai emas rose gold", "Masjid AR Fachruddin, area tempat wudhu wanita", "Reported"),
                new MahasiswaDashboard.Laporan("Ukulele Kayu Mahoni", "berwarna cokelat tua, ada stiker bendera kecil Indonesia di body depan", "Taman Bunga depan Laboratorium Biologi", "Reported")
        );
    }
}