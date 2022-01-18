package list;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.Consumer;

import de.impaq.german_names.RandomName;
import de.impaq.german_names.RandomName.Sex;
import family.Person;
import family.Person.Geschlecht;

public class MyListMeasurement {	
	
	public static void main(final String... args) {		
		MyList<RandomName> l = new MyArrayList<>();
		insert(l);
		
		for(int i = 0; i<12; i++) {
		System.out.println(l.get(i));
		}
		sort(l);
		System.out.println();
		for(int i = 0; i<12; i++) {
			System.out.println(l.get(i));
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
	
	private static void sort(final MyList<RandomName> l) {		
		ListUtils.sort(l, RandomName.compareByFirstName());
	}
	
	private static long measure(final Consumer<MyList<RandomName>> fct, final MyList<RandomName> l) { // zeitmesser
		final long start = System.currentTimeMillis();
		fct.accept(l);
		return System.currentTimeMillis() - start;
	}
}


