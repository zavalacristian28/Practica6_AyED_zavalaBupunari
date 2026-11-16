module com.example.practica6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.practica6 to javafx.fxml;
    exports com.example.practica6;
}