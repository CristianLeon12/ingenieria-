/** uso: java BBWS < BBWS.csv
 *  dependencias: WorldSerie.java, Queue.java
 */

public class BBWS
{
	/** wS es la cola original, por lo que debo tener cuidado de no entregarla vacía
		y es una variable de referencia por lo que puedo utilizarla de nuevo para
		llenar la cola otra vez */
	public static Queue<WorldSerie> clonar(Queue<WorldSerie> wS) {
		Queue<WorldSerie> qWS = new Queue<WorldSerie>();
		int tamaño = wS.size();
		for (int i = 1; i <= tamaño; i++) {
			qWS.enqueue(wS.peek());
			wS.enqueue(wS.dequeu());
		}
		return qWS;
	}
	
	public static void main(String[] args) {
		String[] lineas = StdIn.readAllLines();
		
		/** crea y llena una cola de equipos que jugaron series mundiales de BB */
		Queue<WorldSerie> wS = new Queue<WorldSerie>();		
		for (String s: lineas) {
			String[] f = s.split(",");
			wS.enqueue(new WorldSerie(Integer.parseInt(f[0]),f[1],f[2]));
		}
		
		System.out.println("# de series mundiales: " + wS.size() + "\n");
		
		/** obtener un clon de la cola wS -> wSC */
		Queue<WorldSerie> wSC = clonar(wS);
		System.out.println("wSC será un clon de la Queue wS");
		System.out.println("wS.size(): " + wS.size() + ", wSC.size(): " + wSC.size() + "\n");
		
		/** lista de equipos que contendieron en las series mundiales */
		System.out.println("Usaremos el clon de la queue original: wSC\n");
		System.out.println(" Año             Equipo ganador                          Equipo perdedor");
		System.out.println("---- ---------------------------------------- ----------------------------------------");
		int tamaño = wSC.size();
		for (int i = 1; i <= tamaño; i++)
			System.out.println(wSC.dequeu());

		System.out.println("\nwS.size(): " + wS.size() + ", wSC.size(): " + wSC.size()); 
	}
}