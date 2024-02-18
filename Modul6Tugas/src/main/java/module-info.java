module com.modul6.latihan {
    requires javafx.controls;
    requires javafx.fxml;


    exports com.modul6.latihan1;
    opens com.modul6.latihan1 to javafx.fxml;

    exports com.modul6.latihan2;
    opens com.modul6.latihan2 to javafx.fxml;

    exports com.modul6.Tugas1;
    opens com.modul6.Tugas1 to javafx.fxml;

    exports com.modul6.Tugas2;
    opens com.modul6.Tugas2 to javafx.fxml;
}
