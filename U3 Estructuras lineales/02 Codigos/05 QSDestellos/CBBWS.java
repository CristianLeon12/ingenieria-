/** uso: java BBWS < BBWS.csv
 *  dependencias: WorldSerie.java, Queue.java
 */

public class CBBWS
{
	public static Queue<WorldSerie> buscar(Queue<WorldSerie> wS, String e) {
		Queue<WorldSerie> qWS = new Queue<WorldSerie>();
		int tamaño = wS.size();
		e = e.toUpperCase();
		for (int i = 1; i <= tamaño; i++) {
			WorldSerie t = wS.dequeu();
			if (t.getWinner().toUpperCase().contains(e) || t.getLoser().toUpperCase().contains(e))
				qWS.enqueue(t);
		}
		return qWS;
	}
	
	public static Queue<WorldSerie> buscar(Queue<WorldSerie> wS, String e, String f) {
		Queue<WorldSerie> qWS = new Queue<WorldSerie>();
		int tamaño = wS.size();
		e = e.toUpperCase();
		f = f.toUpperCase();
		for (int i = 1; i <= tamaño; i++) {
			WorldSerie t = wS.dequeu();
			if ((t.getWinner().toUpperCase().contains(e) || t.getLoser().toUpperCase().contains(e))
				&&
				(t.getWinner().toUpperCase().contains(f) || t.getLoser().toUpperCase().contains(f)))
				qWS.enqueue(t);
		}
		return qWS;
	}
	
	public static void imprimir(String letrero, Queue<WorldSerie> datos) {
		System.out.println(letrero);
		System.out.println(" Año             Equipo ganador                          Equipo perdedor");
		System.out.println("---- ---------------------------------------- ----------------------------------------");
		int tamaño = datos.size();
		for (int i = 1; i <= tamaño; i++)
			System.out.println(datos.dequeu());
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] lineas = StdIn.readAllLines();
		
		/** crea y llena una cola de equipos que jugaron series mundiales de BB */
		Queue<WorldSerie> wS = new Queue<WorldSerie>();		
		for (String s: lineas) {
			String[] f = s.split(",");
			wS.enqueue(new WorldSerie(Integer.parseInt(f[0]),f[1],f[2]));
		}
		
		System.out.println("\n# de series mundiales: " + wS.size() + "\n");
		
		/** obtener un clon de la cola wS -> wSC, usando un objeto de QSClonar<WorldSerie> */
		QSClonar<WorldSerie> qs = new QSClonar<WorldSerie>();
		Queue<WorldSerie> wSC = qs.clonarQ(wS);
		System.out.println("wSC será un clon de la Queue wS");
		System.out.println("wS.size(): " + wS.size() + ", wSC.size(): " + wSC.size() + "\n");
		
		/** lista de equipos que contendieron en las series mundiales */
		imprimir("Usaremos el clon de la queue original: wSC\n",wSC);
		System.out.println("\nwS.size(): " + wS.size() + ", wSC.size(): " + wSC.size());
		System.out.println();
		
		String team1 = "Cubs";
		wSC = qs.clonarQ(wS);
		Queue<WorldSerie> wSB = buscar(wSC,team1);
		
		/** lista de algunos equipos que contendieron en las series mundiales */
		String letrero = "Series mundiales protagonizadas por el equipo: " + team1 + "\n";
		imprimir(letrero,wSB);
		System.out.println("\nwS.size(): " + wS.size() + ", wSC.size(): " + wSC.size() + "\n");
		
		String team2 = "Tigers";
		wSC = qs.clonarQ(wS);
		wSB = buscar(wSC,team1,team2);
		letrero = "Series mundiales protagonizadas por: " + team1 + " vs " + team2;
		imprimir(letrero,wSB);
		
		System.out.println("\nwS.size(): " + wS.size() + ", wSC.size(): " + wSC.size() + "\n");
	}
}