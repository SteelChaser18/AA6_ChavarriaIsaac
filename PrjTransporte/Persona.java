/**
 * Persona pasajera. Su condición determina el descuento del pasaje.
 */
public class Persona {
    public static final String CONDICION_REGULAR = "regular";
    public static final String CONDICION_ESTUDIANTE = "estudiante";
    public static final String CONDICION_ORO = "ciudadano de oro";

    private String nombre;
    private String condicion;

    public Persona(String pNombre, String pCondicion) {
        nombre = pNombre;
        condicion = normalizarCondicion(pCondicion);
    }

    public Persona(String pNombre) {
        this(pNombre, CONDICION_REGULAR);
    }

    public String getNombre() {
        return nombre;
    }

    public String getCondicion() {
        return condicion;
    }

    /** Si la condición no es reconocida, la persona queda como regular. */
    private String normalizarCondicion(String pCondicion) {
        if (pCondicion == null) {
            return CONDICION_REGULAR;
        }
        String c = pCondicion.trim().toLowerCase();
        if (c.equals(CONDICION_ESTUDIANTE) || c.equals(CONDICION_ORO)) {
            return c;
        }
        return CONDICION_REGULAR;
    }

    public String toString() {
        return "Persona | Nombre: " + nombre + " | Condición: " + condicion;
    }
}
