/******************************************************************************
 *  Compilation:  javac StringGenome.java
 *  Execution:    java StringGenome
 *
 *
 ******************************************************************************/

public class StringGenome {
    private String s = "";


    public void addNucleotide(char c) {
        if (c == 'A' || c == 'C' || c == 'G' || c == 'T')
            s = s + c;
        else throw new RuntimeException("Illegal nucleotide");
    }

    public char nucleotideAt(int i) {
        if (i < s.length()) return s.charAt(i);
        else throw new RuntimeException("Genome out of bounds");
    }

    public int length()      { return s.length(); }
    public String toString() { return s;          }



    // sample client for testing
    public static void main(String[] args) {
        StringGenome genome = new StringGenome();
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
