public class Vehiculo {
    private String placa;
    private String tipo;
    private String marca;
    private String modelo;
    private int annio;

    public Vehiculo(String pPlaca, String pTipo, String pMarca, String pModelo, int pAnnio) {
        placa = pPlaca; tipo = pTipo; marca = pMarca; modelo = pModelo; annio = pAnnio;
    }
    public String getTipo() { return tipo; }
    public String toString() {
        return "Placa= " + placa + "\n" + "Tipo= " + tipo + "\n" +
               "Marca= " + marca + "\n" + "Modelo= " + modelo + "\n" + "Año= " + annio;
    }
}