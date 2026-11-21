package com.example.practica6;

import Logica.AlgoritmosOrdenamiento;
import Logica.Registro;
import Logica.Resultados;
import Logica.SelectorComparador;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fondo {

    private BorderPane panel;
    private List<Registro> listaOriginal;
    private Tablas vistaTabla;

    private ComboBox<String> comboMetodo;
    private RadioButton rbAsc;
    private RadioButton rbDesc;
    private Label lblEstado;
    private Label lblTiempos;
    private BarChart<String, Number> graficaRendimiento;

    public Fondo(List<Registro> listaOriginal) {
        this.listaOriginal = listaOriginal;
        this.panel = new BorderPane();
        this.panel.setPadding(new Insets(10));

        construirPanelSuperior();
        construirTablaCentral();
        construirGraficaInferior();
    }

    public Pane getPanel() {
        return panel;
    }

    private void construirPanelSuperior() {
        Label lblMetodo = new Label("Metodo de ordenamiento:");
        comboMetodo = new ComboBox<>();
        comboMetodo.getItems().addAll("Todos", "Insercion", "Seleccion", "Shell", "QuickSort", "MergeSort", "ParallelSort", "ArrayList.sort");
        comboMetodo.setValue("Todos");

        ToggleGroup grupoDireccion = new ToggleGroup();
        rbAsc = new RadioButton("Ascendente");
        rbAsc.setToggleGroup(grupoDireccion);
        rbAsc.setSelected(true);

        rbDesc = new RadioButton("Descendente");
        rbDesc.setToggleGroup(grupoDireccion);

        Button btnOriginal = new Button("Orden Original CSV");
        btnOriginal.setOnAction(e -> {
            vistaTabla.actualizarDatos(listaOriginal);
            graficaRendimiento.getData().clear();
            lblTiempos.setText("");
            lblEstado.setText("Mostrando orden original (" + listaOriginal.size() + " registros). Haz clic en el encabezado de cualquier columna para ordenar.");
        });

        lblEstado = new Label("Cargados " + listaOriginal.size() + " registros. Haz clic en una columna para ordenar.");
        lblEstado.setStyle("-fx-font-weight: bold; -fx-text-fill: #1a73e8;");

        HBox filaControles = new HBox(12, lblMetodo, comboMetodo, rbAsc, rbDesc, btnOriginal);
        filaControles.setAlignment(Pos.CENTER_LEFT);

        VBox contenedorSuperior = new VBox(8, filaControles, lblEstado);
        contenedorSuperior.setPadding(new Insets(0, 0, 10, 0));
        panel.setTop(contenedorSuperior);
    }

    private void construirTablaCentral() {
        vistaTabla = new Tablas(listaOriginal, this::ordenarPorColumna);
        panel.setCenter(vistaTabla.getTabla());
    }

    private void construirGraficaInferior() {
        CategoryAxis ejeX = new CategoryAxis();
        ejeX.setLabel("Algoritmo de Ordenamiento");

        NumberAxis ejeY = new NumberAxis();
        ejeY.setLabel("Tiempo (ms)");

        graficaRendimiento = new BarChart<>(ejeX, ejeY);
        graficaRendimiento.setTitle("Rendimiento de Ordenamiento");
        graficaRendimiento.setPrefHeight(230);
        graficaRendimiento.setLegendVisible(false);
        graficaRendimiento.setAnimated(false);

        lblTiempos = new Label("");
        lblTiempos.setStyle("-fx-font-weight: bold; -fx-font-size: 12px;");
        lblTiempos.setWrapText(true);

        VBox contenedorInferior = new VBox(5, lblTiempos, graficaRendimiento);
        contenedorInferior.setAlignment(Pos.CENTER);
        panel.setBottom(contenedorInferior);
    }

    private void ordenarPorColumna(String nombreColumna) {
        String metodoElegido = comboMetodo.getValue();
        boolean esAscendente = rbAsc.isSelected();
        String direccionTexto = esAscendente ? "Ascendente" : "Descendente";

        lblEstado.setText("Ordenando por '" + nombreColumna + "' (" + direccionTexto + ") usando " + metodoElegido + "...");
        //se utiliza un nuevo hilo para evitar saturacion de la interfaz o que se congele
        new Thread(() -> {
            Comparator<Registro> comparador = SelectorComparador.obtenerComparador(nombreColumna, esAscendente);

            if ("Todos".equals(metodoElegido)) {
                List<Resultados> resultados = AlgoritmosOrdenamiento.medirTodos(listaOriginal, comparador);
                List<String> listaTiempos = new ArrayList<>();
                for (Resultados r : resultados) {
                    listaTiempos.add(String.format("%s: %.2f ms", r.getMetodo(), r.getTiempoMs()));
                }

                //el metodo runLater permite actualizar en el hilo principal en cuanto se pueda
                Platform.runLater(() -> {
                    vistaTabla.actualizarDatos(resultados.get(resultados.size() - 1).getDatosOrdenados());
                    actualizarGrafica(resultados, nombreColumna, direccionTexto, listaTiempos);
                    lblEstado.setText("Ordenado por '" + nombreColumna + "' (" + direccionTexto + ") - Comparativa completa.");
                });
            } else {
                Resultados res = AlgoritmosOrdenamiento.medirTiempo(metodoElegido, listaOriginal, comparador);
                List<String> listaTiempos = List.of(String.format("%s: %.2f ms", res.getMetodo(), res.getTiempoMs()));

                Platform.runLater(() -> {
                    vistaTabla.actualizarDatos(res.getDatosOrdenados());
                    actualizarGrafica(List.of(res), nombreColumna, direccionTexto, listaTiempos);
                    lblEstado.setText(String.format("Ordenado por '%s' (%s) con %s en %.2f ms",
                            nombreColumna, direccionTexto, metodoElegido, res.getTiempoMs()));
                });
            }
        }).start();
    }

    private void actualizarGrafica(List<Resultados> resultados, String columna, String direccion, List<String> tiempos) {
        graficaRendimiento.getData().clear();
        graficaRendimiento.setTitle("Tiempos ordenando por: " + columna + " (" + direccion + ")");
        lblTiempos.setText("Tiempos: " + String.join("   |   ", tiempos));

        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        for (Resultados r : resultados) {
            serie.getData().add(new XYChart.Data<>(r.getMetodo(), r.getTiempoMs()));
        }
        graficaRendimiento.getData().add(serie);
    }
}