/******************************************************************************
 *  Compilation:  javac StableOnePass.java
 *  Execution:    java StableOnePass < data.txt
 *  Dependencies: StdIn.java
 *  
 *  Reads in a sequence of real numbers, computes the mean, standard
 *  deviation and 95% approximate confidence interval.
 *
 *  Note: uses a stable one-pass formula.
 *
 *  Limitations
 *  -----------
 *   - accurate subject to overflow of double
 *
 *
 *  % java StableOnePass
 *  10.0 5.0 6.0
 *  3.0 7.0 32.0
 *  average          = 10.5
 *  sample variance  = 116.3
 *  95% approximate confidence interval =  [ -10.637125632403283, 31.637125632403283 ]
 *  
 *  % java StableOnePass
 *  0.5000000000000002 0.5000000000000001
 *  mean             = 0.5000000000000002
 *  sample stddev    = 7.850462293418876E-17    // true answer = 7.07106781186547E-17
 *  sample variance  = 6.162975822039155E-33
 *  95% approximate confidence interval = [ 0.5000000000000001, 0.5000000000000003 ]
 *
 ******************************************************************************/

public class StableOnePass { 
    private int    n = 0;     // number of elements
    private double m = 0.0;   // sample mean
    private double s = 0.0;   // s / (n-1) is the sample variance

    // add a new value x to the dataset (using stable one-pass formula)
    public void add(double x) {
        n++;
        s = s + 1.0 * (n-1) / n * (x - m) * (x - m);
        m = m + (x - m) / n;
    }

    // return the mean of the N values
    public double mean() {
        return m;
    }

    // return the sample variance of the N values
    public double variance() {
        return s / (n - 1);
    }

    // return the sample standard deviation of the N values
    public double stddev() {
        return Math.sqrt(variance());
    }


    // test client
    public static void main(String[] args) { 
        StableOnePass dataset = new StableOnePass();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            dataset.add(x);
        }
        double mean   = dataset.mean();
        double stddev = dataset.stddev();
        double var    = dataset.variance();
        double lo = mean - 1.96 * stddev;
        double hi = mean + 1.96 * stddev;

        // print results
        StdOut.println("mean             = " + mean);
        StdOut.println("sample stddev    = " + stddev);
        StdOut.println("sample variance  = " + var);
        StdOut.print("95% approximate confidence interval = ");
        StdOut.println("[ " + lo + ", " + hi + " ]");
    }
}
