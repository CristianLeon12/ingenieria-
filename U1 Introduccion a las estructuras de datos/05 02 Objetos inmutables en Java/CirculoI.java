/** Clase Circulo inmutable */

/** regla 5. clase 'final' */
final class CirculoI
{ 
    public CirculoI(Punto p, double r) {
        /** regla 4.1, copia defensiva
         *  porque el atributo es una referencia a un objeto
         */
        origen = new Punto(p);
        
        /** no es una referencia, no hay problema. */
        radio = r;
    }
    
    public Punto getOrigen() {
        /** regla 4.2, copia defensiva */
        return new Punto(origen);
    }
    
    public double getRadio() {
        return radio;
    }
    
    public String toString() {
        return String.format("%-10s, %6.2f",origen,radio);
    }
    
    /** regla 1: no hay setters */
    
    /** reglas 2 y 3 */
    final private Punto origen;
    final private double radio;

}