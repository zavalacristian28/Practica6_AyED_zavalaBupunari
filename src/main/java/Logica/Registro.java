
package Logica;

public class Registro {

    private  String intervaloEvidencia;
    private String id_Cancion;
    private String artista;
    private String cancion;
    private String genero;
    private String id_Track;
    private String track_URL;
    private double track_Duracion;
    private boolean track_Explicito;
    private String track_Album;
    private double danzabilidad;
    private double energia;
    private double clave;
    private double volumen;
    private double modo;
    private double speechiness;
    private double acustico;
    private double instrumental;
    private double vivacidad;
    private double valence;
    private double tempo;
    private double compas;
    private double track_Popularidad;
    private double posicion_Peak;
    private String semanas;
    private String primeraSemana;
    private String ultimaSemana;
    private String nivelExitoListas;
    private String perfilExitoLongevidad;
    private String conjuntoAmbientesAcusticos;
    private String eraMusical;
    private String COT;
    private double puntuacionConfianza;

    public Registro(String id_Cancion, String artista, String cancion,
                    String genero, String id_Track, String track_URL,
                    double track_Duracion, boolean track_Explicito,
                    String track_Album, double danzabilidad,
                    double energia, double clave, double volumen,
                    double modo, double speechiness, double acustico,
                    double instrumental, double vivacidad, double valence,
                    double tempo, double compas, double track_Popularidad,
                    double posicion_Peak, String semanas,
                    String primeraSemana, String ultimaSemana,
                    String nivelExitoListas,
                    String perfilExitoLongevidad,
                    String conjuntoAmbientesAcusticos,
                    String eraMusical,
                    String intervaloEvidencia,
                    String COT,
                    double puntuacionConfianza) {

        this.id_Cancion = id_Cancion;
        this.artista = artista;
        this.cancion = cancion;
        this.genero = genero;
        this.id_Track = id_Track;
        this.track_URL = track_URL;
        this.track_Duracion = track_Duracion;
        this.track_Explicito = track_Explicito;
        this.track_Album = track_Album;
        this.danzabilidad = danzabilidad;
        this.energia = energia;
        this.clave = clave;
        this.volumen = volumen;
        this.modo = modo;
        this.speechiness = speechiness;
        this.acustico = acustico;
        this.instrumental = instrumental;
        this.vivacidad = vivacidad;
        this.valence = valence;
        this.tempo = tempo;
        this.compas = compas;
        this.track_Popularidad = track_Popularidad;
        this.posicion_Peak = posicion_Peak;
        this.semanas = semanas;
        this.primeraSemana = primeraSemana;
        this.ultimaSemana = ultimaSemana;
        this.nivelExitoListas = nivelExitoListas;
        this.perfilExitoLongevidad = perfilExitoLongevidad;
        this.conjuntoAmbientesAcusticos = conjuntoAmbientesAcusticos;
        this.eraMusical = eraMusical;
        this.intervaloEvidencia = intervaloEvidencia;
        this.COT = COT;
        this.puntuacionConfianza = puntuacionConfianza;
    }

    // Getters

    public String getId_Cancion() {
        return id_Cancion;
    }

    public String getArtista() {
        return artista;
    }

    public String getCancion() {
        return cancion;
    }

    public String getGenero() {
        return genero;
    }

    public String getId_Track() {
        return id_Track;
    }

    public String getTrack_URL() {
        return track_URL;
    }

    public double getTrack_Duracion() {
        return track_Duracion;
    }

    public boolean isTrack_Explicito() {
        return track_Explicito;
    }

    public String getTrack_Album() {
        return track_Album;
    }

    public double getDanzabilidad() {
        return danzabilidad;
    }

    public double getEnergia() {
        return energia;
    }

    public double getClave() {
        return clave;
    }

    public double getVolumen() {
        return volumen;
    }

    public double getModo() {
        return modo;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public double getAcustico() {
        return acustico;
    }

    public double getInstrumental() {
        return instrumental;
    }

    public double getVivacidad() {
        return vivacidad;
    }

    public double getValence() {
        return valence;
    }

    public double getTempo() {
        return tempo;
    }

    public double getCompas() {
        return compas;
    }

    public double getTrack_Popularidad() {
        return track_Popularidad;
    }

    public double getPosicion_Peak() {
        return posicion_Peak;
    }

    public String getSemanas() {
        return semanas;
    }

    public String getPrimeraSemana() {
        return primeraSemana;
    }

    public String getUltimaSemana() {
        return ultimaSemana;
    }

    public String getNivelExitoListas() {
        return nivelExitoListas;
    }

    public String getPerfilExitoLongevidad() {
        return perfilExitoLongevidad;
    }

    public String getConjuntoAmbientesAcusticos() {
        return conjuntoAmbientesAcusticos;
    }

    public String getEraMusical() {
        return eraMusical;
    }

    public String getIntervaloEvidencia() {
        return intervaloEvidencia;
    }

    public String getCOT() {
        return COT;
    }
    public double getPuntuacionConfianza() {
        return puntuacionConfianza;
    }
}
