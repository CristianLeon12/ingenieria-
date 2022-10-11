/**
 * Alumno:Leon Pacheco Cristian Irving
 * GRUPO:3SB
 * Evaluación Unidad 1 
 * Docente: Ing. Arturo A Aragón Sorroza
 */
//Importamos nuestra libreria de ArrayList
import java.util.ArrayList;
public class Lista { 
    //Declaramos nuestros atributos
    final private String Materia;
    final private String Grupo;
    final private ArrayList<Alumno> lista;
    //Nuestro metodo Lista se le asigna los atributos y se hace referencia a ellos
    public Lista(ArrayList<Alumno> list, String subject, String group){
        lista = new ArrayList<>(list); 
        Materia = subject;
        Grupo = group;
    }
    //Metodo array donde se hace una copia de nuestra lista de alumnos
    public ArrayList<Alumno> getLista(){
        return new ArrayList<>(lista); 
    }
    //En este metodo le damos formato usando el System.out.println para imprimir lo que se vera en pantalla
    //ademas de agregar guiones para que se vea de buena manera al imprimir nuestro metodo main
    public void imprimirLista(){
        System.out.println("-----------------------------------------------------------");
        System.out.println(Materia+" | "+Grupo);
        System.out.println("-----------------------------------------------------------");
        System.out.println("Num° CONTROL |              NOMBRE               | PROMEDIO");
        System.out.println("-----------------------------------------------------------");
        //Usamos un ciclo for unicamente para poder imprimir nuestra lista de alumnos 
        for (Alumno al : lista) {
            System.out.println(al.toString());
        }
    }
}
    