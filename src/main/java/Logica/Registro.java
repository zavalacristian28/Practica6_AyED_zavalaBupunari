package Logica;

public class Registro {

    private String id_Cancion;
    private String artista;
    private String cancion;
    private String genero;
    private String id_Track;
    private String track_URL;
    private double track_Duracion;
    private boolean track_Explicito;
    private  String track_Album;
    private double danzabilidad;

    public Registro(String id_Cancion,String artista,String cancion,String genero,
                    String id_Track,String track_URL, double track_Duracion, boolean track_Explicito,
                    String track_Album,double danzabilidad){
        this.id_Cancion=id_Cancion;
        this.artista=artista;
        this.cancion=cancion;
        this.genero=genero;
        this.id_Track=id_Track;
        this.track_URL=track_URL;
        this.track_Duracion=track_Duracion;
        this.track_Explicito=track_Explicito;
        this.track_Album=track_Album;
        this.danzabilidad=danzabilidad;
    }

    public String getId_Cancion() {
        return id_Cancion;
    }
    public String getArtista(){
        return  artista;
    }
    public String getGenero(){
        return  genero;
    }
    public String getCancion(){
        return  cancion;
    }
    public String getId_Track(){
        return id_Track;
    }
    public String getTrack_URL(){
        return track_URL;
    }
    public double getTrack_Duracion(){
        return track_Duracion;
    }
    public double getDanzabilidad(){
        return danzabilidad;
    }
    public boolean isTrack_Explicito(){
        return track_Explicito;
    }
    public String getTrack_Album(){
        return  track_Album;
    }
}
