
public class Main {
	public static void main(String[] args) {
		IntArrayList ia = new IntArrayList(4, 6, 1, 2, 3, 6, 2, 3, 2);
//		
//		ia.add(20);
//		
//		System.out.println("Arraygröße: " + ia.getSize());
//		
//		for(int zahl : ia.getArray()) {
//			System.out.print(zahl + " ");
//		}
		
		
		int[] i = { 1, 2, 3 };
		int[] o = { 5, 6, 7 };

		ia.addAll(i, o);

		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
	}
}
