/** Crear una pila, clonarla y listarla
 *  compilacion  : javac UsarStack
 *  ejecucion    : java UsarStack
 *  dependencias : Perro.java y QSClonar.java
 */

public class UsarStack
{
	public static void main(String[] args) {
		Stack<Perro> sP = new Stack<Perro>();
		sP.push(new Perro("Zonzo","San Bernardo","Blanco y Amarillo"));
		sP.push(new Perro("Retazo","Chihuahueño","Blanco"));
		sP.push(new Perro("Pinocho","Boxer","Cafe claro"));
		sP.push(new Perro("Lencho","Tepexcuintle","Indefinido"));
		sP.push(new Perro("Guacho","Golden Retriever","Oro"));
		sP.push(new Perro("Chato","Pastor Belga","Oro y negro"));
		sP.push(new Perro("Boris","Siberiano","Blanco y negro"));
		
		/** obtener una copia exacta del stack sP -> cSP */
		QSClonar<Perro> clonador = new QSClonar<Perro>();
		Stack<Perro> cSP = clonador.clonarS(sP);
		System.out.println("\nStack original: " + sP.size() + " - Stack clon: " + cSP.size() + "\n");
		
		int tamaño = sP.size();
		for (int i = 1; i <= tamaño; i++)
			System.out.println(cSP.pop());
		System.out.println("\nStack original: " + sP.size() + " - Stack clon: " + cSP.size() + "\n");
	}
}