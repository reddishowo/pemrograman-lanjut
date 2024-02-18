package com.modul6.latihan2;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    private TableView table = new TableView();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        //Main UI
        stage.setTitle("Test TableView");
        stage.setWidth(450);
        stage.setHeight(550);

        //Object Daftar Mahasiswa
        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Arial", 30));

        //Objek baru & Deklarasi kolom
        TableColumn nameCol = new TableColumn("Nama");
        TableColumn nimCol = new TableColumn("NIM");
        TableColumn emailCol = new TableColumn("Email");

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        //Menambahkan kolom ke TableView
        table.getColumns().addAll(nameCol, nimCol, emailCol);

        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa("Larynt", "202110370311189", "laryntsa@gmail.com"),
                new Mahasiswa("Ahya", "202110370311187", "ayaa@gmail.com")
        );

        //Set Data ke TableView
        table.setItems(data);

        final VBox vbox = new VBox();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        // Membuat TextField untuk input Nama, NIM, dan Email
        TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        TextField addNim = new TextField();
        addNim.setMaxWidth(nimCol.getPrefWidth());
        addNim.setPromptText("NIM");

        TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        // Membuat Button untuk menambahkan data baru
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            // Menambahkan data baru ke dalam ObservableList
            data.add(new Mahasiswa(
                    addName.getText(),
                    addNim.getText(),
                    addEmail.getText()
            ));

            // Mengosongkan nilai input setelah menambahkan data
            addName.clear();
            addNim.clear();
            addEmail.clear();
        });

        // Mengatur layout horizontal untuk TextField dan Button
        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addName, addNim, addEmail, addButton);
        hboxInput.setSpacing(10);

        // Menambahkan HBox input ke dalam VBox sebelumnya
        vbox.getChildren().addAll(hboxInput);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }
}

