
package com.example.practica6;

import Logica.Registro;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Tablas {

    private TableView<Registro> tabla;
    private ObservableList<Registro> datosTabla;
    private Consumer<String> clickearColumna;

    public Tablas(List<Registro> registrosIniciales, Consumer<String> clickearColumna) {

        this.clickearColumna = clickearColumna;

        tabla = new TableView<>();
        datosTabla = FXCollections.observableArrayList(registrosIniciales);

        tabla.setItems(datosTabla);

        construirColumnas(registrosIniciales);
    }

    public TableView<Registro> getTabla() {
        return tabla;
    }

    public void actualizarDatos(List<Registro> nuevosDatos) {
        datosTabla.setAll(nuevosDatos);
    }

    private void construirColumnas(List<Registro> datos) {

        agregarTexto("ID Cancion", datos, 1);
        agregarTexto("Artista", datos, 2);
        agregarTexto("Cancion", datos, 3);
        agregarTexto("Genero", datos, 4);
        agregarTexto("ID Track", datos, 5);
        agregarTexto("Track URL", datos, 6);

        agregarNumero("Duracion", datos, 1);
        agregarBooleano("Explicito", datos);

        agregarTexto("Album", datos, 7);

        agregarNumero("Danzabilidad", datos, 2);
        agregarNumero("Energia", datos, 3);
        agregarNumero("Clave", datos, 4);
        agregarNumero("Volumen", datos, 5);
        agregarNumero("Modo", datos, 6);
        agregarNumero("Speechiness", datos, 7);
        agregarNumero("Acustico", datos, 8);
        agregarNumero("Instrumental", datos, 9);
        agregarNumero("Vivacidad", datos, 10);
        agregarNumero("Valence", datos, 11);
        agregarNumero("Tempo", datos, 12);
        agregarNumero("Compas", datos, 13);
        agregarNumero("Popularidad", datos, 14);
        agregarNumero("Posicion Peak", datos, 15);

        agregarTexto("Semanas", datos, 8);
        agregarTexto("Primera Semana", datos, 9);
        agregarTexto("Ultima Semana", datos, 10);
        agregarTexto("Nivel Exito", datos, 11);
        agregarTexto("Perfil Longevidad", datos, 12);
        agregarTexto("Ambientes Acusticos", datos, 13);
        agregarTexto("Era Musical", datos, 14);
        agregarTexto("Intervalo Evidencia", datos, 15);
        agregarTexto("COT", datos, 16);

        agregarNumero("Confianza", datos, 16);
    }

    private void agregarTexto(String titulo, List<Registro> datos, int numero) {

        TableColumn<Registro, String> columna = new TableColumn<>();

        columna.setCellValueFactory(fila -> {

            Registro r = fila.getValue();
            String valor = "";

            switch (numero) {
                case 1: valor = r.getId_Cancion(); break;
                case 2: valor = r.getArtista(); break;
                case 3: valor = r.getCancion(); break;
                case 4: valor = r.getGenero(); break;
                case 5: valor = r.getId_Track(); break;
                case 6: valor = r.getTrack_URL(); break;
                case 7: valor = r.getTrack_Album(); break;
                case 8: valor = r.getSemanas(); break;
                case 9: valor = r.getPrimeraSemana(); break;
                case 10: valor = r.getUltimaSemana(); break;
                case 11: valor = r.getNivelExitoListas(); break;
                case 12: valor = r.getPerfilExitoLongevidad(); break;
                case 13: valor = r.getConjuntoAmbientesAcusticos(); break;
                case 14: valor = r.getEraMusical(); break;
                case 15: valor = r.getIntervaloEvidencia(); break;
                case 16: valor = r.getCOT(); break;
            }

            return new ReadOnlyObjectWrapper<>(valor);
        });

        columna.setPrefWidth(140);
        columna.setSortable(false);

        Set<String> valores = new HashSet<>();

        for (Registro r : datos) {
            String valor = "";

            switch (numero) {
                case 1: valor = r.getId_Cancion(); break;
                case 2: valor = r.getArtista(); break;
                case 3: valor = r.getCancion(); break;
                case 4: valor = r.getGenero(); break;
                case 5: valor = r.getId_Track(); break;
                case 6: valor = r.getTrack_URL(); break;
                case 7: valor = r.getTrack_Album(); break;
                case 8: valor = r.getSemanas(); break;
                case 9: valor = r.getPrimeraSemana(); break;
                case 10: valor = r.getUltimaSemana(); break;
                case 11: valor = r.getNivelExitoListas(); break;
                case 12: valor = r.getPerfilExitoLongevidad(); break;
                case 13: valor = r.getConjuntoAmbientesAcusticos(); break;
                case 14: valor = r.getEraMusical(); break;
                case 15: valor = r.getIntervaloEvidencia(); break;
                case 16: valor = r.getCOT(); break;
            }

            if (valor != null && !valor.isEmpty()) {
                valores.add(valor);
            }
        }

        Label resumen = new Label(valores.size() + "\nvalores unicos");
        resumen.setStyle("-fx-font-size: 10px; -fx-text-fill: #555;");
        resumen.setAlignment(Pos.CENTER);
        columna.setGraphic(crearEncabezado(titulo, resumen));
        tabla.getColumns().add(columna);
    }

    private void agregarNumero(String titulo, List<Registro> datos, int numero) {

        TableColumn<Registro, Double> columna = new TableColumn<>();

        columna.setCellValueFactory(fila -> {

            Registro r = fila.getValue();
            double valor = 0;

            switch (numero) {
                case 1: valor = r.getTrack_Duracion(); break;
                case 2: valor = r.getDanzabilidad(); break;
                case 3: valor = r.getEnergia(); break;
                case 4: valor = r.getClave(); break;
                case 5: valor = r.getVolumen(); break;
                case 6: valor = r.getModo(); break;
                case 7: valor = r.getSpeechiness(); break;
                case 8: valor = r.getAcustico(); break;
                case 9: valor = r.getInstrumental(); break;
                case 10: valor = r.getVivacidad(); break;
                case 11: valor = r.getValence(); break;
                case 12: valor = r.getTempo(); break;
                case 13: valor = r.getCompas(); break;
                case 14: valor = r.getTrack_Popularidad(); break;
                case 15: valor = r.getPosicion_Peak(); break;
                case 16: valor = r.getPuntuacionConfianza(); break;
            }

            return new ReadOnlyObjectWrapper<>(valor);
        });

        columna.setPrefWidth(130);
        columna.setSortable(false);

        Canvas grafica = crearHistograma(datos, numero);

        columna.setGraphic(crearEncabezado(titulo, grafica));

        tabla.getColumns().add(columna);
    }


    private void agregarBooleano(String titulo, List<Registro> datos) {

        TableColumn<Registro, Boolean> columna = new TableColumn<>();

        columna.setCellValueFactory(fila ->
                new ReadOnlyObjectWrapper<>(
                        fila.getValue().isTrack_Explicito()
                )
        );

        columna.setPrefWidth(135);
        columna.setSortable(false);

        int verdaderos = 0;
        for (Registro r : datos) {
            if (r.isTrack_Explicito()) {
                verdaderos++;
            }
        }

        int total = datos.size();
        int porcentajeTrue = (total > 0) ? (verdaderos * 100 / total) : 0;
        int porcentajeFalse = (total > 0) ? (100 - porcentajeTrue) : 0;

        Canvas pastel = crearGraficaPastel(verdaderos, total);

        Label lblTrue = new Label("● True: " + porcentajeTrue + "%");
        lblTrue.setStyle("-fx-font-size: 9.5px; -fx-text-fill: #20BEFF; -fx-font-weight: bold;");

        Label lblFalse = new Label("● False: " + porcentajeFalse + "%");
        lblFalse.setStyle("-fx-font-size: 9.5px; -fx-text-fill: #FF6B6B; -fx-font-weight: bold;");

        VBox etiquetas = new VBox(2, lblTrue, lblFalse);
        etiquetas.setAlignment(Pos.CENTER_LEFT);

        HBox resumen = new HBox(6, pastel, etiquetas);
        resumen.setAlignment(Pos.CENTER);

        columna.setGraphic(crearEncabezado(titulo, resumen));
        tabla.getColumns().add(columna);
    }

    private VBox crearEncabezado(String titulo, javafx.scene.Node resumen) {

        Label etiqueta = new Label(titulo + " ⇅");

        etiqueta.setFont(Font.font("System", FontWeight.BOLD, 12));
        etiqueta.setTextFill(Color.web("#202124"));

        VBox caja = new VBox(4);
        caja.getChildren().addAll(etiqueta, resumen);

        caja.setAlignment(Pos.CENTER);
        caja.setPrefHeight(65);
        caja.setStyle("-fx-cursor: hand; -fx-padding: 4;");

        caja.setOnMouseClicked(e -> {

            if (clickearColumna != null) {
                clickearColumna.accept(titulo);
            }
        });

        return caja;
    }

    private Canvas crearHistograma(List<Registro> datos, int numero) {

        Canvas canvas = new Canvas(100, 32);

        if (datos.isEmpty()) {
            return canvas;
        }

        double minimo = Double.MAX_VALUE;
        double maximo = -Double.MAX_VALUE;

        for (Registro r : datos) {

            double valor = obtenerNumero(r, numero);

            if (valor < minimo) {
                minimo = valor;
            }

            if (valor > maximo) {
                maximo = valor;
            }
        }

        int[] cantidades = new int[10];

        double rango = maximo - minimo;

        if (rango == 0) {
            rango = 1;
        }

        for (Registro r : datos) {

            double valor = obtenerNumero(r, numero);

            int posicion = (int) (((valor - minimo) / rango) * 9);

            if (posicion < 0) {
                posicion = 0;
            }

            if (posicion > 9) {
                posicion = 9;
            }

            cantidades[posicion]++;
        }

        int mayor = 1;

        for (int i = 0; i < 10; i++) {
            if (cantidades[i] > mayor) {
                mayor = cantidades[i];
            }
        }

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.web("#20BEFF"));

        for (int i = 0; i < 10; i++) {

            double alto = (cantidades[i] * 28.0) / mayor;

            if (cantidades[i] > 0 && alto < 2) {
                alto = 2;
            }

            gc.fillRect(i * 10, 30 - alto, 9, alto);
        }

        return canvas;
    }

    private double obtenerNumero(Registro r, int numero) {

        switch (numero) {
            case 1: return r.getTrack_Duracion();
            case 2: return r.getDanzabilidad();
            case 3: return r.getEnergia();
            case 4: return r.getClave();
            case 5: return r.getVolumen();
            case 6: return r.getModo();
            case 7: return r.getSpeechiness();
            case 8: return r.getAcustico();
            case 9: return r.getInstrumental();
            case 10: return r.getVivacidad();
            case 11: return r.getValence();
            case 12: return r.getTempo();
            case 13: return r.getCompas();
            case 14: return r.getTrack_Popularidad();
            case 15: return r.getPosicion_Peak();
            case 16: return r.getPuntuacionConfianza();
        }

        return 0;
    }

    private Canvas crearGraficaPastel(int verdaderos, int total) {
        double diametro = 28;
        Canvas canvas = new Canvas(diametro, diametro);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        if (total == 0) {
            gc.setFill(Color.web("#E0E0E0"));
            gc.fillOval(0, 0, diametro, diametro);
            return canvas;
        }

        double anguloTrue = (verdaderos * 360.0) / total;
        double anguloFalse = 360.0 - anguloTrue;

        gc.setFill(Color.web("#20BEFF"));
        gc.fillArc(0, 0, diametro, diametro, 90, -anguloTrue, ArcType.ROUND);

        gc.setFill(Color.web("#FF6B6B"));
        gc.fillArc(0, 0, diametro, diametro, 90 - anguloTrue, -anguloFalse, ArcType.ROUND);

        return canvas;
    }
}
