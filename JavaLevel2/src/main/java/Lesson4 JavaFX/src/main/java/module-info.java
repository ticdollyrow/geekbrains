module com.example.lesson4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lesson4 to javafx.fxml;
    exports com.example.lesson4;
}