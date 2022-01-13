package list;

public interface MyList<T> {

	public void listToConsole();
	public int getSize();	
	public T get(final int idx);
	
	public void add(final T element);
	public void add(@SuppressWarnings("unchecked") final T... elements);
	public void addArray(final T[] array);	
	
	public T removeAt(final int idx);	
	public Deleted<?> remove(final T element);	
	public Deleted<?>[] removeAll(final T[] elements);	
	
	public void clear();
}
