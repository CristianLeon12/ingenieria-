public class Test3
{
    public static void main(String[] args)
    {
        System.out.println("Clase circulo inmutable\n");
        /** crear el punto (10,10) */
        Punto p1 = new Punto(10.0,10.0);
        /** imprimir el punto */
        System.out.println("Punto 1: " + p1);
        
        /** crear un CirculoI con origen en p1 y radio 3.0 */
        CirculoI ci = new CirculoI(p1,3.0);
        /** imprimir el circulo */
        System.out.println("Circulo 1" + ci);
        
        /** modificar la coordenada x a 15 */
        p1.setX(15.0);
        /** imprimir el punto modificado en x */
        System.out.println("\nPunto 1: " + p1);
        
        /** imprimir el circulo */
        System.out.println("Circulo 1" + ci);
        
        /** solicitar el origen para modificarlo */
        Punto origenCI = ci.getOrigen();
        System.out.println("\nOrigen: " + origenCI);
        
        /** modificar el 'origen' solicitado */
        origenCI.setY(35);
        System.out.println("\nOrigen: " + origenCI);
        
        /** imprimir el circulo */
        System.out.println("\nCirculo 1" + ci);
        System.out.println("¡Sigue inmutable!");
    }
}