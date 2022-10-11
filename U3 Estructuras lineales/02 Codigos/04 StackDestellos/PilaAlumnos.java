/** Se acomodarán n alumnos en una pila
 *  dependencias: Alumno.java, Stack.java
 */

public class PilaAlumnos
{
	public static void main(String[] args) {
		/** crear una pila y llenarla de alumnos */
		Stack<Alumno> sA = new Stack<Alumno>();
		
		sA.push(new Alumno("Luisa Lane","LA",5));
		sA.push(new Alumno("Juan el Oso","LD",3));
		sA.push(new Alumno("Roberto Madrazo","CP",60));
		
		System.out.println("¿Pila de alumnos vacia? " + sA.isEmpty());
		System.out.println("# elementos en la pila: " + sA.size());
		
		System.out.println("Elemento en el tope: " + sA.peek());
		System.out.println("Elemento en el tope: " + sA.peek());
		System.out.println("Elemento en el tope: " + sA.peek());
		
		System.out.println("# elementos en la pila: " + sA.size());
		
		int tamaño = sA.size();
		for (int i = 1; i <= tamaño; i++) {
			System.out.println(sA.pop());
		}
		
		System.out.println("# elementos en la pila: " + sA.size());
	}
}