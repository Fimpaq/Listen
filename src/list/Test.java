package list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import de.impaq.german_names.RandomName;

public class Test {

	public static void main(String[] args) {
//		MyList<Test> l = new MyArrayList<>();
//		for (int i = 0; i < 10; i++) {
//			Test t = new Test();
//			l.add(t);
//		}

//		Integer[] array = { 24, 23, 2, 6, 18, 100, 6, 7 };
//		l.add(array);

//		for(int i = 0; i<l.getSize(); i++) {
//			System.out.println(l.get(i).num);
//		}
//		System.out.println();
//		ListUtils.sort(l, Test.compareNum());
//		for(int i = 0; i<l.getSize(); i++) {
//			System.out.println(l.get(i).num);
//		}

		MyList<Test> tl = new MyArrayList<>();
		tl.add(new Test());
		tl.add(new Test());
		tl.add(new Test());
		tl.add(new Test());
		tl.add(new Test());
		tl.add(new Test());

		for (int i = 0; i < tl.getSize(); i++) {
			System.out.println(tl.get(i).num);
		}
		System.out.println();

//		Collections.sort(tl, compareNum());
		
		Comparator comp = new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				return ((Test) o1).num.compareTo(((Test) o2).num);
			}
		};
		
		sort(tl);
				
		for (int i = 0; i < tl.getSize(); i++) {
			System.out.println(tl.get(i).num);
		}
	}

	Integer num;

	public Test() {
		Random r = new Random();
		this.num = r.nextInt(100);
	}

	public Integer getNum() {
		return this.num;
	}




	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Comparator<Test> compareNum() {
		return (Comparator<Test>) new Comparator() {

			@Override
			public int compare(Object o1, Object o2) {

				return ((Test) o1).num.compareTo(((Test) o2).num);
			}
		};
	}

	public static <T> void sort(MyList<Test> l) {
		int[] array = new int[l.getSize()];
		for(int i = 0; i< l.getSize();i++) {
			array[i] = (int)l.get(i).num;
		}
		
		    for (int i = 0; i < array.length; i++) {
		        int min = array[i];
		        int minId = i;
		        for (int j = i+1; j < array.length; j++) {
		            if (array[j] < min) {
		                min = array[j];
		                minId = j;
		            }
		        }
		        // swapping
		        int temp = array[i];
		        array[i] = min;
		        array[minId] = temp;
		    }
		

		System.out.println("sortiert");
	}

}