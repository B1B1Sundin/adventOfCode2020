import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * https://adventofcode.com/2020/day/2
 */
public class Day2 {

	/**
	 * Finds the lowest limit for the amount of letters for the first policy
	 * and the first position for the letter for the second policy
	 * 
	 * @param str "17-22", "9-10", "1-4"
	 * @return the lo value "17", "9" and "1"
	 */
	public static int findLo(String str) {
		String[] arrOfStr = str.split("-", 2);
		int lo = Integer.parseInt(arrOfStr[0]);
		return lo;
	}

	/**
	 * Finds the highest limit for the amount of letters for the first policy
	 * and the second position for the letter for the second policy
	 * 
	 * @param str, "17-22", "9-10", "1-4"
	 * @return the hi value "22", "10" and "4"
	 */
	public static int findHi(String str) {
		String[] arrOfStr = str.split("-", 2);
		int hi = Integer.parseInt(arrOfStr[1]);
		return hi;
	}

	/**
	 * First policy, a specific letter must be used in the password
	 * from lo to hi times. So the password "dttt" with the policy "3-4 t:"
	 * means that the letter "t" must be used from 3 to 4 times, which is true in
	 * this case.
	 * 
	 * @param password the String password
	 * @param letter   the char letter that must be used in the password
	 * @return the amount of times the letter was used in the password
	 */
	public static int firstPolicy(String password, char letter) {
		int letterCounter = 0;
		for (int i = 0; i < password.length(); i++) {
			if (password.charAt(i) == letter) {
				letterCounter++;
			}
		}
		return letterCounter;
	}

	/**
	 * Second policy, a specific letter must be used just once in a password.
	 * Each password has it's own required letter that must be used in the password.
	 * 1. The letter must only be used once.
	 * 2. The letter's position/index must be at one out of two given positions in
	 * the password.
	 * 
	 * - Position 1 represents the first letter in the password, instead of 0. So we
	 * subtract our given lo and hi with -1.
	 * - We use a line if statement to check if the lo and hi bounds exceeds the
	 * length of the password. If so then set immediatly to false, else continue.
	 * 
	 * @param password the String password
	 * @param letter   the required letter
	 * @param lo       the first possible index/position
	 * @param hi       the second possible index/position
	 * @return a boolean value representing if the given password is valid or not.
	 */
	public static boolean secondPolicy(String password, char letter, int lo, int hi) {
		boolean loBool = password.length() > lo - 1 ? password.charAt(lo - 1) == letter : false;
		boolean hiBool = password.length() > hi - 1 ? password.charAt(hi - 1) == letter : false;

		if (logicalXOR(loBool, hiBool)) {
			return true;
		}
		return false;
	}

	/**
	 * @param x
	 * @param y
	 * @return the logical XOR value of the booleans x and y
	 */
	public static boolean logicalXOR(boolean x, boolean y) {
		return ((x || y) && !(x && y));
	}

	public static void main(String[] args) {
		try {
			/**
			 * Counts all the valid passwords
			 */
			int counterFirstPolicy = 0;
			int counterSecondPolicy = 0;
			Scanner inputFile = new Scanner(new File("/Users/yohanna/Code/AdventOfCode_2020/InputDay2.txt"));
			while (inputFile.hasNextLine()) {
				/**
				 * Take word at a time and extract the lo(int), hi(int), the required
				 * letter(char) and the password(String)
				 */
				String limit = inputFile.next();
				int lo = findLo(limit);
				int hi = findHi(limit);
				char letter = inputFile.next().charAt(0);
				String password = inputFile.next();

				// First policy
				int letterCounter = firstPolicy(password, letter);
				if (letterCounter >= lo && letterCounter <= hi) {
					counterFirstPolicy++;
				}

				// Second policy
				if (secondPolicy(password, letter, lo, hi)) {
					counterSecondPolicy++;
				}
			}
			System.out.print(
					"In total there is " + counterFirstPolicy + " passwords that are valid according to the first policy\n");
			System.out.print(
					"In total there is " + counterSecondPolicy + " passwords that are valid according to the second policy\n");
		} catch (FileNotFoundException e) {
			System.out.println("File not found, try again");
		}
	}
}
