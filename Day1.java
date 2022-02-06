import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Day1 {

	public static int[] twoMultiples(int[] report) {
		int[] multiples = new int[2];
		for (int i = 0; i < report.length; i++) {
			for (int j = i + 1; j < report.length; j++) {
				if (report[i] + report[j] == 2020) {
					multiples[0] = report[i];
					multiples[1] = report[j];
					return multiples;
				}
			}
		}
		return multiples;
	}

	public static int[] threeMultiples(int[] report) {
		int[] multiples = new int[3];
		for (int i = 0; i < report.length; i++) {
			for (int j = i + 1; j < report.length; j++) {
				for (int k = j + 1; k < report.length; k++) {
					if (report[i] + report[j] + report[k] == 2020) {
						multiples[0] = report[i];
						multiples[1] = report[j];
						multiples[2] = report[k];
						return multiples;
					}
				}
			}
		}
		return multiples;
	}

	public static void main(String[] args) {
		try {
			int[] array = new int[201];
			int counter = 0;
			Scanner scanFile = new Scanner(new File("/Users/yohanna/Code/AdventOfCode_2020/InputDay1.txt"));
			while (scanFile.hasNextInt()) {
				array[counter] = scanFile.nextInt();
				counter++;

			}
			int[] resultMultiplesOfTwo = twoMultiples(array);

			int two_a = resultMultiplesOfTwo[0];
			int two_b = resultMultiplesOfTwo[1];
			int sum2 = two_a * two_b;
			System.out.println(two_a + " + " + two_b + " = " + 2020);
			System.out.println(two_a + " * " + two_b + " = " + sum2 + "\n");

			int[] resultMultiplesOfThree = threeMultiples(array);

			int three_a = resultMultiplesOfThree[0];
			int three_b = resultMultiplesOfThree[1];
			int three_c = resultMultiplesOfThree[2];
			int sum3 = three_a * three_c * three_b;
			System.out.println(three_a + " + " + three_b + " + " + three_c + " = " + 2020);
			System.out.println(three_a + " * " + three_b + " + " + three_c + " = " + sum3);

		} catch (FileNotFoundException e) {
			System.out.println("File not found, try again");
		}
	}
}
