// wenn arrayGröße nicht reicht, soll die größe um 50% erhöht werden
package list;

public class MyArrayList<T> implements MyList<T> {
	private T[] array;
	private int size = 0; // amount of elements in array

	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.array = (T[]) new Object[10];
	}

	@SuppressWarnings("unchecked")
	public MyArrayList(final int length) {
		this.array = (T[]) new Object[length];
	}

	@SuppressWarnings("unchecked")
	public MyArrayList(final T... elements) {
		int elementsLength = elements.length;
		this.array = (T[]) new Object[elementsLength];
		System.arraycopy(elements, 0, this.array, this.size, elementsLength);
		this.size += elementsLength;
	}

	@Override
	public void listToConsole() {
		for (int i = 0; i < this.size; i++)
			System.out.println(array[i]);
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
	@Override
	public void add(final T element) {
		int arrayLength = this.array.length;
		if ((this.size + 1) > arrayLength) {
			arrayLength += (arrayLength / 2);

			final T[] tmp = (T[]) new Object[arrayLength];
			for (int i = 0; i < this.size; ++i) {
				tmp[i] = this.array[i];
			}
			this.array = tmp;
		}
		this.array[this.size] = element;
		this.size++;
	}

	@SuppressWarnings("unchecked")
	private void checkSize(final int n) { // für array hinzufügen
		if ((this.size + n) > this.array.length) {
			int al = this.array.length;
			while ((this.size + n) > al) {
				al += (al / 2);
			}
			final T[] tmp = (T[]) new Object[al];
			System.arraycopy(tmp, 0, this.array, 0, this.size);
			this.array = tmp;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void add(final T... elements) {
		int elementsLength = elements.length;
		checkSize(elementsLength);
		System.arraycopy(elements, 0, this.array, this.size, elementsLength);
		this.size += elementsLength;
	}

	@Override
	public void addArray(final T[] elements) {
		int elementsLength = elements.length;
		checkSize(elementsLength);
		System.arraycopy(elements, 0, this.array, this.size, elementsLength);
		this.size += elementsLength;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T removeAt(final int idx) {
		T element = get(idx);

		T[] tmp = (T[]) new Object[this.array.length - 1];

		System.arraycopy(this.array, (idx + 1), this.array, idx, (this.size - idx));

		this.array = tmp;
		this.size -= 1;
		return element;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Deleted remove(final T element) {
		int gefunden = 0;
		for (int i = 0; i < this.size; i++) {
			if (array[i].equals(element)) {
				gefunden++;
				removeAt(i);
			}
		}
		return new Deleted(element, gefunden);
	}

	@SuppressWarnings({ "rawtypes" })
	@Override
	public Deleted[] removeAll(final T[] elements) {
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
	}

	@Override
	public void set(T element, int idx) {
		this.array[idx] = element;		
	}

}
