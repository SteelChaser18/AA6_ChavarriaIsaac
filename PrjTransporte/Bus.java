/**
 * Bus que cubre una ruta y cobra el pasaje a las personas pasajeras.
 */
public class Bus {
    public static final String PREFIJO_CODIGO = "BUS-";
    public static final String TEXTO_SIN_RUTA = "(sin ruta asignada)";
    public static final double DESCUENTO_REGULAR = 0.0;
    public static final double DESCUENTO_ESTUDIANTE = 0.5;
    public static final double DESCUENTO_ORO = 1.0;
    private static final String FORMATO_MONTO = "%.0f";
    private static int cantidadBuses;

    private String codigo;
    private String placa;
    private int capacidad;
    private Ruta miRuta;
    private double totalRecaudado;
    private int personasAtendidas;

    public Bus(String pPlaca, int pCapacidad) {
        cantidadBuses++;
        codigo = PREFIJO_CODIGO + cantidadBuses;
        placa = pPlaca;
        capacidad = pCapacidad;
    }

    public void asignarRuta(Ruta pRuta) {
        miRuta = pRuta;
    }

    public String consultarNombreRuta() {
        return (miRuta == null) ? TEXTO_SIN_RUTA : miRuta.getNombre();
    }

    /** Cobra el pasaje según la ruta asignada y la condición de la persona. */
    public void cobrarPasaje(Persona pPersona) {
        if (miRuta == null || pPersona == null) {
            return;
        }
        totalRecaudado += miRuta.getTarifa() * (1 - obtenerDescuento(pPersona));
        personasAtendidas++;
    }

    private double obtenerDescuento(Persona pPersona) {
        switch (pPersona.getCondicion()) {
            case Persona.CONDICION_ESTUDIANTE:
                return DESCUENTO_ESTUDIANTE;
            case Persona.CONDICION_ORO:
                return DESCUENTO_ORO;
            default:
                return DESCUENTO_REGULAR;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getPersonasAtendidas() {
        return personasAtendidas;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public static int getCantidadBuses() {
        return cantidadBuses;
    }

    public String toString() {
        String msg = "Bus | Código: " + codigo + "\n";
        msg += "  Placa: " + placa + "\n";
        msg += "  Capacidad: " + capacidad + "\n";
        msg += "  Ruta: " + consultarNombreRuta() + "\n";
        msg += "  Personas atendidas: " + personasAtendidas + "\n";
        msg += "  Total recaudado: ₡" + String.format(FORMATO_MONTO, totalRecaudado);
        return msg;
    }
}
