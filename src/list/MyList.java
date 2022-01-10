package list;

public interface MyList<T> {

	public int getSize();
	
	public T get(final int idx);
	
	@SuppressWarnings("unchecked")
	public void add(final T... values);	
	public void addArray(final T[] array);	
	
	public int remove(final T value);	
	public T removeAt(final int idx);	
	public T[] removeAll(final T[] values);	
	
	public void clear();
}
