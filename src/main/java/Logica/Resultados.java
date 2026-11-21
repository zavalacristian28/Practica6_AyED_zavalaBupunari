package Logica;

import java.util.List;

public class Resultados {
    private String metodo;
    private double tiempoMs;
    private List<Registro> datosOrdenados;

    public Resultados(String metodo, double tiempoMs, List<Registro> datosOrdenados) {
        this.metodo = metodo;
        this.tiempoMs = tiempoMs;
        this.datosOrdenados = datosOrdenados;
    }

    public String getMetodo() {
        return metodo;
    }

    public double getTiempoMs() {
        return tiempoMs;
    }

    public List<Registro> getDatosOrdenados() {
        return datosOrdenados;
    }
}