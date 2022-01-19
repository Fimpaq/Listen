package list;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;

import de.impaq.german_names.RandomName;

public interface MyList<T> {

	public void listToConsole();
	public int getSize();
	public T get(final int idx);
	public void add(final T element);
	@SuppressWarnings("unchecked")
	public void add(final T... elements);
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
	public static <T extends Comparable<T>> void sort(final MyList<T> l) {		
		sort(l, null);
		System.out.println("sortiert");
	}
	
	private static int doCompare(final Object lhs, final Object rhs, final Comparator<Object> cmp) {
		return cmp != null ? cmp.compare(lhs, rhs) : ((Comparable)lhs).compareTo(rhs);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <T> void sort(final MyList<T> l, final Comparator cmp) {
		boolean sorted = false;
		T tmp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < l.getSize() - 1; i++) {
				if (doCompare(l.get(i), l.get(i + 1), cmp) > 0) {
					tmp = l.get(i);
					l.set(l.get(i + 1), i);
					l.set(tmp, i + 1);
					sorted = false;
				}
			}
		}
		System.out.println("sortiert");
	}
	

	public static <T extends Comparable<T>> void mSort(final MyList<T> l) {
		T[] array = (T[]) new Object[l.getSize()];
		for(int i=0; i<l.getSize(); i++) {
			array[i] = l.get(i);
		}		
		
		mergeSort(array);
	}
	
	private static <T extends Comparable<T>> void mergeSort(final T[] array) {
			int startLength = array.length;

			if (startLength < 2) {
				return;
			}

			int middel = startLength / 2;
			T[] leftArray = (T[])new Object[middel];
			T[] rightArray = (T[])new Object[startLength - middel];

			for (int i = 0; i < middel; i++) {
				leftArray[i] = array[i];
			}
			for (int i = middel, j = 0; i < startLength; i++, j++) {
				rightArray[j] = array[i];
			}

			mergeSort(leftArray);
			mergeSort(rightArray);

			merge(array, rightArray, leftArray);
		}

		private static <T extends Comparable<T>> void merge(final T[] input, final T[] rightArray, final T[] leftArray) {
			int leftLength = leftArray.length;
			int rightLength = rightArray.length;

			int i = 0, j = 0, k = 0;

			while (i < leftLength && j < rightLength) {
				if ((leftArray[i]).compareTo(rightArray[j]) <= 0) {  // compareTo irgentwie
					input[k] = leftArray[i];
					i++;
				} else {
					input[k] = rightArray[j];
					j++;
				}
				k++;
			}

			while (i < leftLength) {
				input[k] = leftArray[i];
				i++;
				k++;
			}
			while (j < rightLength) {
				input[k] = rightArray[j];
				j++;
				k++;
			}
		
	}

		public static <T> void shuffle(final MyList<T> l) {
			int size = l.getSize();
			Random random = new Random();
			
			for (int i = 0; i < l.getSize(); i++) {
				int newIdx = random.nextInt(size);
				T src = l.get(i);
				T target = l.get(newIdx);
				l.set(src, newIdx);
				l.set(target, i);
			}
			System.out.println("gemischt");
		}

	

}
