package list;

import java.time.LocalDate;

import family.Person;
import family.Person.Geschlecht;

public class IntArrayListTest {
	
	static Person p1 = new Person("Donald", "Duck", LocalDate.of(1945, 11, 22), Geschlecht.MAENNLICH);
	static Person p2 = new Person("Daisy", "Duck", LocalDate.of(1968, 12, 24), Geschlecht.WEIBLICH);
	static Person p3 = new Person("Lucky", "Luke", LocalDate.of(1974, 7, 5), Geschlecht.MAENNLICH);
	static Person p4 = new Person("Micky", "Maus", LocalDate.of(1973, 4, 13), Geschlecht.MAENNLICH);	

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		testEmptyList(new IntArrayList());
		testEmptyList(new IntArrayList(10));

//		int[] tmp = {14, 76, 63, 12, 6, 1000}; // constructor removed
//		testFilledList(new IntArrayList(tmp));
				
		testFilledList(new IntArrayList(p1, p2, p3, p4, 14.2, 76, 63, 12, 6, 1000));
		
		System.out.println("done");		
	}
	
	// filled constructor -----------------------------------
	private static void testFilledList(final IntArrayList l) {		
		funktioniertAdd(l);		
		funktioniertAddArray(l);		
		funktioniertRemove(l);		
		funktioniertRemoveAll(l);		
//		funktioniertMergeSort(l);		
//		funktioniertSimpleSort(l);		
		geburtsdatum(l); // geburtsdatum funktioniert
		funktioniertClear(l);	
	}
	
	private static void geburtsdatum(IntArrayList l) {
		Person px = (Person)l.get(0);
		assert px.getGeburtsDatum().equals(LocalDate.of(1945, 11, 22));
	}

	private static void funktioniertAdd(final IntArrayList l) {
		assert l.getSize() == 10;
		l.add(8);
		assert l.getSize() == 11;
		assert l.get(0) == p1;
		assert l.get(l.getSize() - 1) == (Object)8;
		
		try {
			l.get(-1);
			assert false;
		} catch(final Exception e) {
			assert true;
		}
	}
	
	private static void funktioniertAddArray(final IntArrayList l) {
		Integer[] tmp = {456, 48};
		l.addArray(tmp);
		assert (l.get(l.getSize() - 2)).equals((Object)456);
	}
	
	private static void funktioniertRemove(IntArrayList l) {
		l.remove(8);
		assert l.getSize() == 12;
	}
	
	private static void funktioniertRemoveAll(IntArrayList l) {
		Object[] tmp1 = {14.2, 63};
		l.removeAll(tmp1);
		assert l.getSize() == 10;		
	}
	
//	private static void funktioniertMergeSort(IntArrayList l) {
//		l.sortArray();
//		int[] tmp = l.getArray();
//		assert tmp[0] == 6;
//		assert tmp[l.getSize() - 1] == 1000;
//	}
//	
//	private static void funktioniertSimpleSort(IntArrayList l) {
//		l.simpleSortArray();
//		int[] tmp = l.getArray();
//		assert tmp[0] == 6;
//		assert tmp[l.getSize() - 1] == 1000;
//	}
		
	private static void funktioniertClear(IntArrayList l) {
		l.clear();
		assert l.getSize() == 0;
	}

	// empty constructor ---------------------------------------
	private static void testEmptyList(final IntArrayList l) {
		assert l.getSize() == 0;
		l.add(p1, p2, p3, p4, 1.0, 2.0, 3.0);
		assert l.getSize() == 7;
		assert l.get(0) == p1;
		
		assert l.getArray().length == 10;
		l.add(4.0, 5, 6, 1, 8, 9, 10, 11);
		assert l.getArray().length == 15;
		assert l.getSize() == 15;

		l.remove(1.0);
		assert l.getSize() == 14;
		
		Object[] tmp = {3.0, 2.0};
		l.removeAll(tmp);		
		assert l.getSize() == 12;
		assert l.getArray().length == 12; 
		
		Object tmpInt = l.removeAt(0);
		assert tmpInt == p1;
		assert l.getSize() == 11;
		tmp = l.getArray();
		assert tmp[0] == p2;
		assert tmp[6] == (Object)(1);
		
		assert l.get(5) == (Object)(6);		
		
		try {
			l.get(-1);
			assert false;
		} catch(final Exception e) {
			assert true;
		}
		
		Person p5 = new Person("Dagobert", "Duck", LocalDate.of(1990, 4, 2), Geschlecht.MAENNLICH);		
		l.add(p5);
		assert l.getArray()[l.getSize() - 1] == p5;		
		l.remove(p5);
		assert l.getArray()[l.getSize() - 1] == (Object)11;
		
		l.clear();
		assert l.getSize() == 0;
		assert l.getArray().length != 0;
//		
//		Short snum = 2;
//		
//		
//		l.add(snum, 789, 2, 153, 846, 12, 9, 9);
//		
//		tmp = l.getArray();
//		assert tmp[0].shortValue() == 2;
		
//		l.sortArray();
//		l.simpleSortArray();
//		tmp = l.getArray();
//		assert tmp[0] == 2;
//		assert tmp[l.getSize() - 1] == 846;
//		
//		assert tmp[tmp.length - 1] != 846;
//		
//		int[] rtz = {1000, 15, 36};
//		l.addArray(rtz);
//		
//		l.simpleSortArray();
//		
//		tmp = l.getArray();
//		
//		
//		for(int asd : tmp) {
//			System.out.println(asd);
//		}		
	}
	

}

