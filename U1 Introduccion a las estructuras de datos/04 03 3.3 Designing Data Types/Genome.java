/******************************************************************************
 *  Compilation:  javac Genome.java
 *  Execution:    java Genome
 *
 *
 ******************************************************************************/

public class Genome {
    private char[] a = new char[2];
    private int n = 0;

    public void addNucleotide(char c) {
        if (n == a.length) resize();
        if (c == 'A' || c == 'C' || c == 'G' || c == 'T')
            a[n++] = c;
        else throw new RuntimeException("Illegal nucleotide");
    }

    // double the size of the array
    private void resize() {
        char[] temp = new char[2*n];
        for (int i = 0; i < n; i++)
            temp[i] = a[i];
        a = temp;
    }

    public char nucleotideAt(int i) {
        if (i < n) return a[i];
        else throw new RuntimeException("Genome out of bounds");
    }

    public int length() {
        return n;
    }

    // sample client for testing
    public static void main(String[] args) {
        Genome genome = new Genome();
        genome.addNucleotide('A');
        genome.addNucleotide('G');
        genome.addNucleotide('C');
        genome.addNucleotide('C');
        genome.addNucleotide('T');
        for (int i = 0; i < genome.length(); i++) {
            StdOut.print(genome.nucleotideAt(i));
        }
        StdOut.println();
    }

}
