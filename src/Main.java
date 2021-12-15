
public class Main {
	public static void main(String[] args) {
		// zahlen im konstruktor eingeben + ausgabe
		IntArrayList ia = new IntArrayList(4, 6, 1, 2, 3, 6, 2, 3, 2);
		
		System.out.println("size: " + ia.getSize());
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		System.out.println();
		
		// zahlen adden + ausgeben
		ia.add(20,12,34,765,2,4,1,76,23,3,6,13,6,2134,2);
		
		System.out.println("size: " + ia.getSize());
		
		for(int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		// eine zahl adden + ausgabe
		ia.add(666);
		
		System.out.println("size: " + ia.getSize());
		
		for(int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		// mehrere arrays eingeben + ausgabe
		int[] i = { 1, 2, 3 };
		int[] o = { 5, 6, 7 };

		ia.addAll(i, o);
		
		System.out.println("size: " + ia.getSize());

		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();

		// zahl entfernen
		System.out.println("Es wurden " + (ia.remove(3)) + " Elemente entfernt.");
		System.out.println("size: " + ia.getSize());
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		System.out.println();
		
		// index entfernen
		System.out.println("Es wurde die Zahl " + (ia.removeAt(21)) + " entfernt.");
		System.out.println("size: " + ia.getSize());
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}

		System.out.println();

		// zahlenArray entfernen
		int[] p = { 5, 6, 7 };
		System.out.print("Es wurde die Zahlen ");
		for( int val : ia.removeAll(p)) {
			System.out.print(val + " ");
		}
		
		System.out.println("entfernt.");
		
		System.out.println("size: " + ia.getSize());
		for (int zahl : ia.getArray()) {
			System.out.print(zahl + " ");
		}
		
		
	}
}
