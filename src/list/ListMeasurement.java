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
		List<RandomName> l = new ArrayList<>();
		System.out.println(String.format("insert al: %s", measure(ListMeasurement::insert, l)));
		System.out.println(String.format("remove al: %s", measure(ListMeasurement::remove, l)));
		System.out.println(String.format("get    al: %s", measure(ListMeasurement::get, l)));
		System.out.println();
		
		l = new LinkedList<>();
		System.out.println(String.format("insert ll: %s", measure(ListMeasurement::insert, l)));
		System.out.println(String.format("remove ll: %s", measure(ListMeasurement::remove, l)));
		System.out.println(String.format("get    ll: %s", measure(ListMeasurement::get, l)));
	}
	
	private static void insert(final List<RandomName> l) {
		for(int i = 0; i < 125000; ++i) {
			l.add(new RandomName(Sex.ANY));
		}
	}
	
	private static void remove(final List<RandomName> l) {
		for(int i = 0; i < l.size(); i+=2) {
			l.remove(i);
		}
	}
	
	private static void get(final List<RandomName> l) {
		final Random rnd = new Random();
		for(int i = 0; i < l.size(); ++i) {
			l.get(rnd.nextInt(l.size()));
		}
	}
	
	private static long measure(final Consumer<List<RandomName>> fct, final List<RandomName> l) {
		final long start = System.currentTimeMillis();
		fct.accept(l);
		return System.currentTimeMillis() - start;
	}
}


