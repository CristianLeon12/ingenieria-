/******************************************************************************
 *  Compilation:  javac PointPolar.java
 *  Execution:    java PointPolar
 *
 *  Implementation of 2D point using polar coordinates.
 *
 ******************************************************************************/

public final class PointPolar {
    private final double r;
    private final double theta; 
   
    // constructor
    PointPolar() {
        double x = StdRandom.uniform(0.0, 1.0);
        double y = StdRandom.uniform(0.0, 1.0);
        r = Math.sqrt(x*x + y*y); 
        theta = Math.atan2(y, x);
    }

    PointPolar(double x, double y) {
        r = Math.sqrt(x*x + y*y); 
        theta = Math.atan2(y, x);
    }

    double r()     { return r;                 }
    double theta() { return theta;             }
    double x()     { return r*Math.cos(theta); }
    double y()     { return r*Math.sin(theta); }

    double distanceTo(PointPolar that) {
        double dx = this.x() - that.x();
        double dy = this.y() - that.y();
        return Math.sqrt(dx*dx + dy*dy);
    }

    public String toString()  { return "(" + x() + ", " + y() + ")"; } 



    // test client
    public static void main(String[] args) {
        PointPolar p = new PointPolar();
        StdOut.println("p  = " + p);
        StdOut.println("   x     = " + p.x());
        StdOut.println("   y     = " + p.y());
        StdOut.println("   r     = " + p.r());
        StdOut.println("   theta = " + p.theta());
        StdOut.println();

        PointPolar q = new PointPolar(0.5, 0.5);
        StdOut.println("q  = " + q);
        StdOut.println("dist(p, q) = " + p.distanceTo(q));
    }
}
