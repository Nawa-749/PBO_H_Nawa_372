package com.praktikum.GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LoginPane extends VBox {
    public LoginPane(Stage stage) {
        setPadding(new Insets(20));
        setSpacing(10);
        setStyle("-fx-background-color: linear-gradient(to bottom, #e0f7fa, #b2ebf2);");

        Label title = new Label("Login Sistem Lost & Found");
        title.setFont(new Font("Arial", 22));
        title.setTextFill(Color.DARKSLATEBLUE);

        ComboBox<String> roleBox = new ComboBox<>();
        roleBox.getItems().addAll("Mahasiswa", "Admin");
        roleBox.setValue("Mahasiswa");
        roleBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #4fc3f7;");

        TextField usernameField = new TextField();
        usernameField.setPromptText("Nama");
        usernameField.setStyle("-fx-background-color: #ffffff; -fx-border-color: #4fc3f7;");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setStyle("-fx-background-color: #ffffff; -fx-border-color: #4fc3f7;");

        Label message = new Label();
        message.setTextFill(Color.CRIMSON);

        Button loginBtn = new Button("Login");
        loginBtn.setStyle("-fx-background-color: #0288d1; -fx-text-fill: white;");
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
