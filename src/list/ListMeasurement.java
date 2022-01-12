package list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

import de.impaq.german_names.RandomName;
import de.impaq.german_names.RandomName.Sex;

public class ListMeasurement {	
	
	public static void main(final String... args) {
		
		MyList<RandomName> l = new MyArrayList<>();		
		measureToConsole(l);
		l = new MyLinkedList<>();
		measureToConsole(l);		
	}
	
	public static void measureToConsole(final MyList<RandomName> l) {
		String str = "";
		if(l.getClass().toString().equals("class list.MyArrayList")) {
			str = "ArrayList";
		} else {
			str = "LinkedList";
		}
		
		System.out.println(String.format("insert %s: %s", str, measure(ListMeasurement::insert, l)));
		System.out.println(String.format("listSize : %s", l.getSize()));
		System.out.println(String.format("remove %s: %s", str, measure(ListMeasurement::remove, l)));
		System.out.println(String.format("listSize : %s", l.getSize()));
		System.out.println(String.format("get    %s: %s", str, measure(ListMeasurement::get, l)));
		System.out.println(String.format("listSize : %s", l.getSize()));
		System.out.println();
	}
	
//	public static void measureToConsole(final List<RandomName> l) {
//		String str = "";
//		if(l.getClass().toString().equals("class java.util.ArrayList")) {
//			str = "ArrayList";
//		} else {
//			str = "LinkedList";
//		}
//		
//		System.out.println(String.format("insert %s: %s", str, measure(ListMeasurement::insert, l)));
//		System.out.println(String.format("listSize : %s", l.size()));
//		System.out.println(String.format("remove %s: %s", str, measure(ListMeasurement::remove, l)));
//		System.out.println(String.format("listSize : %s", l.size()));
//		System.out.println(String.format("get    %s: %s", str, measure(ListMeasurement::get, l)));
//		System.out.println(String.format("listSize : %s", l.size()));
//		System.out.println();
//	}
	
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
		for(int i = 0; i < l.getSize(); ++i) {
			l.get(random.nextInt(l.getSize()));
		}
	}
	
	private static long measure(final Consumer<MyList<RandomName>> fct, final MyList<RandomName> l) { // zeitmesser
		final long start = System.currentTimeMillis();
		fct.accept(l);
		return System.currentTimeMillis() - start;
	}
}


