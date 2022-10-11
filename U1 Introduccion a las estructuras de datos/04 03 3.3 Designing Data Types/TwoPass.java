/******************************************************************************
 *  Compilation:  javac TwoPass.java
 *  Execution:    java TwoPass < data.txt
 *  Dependencies: StdIn.java
 *  
 *  Reads in a sequence of real numbers, computes the mean, standard
 *  deviation and 95% approximate confidence interval.
 *
 *  Note: the two-pass formula is preferred for stability.
 *
 *  Limitations
 *  -----------
 *   - accurate subject to overflow of double
 *
 *
 *  % java TwoPass
 *  10.0 5.0 6.0
 *  3.0 7.0 32.0
 *  average          = 10.5
 *  sample variance  = 116.3
 *  95% approximate confidence interval =  [ -10.637125632403283, 31.637125632403283 ]
 *  
 *  % java Average 
 *  0.5000000000000002 0.5000000000000001
 *  average          = 0.5000000000000002
 *  sample stddev    = 1.1102230246251565E-16
 *  95% approximate confidence interval =  [ 0.5, 0.5000000000000004 ]
 *
 ******************************************************************************/

public class TwoPass { 
    private int capacity = 10;
    private int n = 0;
    private double[] x = new double[capacity];
    private double sumx = 0.0;

    // double the capacity of the array storing the values
    private void increaseCapacity() {
        capacity = capacity * 2;
        double[] temp = new double[capacity];
        for (int i = 0; i < n; i++)
            temp[i] = x[i];
        x = temp;
    }

    // add a new value to the dataset
    public void add(double value) {
        if (n == capacity) increaseCapacity();
        x[n++] = value;
        sumx = sumx + value;
    }

    // return the mean of the n values
    public double mean() {
        return sumx / n;
    }

    // return the sample variance of the n values
    public double variance() {
        double xbar = mean();
        double xxbar = 0.0;
        for (int i = 0; i < n; i++)
            xxbar += (x[i] - xbar) * (x[i] - xbar);
        double variance = xxbar / (n - 1);
        return variance;
    }

    // return the sample standard deviation of the n values
    public double stddev() {
        return Math.sqrt(variance());
    }


    // test client
    public static void main(String[] args) { 
        TwoPass dataset = new TwoPass();
        while (!StdIn.isEmpty()) {
            double x = StdIn.readDouble();
            dataset.add(x);
        }
        double mean   = dataset.mean();
        double stddev = dataset.stddev();
        double lo = mean - 1.96 * stddev;
        double hi = mean + 1.96 * stddev;

        // print results
        StdOut.println("mean             = " + mean);
        StdOut.println("sample stddev    = " + stddev);
        StdOut.print("95% approximate confidence interval = ");
        StdOut.println("[ " + lo + ", " + hi + " ]");
    }
}
