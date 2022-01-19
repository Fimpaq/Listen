package list;

import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.RandomAccess;

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

	private static int doCompare(final Object lhs, final Object rhs, final Comparator<Object> cmp) { // comparator
		return cmp != null ? cmp.compare(lhs, rhs) : ((Comparable) lhs).compareTo(rhs);
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


	
	public static <T extends Comparable<T>> void mergeSort(final MyList<T> list) { // mergeSort
		int startLength = list.getSize();

		if (startLength < 2) {
			return;
		}

		int middel = startLength / 2;
		MyList<T> leftArray = new MyArrayList<>();
		MyList<T> rightArray = new MyArrayList<>();

		for (int i = 0; i < middel; i++) {
			leftArray.set(list.get(i), i);
		}
		for (int i = middel, j = 0; i < startLength; i++, j++) {
			rightArray.set(list.get(i), j);
		}

		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(list, rightArray, leftArray);
		
	}

	private static <T extends Comparable<T>> void merge(final MyList<T> input, final MyList<T> rightArray, final MyList<T> leftArray) {
		int leftLength = leftArray.getSize();
		int rightLength = rightArray.getSize();

		int i = 0, j = 0, k = 0;

		while (i < leftLength && j < rightLength) {
			if (doCompare(leftArray.get(i), rightArray.get(j), null) <= 0) {
				input.set(leftArray.get(i), k);
				i++;
			} else {
				input.set(rightArray.get(j), k);
				j++;
			}
			k++;
		}

		while (i < leftLength) {
			input.set(leftArray.get(i), k);
			i++;
			k++;
		}
		while (j < rightLength) {
			input.set(rightArray.get(j), k);
			j++;
			k++;
		}
	}

	public static <T> void shuffle(final MyList<T> l) { // shuffle
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
