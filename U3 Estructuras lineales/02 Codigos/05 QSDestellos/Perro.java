/** Paso por valor - Implementacion de demostracion

 ** Manejo de variables de tipos primitivos **
	
	static void modX(int x) {
		x = x * 100 / Math.PI;
		System.out.println("Nuevo valor de x : " + x);
	}
	
	public static void main(String[] args)
	{
		int x = 10;
		System.out.println("x inicial: " + x);
		modX(x);
		System.out.println("x ¿modificada?: " + x);
	}
	
 ** Manejo de variables de referencia a objetos **
	--------------------------
	|		  Perro			 |
	--------------------------
	| - String nombre		 |
	| - String raza			 |
	| - String color		 |
	--------------------------
	| + void pelear(Perro p) |
	--------------------------
	
	
	Perro coquis = new("Coquis","Cocker Spanish","Dorado");
	Perro rolex  = coquis;
	Perro tarzan = coquis;								- coquis
														|
														@3578A5 ----> [Coquis,Cocker Spanish,Dorado]
														|	|		  [Coquis,Cocker Spanish,Negro]
										rolex -----------	-------tarzan						|
																								|
	coquis CONTIENE una dirección de memoria en el Heap: 3578A5									|
	rolex CONTIENE una copia de la dirección de coquis:  3578A5									|
	tarzan CONTIENE una copia de la dirección de coquis: 3578A5									|
																								|
	System.out.println(coquis.getColor());		---> Dorado										|
	System.out.println(rolex.getColor());		---> Dorado										|
	System.out.println(tarzan.getColor());		---> Dorado										|
																								|
	rolex.setColor("Negro");					---> --------------------------------------------
	System.out.println(tarzan.get(Color));		---> Negro									  Verde
																								|																														|
	public void jugar(Perro x) {																|
		System.out.println("Estoy jugando con " + x.getNombre() + " lanzando una pelota");		|
		....																					|
		x.setColor("Verde");     ---> -----------------------------------------------------------
	}
	
	resulta que x CONTIENE una copia de la direccion del perro que se pase como argumento
	coquis.jugar(rolex);
	System.out.println(coquis.getColor());		---> Verde
	System.out.println(rolex.getColor());		---> Verde
	System.out.println(tarzan.getColor());		---> Verde
	
	System.out.println(tarzan.getNombre());		---> Coquis
	System.out.println(coquis.getNombre());		---> Coquis
	System.out.println(rolex.getNombre());		---> Coquis	
*/
	
public class Perro
{
	private String nombre;
	private String raza;
	private String color;
	
	public Perro(String n, String r, String c) {
		nombre = n;
		raza   = r;
		color  = c;
	}
	
	public String getNombre() { return nombre; }
	
	public String getColor() { return color; }
	
	public void setColor(String nC) { color = nC; }
	
	public String toString() { return String.format("%-10s %-20s %-10s",nombre,raza,color); }
	
	public void jugar(Perro x) {
		if (this.equals(x)) 
			System.out.println(nombre + " esta jugando consigo mismo.");
		else
		{
			System.out.println("Yo " + nombre + ", estoy jugando con mi amigo " + x.getNombre() +
							   " lanzando una pelota.");
			System.out.println("¡Yo " + x.getNombre() + " nomás porque sí me pongo verde!");
		}
		x.setColor("Verde");
	}
}		
