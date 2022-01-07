package list;

public class IntArrayListTest {
	
	

	public static void main(String[] args) {
		test();
	}

	private static void test() {
		testEmptyList(new IntArrayList());
		testEmptyList(new IntArrayList(10));

//		int[] tmp = {14, 76, 63, 12, 6, 1000}; // constructor removed
//		testFilledList(new IntArrayList(tmp));
		testFilledList(new IntArrayList(14.2, 76.24, 63, 12, 6, 1000));
		
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
		funktioniertClear(l);		
	}
	
	private static void funktioniertAdd(final IntArrayList l) {
		assert l.getSize() == 6;
		l.add(8);
		assert l.getSize() == 7;
		assert l.get(0).doubleValue() == 14.2;
		assert l.get(l.getSize() - 1).intValue() == 8;
		
		try {
			l.get(-1);
			assert false;
		} catch(final Exception e) {
			assert true;
		}
	}
	
	private static void funktioniertAddArray(final IntArrayList l) {
		Short[] tmp = {456, 48};
		l.addArray(tmp);
		assert l.get(l.getSize() - 2).shortValue() == 456; // value-art egal?
	}
	
	private static void funktioniertRemove(IntArrayList l) {
		l.remove(8);
		assert l.getSize() == 8;
	}
	
	private static void funktioniertRemoveAll(IntArrayList l) {
		Number[] tmp1 = {14.2, 63};
		l.removeAll(tmp1);
		assert l.getSize() == 6;		
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
		l.add(1.0, 2.0, 3.0);
		assert l.getSize() == 3;
		assert l.get(0).doubleValue() == 1.0;

		
		assert l.getArray().length == 10;
		l.add(4.0, 5, 6, 1, 8, 9, 10, 11);
		assert l.getArray().length == 15;
		assert l.getSize() == 11;

		l.remove(1.0);
		
		Number[] tmp = {3.0, 2.0};
		l.removeAll(tmp);
		
		assert l.getSize() == 8;
		assert l.getArray().length == 12; 
		
		Number tmpInt = l.removeAt(0);
		assert tmpInt.doubleValue() == 4.0;
		assert l.getSize() == 7;
		tmp = l.getArray();
		assert tmp[0].intValue() == 5;
		assert tmp[6].intValue() == 11;
		
		assert l.get(5).intValue() == 10;		
		
		try {
			l.get(-1);
			assert false;
		} catch(final Exception e) {
			assert true;
		}
		
		l.add(4);		
		l.remove(4); // entfernt alle 4en? - kein remove one
		tmp = l.getArray();
		
		assert tmp[0].intValue() == 5;						
		assert tmp[5].intValue() == 10;	
		
		l.clear();
		assert l.getSize() == 0;
		assert l.getArray().length != 0;
		
		Short snum = 2;
		
		
		l.add(snum, 789, 2, 153, 846, 12, 9, 9);
		
		tmp = l.getArray();
		assert tmp[0].shortValue() == 2;
		
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

