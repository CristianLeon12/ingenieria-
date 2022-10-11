/******************************************************************************
 *  Compilation:  javac Sketch.java
 *  Execution:    java Sketch k d < input.txt
 *  Data files:   https://introcs.cs.princeton.edu/java/33design/genome20.txt
 *                https://introcs.cs.princeton.edu/java/33design/genome50.txt
 *
 *  % java Sketch 2 16 < genome20.txt
 *
 *
 ******************************************************************************/
import java.util.Arrays;

public class Sketch {
    private final Vector profile;         // unit vector

    public Sketch(String text, int k, int d) {
        int n = text.length();
        double[] freq = new double[d];
        for (int i = 0; i < n-k+1; i++) {
            String kgram = text.substring(i, i+k);
            int hash = kgram.hashCode();
            freq[Math.abs(hash % d)] += 1;
			System.out.print("(" + (Math.abs(hash % d)) + ")" + kgram + ",");
			if (i > 0) System.out.print(i % 10 == 0 ? "\n" : "");
        }
		System.out.println("\nLista de frecuencias acumuladas");
        Vector vector = new Vector(freq);
        profile = vector.direction();
		System.out.println(Arrays.toString(freq));
    }

    public double similarTo(Sketch other) {
        return profile.dot(other.profile);
    }

    public String toString() {
        return "" + profile;
    }

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int d = Integer.parseInt(args[1]);
        String text = StdIn.readAll();
		System.out.println("Longitud del texto: " + text.length());
		System.out.println("Contenido del texto");
		System.out.println(text + "\nLista de kgramas");
        Sketch sketch = new Sketch(text, k, d);
        StdOut.println("Direcciones del vector de frecuencias:\n" + sketch);
    }
}
