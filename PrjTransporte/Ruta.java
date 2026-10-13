import java.util.ArrayList;

/**
 * Ruta de autobús: tiene un recorrido de paradas (agregación)
 * y sus horarios de salida (composición).
 */
public class Ruta {
    public static final int HORA_MINIMA = 0;
    public static final int HORA_MAXIMA = 23;
    public static final int MINUTO_MINIMO = 0;
    public static final int MINUTO_MAXIMO = 59;
    public static final int MINUTO_POR_OMISION = 0;
    private static final String SEPARADOR = ", ";
    private static final String FORMATO_MONTO = "%.0f";

    private String codigo;
    private String nombre;
    private double tarifa;
    private ArrayList<Parada> misParadas;
    private ArrayList<HorarioSalida> misHorarios;

    public Ruta(String pCodigo, String pNombre, double pTarifa) {
        codigo = pCodigo;
        nombre = pNombre;
        tarifa = pTarifa;
        misParadas = new ArrayList<>();
        misHorarios = new ArrayList<>();
    }

    /** Agrega una parada al recorrido; si ya forma parte de él, se ignora. */
    public void agregarParada(Parada pParada) {
        if (pParada != null && !existeParada(pParada)) {
            misParadas.add(pParada);
        }
    }

    /** Registra un horario de salida; si está fuera de rango, no se registra. */
    public void registrarSalida(int pHora, int pMinuto) {
        if (esHorarioValido(pHora, pMinuto)) {
            misHorarios.add(new HorarioSalida(pHora, pMinuto));
        }
    }

    /** Registra una salida en punto (minuto = 0). */
    public void registrarSalida(int pHora) {
        registrarSalida(pHora, MINUTO_POR_OMISION);
    }

    public String consultarNombresParadas() {
        String msg = "";
        for (int i = 0; i < misParadas.size(); i++) {
            if (i > 0) {
                msg += SEPARADOR;
            }
            msg += misParadas.get(i).getNombre();
        }
        return msg;
    }

    public String consultarHorariosSalida() {
        String msg = "";
        for (int i = 0; i < misHorarios.size(); i++) {
            if (i > 0) {
                msg += SEPARADOR;
            }
            msg += misHorarios.get(i).toString();
        }
        return msg;
    }

    public int consultarCantidadHorarios() {
        return misHorarios.size();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getTarifa() {
        return tarifa;
    }

    private boolean existeParada(Parada pParada) {
        for (Parada p : misParadas) {
            if (p.getCodigo().equals(pParada.getCodigo())) {
                return true;
            }
        }
        return false;
    }

    private boolean esHorarioValido(int pHora, int pMinuto) {
        return pHora >= HORA_MINIMA && pHora <= HORA_MAXIMA
                && pMinuto >= MINUTO_MINIMO && pMinuto <= MINUTO_MAXIMO;
    }

    public String toString() {
        String msg = "Ruta | Código: " + codigo + "\n";
        msg += "  Nombre: " + nombre + "\n";
        msg += "  Tarifa: ₡" + String.format(FORMATO_MONTO, tarifa) + "\n";
        msg += "  Paradas: " + consultarNombresParadas() + "\n";
        msg += "  Horarios registrados: " + misHorarios.size() + "\n";
        msg += "  Salidas: " + consultarHorariosSalida();
        return msg;
    }
}
