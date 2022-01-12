package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Test {
	
	public class Inner {
		public void calc() {
			System.out.println("bumm");
		}
	}

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5);
//		nums.forEach(i -> System.out.println(i));
		Consumer<Integer> c = i -> System.out.print(i);
		
		nums.forEach(c);

		System.out.println();
		
		int a = 1_2_3_4;
		System.out.println(a);
		
		// performace:
		for (int i = 0; i < nums.size();i++) {}
		// hier wird immerwieder nums.size aufgeruden -> schlecht
		int size = nums.size();
		for (int i = 0; i < size; i++) {} // size
		
		// Streams
		
	}

}
