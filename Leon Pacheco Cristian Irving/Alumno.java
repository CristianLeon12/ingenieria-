
/**
 * Alumno:Leon Pacheco Cristian Irving
 * GRUPO:3SB
 * Evaluación Unidad 1 
 * Docente: Ing. Arturo A Aragón Sorroza
 */
//iniciamos nuestra clase alumno 
public class Alumno {
    //Atributos de nuestras clase alumno de manera privada
    private int NControl;
    private String Nombre;
    private double Promedio;
    //Declaramos el metodo alumno con sus parametros y hacemos referencia a cada uno de ellos con la palabra reservada this
    public Alumno(int NControl, String Nombre, double Promedio){
        this.NControl = NControl;
        this.Nombre = Nombre;
        this.Promedio = Promedio;
    }
    //Metodos getters del Alumno
    public int getnControl() {return NControl;}
    public String getNombre() {return Nombre;}
    public double getPromedio() {return Promedio;}
    //Metodos setters del Alumno
    public void setnControl(int nControl) {this.NControl = NControl;}
    public void setNombre(String nombre) {this.Nombre = Nombre;}
    public void setPromedio(double promedio) {this.Promedio = Promedio;}
    //Le damos formato a nuestro Metodo toString con los atributos que se nos brindaron
    public String toString(){
        return String.format("%10d  %-35s  %.2f",NControl,Nombre,Promedio);
    }
}


