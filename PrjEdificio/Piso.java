public class Piso {
    private int numeroPiso;
    private double area;
    private int capacidad;
    private String uso;

    public Piso(int pNumeroPiso, double pArea, int pCapacidad, String pUso) {
        numeroPiso = pNumeroPiso;
        area = pArea;
        capacidad = pCapacidad;
        uso = pUso;
    }
    public int getNumeroPiso() { return numeroPiso; }
    public double getArea() { return area; }
    public int getCapacidad() { return capacidad; }
    public String getUso() { return uso; }
    public String toString() {
        String msg = "Piso #" + numeroPiso + " | ";
        msg += "Área: " + area + " m2 | ";
        msg += "Capacidad: " + capacidad + " | ";
        msg += "Uso: " + uso;
        return msg;
    }
}
