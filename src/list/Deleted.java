package list;

public class Deleted<T> {
	T element;
	int amount;
	
	public Deleted(final T element, final int amount) {
		this.element = element;
		this.amount = amount;
	}
}
