package com.modul6.latihan2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mahasiswa {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty nim = new SimpleStringProperty();
    private final StringProperty email = new SimpleStringProperty();

    public Mahasiswa(String name, String nim, String email) {
        setName(name);
        setNim(nim);
        setEmail(email);
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
}
