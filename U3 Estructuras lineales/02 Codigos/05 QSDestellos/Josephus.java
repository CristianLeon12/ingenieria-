/******************************************************************************
 *  Compilation:  javac Josephus.java
 *  Execution:    java Josephus m n
 *  Dependencies: Queue.java
 *
 *  Solves the Josephus problem.
 *
 *  % java Josephus 5 9
 *  5 1 7 4 3 6 9 2 8 
 *
 ******************************************************************************/

public class Josephus {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // initialize the queue
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 1; i <= n; i++)
            queue.enqueue(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m-1; i++)
                queue.enqueue(queue.dequeu());
            System.out.print(queue.dequeu() + " ");
        } 
        System.out.println();
    }
}
