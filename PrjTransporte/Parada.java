/**
 * Parada de autobús. Existe de forma independiente de las rutas.
 */
public class Parada {
    private String codigo;
    private String nombre;

    public Parada(String pCodigo, String pNombre) {
        codigo = pCodigo;
        nombre = pNombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString() {
        return "Parada | Código: " + codigo + " | Nombre: " + nombre;
    }
}
