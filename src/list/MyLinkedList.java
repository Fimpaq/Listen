package list;

public class MyLinkedList<T> implements MyList<T> {

	public static void main(String[] args) {
		MyLinkedList q = new MyLinkedList();
		q.add(5, 11);
		q.add(10);
		System.out.println("listenGöße: " + q.getSize());

		System.out.println("Element 1: " + q.get(0));
		System.out.println("Element 2: " + q.get(1));
		System.out.println("Element 3: " + q.get(2));

		
		System.out.println("Entferne: " + q.remove(10));

		for (int i = 0; i < q.getSize(); i++) {
			System.out.println("Element " + i + ": " + q.get(i));
		}

		System.out.println("neue Größe: " + q.getSize());
	}

	private static class Node<T> {
		public T element;
		public Node<T> next;

		public Node(final T element) {
			this.element = element;
		}
	}

	private Node<T> node;
	private int size = 0;

	public int getSize() {
		return this.size;
	}

	private Node<T> getInternal(final int idx) {
		Node<T> found = this.node;
		for (int i = 0; i < idx; ++i) {
			found = found.next;
		}
		return found;
	}

	public T get(final int idx) {
		if (idx < 0 || idx > this.size - 1) {
			throw new IllegalArgumentException(String.format("index out of bounds: %s", idx));
		}
		return getInternal(idx).element;
	}

	@Override
	public void add(final T... elements) {
		addArray(elements);
	}

	@Override
	public void addArray(T[] array) {
		for (T element : array) {
			final Node<T> node = new Node<>(element);
			if (this.size == 0) {
				this.node = node;
			} else {
				getInternal(this.size - 1).next = node;
			}
			++this.size;
		}
	}

	@Override
	public T removeAt(int idx) {
		if (idx == 0) {
			this.node = node.next;
			this.size--;
		} else {
			Node<T> beforeThat = this.node;
			for (int i = 0; i < idx - 1; ++i) {
				beforeThat = beforeThat.next;
			}
			Node<T> afterThat = this.node;
			for (int i = 0; i <= idx; ++i) {
				afterThat = afterThat.next;
			}
			beforeThat.next = afterThat;
			this.size--;
		}

		return null;
//		return afterThat.element;
	}

	@Override
	public int remove(T value) { // gibt anzahl entfernter elemente zurück
		int ret = 0;
		int i = 0;
		Node<T> found = this.node;
		
		if (found.element.equals(value)) {
			ret++;
			removeAt(i);
		}
		
		while (found.next != null) {
			found = found.next;
			i++;
			if (found.element.equals(value)) {
				ret++;
				removeAt(i);
			}		
		
		}
		return ret;
	}

	@Override
	public T[] removeAll(T[] values) {
		for(T value : values) {
			remove(value);
		}
		return null;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.node = null;
	}
}
