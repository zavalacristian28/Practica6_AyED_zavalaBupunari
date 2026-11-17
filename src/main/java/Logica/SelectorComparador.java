package Logica;

import java.util.Comparator;

public class SelectorComparador {

    public static Comparator<Registro> obtenerComparador(String columna, boolean ascendente) {
        Comparator<Registro> comp = switch (columna) {
            case "ID Canción" -> Comparator.comparing(Registro::getId_Cancion, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Artista" -> Comparator.comparing(Registro::getArtista, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Canción" -> Comparator.comparing(Registro::getCancion, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Género" -> Comparator.comparing(Registro::getGenero, Comparator.nullsLast(String::compareToIgnoreCase));
            case "ID Track" -> Comparator.comparing(Registro::getId_Track, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Track URL" -> Comparator.comparing(Registro::getTrack_URL, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Duración" -> Comparator.comparingDouble(Registro::getTrack_Duracion);
            case "Explícito" -> Comparator.comparing(Registro::isTrack_Explicito);
            case "Álbum" -> Comparator.comparing(Registro::getTrack_Album, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Danzabilidad" -> Comparator.comparingDouble(Registro::getDanzabilidad);
            case "Energía" -> Comparator.comparingDouble(Registro::getEnergia);
            case "Clave" -> Comparator.comparingDouble(Registro::getClave);
            case "Volumen" -> Comparator.comparingDouble(Registro::getVolumen);
            case "Modo" -> Comparator.comparingDouble(Registro::getModo);
            case "Speechiness" -> Comparator.comparingDouble(Registro::getSpeechiness);
            case "Acústico" -> Comparator.comparingDouble(Registro::getAcustico);
            case "Instrumental" -> Comparator.comparingDouble(Registro::getInstrumental);
            case "Vivacidad" -> Comparator.comparingDouble(Registro::getVivacidad);
            case "Valence" -> Comparator.comparingDouble(Registro::getValence);
            case "Tempo" -> Comparator.comparingDouble(Registro::getTempo);
            case "Compás" -> Comparator.comparingDouble(Registro::getCompas);
            case "Popularidad" -> Comparator.comparingDouble(Registro::getTrack_Popularidad);
            case "Posición Peak" -> Comparator.comparingDouble(Registro::getPosicion_Peak);
            case "Semanas" -> Comparator.comparing(Registro::getSemanas, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Primera Semana" -> Comparator.comparing(Registro::getPrimeraSemana, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Última Semana" -> Comparator.comparing(Registro::getUltimaSemana, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Nivel Éxito" -> Comparator.comparing(Registro::getNivelExitoListas, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Perfil Longevidad" -> Comparator.comparing(Registro::getPerfilExitoLongevidad, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Ambientes Acústicos" -> Comparator.comparing(Registro::getConjuntoAmbientesAcusticos, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Era Musical" -> Comparator.comparing(Registro::getEraMusical, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Intervalo Evidencia" -> Comparator.comparing(Registro::getIntervaloEvidencia, Comparator.nullsLast(String::compareToIgnoreCase));
            case "COT" -> Comparator.comparing(Registro::getCOT, Comparator.nullsLast(String::compareToIgnoreCase));
            case "Confianza" -> Comparator.comparingDouble(Registro::getPuntuacionConfianza);
            default -> Comparator.comparing(Registro::getId_Cancion, Comparator.nullsLast(String::compareToIgnoreCase));
        };

        return ascendente ? comp : comp.reversed();
    }
}