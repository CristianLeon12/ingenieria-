/** dependencias: Fruta.java, Stack.java */

public class Canasta
{
	public static void main(String[] args) {
		Stack<Fruta> sF = new Stack<Fruta>();
		
		sF.push(new Fruta("Naranja","Naranja","Agridulce"));
		sF.push(new Fruta("Manzana","Rojo delicioso","Dulce"));
		sF.push(new Fruta("Platano","Amarillo con negro","Neutro"));
		sF.push(new Fruta("Fresa","Roja","Agrio"));
		
		System.out.println("¿Canasta está vacía? " + sF.isEmpty());
		System.out.println("Numero de frutas en la canasta: " + sF.size() + "\n");
		
		System.out.println(sF.peek());
		System.out.println(sF.peek());
		System.out.println(sF.peek());
		System.out.println(sF.peek());
		System.out.println();
		
		int tamaño = sF.size();
		for (int i = 0; i < tamaño; i++)
			System.out.println(sF.pop());
		
		System.out.println("Numero de frutas en la canasta: " + sF.size() + "\n");
	}
}