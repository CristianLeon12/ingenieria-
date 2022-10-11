/** stack de flores
* dependencias: Flor.java, Stack.java
*/

public class Florero
{
	public static void main(String[] args) {
		Stack<Flor> sF = new Stack<Flor>();
		
		sF.push(new Flor("Rosa de castilla","Rosa"));
		sF.push(new Flor("Camelia de los Andes","Cereza"));
		sF.push(new Flor("Margarita salvaje","Morado con blanco"));
		
		System.out.println("¿El florero esta vacío? " + sF.isEmpty());
		System.out.println("Numero de flores en el florero: " + sF.size());
		
		System.out.println(sF.peek());
		System.out.println(sF.peek());
		System.out.println(sF.peek());
		System.out.println();
		
		int tamaño = sF.size();
		for (int i = 1; i <= tamaño; i++)
			System.out.println(sF.pop());
		
		System.out.println("Numero de flores en el florero: " + sF.size());
		
	}
}