package list;
public class MyLinkedList<T> implements MyList<T> {

	private int size = 0; // amount of elements in array	
	
	

	
	public MyLinkedList() {
	}
	
	@SuppressWarnings("unchecked")
	public MyLinkedList(final int length) {
		this.array = (T[])new Object[length];
	}
	
	@SuppressWarnings("unchecked")
	public MyLinkedList(final T... array) {
		this.array = (T[])new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		this.size = array.length;
	}
	

	@Override
	public T[] getArray() {
		return this.array;
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	@Override
	public void clear() {
		this.size = 0;
	}

	
	
	
	@Override
	public T get(int idx) {
		
	}

	@Override
	public void add(T... values) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addArray(T[] array) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int remove(T value) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T removeAt(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T[] removeAll(T[] values) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
