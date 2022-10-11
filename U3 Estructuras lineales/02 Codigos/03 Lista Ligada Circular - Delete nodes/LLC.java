/** Implementacion de una lista ligada circular (LLC) */

class LLC
{
    private static class Node
    {
        int data;
        Node next;
    }
    
    /** Insertar un nodo al inicio de la lista */
    private Node push(Node head_ref, int data) {
        /** Crear un nuevo nodo y establecerlo como head */
        Node ptr1 = new Node();
        ptr1.data = data;
        ptr1.next = head_ref;

        /** Si la lista no es null entonces poner el next del ultimo nodo */
        if (head_ref != null) {
            /** Encontrar el nodo anterior a head y actualizar su referencia a next */ 
            Node temp = head_ref;
            while (temp.next != head_ref)
                temp = temp.next;
            temp.next = ptr1;
        }
        else
            /** para el primer nodo */
            ptr1.next = ptr1;

        head_ref = ptr1;
        System.out.println("ptr1 -> " + ptr1.data + ", head_ref -> " + head_ref.data +
                           ", head_ref.next -> " + head_ref.next.data);
        return head_ref; 
    }

    /** Imprimir los nodos */
    private void printList(Node head) {
        Node temp = head;
        if (head != null) {
            do {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            } while (temp != head);
        }

        System.out.printf("\n");
    }

    /** Eliminar un nodo dado */
    private Node deleteNode(Node head, int key)
    {
        if (head == null)
            return null;

        /** Encontrar el nodo requerido */
        Node curr = head, prev = new Node();
        while (curr.data != key) {
            if (curr.next == head) {
                System.out.printf("Nodo dado no esta en la lista%n");
                return head;
            }

            prev = curr;
            curr = curr.next;
        }

        /** Checar si el nodo es unico */
        if (curr.next == head) {
            head = null;
            return head;
        }

        /** Si hay mas de un nodo, checar si es el primero */
        if (curr == head) {
            prev = head;
            while (prev.next != head)
                prev = prev.next;
            head = curr.next;
            prev.next = head;
        }
        /** checar si es el ultimo node */ 
        else
            if (curr.next == head) {
                prev.next = head;
            }
            else {
                prev.next = curr.next;
            }
        return head;
    }
    
    /** Driver para probar las funciones */
    public static void main(String args[]) {
        /** Iniciar con una lista vacia */
        LLC l = new LLC();
        Node head = null;

        /** La lista creada sera 2,5,7,8,10 */
        head = l.push(head, 1);
        head = l.push(head, 3);
        head = l.push(head, 5);
        head = l.push(head, 7);
        head = l.push(head, 9);

        System.out.printf("\n\nLista original%n");
        l.printList(head);
                
        System.out.printf("\nLista despues de eliminar el nodo 9%n");
        head = l.deleteNode(head, 9);
        l.printList(head);
        
        System.out.printf("\nLista despues de eliminar el nodo 9%n");
        head = l.deleteNode(head, 9);
        l.printList(head);
        
        System.out.printf("\nLista despues de eliminar el nodo 5%n");
        head = l.deleteNode(head, 5);
        l.printList(head);
        
        System.out.printf("\nLista despues de eliminar el nodo 1%n");
        head = l.deleteNode(head, 1);
        l.printList(head);
    }
}
