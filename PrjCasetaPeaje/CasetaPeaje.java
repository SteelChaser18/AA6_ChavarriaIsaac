public class CasetaPeaje {
    public static final String TIPO_PARTICULAR = "particular";
    public static final String TIPO_CARGA_LIVIANA = "carga liviana";
    public static final String TIPO_CARGA = "carga";
    public static final String TIPO_MOTO = "moto";
    private static final double TARIFA_PARTICULAR = 100;
    private static final double TARIFA_CARGA_LIVIANA = 200;
    private static final double TARIFA_CARGA = 500;
    private static final double TARIFA_MOTO = 75;
    private static final double TARIFA_TIPO_DESCONOCIDO = 0;

    private int numeroCaseta;
    private String nombreAutopista;
    private double totalCobrado;
    private static int cantidadCasetas;

    public CasetaPeaje(String pNombreAutopista) {
        cantidadCasetas++;
        numeroCaseta = cantidadCasetas;
        nombreAutopista = pNombreAutopista;
    }
    /** Cobra el peaje según el tipo del vehículo recibido. */
    public void cobrarPeaje(Vehiculo obj) {
        totalCobrado += obtenerTarifa(obj.getTipo());
    }

    private double obtenerTarifa(String pTipo) {
        switch (pTipo.toLowerCase()) {
            case TIPO_PARTICULAR:
                return TARIFA_PARTICULAR;
            case TIPO_CARGA_LIVIANA:
                return TARIFA_CARGA_LIVIANA;
            case TIPO_CARGA:
                return TARIFA_CARGA;
            case TIPO_MOTO:
                return TARIFA_MOTO;
            default:
                return TARIFA_TIPO_DESCONOCIDO;
        }
    }
    public double getTotalCobrado() { return totalCobrado; }
    public static int getCantidadDeCasetasPeaje() { return cantidadCasetas; }
    public String toString() {
        return "Caseta de Peaje número: " + numeroCaseta + "\n" +
               "Autopista= " + nombreAutopista + "\n" +
               "Total Cobrado= " + totalCobrado + "\n";
    }
}
