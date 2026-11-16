package Logica;
import java.util.*;
import java.io.*;

public class Archivo {
    private ArrayList<Registro> listaRegistro;
    private String rutaArchivo ="C:/Users/Zaval/IdeaProjects/Practica6_AyED/Practica6/src/main/resources/com/example/practica6/registros.csv";
    public Archivo(){
        listaRegistro=new ArrayList<>();
    }

    public ArrayList<Registro> getListaRegistro(){return listaRegistro;}

    public void Archivo(){

        try(BufferedReader bf=new BufferedReader(new FileReader(rutaArchivo))){
            String linea;
            bf.readLine();
            while((linea=bf.readLine())!=null){
                if(linea.trim().isEmpty()){
                    continue;
                }
                String datosArchivo[] = linea.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if(datosArchivo.length != 10){
                    System.out.println("Error en la línea: " + linea);
                    continue;
                }

             Registro registro=new Registro(datosArchivo[0],
                     datosArchivo[1],
                     datosArchivo[2],
                     datosArchivo[3],
                     datosArchivo[4],
                     datosArchivo[5],
                     Double.parseDouble(datosArchivo[6]),
                     Boolean.parseBoolean(datosArchivo[7]),
                     datosArchivo[8],
                     Double.parseDouble(datosArchivo[9]));
               listaRegistro.add(registro);
            }

        }catch(IOException e){
            System.out.println("Error al cargar el archivo");

        }
    }

    public void mostrarRegistros() {

        for (Registro registro : listaRegistro) {
            System.out.println("ID Canción: " + registro.getId_Cancion());
            System.out.println("Artista: " + registro.getArtista());
            System.out.println("Canción: " + registro.getCancion());
            System.out.println("Géneros: " + registro.getGenero());
            System.out.println("ID track"+ registro.getId_Track());
            System.out.println("Track URL" + registro.getTrack_URL());
            System.out.println("Track duracion" + registro.getTrack_Duracion());
            System.out.println("Track Explicito" + registro.isTrack_Explicito());
            System.out.println("Track album"+registro.getTrack_Album());
            System.out.println("Danzabilidad"+registro.getDanzabilidad());


            System.out.println("--------------------------------");
        }
    }
}
