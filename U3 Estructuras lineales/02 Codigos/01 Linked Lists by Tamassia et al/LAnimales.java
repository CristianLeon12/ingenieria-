public class LAnimales
{
    public static void main(String[] args) {
        SinglyLinkedList<Animal> a = new SinglyLinkedList();
        
        Animal an = new Animal("Leon");
        a.addFirst(an);
               an = new Animal("Cigüeña");
        a.addFirst(an);
               an = new Animal("Rana");        
        a.addFirst(an);
               an = new Animal("Burro");
        a.addFirst(an);
        
               an = new Animal("Elefante");
        a.addLast(an);
               an = new Animal("Tiburón");
        a.addLast(an);
        
        System.out.println("# nodos: " + a.size());
        System.out.println(a);
        
        System.out.println();
        
        a.removeFirst();
        System.out.println("# nodos: " + a.size());
        System.out.println(a);
		
    }
}
/**
*	a -> Burro -> Rana - > Cigüeña -> Leon -> Elefante -> Tiburón -> null
*   a -> Rana - > Cigüeña -> Leon -> Elefante -> Tiburón -> null
*/
