public class Flor
{
	static int serie = 0;
	
	int id;
	String nombre;
	String color;
	
	public Flor(String n, String c) {
		id = ++serie;
		nombre = n;
		color = c;
	}
	
	public String toString() {
		return String.format("%03d %-20s %-20s",id,nombre,color);
	}
}