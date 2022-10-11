/**
 * A basic stack implementation.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class Stack<E>
{
  //---------------- nested Node class ----------------
  /**
   * Node of a stack, which stores a reference to its
   * element and to the subsequent node in the stack (or null if this
   * is the last node).
   */
  private static class Node<E> {

    /** reference to the element stored at this node */
    private E element;

    /** A reference to the subsequent node in the stack */
    private Node<E> next;

    /**
     * Creates a node with the given element and next node.
     *
     * @param e  the element to be stored
     * @param n  reference to a node that should follow the new node
     */
    public Node(E e, Node<E> n) {
      element = e;
      next = n;
    }

    /** Accessor methods
     * @return the element stored at the node
     */
    public E getElement() { return element; }

    /**
     * Returns the node that follows this one (or null if no such node).
     * @return the following node
     */
    public Node<E> getNext() { return next; }

    /** Modifier methods
     * Sets the node's next reference to point to Node n.
     * @param n    the node that should follow this one
     */
    public void setNext(Node<E> n) { next = n; }
  } /**----------- end of nested Node class ----------- */

  /** instance variables of the Stack */
  
  /** head node (top) of the stack (or null if empty) */
  private Node<E> head = null;

  /** Number of nodes in the stack */
  private int size = 0;

  /** Constructs an initially empty stack. */
  public Stack() {}

  /**
   * access methods
   * @return number of elements in the stack
   */
  public int size() { return size; }

  /**
   * Tests whether the stack is empty.
   * @return true if the stack is empty, false otherwise
   */
  public boolean isEmpty() { return size == 0; }

  /**
   * Returns (but does not remove) the element top of the stack
   * @return element at the tope of the stack (or null if empty)
   */
  public E peek() {
    if (isEmpty()) return null;
    return head.getElement();
  }

  /**
   * update methods
   * Adds an element to the top of the stack.
   * @param e  the new element to add
   */
  public void push(E e) {
    head = new Node<>(e, head);
    size++;
  }

  /**
   * Removes and returns the element top of the list.
   * @return the removed element (or null if empty)
   */
  public E pop() {
	/** nothing to remove */
    if (isEmpty()) return null;
    E answer = head.getElement();
	/** will become null if list had only one node */
    head = head.getNext();
    size--;
    return answer;
  }
}
