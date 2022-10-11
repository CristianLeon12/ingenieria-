/**
 * Write a description of class Ruleta here.
 * 
 * @author Maldad
 * @version 1.0
 */
public class RuletaSimulacion
{
    public static void main (String [] args) {
        Soldados sol = new Soldados();
        
        /** rellenamos con X soldados */
        sol.rellenar(7);
        
        int ciclos = sol.getContador();
        Nodo iniciante;
        
        System.out.println("Prueba para 7 soldados");
        System.out.println("Pasos = 3, iniciando por el soldado 2"); 
        for(int i = ciclos; i > 0; i--) {       
            if (i == ciclos)
                /** primera iteracion, buscamos la posicion
                 *  del nodo que queremos iniciar */
                iniciante = sol.buscarLista(2);
            else
                /** caso contrario nos vamos por la variable estatica
                 *  que contiene el siguiente despues de eliminar X nodo; */
                iniciante = Soldados.saliente;          
            
            /** es la ultima vuelta */
            if (i == 1) {                       
                Nodo saved = sol.getFirst();
                System.out.print("Se ha salvado el soldado " + saved.datos + " " + saved.nombre);
                return;
            }
        
            /** pasos y nodo que inicia */
            Nodo queSale = sol.darVueltas(3, iniciante);
            sol.eliminar(queSale);
        } /** final FOR */
    }
}
