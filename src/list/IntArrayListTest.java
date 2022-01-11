package list;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

import family.Person;
import family.Person.Geschlecht;

public class IntArrayListTest {
	
	public static void main(String[] args) {
//		arrayLists();
		
		linkedLists();	
	}
	
	static Person p1 = new Person("Donald", "Duck", LocalDate.of(1945, 11, 22), Geschlecht.MAENNLICH);
	static Person p2 = new Person("Daisy", "Duck", LocalDate.of(1968, 12, 24), Geschlecht.WEIBLICH);
	static Person p3 = new Person("Lucky", "Luke", LocalDate.of(1974, 7, 5), Geschlecht.MAENNLICH);
	static Person p4 = new Person("Micky", "Maus", LocalDate.of(1973, 4, 13), Geschlecht.MAENNLICH);	

	public static void arrayLists() {
		MyList myArrayList1 = new MyArrayList();
		MyList myArrayList2 = new MyArrayList(10);
		MyList<?> myArrayList3 = new MyArrayList<Person>(p1, p2, p3);

		test(myArrayList1);
		test(myArrayList2);
		test(myArrayList3);
		
		System.out.println("ArrayList test done");
	}
	
	public static void linkedLists() {
		MyList myLinkedList1 = new MyLinkedList();
		MyList myLinkedList2 = new MyLinkedList(p1, p2, p3);

		test(myLinkedList1);
		test(myLinkedList2);
		
		
				
		System.out.println("LinkedList test done");		
	}	
	
	private static void test(final MyList l) {		
		funktioniertAddPerson(l);
		funktioniertAddInteger(l);
		funktioniertAddArray(l);
		funktioniertRemoveAt(l);
		funktioniertRemove(l);		
		funktioniertRemoveAll(l);		
		funktioniertGetList(l);
//		funktioniertMergeSort(l);		
//		funktioniertSimpleSort(l);		
		geburtsdatum(l);
		funktioniertClear(l);	
	}

	private static void funktioniertAddPerson(final MyList l) {
		int size = l.getSize();
		l.add(p1);
		l.add(p4);
		assert l.getSize() == (size + 2);
	}
	
	private static void funktioniertAddInteger(final MyList l) {
		int size = l.getSize();
		l.add(8);
		assert l.getSize() == (size + 1);

		try {
			l.get(-1);
			assert false;
		} catch(final Exception e) {
			assert true;
		}
	}
	
	private static void funktioniertGet(final MyList l) {
		assert l.get(0) == p1;
	}
	
	private static void funktioniertAddArray(final MyList l) {
		Integer[] tmp = {456, 48, 123, 234, 567, 567, 234, 234, 98};
		l.addArray(tmp);
		assert (l.get(l.getSize() - 2)).equals((Integer)234);
	}
	
	private static void funktioniertRemoveAt(final MyList l) {
		int size = l.getSize();
		l.removeAt(9);
		assert l.getSize() == (size - 1);
	}
	
	private static void funktioniertRemove(final MyList l) {
		int size = l.getSize();
		l.remove(p4);
		assert l.getSize() == size - 1;
	}
	
	private static void funktioniertRemoveAll(final MyList l) {
		int size = l.getSize();
		Object[] tmp1 = {456, 48};
		l.removeAll(tmp1);
		assert l.getSize() == size - 2;		
	}
	
	public static void funktioniertGetList(final MyList l) {
		l.listToConsole();
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
	
	private static void geburtsdatum(final MyList l) {
		Person px = (Person)l.get(0);
		assert px.getGeburtsDatum().equals(LocalDate.of(1945, 11, 22));
	}
		
	private static void funktioniertClear(final MyList l) {
		l.clear();
		assert l.getSize() == 0;
	}

}

