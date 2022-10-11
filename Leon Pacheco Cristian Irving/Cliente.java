
/**
 * Alumno:Leon Pacheco Cristian Irving
 * GRUPO:3SB
 * Evaluación Unidad 1 
 * Docente: Ing. Arturo A Aragón Sorroza
 */
//Usamos y exportamos la libreria para nuestro arraylist
import java.util.ArrayList;
//Declaramos nuestra clase cliente 
public class Cliente {
    //Metodo main
    public static void main(String[] args) {
        //Instanciamos la lista de alumnos que se anexara con nuestro arrayList.
        ArrayList<Alumno> lis = new ArrayList<>();
        //Creamos a nuestros 20 alumnos que se han solicitado con nombre N control y promedio
        lis.add(new Alumno(20161237,"Leon Pacheco Cristian Irving", 87.00));
        lis.add(new Alumno(20345666,"Daniel Robes Garcia",75.50));
        lis.add(new Alumno(20456389,"Alexa Isabel Rodriguez Hernandez",99.30));
        lis.add(new Alumno(20234565,"Astird Jimenez Llaguno",89.50));
        lis.add(new Alumno(20977535,"Noel Maruqez Perez",78.90));
        lis.add(new Alumno(20764654,"Yahir Santiago Vicente",80.90));
        lis.add(new Alumno(20648787,"Yessica Santiago Lopez",56.40)); 
        lis.add(new Alumno(20384775,"Rosalia Pacheco Lopez",90.10));
        lis.add(new Alumno(20554354,"Julian Leon Perez",67.50));
        lis.add(new Alumno(20945450,"Miguel Gomez Lopez",75.55));
        lis.add(new Alumno(20873565,"Silvina Lizeth Pacheco Leon",95.00));
        lis.add(new Alumno(20561223,"Sandra Juarez Garcia",100.00));//Alumno 12
        lis.add(new Alumno(20603453,"Daniel Maquez Lopez",43.50));
        lis.add(new Alumno(20787373,"Cynthia Juarez Leon",63.00));
        lis.add(new Alumno(20509523,"David Garcia Mendez ",76.45));
        lis.add(new Alumno(20789492,"Joel Leon Perez",94.40));
        lis.add(new Alumno(20089942,"Elizabeth leon luna",77.25));
        lis.add(new Alumno(20898723,"Tania Mendez Gutierrez",77.09));
        lis.add(new Alumno(20389965,"Francisco Kevin Sanchez Pioquinto",94.55));
        lis.add(new Alumno(20789459,"Karla Vargas Avendaño",93.00));
        //Creamos la "Clase Inmutable" Lista instanciandola
        Lista lista = new Lista(lis,"Estructura de Datos","3SD");
        //Imprimimos la lista
        System.out.println("Contenido de nuestra lista inmutable");
        lista.imprimirLista();
        //Creamos una nueva lista
        //Eliminamos el Alumno 12: 
        System.out.println("\n Eliminamos al alumno numero 12: "+lista.getLista().get(11).getNombre());
        lista.getLista().remove(11);
        // Obtenemos Nuestra Lista y luego removemos al alumno en el caso de no se imprime un anuncio donde dice que no se ha modificado
        System.out.println("Imprimimos de nuevo la lista");
        lista.imprimirLista();
        System.out.println("La lista no ha sido modifcada");

    }
}
 
 


