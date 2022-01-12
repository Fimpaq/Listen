package de.impaq.german_names;

import java.util.Random;

public class RandomName {
	
	private static final String[][] firstNames = new String[][] {
			"Maria,Marie,Elisabeth,Katharina,Catharina,Dorothea,Agnes,Magdalene,Magdalena,Sophie,Christine,Christina,Hedwig,Sibylle,Sibylla,Sophia,Barbara,Margarete,Margaretha,Johanna,Eleonore,Ursula,Charlotte,Eva"
					.split(","),
			"Johann,Johannes,Georg,Heinrich,Hans,Christoph,Friedrich,Philipp,Wilhelm,Andreas,Jakob,Jacob,Joachim,Hermann,Martin,Michael,Ludwig,Peter,Caspar,Paul,Anton,Christian"
					.split(",") };

	private static final String[] names = "Müller,Schmidt,Schneider,Fischer,Weber,Schulz,Becker,Hoffmann,Schäfer,Koch,Richter,Bauer,Klein,Wolf,Schröder,Neumann,Schwarz,Zimmermann,Braun,Hofmann,Krüger,Hartmann,Lange,Werner,Schmitz,Krause,Meier,Lehmann"
			.split(",");

	private final String firstName;

	private final String name;

	public enum Sex {
		FEMININE, MASCULINE, ANY;
	}

	public RandomName(Sex sex) {
		Random random = new Random();
		int s = (sex == Sex.ANY) ? random.nextInt(2) : sex.ordinal(); // wenn any, random 0 - 1; sonst enum-position
		this.firstName = firstNames[s][random.nextInt((firstNames[s]).length)]; // [welches array][welcher index]
		this.name = names[random.nextInt(names.length)];
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getName() {
		return this.name;
	}

	public String getFullName() {
		return String.format("%s %s", new Object[] { this.firstName, this.name });
	}

	public String getFullNameFormally() {
		return String.format("%s, %s", new Object[] { this.name, this.firstName });
	}

	public String toString() {
		return getFullName();
	}
}
