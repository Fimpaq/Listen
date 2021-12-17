package quatsch;

import java.time.Duration;
import java.time.Instant;

public class Main {
	
	static long simple;
	static long recursive;

	public static void main(String[] args) {
		SortStuff s = new SortStuff();
		s.randomZeroToHundert(1000);
		for (int num : s.getArray()) {
			System.out.print(num + " ");
		}
		System.out.println();
		
		
		Instant start = Instant.now();
		s.simpleSort();
		Duration dur = Duration.between(start, Instant.now());
		simple = dur.getSeconds();
		
		System.out.println("Simple: " + simple + "seconds");
		for(int num : s.getArray()) {
			System.out.print(num + " ");
		}
		System.out.println();

		
		
		start = Instant.now();
		s.recursiveSort();
		dur = Duration.between(start, Instant.now());
		recursive = dur.getSeconds();
		
		System.out.println("Simple: " + recursive + "seconds");
		for(int num : s.getArray()) {
			System.out.print(num + " ");
		}
		System.out.println();		

	}

}
