package com.example.practica6;

import Logica.Archivo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Fondo fondo=new Fondo();
        Scene scene = new Scene(fondo.getPanel(), 820, 840);
        stage.setTitle("Comparaciones");
        stage.setScene(scene);
        stage.show();
        Archivo archivo=new Archivo();
        archivo.Archivo();
        //archivo.mostrarRegistros();
    }
}
