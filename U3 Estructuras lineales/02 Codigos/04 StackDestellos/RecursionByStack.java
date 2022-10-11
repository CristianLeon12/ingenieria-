/** Calculo del factorial de un numero usando un stack en lugar de 
 *  recursion
 *
 * uso: java RecursionByStack
 *
 * dependencias: Stack.java
 *
 * Simplemente empujamos sucesivamente valores más pequeños de n en
 * la pila hasta que se alcanza el caso base, luego sacamos repetidamente
 * los valores almacenados y los multiplicamos para dar el resultado.  
*/

public class RecursionByStack
{
	/** Return n! */
	static long sfact(int n) {
		/** fact(20) es el valor mas grande que cabe en un long */
		if ((n < 0) || (n > 20)) { return -1; }
		
		/** Crear un stack y llenarlo */
		Stack<Integer> S = new Stack<Integer>();
		while (n > 1) { S.push(n--); }
		
		/** Vaciar la pila e ir obteniendo los productos parciales */
		long result = 1;
		while (S.size() > 0) {
			result = result * S.pop();
		}
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(" i          factorial(i)");
		System.out.println("-- -------------------------");
		for (int i = 0; i <= 20; i++) {
			System.out.println(String.format("%02d %-,20d",i,sfact(i)));
		}
	}
}