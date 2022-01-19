package list;

import java.util.Comparator;
import java.util.Random;

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

	public static <T extends Comparable<T>> void sort(final MyList<T> l) {
		sort(l, null);
		System.out.println("sortiert");
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

	public static <T extends Comparable<T>> void mergeSort(final MyList<T> list) {
		divide(0, list.getSize() - 1, list);
	}

	private static <T extends Comparable<T>> void divide(final int startIndex, final int endIndex, final MyList<T> list) {

		if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
			int mid = (endIndex + startIndex) / 2;
			divide(startIndex, mid, list);
			divide(mid + 1, endIndex, list);

			merger(startIndex, mid, endIndex, list);
		}
	}

	private static <T extends Comparable<T>> void merger(final int startIndex, final int midIndex, final int endIndex,
			final MyList<T> list) {
		MyList<T> mergedSortedArray = new MyArrayList<>();

		int leftIndex = startIndex;
		int rightIndex = midIndex + 1;

		while (leftIndex <= midIndex && rightIndex <= endIndex) {
//			if ((list.get(leftIndex)).compareTo(list.get(rightIndex)) <= 0) { // if (list.get(leftIndex) <= list.get(rightIndex)) {
			if (doCompare(list.get(leftIndex), list.get(rightIndex), null) <= 0) {
				mergedSortedArray.add(list.get(leftIndex));
				leftIndex++;
			} else {
				mergedSortedArray.add(list.get(rightIndex));
				rightIndex++;
			}
		}

		while (leftIndex <= midIndex) {
			mergedSortedArray.add(list.get(leftIndex));
			leftIndex++;
		}

		while (rightIndex <= endIndex) {
			mergedSortedArray.add(list.get(rightIndex));
			rightIndex++;
		}

		int i = 0;
		int j = startIndex;

		while (i < mergedSortedArray.getSize()) {
			list.set(mergedSortedArray.get(i++), j);
			j++;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static int doCompare(final Object lhs, final Object rhs, final Comparator<Object> cmp) { // comparator
		return cmp != null ? cmp.compare(lhs, rhs) : ((Comparable) lhs).compareTo(rhs);
	}
}
