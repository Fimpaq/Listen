package compare;

import java.util.Comparator;
import java.util.Objects;

public class Compare implements Comparator, Comparable{

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			Compare compare = new Compare();
			compare.name = "Johann";
			compare.age = 20 + i;
			
			System.out.println(Objects.hash(compare, compare.name, compare.age));
			
			System.out.println(compare.hashCode());
			
			if(compare.name.equals("Johann")) {
				System.out.println("gleich");
			}
			
		}

	}
	
	String name;
	int age;

	@Override
	public int hashCode() {
		return name.hashCode() * age;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) { // mit sich selbst
			return true;
		}
		if(o == null) { // vielleicht weglassen?
			return false;
		}
		if(o instanceof Compare) { // nur selbe klasse vergleichen
			Compare test = (Compare) o;
			if(test.name == this.name && test.age == this.age) {
				return true;
			}
		}
		return false;
	}

		@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		return ;
	}

		@Override
		public int compareTo(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}
	
	
	
}
