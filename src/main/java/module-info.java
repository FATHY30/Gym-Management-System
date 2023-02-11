module com.example.finalgym {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.example.finalgym to javafx.fxml;
    exports com.example.finalgym;
    exports Controllers;
    opens Controllers to javafx.fxml;
}