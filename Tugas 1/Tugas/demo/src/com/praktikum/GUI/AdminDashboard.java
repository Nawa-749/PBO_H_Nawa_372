package com.praktikum.GUI;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AdminDashboard extends VBox {
    public AdminDashboard() {
        setPadding(new Insets(15));
        setSpacing(10);

        Label title = new Label("Lost & Found Kampus");
        Label welcome = new Label("Halo, Administrator admin");

        TableView<MahasiswaDashboard.Laporan> tabelBarang = new TableView<>();
        tabelBarang.setItems(MahasiswaDashboard.laporanList);

        TableColumn<MahasiswaDashboard.Laporan, String> jenisCol = new TableColumn<>("Nama");
        jenisCol.setCellValueFactory(new PropertyValueFactory<>("jenis"));

        TableColumn<MahasiswaDashboard.Laporan, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

        TableColumn<MahasiswaDashboard.Laporan, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        tabelBarang.getColumns().addAll(jenisCol, lokasiCol, statusCol);

        Button tandaiBtn = new Button("Tandai Claimed");
        tandaiBtn.setOnAction(e -> {
            MahasiswaDashboard.Laporan selected = tabelBarang.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setStatus("Claimed");
                tabelBarang.refresh();
            }
        });

        TableView<Mahasiswa> tabelMahasiswa = new TableView<>();
        tabelMahasiswa.setItems(MahasiswaDashboard.mahasiswaList);

        TableColumn<Mahasiswa, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<Mahasiswa, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));

        tabelMahasiswa.getColumns().addAll(namaCol, nimCol);

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");

        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button tambahBtn = new Button("Tambahkan");
        tambahBtn.setOnAction(e -> {
            String nama = namaField.getText();
            String nim = nimField.getText();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                MahasiswaDashboard.mahasiswaList.add(new Mahasiswa(nama, nim));
                namaField.clear();
                nimField.clear();
            }
        });

        Button hapusBtn = new Button("Hapus Mahasiswa");
        hapusBtn.setOnAction(e -> {
            Mahasiswa selected = tabelMahasiswa.getSelectionModel().getSelectedItem();
            if (selected != null) {
                MahasiswaDashboard.mahasiswaList.remove(selected);
            }
        });

        HBox formInput = new HBox(5, namaField, nimField, tambahBtn, hapusBtn);

        VBox mahasiswaBox = new VBox(10, new Label("Data Mahasiswa"), tabelMahasiswa, formInput);

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> getScene().setRoot(new LoginPane((Stage) getScene().getWindow())));

        getChildren().addAll(title, welcome, new Label("Laporan Barang"), tabelBarang, tandaiBtn, mahasiswaBox, logoutBtn);
    }

    public static class Mahasiswa {
        private String nama;
        private String nim;

        public Mahasiswa(String nama, String nim) {
            this.nama = nama;
            this.nim = nim;
        }

        public String getNama() { return nama; }
        public String getNim() { return nim; }
    }
}