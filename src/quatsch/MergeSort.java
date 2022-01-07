package quatsch;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;

public class MergeSort {

	private int amount;
	private int maxRandomNumber;
	private int numbers[];

	// variablen f¸llen
	public MergeSort(int amount, int maxRandomNumber) {
		this.amount = amount;
		this.maxRandomNumber = maxRandomNumber;
		this.numbers = randomArray(this.amount, this.maxRandomNumber);
	}

	// schreibt das sortierte Array in die Datei mit dem ¸bergebenen String "dateiname"
	public void ausgabeInDatei(String dateiname) {		
		mergeSort(numbers);
		dateiOperation(dateiname);
	}
		
	// teil von "ausgabeDatei" - erstellt Datei und h‰ngt "numbers"-Array an
	private void dateiOperation(String dateiname) {
		try {
			Path p = Paths.get(dateiname);

			if (Files.exists(p)) {
				System.out.println("File already exits, content appended");

				Files.write(p, "---------\nNew Array\n---------".getBytes(), StandardOpenOption.APPEND);
				Files.write(p, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
				
				// wenn file.exists -> anh‰ngen
				for (int i = 0; i < numbers.length; i++) {					
					String content = numbers[i] + "";
					
					Files.write(p, content.getBytes(), StandardOpenOption.APPEND);
					Files.write(p, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
				}
				System.out.println();
				
			} else {
				// wenn file nicht exists -> kreieren und schreiben
				Path donePath = Files.createFile(p);
				System.out.println("File created at " + donePath.toString());
				
				// schreiben (anh‰ngen)
				Files.write(p, "---------\nNew sorted Array\n---------".getBytes(), StandardOpenOption.APPEND);
				Files.write(p, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
				for (int i = 0; i < numbers.length; i++) {					
					String content = numbers[i] + "";
					
					Files.write(p, content.getBytes(), StandardOpenOption.APPEND);
					Files.write(p, System.lineSeparator().getBytes(), StandardOpenOption.APPEND);
				}
				System.out.println();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// gibt das Array sortiert in der Console aus
	public void ausgabeInConsole() {
		mergeSort(numbers);
		printArray(numbers);
	}

	// array "numbers" mit zufallszahlen f¸llen
	// "amount"- arraygrˆﬂe ; "maxRandomNumber"- obergrenze f¸r randomzahlen
	private int[] randomArray(int amount, int maxRandomNumber) {
		Random r = new Random();
		int[] numbers = new int[amount];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = r.nextInt(maxRandomNumber);
		}
		return numbers;
	}

	// sortierMethode - Sortiert die Zahlen im Array aufsteigend
	private int[] mergeSort(int[] inputArray) {
		int inputLength = inputArray.length;

		// nur eine Zahl? -> einfach ausgeben
		if (inputLength < 2) {
			return inputArray;
		}

		// f¸r ArrayGrˆﬂe in der Mitte Teilen
		int midIndex = inputLength / 2;
		int[] leftHalf = new int[midIndex];
		// nicht nochmal in der mitte teilen, falls ungerade arraygrˆﬂe
		int[] rightHalf = new int[inputLength - midIndex];

		// rightHalfArray und leftHalfArray f¸llen
		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}

		// rekursiv aufrufen -> passiert so lange bis die arrays nur einen Wert groﬂ sind
		mergeSort(leftHalf);
		mergeSort(rightHalf);

		// ruft methode zum sortieren und zusammenbauen des ausgabearrays auf
		int[] sortedArray = merge(inputArray, leftHalf, rightHalf);

		return sortedArray;
	}

	// teil von Sortiermethode - wird in "mergeSort" benutzt
	private int[] merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {

		// index-z‰hler
		int i = 0, j = 0, k = 0;

		// sortieren
		while (i < leftHalf.length && j < rightHalf.length) {
			if (leftHalf[i] <= rightHalf[j]) {
				inputArray[k] = leftHalf[i];
				i++;
			} else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}

		while (i < leftHalf.length) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}
		while (j < rightHalf.length) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}
		return inputArray;

	}

	// numbers - Array in Console ausgeben
	private void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i] + " ");
		}
	}

}
