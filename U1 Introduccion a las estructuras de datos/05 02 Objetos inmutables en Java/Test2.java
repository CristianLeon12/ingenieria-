public class Test2
{
    public static void main(String[] args)
    {
        System.out.println("Clase circulo mutable\n");
        /** crear el punto (10,10) */
        Punto p1 = new Punto(10.0,10.0);
        /** imprimir el punto */
        System.out.println("Punto 1: " + p1);
        
        /** crear un CirculoM con origen en p1 y radio 3.0 */
        CirculoM cm = new CirculoM(p1,3.0);
        /** imprimir el circulo */
        System.out.println("Circulo 1" + cm);
        
        /** modificar la coordenada x a 15 */
        p1.setX(15.0);
        /** imprimir el punto modificado en x */
        System.out.println("\nPunto 1: " + p1);
        
        /** imprimir el circulo */
        System.out.println("Circulo 1" + cm);
    }
}
