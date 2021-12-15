
public class Main {
	public static void main(String[] args) {
		IntArrayList ia = new IntArrayList(4, 6, 1, 2, 3, 6, 2, 3, 2);
		
		System.out.println("size: " + ia.getSize());
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		System.out.println();
		
		ia.add(20,12,34,765,2,4,1,76,23,3,6,13,6,2134,2);
		
		System.out.println("size: " + ia.getSize());
		
		for(int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		ia.add(666);
		
		System.out.println("size: " + ia.getSize());
		
		for(int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		int[] i = { 1, 2, 3 };
		int[] o = { 5, 6, 7 };

		ia.addAll(i, o);
		
		System.out.println("size: " + ia.getSize());

		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		System.out.println("Es wurden " + (ia.remove(3)) + " Elemente entfernt.");
		
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		System.out.println("Es wurde die Zahl " + (ia.removeAt(21)) + " entfernt.");
		
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
	}
}
