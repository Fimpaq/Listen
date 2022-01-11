// wenn arrayGröße nicht reicht, soll die größe um 50% erhöht werden
package list;

public class MyArrayList<T> implements MyList<T> {
	private T[] array;
	private int size = 0; // amount of elements in array	
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.array = (T[])new Object[10];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(final int length) {
		this.array = (T[])new Object[length];
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(final T... array) {
		this.array = (T[])new Object[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		this.size = array.length;
	}

	public T[] getArray() {
		return this.array;
	}

	@Override
	public int getSize() {
		return this.size;
	}

	@Override
	public T get(final int idx) {
		if (idx >= 0 && idx < this.size) {
			return this.array[idx];
		}
		throw new IllegalArgumentException(String.format("index out of range: %s", idx));
	}
	
	@SuppressWarnings("unchecked")
	private void checkSize(final int n) { // für add / addAll
		if ((this.size + n) > this.array.length) {
			int al = this.array.length;
			while ((this.size + n) > al) {
				al += (al / 2);
			}
			final T[] tmp = (T[])new Object[al];
			for (int i = 0; i < this.size; ++i) {
				tmp[i] = this.array[i];
			}
			this.array = tmp;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(final T... values) {
		checkSize(values.length);

		int i = this.size;
		for (T value : values) {
			this.array[i] = value;
			i++;
		}
		this.size = i;
	}

	@Override
	public void addArray(final T[] array) {
		checkSize(array.length);

		int i = this.size;

		for (T value : array) {
			this.array[i] = value;
			i++;
		}
		this.size = i;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Deleted remove(final T value) {
		int gefunden = 0;
		int tmpSize = this.size; 
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(value)) {
				gefunden++;
				tmpSize--;
			}
		}

		
		T[] tmp = (T[])new Object[this.array.length - gefunden];
		for (int i = 0, j = 0; i < this.size; i++, j++) {
			if (!array[i].equals(value)) {
				tmp[j] = array[i];
			} else {
				j--;
			}
		}
		this.size = tmpSize;
		this.array = tmp;
		return new Deleted(value, gefunden);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeAt(final int idx) {
		
		T ret = (T)new Object();
		
		T[] tmp = (T[])new Object[this.array.length - 1];
		for (int i = 0, j = 0; i < this.size; i++, j++) {
			if (this.array[i] != array[idx]) {
				tmp[j] = this.array[i];
			} else {
				j--;
				ret = array[idx];
			}
		}
		this.array = tmp;
		this.size -= 1;
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] removeAll(final T[] values) {
		int gefunden = 0;
		for (T value : values) {
			for (int i = 0; i < this.size; i++) {
				if (array[i].equals(value)) {
					gefunden++;
				}
			}
		}

		
		T[] ret = (T[])new Object[gefunden];
		int j = 0;
		for (T val : values) {
			for (int i = 0; i < this.size; i++) {
				if (val == this.array[i]) {
					ret[j] = val;
					j++;
				}
			}
			remove(val);
		}
		return ret;
	}

	@Override
	public void clear() {
		this.size = 0;
	}

	// sortieren ------------------------------------
//	public void sortArray() {
//		mergeSort(this.array);
//
//		int[] tmp = new int[this.array.length];
//
//		int i = 0;
//		for (int num : this.array) {
//			if (num != 0) {
//				tmp[i] = num;
//				i++;
//			}
//		}
//		this.array = tmp;
//	}
//
//	private void mergeSort(final int[] input) {
//		int startLength = input.length;
//
//		if (startLength < 2) {
//			return;
//		}
//
//		int middel = startLength / 2;
//		int[] leftArray = new int[middel];
//		int[] rightArray = new int[startLength - middel];
//
//		for (int i = 0; i < middel; i++) {
//			leftArray[i] = input[i];
//		}
//		for (int i = middel, j = 0; i < startLength; i++, j++) {
//			rightArray[j] = input[i];
//		}
//
//		mergeSort(leftArray);
//		mergeSort(rightArray);
//
//		merge(input, rightArray, leftArray);
//	}
//
//	private void merge(final int[] input, final int[] rightArray, final int[] leftArray) {
//		int leftLength = leftArray.length;
//		int rightLength = rightArray.length;
//
//		int i = 0, j = 0, k = 0;
//
//		while (i < leftLength && j < rightLength) {
//			if (leftArray[i] <= rightArray[j]) {
//				input[k] = leftArray[i];
//				i++;
//			} else {
//				input[k] = rightArray[j];
//				j++;
//			}
//			k++;
//		}
//
//		while (i < leftLength) {
//			input[k] = leftArray[i];
//			i++;
//			k++;
//		}
//		while (j < rightLength) {
//			input[k] = rightArray[j];
//			j++;
//			k++;
//		}
//	}
//
//	public void simpleSortArray() {
//		int a;
//		for (int z = 0; z < this.array.length; z++) {
//			for (int i = 0; i < this.array.length - 1; i++) {
//				if (array[i] > array[i + 1] && array[i + 1] != 0) {
//					a = array[i];
//					array[i] = array[i + 1];
//					array[i + 1] = a;
//				}
//			}
//		}
//	}
}
