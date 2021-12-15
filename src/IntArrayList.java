import java.util.Iterator;

public class IntArrayList {
	private int[] array;
	private int size = 0; // amount of elements in array

	public IntArrayList() {

	}

	public IntArrayList(final int size) {
		this.array = new int[size];
	}

	public IntArrayList(final int[] array) {
		this.array = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		this.size = array.length;
	}

	public IntArrayList(final Integer... array) {
		this.array = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			this.array[i] = array[i];
		}
		this.size = array.length;
	}

	public int[] getArray() {
		return this.array;
	}

	public int getSize() {
		return this.size;
	}

	// ------------- Aufgabe 4 -----------------------
	// wenn arrayGröße nicht reicht, soll die größe um 50% erhöht werden

	private void checkSize(final int n) {  // für add / addAll
		if ((this.size + n) > this.array.length) {
			int al = this.array.length;
			while ((this.size + n) > al) {
				al += (al / 2);
			}
			final int[] tmp = new int[al];
			for (int i = 0; i < this.size; ++i) {
				tmp[i] = this.array[i];
			}
			this.array = tmp;
		}
	}
	
	public void add(final int... values) {
		checkSize(values.length);

		int i = this.size;
		for (int value : values) {
			this.array[i] = value;
			i++;
		}
		this.size = i;
	}

	public void addAll(final int[]... arrays) {
		for (int[] array : arrays) {
			checkSize(array.length);

			int i = this.size;

			for (int value : array) {
				this.array[i] = value;
				i++;
			}
			this.size = i;
		}
	}	

	public int remove(final int value) { 
		int gefunden = 0; 		// das array wird um die anzahl der entferten elemte verkleinert / weglassen?
		for (int i = 0; i < this.size; i++) {
			if (array[i] == value) {
				gefunden++;
				this.size--;
			}
		}
		
		int[] tmp = new int[this.array.length - gefunden];
		for (int i = 0, j = 0; i < this.size; i++, j++) {
			if (array[i] != value) {
				tmp[j] = array[i];
			} else {
				j--;
			}
		}
		this.array = tmp;
		return gefunden;
	}
	
	public int removeAt(final int idx) {
		int ret = 0;
		int[] tmp = new int[this.array.length - 1];
		for(int i = 0; i < this.size; i++) {
			if(this.array[i] != array[idx] ) {
				tmp[i] = this.array[i];
			} else {
				ret = array[idx];
			}
		}
		this.array = tmp;
		this.size -= 1;
		return ret;		
	}

	public int removeAll(final int[] values) { // hier 
		return 0;
	}

}
