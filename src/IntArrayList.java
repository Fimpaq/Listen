
public class IntArrayList {
	private int[] array;
	private int size;
	
	
	public IntArrayList() {}
	
	public IntArrayList(int size) {
		this.size = size;
	}
	
	public IntArrayList(final int[] array) {
		this.array = array;
	}
	
	public IntArrayList(Integer... z) { // IntegerArray zu intArray wirklich so kompliziert?!?!?
		final int[] ia = new int[z.length];
		for(int i = 0; i < z.length; i++) {
			ia[i] = z[i];
		}
		this.array = ia;
	}
	
	public int[] getArray() {
		return this.array;
	}
}
