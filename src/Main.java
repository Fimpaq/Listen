
public class Main {
	public static void main(String[] args) {
		IntArrayList ia = new IntArrayList(4,6,1,2,3,6,2,3,2);
		int[] array = ia.getArray();
		for(int zahl : array) {
			System.out.println(zahl);
		}
	}
}
