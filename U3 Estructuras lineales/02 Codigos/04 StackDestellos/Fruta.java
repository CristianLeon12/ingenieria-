public class Fruta
{
	static int serie = 0;
	
	int id;
	String nombre;
	String color;
	String sabor;
	
	public Fruta(String nombre, String color, String sabor) {
		id = ++serie;
		this.nombre = nombre;
		this.color  = color;
		this.sabor  = sabor;
	}
	
	public String toString() {
		return String.format("%03d %-20s %-20s %-20s",id,nombre,color,sabor);
	}
}