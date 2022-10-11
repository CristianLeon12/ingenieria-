/******************************************************************************
 *  Compilation:  javac OnePass.java
 *  Execution:    java Average < data.txt
 *  Dependencies: StdIn.java
 *  
 *  Reads in a sequence of real numbers, and computes their average
 *  and standard deviation using one-pass formula.
 *
 *  Limitations
 *  -----------
 *   -  Not numerically stable.
 *
 *  % java OnePass
 *  10.0 5.0 6.0
 *  3.0 7.0 32.0
 *  [Ctrl-d]
 *  10 5 6 3 7 32
 *  mean             = 10.5
 *  sample stddev    = 10.784247771634329
 *  95% approximate confidence interval = [ -10.637125632403283, 31.637125632403283 ]
 * 
 *  % java OnePass
 *  1000000000 1000000001 1000000002
 *  [Ctrl-d]
 *  Number  = 3
 *  Average = 1.000000001E9
 *  Standard deviation = 0.0            // correct answer = 1.0
 *  95% approximate confidence interval = [ 1.000000001E9, 1.000000001E9 ]
 *
 *  % java OnePass
 *  0.5000000000000002 0.5000000000000001
 *  Number  = 2
 *  Average = 0.5000000000000002
 *  Standard deviation = NaN            // variance is negative!!!
 *  95% approximate confidence interval = [ NaN, NaN ]
 *
 *  Note [Ctrl-d] signifies the end of file on Unix.
 *  On windows use [Ctrl-z].
 *
 ******************************************************************************/

public class OnePass { 
    private int n = 0;
    private double sum  = 0.0;
    private double sum2 = 0.0;

    // add a new value to the dataset
    public void add(double value) {
        sum  = sum + value;
        sum2 = sum2 + value * value;
        n++;
    }

    // return the mean of the N values
    public double mean() {
        return sum / n;
    }

    // return the sample variance of the n values
    public double variance() {
        return (n*sum2 - sum*sum) / (n*(n-1));
    }

    // return the sample standard deviation of the n values
    public double stddev() {
        return Math.sqrt(variance());
    }


    // test client
    public static void main(String[] args) { 
        OnePass dataset = new OnePass();
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
