package com.praktikum.gui;

import com.praktikum.data.Student;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import com.praktikum.data.*;

import java.util.ArrayList;


public class LoginPane extends Application {
    ArrayList<Student> stdlist = new ArrayList<>();
    dataCollected data = new dataCollected();


    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Lost and found Campus");
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.TOP_CENTER);

        Label titleLabel = new Label("Login Sistem Lost & Found");
        ComboBox<String> personType = new ComboBox<>();
        personType.getItems().addAll("Mahasiswa", "Admin");
        personType.setValue("Mahasiswa");

        TextField userNameField = new TextField();
        userNameField.setPromptText("Masukkan Username");

        TextField passwordField = new TextField();
        passwordField.setPromptText("Masukkan Nomor ID");

        Button login = new Button("Login");
        Label announce = new Label();

        login.setOnAction(e -> {
            String user = userNameField.getText();
            String pass = passwordField.getText();
            String personChoice = personType.getValue();

            if(personChoice.equals("Mahasiswa")){
                if(statusLogin(user, pass)){
                    announce.setText("LOGIN BERHASIL");
                    mahasiswaDashboard mhs = new mahasiswaDashboard(user, pass);
                    try {
                        mhs.start(new Stage());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    stage.close();
                }else {
                    announce.setText("LOGIN GAGAL");
                }
            }else if(personChoice.equals("Admin")){
                if(user.equals("Admin200") && pass.equals("Password200")){
                    announce.setText("LOGIN ADMIN BERHASIL");
                    adminDashboard admin = new adminDashboard();
                    try {
                        admin.start(new Stage());
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    stage.close();
                }else{
                    announce.setText("LOGIN GAGAL");
                }
            }

        });

        root.getChildren().addAll(titleLabel,personType, userNameField, passwordField, login, announce);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public boolean statusLogin(String user, String pass){
        data.dataMahasiswaDefault(stdlist);
        for(Student student : stdlist){
            if(user.equals(student.getNama()) && pass.equals(student.getNIM())){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        launch(args);
    }
}
