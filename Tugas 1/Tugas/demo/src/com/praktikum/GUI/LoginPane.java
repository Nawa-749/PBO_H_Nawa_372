package com.praktikum.GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class LoginPane extends VBox {
    public LoginPane(Stage stage) {
        setPadding(new Insets(20));
        setSpacing(10);

        Label title = new Label("Login Sistem Lost & Found");

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Nama");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Label message = new Label();

        Button loginBtn = new Button("Login");
        loginBtn.setOnAction(e -> {
            String role = roleBox.getValue();
            String user = usernameField.getText();
            String pass = passwordField.getText();

            if (validateLogin(user, pass, role)) {
                if (role.equals("Mahasiswa")) {
                    MahasiswaDashboard.addMahasiswa(user, pass);
                    stage.setScene(new Scene(new MahasiswaDashboard(user), 600, 400));
                } else {
                    stage.setScene(new Scene(new AdminDashboard(), 800, 500));
                }
            } else {
                message.setText("Login gagal, periksa kredensial.");
            }
        });

        getChildren().addAll(title, roleBox, usernameField, passwordField, loginBtn, message);
    }

    private boolean validateLogin(String user, String pass, String role) {
        if (role.equals("Mahasiswa")) {
            return !user.isEmpty() && !pass.isEmpty();
        } else {
            return (user.equals("admin") && pass.equals("admin"));
        }
    }
}