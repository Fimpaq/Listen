package list;

public class IntArrayList {
	private Number[] array;
	private int size = 0; // amount of elements in array

	public IntArrayList() {
		this.array = new Number[10];
	}

	public IntArrayList(final int length) {
		this.array = new Number[length];
	}

//	public IntArrayList(final Integer[] array) { // var args and array = gleich?
//		this.array = new Integer[array.length];
//		for (int i = 0; i < array.length; i++) {
//			this.array[i] = array[i];
//		}
//		this.size = array.length;
//	}

	public IntArrayList(final Number... array) {
		this.array = new Number[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		this.size = array.length;
	}

	public Number[] getArray() {
		return this.array;
	}

	public int getSize() {
		return this.size;
	}

	public Number get(final int idx) {
		if (idx >= 0 && idx < this.size) {
			return this.array[idx];
		}
		throw new IllegalArgumentException(String.format("index out of range: %s", idx));
	}
	
	// ------------- Aufgabe 4 -----------------------
	// wenn arrayGröße nicht reicht, soll die größe um 50% erhöht werden

	private void checkSize(final int n) { // für add / addAll
		if ((this.size + n) > this.array.length) {
			int al = this.array.length;
			while ((this.size + n) > al) {
				al += (al / 2);
			}
			final Number[] tmp = new Number[al];
			for (int i = 0; i < this.size; ++i) {
				tmp[i] = this.array[i];
			}
			this.array = tmp;
		}
	}

	public void add(final Number... values) {
		checkSize(values.length);

		int i = this.size;
		for (Number value : values) {
			this.array[i] = value;
			i++;
		}
		this.size = i;
	}

	public void addArray(final Number[] array) {
		checkSize(array.length);

		int i = this.size;

		for (Number value : array) {
			this.array[i] = value;
			i++;
		}
		this.size = i;
	}

	public Number remove(final Number value) {
		int gefunden = 0; // das array wird um die anzahl der entferten elemte verkleinert / weglassen?
		int tmpSize = this.size; 
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(value)) {
				gefunden++;
				tmpSize--;
			}
		}

		Number[] tmp = new Number[this.array.length - gefunden];
		for (int i = 0, j = 0; i < this.size; i++, j++) {
			if (!array[i].equals(value)) {
				tmp[j] = array[i];
			} else {
				j--;
			}
		}
		this.size = tmpSize;
		this.array = tmp;
		return gefunden;
	}

	public Number removeAt(final int idx) {
		Number ret = 0;
		Number[] tmp = new Number[this.array.length - 1];
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


	public Number[] removeAll(final Number[] values) {
		int gefunden = 0;
		for (Number value : values) {
			for (int i = 0; i < this.size; i++) {
				if (array[i].equals(value)) {
					gefunden++;
				}
			}
		}

		Number[] ret = new Number[gefunden];
		int j = 0;
		for (Number val : values) {
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
