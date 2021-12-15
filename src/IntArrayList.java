import java.util.Iterator;

public class IntArrayList {
	private int[] array;
	private int size;

	public IntArrayList() {
		this.size = 0;
	}

	public IntArrayList(final int size) {
		this.size = size;
	}

	public IntArrayList(final int[] array) {
		this.array = array;
		this.size = array.length;
	}

	public IntArrayList(final Integer... z) {
		final int[] ia = new int[z.length];
		for (int i = 0; i < z.length; i++) {
			ia[i] = z[i];
		}
		this.array = ia;
		this.size = z.length;
		
	}

	public int[] getArray() {
		return this.array;
	}

	public int getSize() {
		return this.size;
	}

	// ------------- Aufgabe 4
	public void add(final int value) {
		int[] ia = new int[array.length + (array.length / 2)];
		for (int i = 0; i < array.length; i++) {
			ia[i] = array[i];
		}
		ia[array.length] = value;
		this.array = ia;
		this.size = ia.length;
	}

	public void addAll(final int[]... values) {
		int i = this.size;
				
		for (int[] arr : values) {
			this.size += arr.length;
		}
		
		int[] ia = new int[this.size];
		for (int j = 0; j < this.array.length; j++) {
			ia[j] = this.array[j];
		}
		
		for (int[] arr : values) {
			for (int zahl : arr) {
					ia[i] = zahl;
					i++;
			}
		}		
		this.array = ia;
	}

}
