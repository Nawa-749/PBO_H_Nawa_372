package com.praktikum.GUI;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard extends VBox {
    public static ObservableList<Laporan> laporanList = FXCollections.observableArrayList();
    public static ObservableList<AdminDashboard.Mahasiswa> mahasiswaList = FXCollections.observableArrayList();

    public MahasiswaDashboard(String nama) {
        setPadding(new Insets(15));
        setSpacing(10);

        Label welcome = new Label("Selamat datang, " + nama);
        Label instruksi = new Label("Laporkan Barang Hilang/Temuan");

        TextField item = new TextField();
        item.setPromptText("Nama barang");

        TextField deskripsi = new TextField();
        deskripsi.setPromptText("Deskripsi barang");

        TextField lokasi = new TextField();
        lokasi.setPromptText("Lokasi ditemukan/kehilangan");

        Button laporBtn = new Button("Laporkan");

        TableView<Laporan> tabel = new TableView<>();
        tabel.setPlaceholder(new Label("Daftar laporan akan tampil di sini"));

        TableColumn<Laporan, String> jenisCol = new TableColumn<>("Jenis");
        jenisCol.setCellValueFactory(new PropertyValueFactory<>("jenis"));

        TableColumn<Laporan, String> deskripsiCol = new TableColumn<>("Deskripsi");
        deskripsiCol.setCellValueFactory(new PropertyValueFactory<>("deskripsi"));

        TableColumn<Laporan, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(new PropertyValueFactory<>("lokasi"));

        tabel.getColumns().addAll(jenisCol, deskripsiCol, lokasiCol);
        tabel.setItems(laporanList);

        laporBtn.setOnAction(e -> {
            String j = item.getText();
            String d = deskripsi.getText();
            String l = lokasi.getText();

            if (j != null && !d.isEmpty() && !l.isEmpty()) {
                laporanList.add(new Laporan(j, d, l, "Reported"));
                deskripsi.clear();
                lokasi.clear();
                item.clear();
            }
        });

        Button logoutBtn = new Button("Logout");
        logoutBtn.setOnAction(e -> getScene().setRoot(new LoginPane((Stage) getScene().getWindow())));

        getChildren().addAll(welcome, instruksi, item, deskripsi, lokasi, laporBtn, tabel, logoutBtn);
    }

    public static void addMahasiswa(String nama, String nim) {
        boolean exists = mahasiswaList.stream().anyMatch(m -> m.getNama().equals(nama) && m.getNim().equals(nim));
        if (!exists) {
            mahasiswaList.add(new AdminDashboard.Mahasiswa(nama, nim));
        }
    }

    public static class Laporan {
        private final SimpleStringProperty jenis;
        private final SimpleStringProperty deskripsi;
        private final SimpleStringProperty lokasi;
        private final SimpleStringProperty status;

        public Laporan(String jenis, String deskripsi, String lokasi, String status) {
            this.jenis = new SimpleStringProperty(jenis);
            this.deskripsi = new SimpleStringProperty(deskripsi);
            this.lokasi = new SimpleStringProperty(lokasi);
            this.status = new SimpleStringProperty(status);
        }

        public String getJenis() { return jenis.get(); }
        public String getDeskripsi() { return deskripsi.get(); }
        public String getLokasi() { return lokasi.get(); }
        public String getStatus() { return status.get(); }
        public void setStatus(String status) { this.status.set(status); }
    }
}