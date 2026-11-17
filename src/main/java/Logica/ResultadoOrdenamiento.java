package Logica;

import java.util.List;

public class ResultadoOrdenamiento {
    private final String metodo;
    private final double tiempoMs;
    private final List<Registro> datosOrdenados;

    public ResultadoOrdenamiento(String metodo, double tiempoMs, List<Registro> datosOrdenados) {
        this.metodo = metodo;
        this.tiempoMs = tiempoMs;
        this.datosOrdenados = datosOrdenados;
    }

    public String metodo() { return metodo; }
    public double tiempoMs() { return tiempoMs; }
    public List<Registro> datosOrdenados() { return datosOrdenados; }
}