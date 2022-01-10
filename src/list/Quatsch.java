package list;


public class Quatsch<T> {

	public static void main(String[] args) {
		Quatsch q = new Quatsch();
		q.add(5);
		System.out.println(q.getSize());

	}
	
	public int getSize() {
		return this.size;
	}

	private static class Node<T> {
		public T element;
		public Node<T> next;

		public Node(final T element) {
			this.element = element;
		}
	}

	private Node<T> first;
	private int size = 0;
	
	public void add(final T element) {
		// create new Node to hold element 
		final Node<T> node = new Node<>(element);
		if(this.size == 0) {
			this.first = node;
		} else {
			// connect to predecessor
			getInternal(this.size).next = node;
		}
		
		// increase size
		++this.size;
	}
	
	private Node<T> getInternal(final int idx) {
		Node<T> found = this.first;
		for(int i = 0; i < idx; ++i) {
			found = found.next;
		}
		return found;
	}
	
	public T get(final int idx) {
		if(idx < 0 || idx > this.size-1) {
			throw new IllegalArgumentException(String.format("index out of bounds: %s", idx));
		}
		return getInternal(idx).element;
	}
	
	
}
