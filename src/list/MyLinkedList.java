package list;

public class MyLinkedList<T> implements MyList<T> {

	private static class Node<T> {
		public T element;
		public Node<T> next;

		public Node(final T element) {
			this.element = element;
		}
	}

	private Node<T> node;
	private int size = 0;
	
	public MyLinkedList() {}
	
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
	
	public void add(T element) {
		final Node<T> node = new Node<>(element);
		if (this.size == 0) {
			this.node = node;
		} else {
			getInternal(this.size - 1).next = node;
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
		Node<T> ret = this.node;
		if (idx == 0) {
			this.node = node.next;
			this.size--;
		} else {
			Node<T> beforeThat = this.node;
			for (int i = 0; i < idx - 1; ++i) {
				beforeThat = beforeThat.next;
			}
			
			for (int i = 0; i < idx; i++) {
				ret = ret.next;
			}
			
			Node<T> afterThat = this.node;
			for (int i = 0; i <= idx; ++i) {
				afterThat = afterThat.next;
			}
			beforeThat.next = afterThat;
			this.size--;
		}
		return ret.element;
	}	
	
	@SuppressWarnings({"unchecked", "rawtypes"})
	@Override
	public Deleted remove(final T element) {
		int amount = 0;
		int i = 0;
		Node<T> found = this.node;
		
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
		this.node = null;
	}

	@Override
	public void listToConsole() {
		Node<T> found = this.node;
		while (found.next != null) {
			System.out.println(found.element);
			found = found.next;
		}
		System.out.println(found.element);
	}
}
