
package Logica;

import java.util.*;
import java.io.*;

public class Archivo {

    private ArrayList<Registro> listaRegistro;

    private String rutaArchivo = "C:/Users/Zaval/IdeaProjects/Practica6_AyED/Practica6/src/main/resources/com/example/practica6/registros.csv";

    public Archivo() {
        listaRegistro = new ArrayList<>();
    }

    public ArrayList<Registro> getListaRegistro() {
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
                    System.out.println("Error en la línea: " + linea);
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

    public void mostrarRegistros() {

        for (Registro registro : listaRegistro) {

            System.out.println("ID Canción: " + registro.getId_Cancion());
            System.out.println("Artista: " + registro.getArtista());
            System.out.println("Canción: " + registro.getCancion());
            System.out.println("Géneros: " + registro.getGenero());
            System.out.println("ID Track: " + registro.getId_Track());
            System.out.println("Track URL: " + registro.getTrack_URL());
            System.out.println("Track duración: " + registro.getTrack_Duracion());
            System.out.println("Track Explícito: " + registro.isTrack_Explicito());
            System.out.println("Track álbum: " + registro.getTrack_Album());
            System.out.println("Danzabilidad: " + registro.getDanzabilidad());
            System.out.println("Energía: " + registro.getEnergia());
            System.out.println("Clave: " + registro.getClave());
            System.out.println("Volumen: " + registro.getVolumen());
            System.out.println("Modo: " + registro.getModo());
            System.out.println("Speechiness: " + registro.getSpeechiness());
            System.out.println("Acústico: " + registro.getAcustico());
            System.out.println("Instrumental: " + registro.getInstrumental());
            System.out.println("Vivacidad: " + registro.getVivacidad());
            System.out.println("Valence: " + registro.getValence());
            System.out.println("Tempo: " + registro.getTempo());
            System.out.println("Compás: " + registro.getCompas());
            System.out.println("Popularidad: " + registro.getTrack_Popularidad());
            System.out.println("Posición Peak: " + registro.getPosicion_Peak());
            System.out.println("Semanas: " + registro.getSemanas());
            System.out.println("Primera semana: " + registro.getPrimeraSemana());
            System.out.println("Última semana: " + registro.getUltimaSemana());
            System.out.println("Nivel éxito listas: " + registro.getNivelExitoListas());
            System.out.println("Perfil éxito longevidad: " + registro.getPerfilExitoLongevidad());
            System.out.println("Conjunto ambientes acústicos: " + registro.getConjuntoAmbientesAcusticos());
            System.out.println("Era musical: " + registro.getEraMusical());
            System.out.println("Intervalo evidencia: " + registro.getIntervaloEvidencia());
            System.out.println("COT: " + registro.getCOT());
            System.out.println("Puntuación confianza: " + registro.getPuntuacionConfianza());

            System.out.println("--------------------------------");
        }
    }

    private double convertirDouble(String dato) {
        if (dato == null || dato.trim().isEmpty()) {
            return 0.0;
        }

        return Double.parseDouble(dato.trim());
    }
}
