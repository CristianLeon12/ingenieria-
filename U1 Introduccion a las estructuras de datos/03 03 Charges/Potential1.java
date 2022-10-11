/******************************************************************************
 *  Compilation:  javac Potential1.java
 *  Execution:    java Potential1 < input.txt
 *  Dependencies: Charge.java Picture.java StdIn.java
 *                http://www.cs.princeton.edu/introcs/31datatype/charges.txt
 *
 *  Potential1 value visualization for a set of charges.
 *
 *  % java Potential1 < charges.txt
 *
 *
 ******************************************************************************/

import java.awt.Color;

public class Potential1 {

    public static void main(String[] args) {

        // read in n point charges
        int n = StdIn.readInt();
        Charge[] a = new Charge[n];
        for (int k = 0; k < n; k++) {
            double x0 = StdIn.readDouble();
            double y0 = StdIn.readDouble();
            double q0 = StdIn.readDouble();
            a[k] = new Charge(x0, y0, q0);
        }

        // compute the potential at each point and plot
        int SIZE = 800;
        Picture pic = new Picture(SIZE, SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                double potential = 0.0;
                for (int k = 0; k < n; k++) {
                    double x = 1.0 * i / SIZE;
                    double y = 1.0 * j / SIZE;
                    potential += a[k].potentialAt(x, y);
                }
                potential = 128 + potential / 2.0e10;
                int t = 0;
                if      (potential <   0) t = 0;
                else if (potential > 255) t = 255;
                else                      t = (int) potential;
                Color c = new Color(t, t, t);
                pic.set(i, SIZE-1-j, c);
            }
        }
        pic.show();
    }
}
