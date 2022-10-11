import java.util.Random;

public class Stats
{
    private static final Random RANDOM = new Random();
    
    public static void main(String[] args)
    {
        show("java.version");
        show("java.vm.name");
        show("java.vm.version");
        show("java.vm.info");
        System.out.println("\n #c      nanosegs   milisegs");
        
        int n           = Integer.parseInt(args[0]);
        int veces       = Integer.parseInt(args[1]);
        double delta0   = 1;
        
        for (int repeat = 0; repeat < veces; repeat++)
        {
            long t1     = System.nanoTime();
            long t1m    = System.currentTimeMillis();
            calculo(n);
            long t2     = System.nanoTime();
            long t2m    = System.currentTimeMillis();
            long delta  = t2 -t1;
            long delta2 = t2m - t1m;
            
            if (delta > delta0)
            {
                if ((delta -delta0) / delta0 > 2)
                {
                    System.out.printf("%4d: %, 12d %, 10d%n", repeat, delta, delta2);
                    delta0 = delta;
                }
            }
            else {
                if ((delta0 - delta) / delta > 2)
                {
                    System.out.printf("%4d: %, 12d %, 10d%n", repeat, delta, delta2);
                    delta0 = delta;
                }
            }
        }
    }
    
    private static void show(String property)
    {
        System.out.println(property + ": " + System.getProperty(property));
    }
    
    private static void calculo(int n)
    {
        double sx  = 0;
        double sx2 = 0;
        for (int i = 0; i < n; i++)
        {
            double x = RANDOM.nextGaussian();
            sx  += x;
            sx2 += x * x;
        }
        double media      = sx / n;
        double desviacion = Math.sqrt(sx2 / n - media * media);
        if (Math.abs(media) > 0.5 || Math.abs(desviacion - 1) > 0.5)
            System.out.printf("media: %f; desviacion= %f%n", media, desviacion);
    }
    
}