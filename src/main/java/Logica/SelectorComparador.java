
package Logica;

import java.util.Comparator;

public class SelectorComparador {

    public static Comparator<Registro> obtenerComparador(String columna, boolean ascendente) {

        Comparator<Registro> comp;

        switch (columna) {

            case "ID Cancion": comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getId_Cancion(), r2.getId_Cancion());
                    }
                };
                break;

            case "Artista":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getArtista(), r2.getArtista());
                    }
                };
                break;

            case "Cancion":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getCancion(), r2.getCancion());
                    }
                };
                break;

            case "Genero":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getGenero(), r2.getGenero());
                    }
                };
                break;

            case "ID Track":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getId_Track(), r2.getId_Track());
                    }
                };
                break;

            case "Track URL":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getTrack_URL(), r2.getTrack_URL());
                    }
                };
                break;

            case "Duracion":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getTrack_Duracion(), r2.getTrack_Duracion());
                    }
                };
                break;

            case "Explicito":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Boolean.compare(r1.isTrack_Explicito(), r2.isTrack_Explicito());
                    }
                };
                break;

            case "Album":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getTrack_Album(), r2.getTrack_Album());
                    }
                };
                break;

            case "Danzabilidad":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getDanzabilidad(), r2.getDanzabilidad());
                    }
                };
                break;

            case "Energia":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getEnergia(), r2.getEnergia());
                    }
                };
                break;

            case "Clave":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getClave(), r2.getClave());
                    }
                };
                break;

            case "Volumen":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getVolumen(), r2.getVolumen());
                    }
                };
                break;

            case "Modo":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getModo(), r2.getModo());
                    }
                };
                break;

            case "Speechiness":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getSpeechiness(), r2.getSpeechiness());
                    }
                };
                break;

            case "Acustico":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getAcustico(), r2.getAcustico());
                    }
                };
                break;

            case "Instrumental":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getInstrumental(), r2.getInstrumental());
                    }
                };
                break;

            case "Vivacidad":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getVivacidad(), r2.getVivacidad());
                    }
                };
                break;

            case "Valence":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getValence(), r2.getValence());
                    }
                };
                break;

            case "Tempo":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getTempo(), r2.getTempo());
                    }
                };
                break;

            case "Compas":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getCompas(), r2.getCompas());
                    }
                };
                break;

            case "Popularidad":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getTrack_Popularidad(), r2.getTrack_Popularidad());
                    }
                };
                break;

            case "Posicion Peak":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getPosicion_Peak(), r2.getPosicion_Peak());
                    }
                };
                break;

            case "Semanas":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getSemanas(), r2.getSemanas());
                    }
                };
                break;

            case "Primera Semana":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getPrimeraSemana(), r2.getPrimeraSemana());
                    }
                };
                break;

            case "Ultima Semana":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getUltimaSemana(), r2.getUltimaSemana());
                    }
                };
                break;

            case "Nivel Exito":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getNivelExitoListas(), r2.getNivelExitoListas());
                    }
                };
                break;

            case "Perfil Longevidad":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getPerfilExitoLongevidad(), r2.getPerfilExitoLongevidad());
                    }
                };
                break;

            case "Ambientes Acusticos":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getConjuntoAmbientesAcusticos(), r2.getConjuntoAmbientesAcusticos());
                    }
                };
                break;

            case "Era Musical":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getEraMusical(), r2.getEraMusical());
                    }
                };
                break;

            case "Intervalo Evidencia":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getIntervaloEvidencia(), r2.getIntervaloEvidencia());
                    }
                };
                break;

            case "COT":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getCOT(), r2.getCOT());
                    }
                };
                break;

            case "Confianza":
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return Double.compare(r1.getPuntuacionConfianza(), r2.getPuntuacionConfianza());
                    }
                };
                break;

            default:
                comp = new Comparator<Registro>() {
                    @Override
                    public int compare(Registro r1, Registro r2) {
                        return compararTexto(r1.getId_Cancion(), r2.getId_Cancion());
                    }
                };
                break;
        }

        if (ascendente == true) {
            return comp;
        } else {
            return comp.reversed();
        }
    }

    private static int compararTexto(String texto1, String texto2) {

        if (texto1 == null && texto2 == null) {
            return 0;
        }

        if (texto1 == null) {
            return 1;
        }

        if (texto2 == null) {
            return -1;
        }

        return texto1.compareToIgnoreCase(texto2);
    }
}
