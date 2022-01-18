package list;

import java.util.Comparator;

public interface MyList<T> {

	public void listToConsole();

	public int getSize();

	public T get(final int idx);

	public void add(final T element);

	public void add(@SuppressWarnings("unchecked") final T... elements);

	public void addArray(final T[] array);

	public T removeAt(final int idx);

	@SuppressWarnings("rawtypes")
	public Deleted remove(final T element);

	@SuppressWarnings("rawtypes")
	public Deleted[] removeAll(final T[] elements);

	public void clear();
	
	public void set(final T element, final int idx);
}

class ListUtils {	
	public static <T extends Comparable> void sort(final MyList<T> l) {

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> void sort(final MyList<T> l, final Comparator cmp) {
		boolean sorted = false;
	    T tmp;
	    while(!sorted) {
	        sorted = true;
	        for (int i = 0; i < l.getSize() - 1; i++) {
	            if (cmp.compare(l.get(i), l.get(i+1)) > 0) {
	                tmp = l.get(i);
	                l.set(l.get(i+1), i);
	                l.set(tmp, i+1);
	                sorted = false;
	            }
	        }
	    }
	    System.out.println("sortiert");
	}

	public static <T> void shuffle(final MyList<T> l) {

	}
}
