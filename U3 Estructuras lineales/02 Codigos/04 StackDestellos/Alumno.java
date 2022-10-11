public class Alumno
{
	static int serie = 0;
	
	int id;
	String nombre;
	String carrera;
	int semestre;
	
	public Alumno(String n, String c, int s) {
		id       = ++serie;
		nombre   = n;
		carrera  = c;
		semestre = s;
	}
	
	public String toString() {
		return String.format("%05d %-25s %-5s %02d",id,nombre,carrera,semestre);
	}
}