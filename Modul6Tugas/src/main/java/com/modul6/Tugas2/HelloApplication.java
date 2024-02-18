package com.modul6.Tugas2;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    private TableView table = new TableView();

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Jadwal Kuliah");//nama dari file outputnya
        stage.setWidth(650);
        stage.setHeight(750);

        final Label label = new Label("Jadwal Kuliah");
        label.setFont(new Font("Times New Roman", 30));


        TableColumn dosenCol = new TableColumn("Dosen");
        TableColumn matkulCol = new TableColumn("Mata Kuliah");
        TableColumn gkbCol = new TableColumn("GKB");
        TableColumn waktuCol = new TableColumn("Waktu");
        TableColumn ruanganCol = new TableColumn("Ruangan");

        dosenCol.setCellValueFactory(new PropertyValueFactory<>("dosen"));
        matkulCol.setCellValueFactory(new PropertyValueFactory<>("matakuliah"));
        gkbCol.setCellValueFactory(new PropertyValueFactory<>("gkb"));
        waktuCol.setCellValueFactory(new PropertyValueFactory<>("waktu"));
        ruanganCol.setCellValueFactory(new PropertyValueFactory<>("ruangan"));

        table.getColumns().addAll(dosenCol, matkulCol, gkbCol, waktuCol, ruanganCol);

        ObservableList<JadwalKuliah> data = FXCollections.observableArrayList(
          new JadwalKuliah("Windah", "Pemrograman Lanjut", "3", "13:00", "308")
        );

        table.setItems(data);

        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20,10,10,10));
        vbox.getChildren().addAll(label, table);

        //Membuat TextField untuk Input Dosen
        TextField addDosen = new TextField();
        addDosen.setMaxWidth(dosenCol.getPrefWidth());
        addDosen.setPromptText("Nama Dosen");

        TextField addMatkul = new TextField();
        addMatkul.setMaxWidth(matkulCol.getPrefWidth());
        addMatkul.setPromptText("Mata Kuliah");

        TextField addGKB = new TextField();
        addGKB.setMaxWidth(gkbCol.getPrefWidth());
        addGKB.setPromptText("GKB");

        TextField addWaktu = new TextField();
        addWaktu.setMaxWidth(waktuCol.getPrefWidth());
        addWaktu.setPromptText("Waktu");

        TextField addRuangan = new TextField();
        addRuangan.setMaxWidth(ruanganCol.getPrefWidth());
        addRuangan.setPromptText("Ruangan");


        //Membuat Button untuk Menambahkan Data Baru
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {

            //Mendapatkan Input dari TextField
            String dosen = addDosen.getText();
            String matkul = addMatkul.getText();
            String gkb = addGKB.getText();
            String waktu = addWaktu.getText();
            String ruangan = addRuangan.getText();

                //Memeriksa Apakah ada input yang kosong atau NIM tidak berupa angka
                if (dosen.isEmpty() || matkul.isEmpty() || gkb.isEmpty() || waktu.isEmpty() || ruangan.isEmpty()) {
                    //Menampilkan notifikasi jika ada input yang kosong
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Semua Field Harus Diisi");
                    alert.showAndWait();
                    return;
                }

            //Menambahkan Data Baru Ke Dalam ObservableList
            data.add(new JadwalKuliah(dosen, matkul, gkb, waktu, ruangan));

            //Mengosongkan Nilai Input Setelah Menambahkan Data
            addDosen.clear();
            addMatkul.clear();
            addGKB.clear();
            addWaktu.clear();
            addRuangan.clear();
        });

        //Mengatur Layout Horizontal Untuk TextField dan Button
        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addDosen, addMatkul, addGKB, addWaktu, addRuangan, addButton);
        hboxInput.setSpacing(10);

        //Menambahkan HBOX input ke dalam Vbox Sebelumnya
        vbox.getChildren().addAll(hboxInput);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public class JadwalKuliah {
        private final StringProperty dosen = new SimpleStringProperty();
        private final StringProperty matkul = new SimpleStringProperty();
        private final StringProperty gkb = new SimpleStringProperty();
        private final StringProperty waktu = new SimpleStringProperty();
        private final StringProperty ruangan = new SimpleStringProperty();

        public JadwalKuliah(String dosen, String matakuliah, String gkb, String waktu, String ruangan) {
            setDosen(dosen);
            setMatkul(matakuliah);
            setGkb(gkb);
            setWaktu(waktu);
            setRuangan(ruangan);
        }

        public StringProperty nameProperty() {
            return dosen;
        }

        public String getDosen() {
            return dosen.get();
        }

        public void setDosen(String newDosen) {
            dosen.set(newDosen);
        }

        public String getMatakuliah() {
            return matkul.get();
        }

        public void setMatkul(String newMatakuliah) {
            matkul.set(newMatakuliah);
        }

        public String getGkb() {
            return gkb.get();
        }

        public void setGkb(String newGkb) {
            gkb.set(newGkb);
        }

        public String getWaktu() {
            return waktu.get();
        }

        public void setWaktu(String newWaktu) {
            waktu.set(newWaktu);
        }

        public String getRuangan() {
            return ruangan.get();
        }

        public void setRuangan(String newRuangan) {
            ruangan.set(newRuangan);
        }
    }
}