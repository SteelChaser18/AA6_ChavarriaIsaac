/**
 * Horario de salida de una ruta desde su primera parada.
 * Solo tiene sentido dentro de la Ruta que lo crea.
 */
public class HorarioSalida {
    private static final String FORMATO_HORARIO = "%02d:%02d";

    private int hora;
    private int minuto;

    public HorarioSalida(int pHora, int pMinuto) {
        hora = pHora;
        minuto = pMinuto;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public String toString() {
        return String.format(FORMATO_HORARIO, hora, minuto);
    }
}
