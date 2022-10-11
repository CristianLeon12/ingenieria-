public class Punto
{
    private double x, y;

    public Punto(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Punto(Punto p) {
        x = p.getX();
        y = p.getY();
    }

    public double getX() {
            return x;
    }
    
    public double getY() {
            return y;
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public String toString() {
        return String.format("(%6.2f,%6.2f )",x,y);
    }
}
