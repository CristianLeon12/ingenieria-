/**
 * Donde se crean los circulos de soldados
 * 
 * @author Maldad
 * @version 1.0
 */
public class Soldados
{
    static String [] nombres = {"Toshiro", "Hashirama Senju", "Anko Miratashi", "Hiruzen Sarutobi", 
                                "Minato Namizake", "Tsunade", "Itachi Uchiha", "Deidara"};
                                
    /** apuntador de cabecera; */
    Nodo first;
    /** apuntador de ultimo elemento agregado */
    Nodo lastAdded;
    /** lleva la cuenta de cuantos hay */
    int contador;
    
    static Nodo saliente;
   
    public Soldados () {
        first = null; 
    }
    
    public int getContador() {
        return contador;
    } 
    
    public boolean isEmpty() {
        if (contador == 0)
            return true;
        return false;
    }
   
    /** agrega nodos guiandose con la variable last */
    public void insertar(int num) {
        /** se enlaza al ultimo nodo que haya */
        Nodo n = new Nodo(num, nombres[num % 8]); 
        
        if (isEmpty()) {
            first = n;
            lastAdded = first;
            
            /** apuntar su siguiente a la cabecera */
            lastAdded.next = first;
            
            contador ++;
        }
        else {
            lastAdded.next = n;
            lastAdded = n;
            lastAdded.next = first;  /** hacerla circular */
            contador ++;
        }
    }
   
    /** ciclo para establecer el num, de soldados */
    public void rellenar(int cantidad) {
        for(int i = 1; i <= cantidad; i ++)
            insertar(i);
    }
    
    /** imprimir la lista */
    public void recorrer() {
        if (! isEmpty()) {
            Nodo reco = first;
            do {
                System.out.println(reco.datos + " " + reco.nombre);
                reco = reco.next;
            } while (reco != first);   
        }
    }
    
    public Nodo getFirst() {
        return first;
    } 
   
    public Nodo darVueltas(int pasos, Nodo inicio) {
        /** ajustar desde donde inicia el conteo */
        saliente = inicio;
        
        /** si fuera 0, no empezaria la cuenta, */
        if (! isEmpty() && pasos > 0) {
            for(int i = 1; i < pasos; i++) 
                saliente = saliente.next;
                
            /** regresa el nodo donde cae la "ruleta" */
            return saliente;
        }
        return null;
    }
     
    public Nodo buscarLista(int destino) {
        Nodo indice = first;
        for (int i = 0; i < contador; indice = indice.next, i++)
            if (destino == indice.datos)
                /** regresa el nodo donde se encuentra el dato buscado */
                return indice;
        return null;
   }
   
   public void eliminar(Nodo elemento) {
       Nodo actual;
       boolean encontrado = false;
     
       actual = first;
       while ((actual.next != first) && (!encontrado)) {
           /** se vuelve true si coinciden */
           encontrado = (actual.next == elemento);
           
           /** evalua la variable anterior */
           if (!encontrado) { 
               actual = actual.next;
            }
       }
       encontrado = (actual.next == elemento);
      
       /** cuando se sale del ciclo, se enlazan los nodos */
       if (encontrado) {
           Nodo delete;
           /** nodo a eliminar */
           delete = actual.next;
           
           /** lista con 1 solo nodo */
           if (first == first.next)
               first = null;
           else {
               /** en caso de que el nodo a eliminar sea el primero */
               if (delete == first) {
                   /** adelantar uno */
                   first = first.next;
               }
           actual.next = delete.next;
           }
        
           System.out.println("se ha eliminado el " + delete.datos + " " + delete.nombre);
           contador --;
           saliente = delete.next;
           
           /** mandarlo al diablo */
           delete   = null;
       }
    }  
} /** end class */
