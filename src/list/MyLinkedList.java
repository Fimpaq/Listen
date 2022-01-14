package list;

public class MyLinkedList<T> implements MyList<T> {
	private static class Node<T> {
		public T element;
		public Node<T> next;
		public Node<T> previous;

		public Node(final T element) {
			this.element = element;
		}
	}

	private Node<T> lastNode;
	private Node<T> firstNode;
	private int size = 0;

	public MyLinkedList() {
	}

	@SuppressWarnings("unchecked")
	public MyLinkedList(final T... elements) {
		for (T element : elements) {
			add(element);
		}
	}

	public int getSize() {
		return this.size;
	}

	private Node<T> getInternal(final int idx) {
		Node<T> found = this.firstNode;
		int middle = this.size / 2;
		if (idx <= middle) {
			for (int i = 0; i < idx; i++) {
				found = found.next;
			}
		} else {
			int steps = this.size - idx;
			found = this.lastNode;
			for (int i = 0; i < steps - 1; i++) {
				found = found.previous;
			}
		}
		return found;
	}

	public T get(final int idx) {
		if (idx < 0 || idx > this.size - 1) {
			throw new IllegalArgumentException(String.format("index out of bounds: %s", idx));
		}
		return getInternal(idx).element;
	}

	public void add(T element) {
		final Node<T> node = new Node<>(element);
		if (this.size == 0) {
			this.firstNode = node;
			this.lastNode = node;
		} else {
			this.lastNode.next = node;
			node.previous = this.lastNode;
			this.lastNode = node;
		}
		++this.size;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(final T... elements) {
		for (T element : elements) {
			add(element);
		}
	}

	@Override
	public void addArray(T[] array) {
		for (T element : array) {
			add(element);
		}
	}

	@Override
	public T removeAt(int idx) {
		Node<T> found = getInternal(idx); // letztes element entfernen macht falsch
		if (idx == 0) {
			this.firstNode = firstNode.next;
			this.firstNode.previous = null;
		} else {
			if (found.equals(this.lastNode)) {
				found.previous.next = null;
				this.lastNode = found.previous;
			} else {
				found.previous.next = found.next;
				found.next.previous = found.previous;
			}
		}
		this.size--;
//		System.out.println("größe: " + this.size);
//		System.out.println("first: " + this.firstNode.element);
//		System.out.println("last: " + this.lastNode.element);

		return found.element;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Deleted remove(final T element) {
		int amount = 0;
		int i = 0;
		Node<T> found = this.firstNode;

		if (found.element.equals(element)) {
			amount++;
			removeAt(i);
		}

		while (found.next != null) {
			found = found.next;
			i++;
			if (found.element.equals(element)) {
				amount++;
				removeAt(i);
			}
		}
		return new Deleted(element, amount);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Deleted[] removeAll(T[] elements) {
		Deleted[] ret = new Deleted[elements.length];
		int i = 0;
		for (T value : elements) {
			ret[i] = remove(value);
			i++;
		}
		return ret;
	}

	@Override
	public void clear() {
		this.size = 0;
		this.firstNode = null;
	}

	@Override
	public void listToConsole() {
		Node<T> found = this.firstNode;
		while (found.next != null) {
			System.out.println(found.element);
			found = found.next;
		}
		System.out.println(found.element);
	}
}
