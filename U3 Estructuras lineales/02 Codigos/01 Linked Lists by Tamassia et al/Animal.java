public class Animal
{
    static int serie = 0;
    int numero;
    String nombre;
    
    public Animal(String nombre) {
        serie++;
        numero = serie;
        this.nombre = nombre;
    }
    
    public String toString() {
        return numero + " " + nombre;
    }
    
}
