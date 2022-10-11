public class Test1
{
    public static void main(String[] args)
    {
        /** crear el punto (10,10) */
        Punto p1 = new Punto(10.0,10.0);
        /** imprimir el punto */
        System.out.println("Punto 1: " + p1);
        /** modificar la coordenada x a 15 */
        p1.setX(15.0);
        /** imprimir el punto modificado en x */
        System.out.println("Punto 1: " + p1);
    }
}
