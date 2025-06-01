package com.praktikum.gui;

import javafx.collections.transformation.FilteredList;
import com.praktikum.data.*;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;


public class mahasiswaDashboard extends Application {
    private String user;
    private String nim;

    public mahasiswaDashboard(String user, String nim){
        this.user = user;
        this.nim = nim;
    }

    ItemStorage ItemStorage = new ItemStorage();
    ArrayList<Item> itemList = new ArrayList<>();
    public ObservableList<Item> masterData = ItemStorage.getItems();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Mahasiswa Dashboard");
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.TOP_LEFT);

        Label profileLabel = new Label("Selamat datang, " + user);
        Label informationLabel = new Label("Laporkan barang Hilang/Temuan");

        HBox userField = new HBox(10);
        userField.setPadding(new Insets(5));
        userField.setAlignment(Pos.CENTER);

        TextField namaBarang = new TextField();
        namaBarang.setPromptText("Nama Barang");

        TextField deskripsiBarang = new TextField();
        deskripsiBarang.setPromptText("Deskripsi Barang");

        TextField lokasiBarang = new TextField();
        lokasiBarang.setPromptText("Lokasi terakhir");

        Button laporkan = new Button("Laporkan");

        userField.getChildren().addAll(namaBarang, deskripsiBarang, lokasiBarang, laporkan);

        TableView<Item> tableView = new TableView<>();
        tableView.setPrefWidth(500);

        //table columns
        TableColumn<Item, String> nameCol = new TableColumn<>("Nama Barang");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
        nameCol.setPrefWidth(100);

        TableColumn<Item, String> desCol = new TableColumn<>("Deskripsi Barang");
        desCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        desCol.setPrefWidth(200);

        TableColumn<Item, String> lokCol = new TableColumn<>("Lokasi terakhir");
        lokCol.setCellValueFactory(new PropertyValueFactory<>("location"));
        lokCol.setPrefWidth(200);

        tableView.getColumns().addAll(nameCol, desCol, lokCol);
        FilteredList<Item> foundedItems = new FilteredList<>(masterData, item -> item.getStatus().equalsIgnoreCase("Founded"));
        tableView.setItems(foundedItems);


        Button logout = new Button("Logout");
        logout.setOnAction(e -> {
            LoginPane login = new LoginPane();
            try {
                login.start(new Stage());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            stage.close();
        });

        laporkan.setOnAction(e-> {
            String barang = namaBarang.getText();
            String deskripsi = deskripsiBarang.getText();
            String lokasi = lokasiBarang.getText();

            masterData.add(new Item(barang, deskripsi, lokasi));
        });

        root.getChildren().addAll(profileLabel, informationLabel, userField, tableView, logout);
        Scene scene = new Scene(root, 800, 800);
        stage.setScene(scene);
        stage.show();
    }

}
