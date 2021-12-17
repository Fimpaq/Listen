package quatsch;

import java.util.Random;

public class SortStuff {

	private int[] array;
	
	public int[] getArray() {
		return this.array;
	}

	public void randomZeroToHundert(final int amount) {
		int[] ar = new int[amount];
		Random r = new Random();

		for (int i = 0; i < amount; i++) {
			ar[i] = r.nextInt(1000); // 100 000 funktioniert nicht?
		}
		this.array = ar;
	}

	public void simpleSort() { // stellt nullen ganz ans ende hinter die höchste zahl -> warum?
		int a;
		for (int z = 0; z < this.array.length; z++) {
			for (int i = 0; i < this.array.length - 1; i++) {
				if (array[i] > array[i + 1]) {
					a = array[i];
					array[i] = array[i + 1];
					array[i + 1] = a;
				}
			}
		}
	}
	
	public void recursiveSort() {
		mergeSort(this.array);
		
		int[] tmp = new int[this.array.length];
		
		int i = 0;
		for (int num : this.array) {
			if (num != 0) {
				tmp[i] = num;
				i++;
			}
		}
		this.array = tmp;
	}
	
	private void mergeSort(final int[] input) {
		int startLength = input.length;

		if(startLength < 2) {
			return;
		}

		int middel = startLength / 2;
		int[] leftArray = new int[middel];		
		int[] rightArray = new int[startLength - middel];
		
		for (int i = 0; i < middel; i++) {
			leftArray[i] = input[i];
		}
		for (int i = middel, j = 0; i < startLength; i++, j++) {
			rightArray[j] = input[i];
		}
		
		mergeSort(leftArray);
		mergeSort(rightArray);		
		
		merge(input, rightArray, leftArray);
	}
	
	private void merge(final int[] input, final int[] rightArray, final int[] leftArray) {
		int leftLength = leftArray.length;
		int rightLength = rightArray.length;
		
		int i = 0, j = 0, k = 0;
		
		while(i < leftLength && j < rightLength) {
			if(leftArray[i] <= rightArray[j]) {
				input[k] = leftArray[i];
				i++;
			} else {
				input[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		while (i < leftLength) {
			input[k] = leftArray[i];
			i++;
			k++;
		}
		while (j < rightLength) {
			input[k] = rightArray[j];
			j++;
			k++;
		}
	}
}
