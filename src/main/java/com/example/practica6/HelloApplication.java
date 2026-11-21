package com.example.practica6;

import Logica.Archivo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {
        Archivo archivo = new Archivo();
        archivo.cargarArchivo();

        Fondo fondo = new Fondo(archivo.getListaRegistro());
        Scene scene = new Scene(fondo.getPanel(), 1200, 820);
        stage.setTitle("Billboard Hot 100 - Analisis y Rendimiento de Ordenamientos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}