package com.praktikum.GUI;

import com.praktikum.Models.DataStore;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MahasiswaDashboard extends VBox {
    public static ObservableList<Laporan> laporanList = DataStore.laporanList;
    public static ObservableList<AdminDashboard.Mahasiswa> mahasiswaList = DataStore.mahasiswaList;

    public MahasiswaDashboard(String nama) {
        setPadding(new Insets(15));
        setSpacing(10);
        setStyle("-fx-background-color: linear-gradient(to bottom, #b2ebf2, #e0f7fa);");

        Label welcome = new Label("Selamat datang, " + nama);
        welcome.setStyle("-fx-font-size: 18px; -fx-text-fill: #01579b;");

        Label instruksi = new Label("Laporkan Barang Hilang/Temuan");
        instruksi.setStyle("-fx-font-size: 14px; -fx-text-fill: #0277bd;");

        TextField item = new TextField();
        item.setPromptText("Nama barang");
        item.setStyle("-fx-background-color: white; -fx-border-color: #4fc3f7;");

        TextField deskripsi = new TextField();
        deskripsi.setPromptText("Deskripsi barang");
        deskripsi.setStyle("-fx-background-color: white; -fx-border-color: #4fc3f7;");

        TextField lokasi = new TextField();
        lokasi.setPromptText("Lokasi ditemukan/kehilangan");
        lokasi.setStyle("-fx-background-color: white; -fx-border-color: #4fc3f7;");

        Button laporBtn = new Button("Laporkan");
        laporBtn.setStyle("-fx-background-color: #0288d1; -fx-text-fill: white; -fx-font-weight: bold;");

        TableView<Laporan> tabel = new TableView<>();
        tabel.setPlaceholder(new Label("Daftar laporan akan tampil di sini"));
        tabel.setStyle("-fx-background-color: #ffffff; -fx-border-color: #4dd0e1;");

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
        logoutBtn.setStyle("-fx-background-color: #00acc1; -fx-text-fill: white;");
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
