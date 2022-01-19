package list;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Random;
import java.util.function.Consumer;

import de.impaq.german_names.RandomName;
import de.impaq.german_names.RandomName.Sex;
import family.Person;
import family.Person.Geschlecht;

public class MyListMeasurement {	
	
	public static void main(final String... args) {		
//		System.out.println("RandomName Liste");
//		MyList<RandomName> l = new MyLinkedList<>();
//		insert(l);
//		
//		for(int i = 0; i<12; i++) {
//		System.out.println(l.get(i));
//		}
//		System.out.println();
//		
//		ListUtils.bubbleSort(l, RandomName.compareByFirstName());
//		ListUtils.shuffle(l);
//		ListUtils.sort(l);
//		
//		for(int i = 0; i<12; i++) {
//			System.out.println(l.get(i));
//		}
//		System.out.println();
//
//		ListUtils.shuffle(l);
//		
//		for(int i = 0; i<12; i++) {
//			System.out.println(l.get(i));
//		}
//		System.out.println();		
		
		// ----------------------------
		System.out.println("Person Liste");
		final Person p1 = new Person("Marie", "Mayer", LocalDate.of(1945, 11, 22), Person.Geschlecht.WEIBLICH);
		final Person p2 = new Person("Alex", "Mayer", LocalDate.of(1943, 05, 12), Person.Geschlecht.MAENNLICH);

		final Person p3 = new Person("Sofie", "Weber", LocalDate.of(1951, 12, 15), Person.Geschlecht.WEIBLICH);
		final Person p4 = new Person("Max", "Weber", LocalDate.of(1948, 04, 24), Person.Geschlecht.MAENNLICH);

		final Person p5 = new Person("Ben", "Mayer", LocalDate.of(1967, 07, 13), Person.Geschlecht.MAENNLICH);
		final Person p6 = new Person("Emma", "Mayer", LocalDate.of(1961, 03, 27), Person.Geschlecht.WEIBLICH);

		final Person p7 = new Person("Mike", "Mayer", LocalDate.of(1999, 11, 04), Person.Geschlecht.MAENNLICH);
		final Person p8 = new Person("Hanna", "Mayer", LocalDate.of(2003, 06, 19), Person.Geschlecht.WEIBLICH);
		
		MyList<Person> al = new MyArrayList<>();
		al.add(p1,p2,p3,p4,p5,p6,p7,p8);
		
		for(int i=0; i<al.getSize(); i++) {
			System.out.println(al.get(i));
		}
		
		ListUtils.sort(al, Person.compareByVorname());

		for(int i=0; i<al.getSize(); i++) {
			System.out.println(al.get(i));
		}
	}
	
	public static void measureMyList(final MyList<RandomName> l) {
		String str = "";
		if(l.getClass().toString().equals("class list.MyArrayList")) {
			str = "MyArrayList";
		} else {
			str = "MyLinkedList";
		}
		
		System.out.println(String.format("insert %s: %s", str, measure(MyListMeasurement::insert, l)));
		System.out.println(String.format("listSize : %s", l.getSize()));
		System.out.println(String.format("remove %s: %s", str, measure(MyListMeasurement::remove, l)));
		System.out.println(String.format("listSize : %s", l.getSize()));
		System.out.println(String.format("get    %s: %s", str, measure(MyListMeasurement::get, l)));
		System.out.println(String.format("listSize : %s", l.getSize()));
		System.out.println();
	}
	
	private static void insert(final MyList<RandomName> l) { // 125000 zufällige zur liste hinzufügen
		for(int i = 0; i < 20; ++i) {
			l.add(new RandomName(Sex.ANY));
		}
	}
	
	private static void remove(final MyList<RandomName> l) { // jedes 2te wird entfernt
		for(int i = 0; i < l.getSize(); i+=2) {
			l.removeAt(i);
		}
	}
	
	private static void get(final MyList<RandomName> l) { // für die gesamtgröße mal, werden zufällige einträge ausgelesen
		final Random random = new Random();
		int size = l.getSize();
		for(int i = 0; i < size; ++i) {
			l.get(random.nextInt(size));
		}
	}
	
	private static long measure(final Consumer<MyList<RandomName>> fct, final MyList<RandomName> l) { // zeitmesser
		final long start = System.currentTimeMillis();
		fct.accept(l);
		return System.currentTimeMillis() - start;
	}
}


