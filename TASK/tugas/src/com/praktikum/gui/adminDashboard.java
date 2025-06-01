package com.praktikum.gui;

import com.praktikum.data.*;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class adminDashboard extends Application {
    ItemStorage itStor = new ItemStorage();
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<Student> stdList;

    public ObservableList<Item> masterDataItem = itStor.getItems();
    public ObservableList<Student> masterDataStudent = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) throws Exception {
        stdList = ItemStorage.stdList;
        if (stdList.isEmpty()) {
            dataCollected data = new dataCollected();
            data.dataMahasiswaDefault(stdList);
        }
        masterDataStudent.setAll(stdList);

            stage.setTitle("Lost and found Campus");
            VBox root = new VBox(20);
            root.setPadding(new Insets(40));
            root.setAlignment(Pos.TOP_LEFT);

            Label adminLabel = new Label("Halo, Administrator admin");

            //tabel barang
            VBox itemBox = new VBox(10);
            itemBox.setPadding(new Insets(10));
            itemBox.setAlignment(Pos.TOP_LEFT);

            Label lapBarang = new Label("Laporan barang");
            TableView<Item> barangTable = new TableView<>();
            barangTable.setPrefWidth(400);

            TableColumn<Item, String> nameCol = new TableColumn<>("Nama");
            nameCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));
            nameCol.setPrefWidth(100);

            TableColumn<Item, String> lokCol = new TableColumn<>("Lokasi");
            lokCol.setCellValueFactory(new PropertyValueFactory<>("location"));
            lokCol.setPrefWidth(100);

            TableColumn<Item, String> statusCol = new TableColumn<>("Status");
            statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
            statusCol.setPrefWidth(100);

            TableColumn<Item, Void> setStatCol = new TableColumn<>("Action");
            setStatCol.setPrefWidth(100);
            setStatCol.setCellFactory(e -> new TableCell<>() {
                private final Button clBtn = new Button("CLAIMED");
                {
                    clBtn.setOnAction(ex -> {
                        Item item = getTableView().getItems().get(getIndex());
                        if(item.getStatus().equalsIgnoreCase("Founded")){
                            item.setStatus("Claimed");
                            getTableView().refresh();
                        }else {
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Info");
                            alert.setHeaderText(null);
                            alert.setContentText("Item ini sudah diklaim.");
                            alert.showAndWait();
                        }
                    });
                }
                @Override
                protected void updateItem(Void v, boolean empty) {
                    super.updateItem(v, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(clBtn);
                    }
                }
            });
            barangTable.getColumns().addAll(nameCol, lokCol, statusCol, setStatCol);
            barangTable.setItems(masterDataItem);
            itemBox.getChildren().addAll(lapBarang, barangTable);


            VBox mhsBox = new VBox(10);
            mhsBox.setPadding(new Insets(10));
            mhsBox.setAlignment(Pos.TOP_LEFT);

            //tabel mahasiswa
            Label lapMahasiswa = new Label("Data Mahasiswa");
            TableView<Student> mhsTable = new TableView<>();
            mhsTable.setPrefWidth(400);

            TableColumn<Student, String> namaCol = new TableColumn<>("Nama");
            namaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));
            namaCol.setPrefWidth(150);

            TableColumn<Student, String> nimCol = new TableColumn<>("NIM");
            nimCol.setCellValueFactory(new PropertyValueFactory<>("NIM"));
            nimCol.setPrefWidth(150);

            TableColumn<Student, Void> hapusMhs = new TableColumn<>("Hapus");
            hapusMhs.setPrefWidth(100);
            hapusMhs.setCellFactory(e -> new TableCell<>() {
                private final Button clBtn = new Button("HAPUS");
                {
                    clBtn.setOnAction(ex -> {
                        Student student = getTableView().getItems().get(getIndex());

                        // Konfirmasi sebelum hapus
                        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                        confirm.setTitle("Konfirmasi");
                        confirm.setHeaderText(null);
                        confirm.setContentText("Apakah Anda yakin ingin menghapus data mahasiswa ini?");

                        confirm.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                ItemStorage.stdList.remove(student);
                                masterDataStudent.setAll(ItemStorage.stdList);
                                mhsTable.refresh();
                            }
                        });
                    });
                }

                @Override
                protected void updateItem(Void v, boolean empty) {
                    super.updateItem(v, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(clBtn);
                    }
                }
            });

            mhsTable.getColumns().addAll(namaCol, nimCol, hapusMhs);
            mhsTable.setItems(masterDataStudent);

            HBox inputForm = new HBox(10);
            inputForm.setAlignment(Pos.CENTER_LEFT);
            inputForm.setPadding(new Insets(10, 0, 0, 0));

            TextField namaField = new TextField();
            namaField.setPromptText("Nama Mahasiswa");

            TextField nimField = new TextField();
            nimField.setPromptText("NIM");

            Button tambahBtn = new Button("Tambah");

            tambahBtn.setOnAction(e -> {
                String nama = namaField.getText().trim();
                String nim = nimField.getText().trim();

                if (nama.isEmpty() || nim.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Peringatan");
                    alert.setHeaderText(null);
                    alert.setContentText("Nama dan NIM tidak boleh kosong.");
                    alert.showAndWait();
                } else {
                    Student newStudent = new Student(nama, nim);
                    ItemStorage.stdList.add(newStudent);
                    masterDataStudent.setAll(ItemStorage.stdList);
                    namaField.clear();
                    nimField.clear();
                    mhsTable.refresh();
                }
            });

            inputForm.getChildren().addAll(new Label("Nama:"), namaField, new Label("NIM:"), nimField, tambahBtn);
            mhsBox.getChildren().addAll(lapMahasiswa, mhsTable, inputForm);
            Button kembali = new Button("KEMBALI");
            kembali.setOnAction(e -> {
                LoginPane login = new LoginPane();
                try {
                    login.start(new Stage());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                stage.close();
            });
            HBox table = new HBox(10);
            table.setPadding(new Insets(10, 0, 0, 0));
            table.getChildren().addAll(itemBox, mhsBox);


            root.getChildren().addAll(adminLabel, table, kembali);
            Scene scene = new Scene(root, 1020, 500);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
    }
}
