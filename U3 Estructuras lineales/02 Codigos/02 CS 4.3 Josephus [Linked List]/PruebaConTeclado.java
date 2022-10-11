/**
 * Write a description of class PruebaConTeclado here.
 * 
 * @author Maldad
 * @version (a version number or a date)
 */
public class PruebaConTeclado {
    
    /** args: [0] # soldados; [1] de cuanto en cuanto; [2] primer soldado */
    public static void main(String [] args) {
        Soldados sol = new Soldados();
        int cuantos  = Integer.parseInt(args[0]);
        sol.rellenar(cuantos);
        int ciclos   = sol.getContador();
        Nodo iniciante;

        int pasos    = Integer.parseInt(args[1]);
        int soldado  = Integer.parseInt(args[2]);
    
        System.out.println("Ruleta para " + cuantos + " soldados.");
        System.out.println("Pasos = " + pasos + ", iniciando con el soldado " + soldado);
    
        for(int i = ciclos; i > 0; i--) {        
            if (i == ciclos)
                /** primera iteracion, buscamos la posicion
                 *  del nodo en que queremos iniciar */
                iniciante = sol.buscarLista(soldado);
            else
                /** caso contrario nos vamos por la variable estatica
                 *  que contiene el siguiente despues de eliminar X nodo; */
                iniciante = Soldados.saliente;
            /** es la ultima vuelta */
            
            if (i == 1) {
                Nodo saved = sol.getFirst();
                if (saved.datos < 7)
                    System.out.println("Se ha salvado el soldado " + saved.datos + " " +
                                        saved.nombre);
            else {
                System.out.print("Se ha salvado el soldado ");
                sol.recorrer();
                 }
                return;
            }
        
            /** pasos y nodo que inicia */
            Nodo queSale = sol.darVueltas(pasos, iniciante);
            sol.eliminar(queSale);
        }
    }
}
