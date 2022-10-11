public class CirculoM
{
    public CirculoM(Punto p, double r) {
        origen = p; radio = r;
    }
    
    public Punto getOrigen() {
        return origen; 
    }
    
    public double getRadio() {
        return radio;
    }
    
    public String toString() {
        return String.format("%-10s, %6.2f",origen,radio);
    }
    
    private Punto origen;
    private double radio;
}
