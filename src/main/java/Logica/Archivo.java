
package Logica;

import java.util.*;
import java.io.*;

public class Archivo {

    private List<Registro> listaRegistro;

    private String rutaArchivo = "C:/Users/Zaval/IdeaProjects/Practica6_AyED/Practica6/src/main/resources/com/example/practica6/registros.csv";

    public Archivo() {
        listaRegistro = new ArrayList<>();
    }

    public List<Registro> getListaRegistro() {
        return listaRegistro;
    }

    public void cargarArchivo() {
        try (BufferedReader bf = new BufferedReader(new FileReader(rutaArchivo))) {

            String linea;
            bf.readLine();

            while ((linea = bf.readLine()) != null) {

                if (linea.trim().isEmpty()) {
                    continue;
                }

                String datosArchivo[] = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (datosArchivo.length != 33) {
                    System.out.println("Error en la linea: " + linea);
                    continue;
                }


                Registro registro = new Registro(
                        datosArchivo[0],
                        datosArchivo[1],
                        datosArchivo[2],
                        datosArchivo[3],
                        datosArchivo[4],
                        datosArchivo[5],
                        convertirDouble(datosArchivo[6]),
                        Boolean.parseBoolean(datosArchivo[7]),
                        datosArchivo[8],
                        convertirDouble(datosArchivo[9]),
                        convertirDouble(datosArchivo[10]),
                        convertirDouble(datosArchivo[11]),
                        convertirDouble(datosArchivo[12]),
                        convertirDouble(datosArchivo[13]),
                        convertirDouble(datosArchivo[14]),
                        convertirDouble(datosArchivo[15]),
                        convertirDouble(datosArchivo[16]),
                        convertirDouble(datosArchivo[17]),
                        convertirDouble(datosArchivo[18]),
                        convertirDouble(datosArchivo[19]),
                        convertirDouble(datosArchivo[20]),
                        convertirDouble(datosArchivo[21]),
                        convertirDouble(datosArchivo[22]),
                        datosArchivo[23],
                        datosArchivo[24],
                        datosArchivo[25],
                        datosArchivo[26],
                        datosArchivo[27],
                        datosArchivo[28],
                        datosArchivo[29],
                        datosArchivo[30],
                        datosArchivo[31],
                        convertirDouble(datosArchivo[32])
                );
                listaRegistro.add(registro);
            }

        } catch (IOException e) {
            System.out.println("Error al cargar el archivo: " + e.getMessage());
        }
    }

    private double convertirDouble(String dato) {
        if (dato == null || dato.trim().isEmpty()) {
            return 0.0;
        }

        return Double.parseDouble(dato.trim());
    }
}
