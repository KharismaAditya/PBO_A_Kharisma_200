package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.util.Random;

public class mainCode extends Application {
    int percobaan = 1;
    int benar = 0;
    Random rand = new Random();
    int numRand = rand.nextInt(10);

    @Override
    public void start(Stage stage) throws Exception {


        stage.setTitle("Tebak Angka!");
        VBox root = new VBox(20);
        root.setPadding(new Insets(40));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: WHITE");

        Label titleLabel = new Label("☀ TEBAK ANGKA 1-100 ☀");
        titleLabel.setTextFill(Color.GRAY);
        titleLabel.setFont(Font.font("Tahoma", 20));

        Label textLabel = new Label();
        textLabel.setTextFill(Color.BLACK);

        TextField numField = new TextField();
        numField.setPromptText("Enter number");
        numField.setStyle("-fx-background-color : #AFDDFF; -fx-background-radius: 5");

        Button tebak = new Button("Coba tebak!");
        tebak.setStyle("-fx-background-color: #FF9149; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;");
        tebak.setOnMouseExited(e -> tebak.setStyle("-fx-background-color: #FF9149; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;"));
        tebak.setOnMouseEntered(e -> tebak.setStyle("-fx-background-color: #FFECDB; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;"));

        GridPane fieldBox = new GridPane();
        fieldBox.setVgap(5);
        fieldBox.setHgap(5);
        GridPane.setHgrow(numField, Priority.ALWAYS);

        fieldBox.add(numField, 0, 0);
        fieldBox.add(tebak, 1, 0);

        Label jumlahPer = new Label();
        jumlahPer.setTextFill(Color.BLACK);

        tebak.setOnAction(e -> {
            String input = numField.getText();
            int angka = Integer.parseInt(input);
            if(benar == 0){
                try {
                    if(angka == numRand){
                        textLabel.setText("✔ Tebakan benar");
                        textLabel.setTextFill(Color.BLUE);
                        tebak.setText("→ Main Lagi");
                        tebak.setStyle("-fx-background-color: #60B5FF; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;");
                        tebak.setOnMouseExited(ex -> tebak.setStyle("-fx-background-color: #60B5FF; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;"));
                        tebak.setOnMouseEntered(ex -> tebak.setStyle("-fx-background-color: #AFDDFF; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;"));
                        benar = 1;
                    }

                    if(angka < numRand){
                        textLabel.setText("✖ Terlalu kecil");
                        textLabel.setTextFill(Color.ORANGE);
                    }

                    if(angka > numRand){
                        textLabel.setText("✖ Terlalu besar");
                        textLabel.setTextFill(Color.ORANGE);
                    }
                }catch (NumberFormatException ex){
                    textLabel.setTextFill(Color.RED);
                    textLabel.setText("INPUT YANG ANDA MASUKKAN SALAH");
                }

                jumlahPer.setText("Jumlah percobaan: " + percobaan);
                percobaan++;
            }else{
                numField.clear();
                textLabel.setText("");
                tebak.setText("Coba tebak!");
                tebak.setStyle("-fx-background-color: #FF9149; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;");
                tebak.setOnMouseExited(ex -> tebak.setStyle("-fx-background-color: #FF9149; -fx-text-fill: white; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;"));
                tebak.setOnMouseEntered(ex -> tebak.setStyle("-fx-background-color: #FFECDB; -fx-text-fill: black; -fx-font-weight: bold; -fx-padding: 3; -fx-background-radius: 5;"));
                numRand = new Random().nextInt(10);
                percobaan = 1;
                benar = 0;
                jumlahPer.setText("");
            }
        });

        root.getChildren().addAll(titleLabel, textLabel, fieldBox, jumlahPer);
        Scene scene = new Scene(root,400,250);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
