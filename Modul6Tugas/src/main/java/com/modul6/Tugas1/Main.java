package com.modul6.Tugas1;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
        stage.setTitle("Test TableView");
        stage.setWidth(725);
        stage.setHeight(750);

        final Label label = new Label("Daftar Mahasiswa");
        label.setFont(new Font("Times New Roman", 30));

        TableColumn nameCol = new TableColumn("Nama");
        TableColumn nimCol = new TableColumn("NIM");
        TableColumn emailCol = new TableColumn("Email");
        TableColumn fakultasCol = new TableColumn("Fakultas");
        TableColumn jurusanCol = new TableColumn("Jurusan");
        TableColumn alamatCol = new TableColumn("Alamat");
        TableColumn kotaCol = new TableColumn("Kota");


        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));
        fakultasCol.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        jurusanCol.setCellValueFactory(new PropertyValueFactory<>("jurusan"));
        alamatCol.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        kotaCol.setCellValueFactory(new PropertyValueFactory<>("kota"));


        table.getColumns().addAll(nameCol, nimCol, emailCol, fakultasCol, jurusanCol, alamatCol, kotaCol);

        ObservableList<Mahasiswa> data = FXCollections.observableArrayList(
                new Mahasiswa("Farriel Arrianta", "2022103703077", "Farriel@webmail.umm.ac.id", "Teknik", "Informatika", "Veteran", "Malang")
        );

        table.setItems(data);

        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20, 10, 10, 10));
        vbox.getChildren().addAll(label, table);

        // Membuat TextField untuk input Nama, NIM, Email, Fakultas, jurusan, alamat, dan kota
        TextField addName = new TextField();
        addName.setMaxWidth(nameCol.getPrefWidth());
        addName.setPromptText("Nama Mahasiswa");

        TextField addNim = new TextField();
        addNim.setMaxWidth(nimCol.getPrefWidth());
        addNim.setPromptText("NIM");

        // Menambahkan listener ke properti textProperty() untuk memastikan hanya angka yang dimasukkan
        addNim.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                // Jika yang dimasukkan bukan angka, mengganti nilai dengan nilai sebelumnya
                addNim.setText(oldValue);
            }
        });

        TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");

        TextField addFakultas = new TextField();
        addFakultas.setMaxWidth(fakultasCol.getPrefWidth());
        emailCol.setMinWidth(170);
        addFakultas.setPromptText("Fakultas");

        TextField addJurusan = new TextField();
        addJurusan.setMaxWidth(jurusanCol.getPrefWidth());
        alamatCol.setMinWidth(100);
        addJurusan.setPromptText("Jurusan");

        TextField addAlamat = new TextField();
        addAlamat.setMaxWidth(alamatCol.getPrefWidth());
        kotaCol.setMinWidth(100);
        addAlamat.setPromptText("Alamat");

        TextField addKota = new TextField();
        addKota.setMaxWidth(kotaCol.getPrefWidth());
        addKota.setPromptText("Kota");



        // Membuat Button untuk menambahkan data baru
        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {

            // Mendapatkan input dari TextField
            String name = addName.getText();
            String nim = addNim.getText();
            String email = addEmail.getText();
            String fakultas = addFakultas.getText();
            String jurusan = addJurusan.getText();
            String alamat = addAlamat.getText();
            String kota = addKota.getText();




            // Memeriksa apakah email diakhiri dengan @webmail.umm.ac.id
            if (!email.endsWith("@webmail.umm.ac.id")) {
                // Menampilkan notifikasi jika akhiran email salah
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Email harus diakhiri dengan @webmail.umm.ac.id");
                alert.showAndWait();
                return;  // Menghentikan eksekusi lebih lanjut jika akhiran email salah
            }

            // Menambahkan data baru ke dalam ObservableList
            data.add(new Mahasiswa(name, nim, email, fakultas, jurusan, alamat, kota));

            // Mengosongkan nilai input setelah menambahkan data
            addName.clear();
            addNim.clear();
            addEmail.clear();
            addFakultas.clear();
            addJurusan.clear();
            addAlamat.clear();
            addKota.clear();
        });

        // Mengatur layout horizontal untuk TextField dan Button
        final HBox hboxInput = new HBox();
        hboxInput.getChildren().addAll(addName, addNim, addEmail, addFakultas, addJurusan, addAlamat, addKota, addButton);
        hboxInput.setSpacing(10);

        // Menambahkan HBox input ke dalam VBox sebelumnya
        vbox.getChildren().addAll(hboxInput);

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

    public class Mahasiswa {
        private final StringProperty name = new SimpleStringProperty();
        private final StringProperty nim = new SimpleStringProperty();
        private final StringProperty email = new SimpleStringProperty();
        private final StringProperty fakultas = new SimpleStringProperty();
        private final StringProperty jurusan = new SimpleStringProperty();
        private final StringProperty alamat = new SimpleStringProperty();
        private final StringProperty kota = new SimpleStringProperty();

        public Mahasiswa(String name, String nim, String email, String fakultas, String jurusan, String alamat, String kota) {
            setName(name);
            setNim(nim);
            setEmail(email);
            setFakultas(fakultas);
            setJurusan(jurusan);
            setAlamat(alamat);
            setKota(kota);

        }

        public StringProperty nameProperty() {
            return name;
        }

        public String getName() {
            return name.get();
        }

        public void setName(String newName) {
            name.set(newName);
        }

        public StringProperty nimProperty() {
            return nim;
        }

        public String getNim() {
            return nim.get();
        }

        public void setNim(String newNim) {
            nim.set(newNim);
        }

        public StringProperty emailProperty() {
            return email;
        }

        public String getEmail() {
            return email.get();
        }

        public void setEmail(String newEmail) {
            email.set(newEmail);
        }

        public String getFakultas(){
            return fakultas.get();
        }

        public void setFakultas(String newFakultas) {
            fakultas.set(newFakultas);
        }

        public String getJurusan() {
            return jurusan.get();
        }

        public void setJurusan(String newJurusan) {
            jurusan.set(newJurusan);
        }

        public String getAlamat() {
            return alamat.get();
        }

        public void setAlamat(String newAlamat) {
            alamat.set(newAlamat);
        }

        public String getKota() {
            return  kota.get();
        }

        public void setKota(String newKota) {
            kota.set(newKota);
        }
    }

}
