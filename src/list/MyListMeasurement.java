package list;

import java.util.Random;
import java.util.function.Consumer;

import de.impaq.german_names.RandomName;
import de.impaq.german_names.RandomName.Sex;

public class MyListMeasurement {	
	
	public static void main(final String... args) {		
		System.err.println("My List:");
		MyList<RandomName> ml = new MyArrayList<>();		
		measureMyList(ml);
		ml = new MyLinkedList<>();
		measureMyList(ml);
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
		for(int i = 0; i < 125000; ++i) {
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


