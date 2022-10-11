public class QFibonacci
{
    public static void main(String[] args) {
        Queue<Long> q = new Queue<Long>();
        Queue<Long> s = new Queue<Long>();
        
        q.enqueue(0L);
        q.enqueue(1L);
        
        System.out.println("Cálculo de #s de Fibonacci:\n");
        for (int i = 0; i <= 59; i++) {
            long a = q.dequeu();
            long b = q.dequeu();
            q.enqueue(b);
            q.enqueue(a + b);
            System.out.printf("%3d %,15d%n",i,a);
            s.enqueue(a);
        }
        
		int t = s.size();
        System.out.println("\nTamaño de la cola: " + t);
        System.out.println("\nContenido de la cola:");
		for (int i = 1; i <= t; i++) {				
			System.out.print(String.format("%,15d ",s.dequeu()));
			if (i % 10 == 0)
				System.out.println();
		}
		System.out.println();
    }
}
