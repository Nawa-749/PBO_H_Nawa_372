package com.praktikum.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.praktikum.GUI.LoginPane;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        LoginPane loginPane = new LoginPane(primaryStage);
        Scene scene = new Scene(loginPane, 400, 300);

        primaryStage.setTitle("Login Sistem Lost & Found");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}