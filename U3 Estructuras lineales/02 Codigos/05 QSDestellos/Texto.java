public class Texto
{
	public static void main(String[] args) {
		String s = "Tlacolula de Matamoros";
		/** no es lo mismo s.toUpperCase() a s = s.toUpperCase() */
		s = s.toUpperCase();
		System.out.println(s);
		
		String r = s + " Oaxaca".toUpperCase();
		System.out.println(r);
		/** "Tlacolula de Matamoros" y "Oaxaca" son  OBJETOS de tipo String*/
	}
}