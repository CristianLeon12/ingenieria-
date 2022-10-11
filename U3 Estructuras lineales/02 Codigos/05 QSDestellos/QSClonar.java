public class QSClonar<E>
{
	public Queue<E> clonarQ(Queue<E> wS) {
		Queue<E> qWS = new Queue<E>();
		int tamaño = wS.size();
		for (int i = 1; i <= tamaño; i++) {
			qWS.enqueue(wS.peek());
			wS.enqueue(wS.dequeu());
		}
		return qWS;
	}
	
	public Stack<E> clonarS(Stack<E> sS) {
		Stack<E> sWS = new Stack<E>();
		Stack<E> tmp = new Stack<E>();
		int tamaño = sS.size();
		for (int i = 1; i <= tamaño; i++)
			tmp.push(sS.pop());
		for (int i = 1; i <= tamaño; i++) {
			sWS.push(tmp.peek());
			sS.push(tmp.pop());
		}
		return sWS;
	}
}
