import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToTextConverter {

	private static final String[] miscellaneous = { "", " thousand", " million", " billion", " trillion",
			" quadrillion", " quintillion" };

	private static final String[] tensMultiplies = { "", " ten", " twenty", " thirty", " forty", " fifty", " sixty",
			" seventy", " eighty", " ninety" };

	private static final String[] numNames = { "", " one", " two", " three", " four", " five", " six", " seven",
			" eight", " nine", " ten", " eleven", " twelve", " thirteen", " fourteen", " fifteen", " sixteen",
			" seventeen", " eighteen", " nineteen" };

	public static void main(String a[]) {

		System.out.println("Please Enter a valid number in between 1 to 999,999,999.");
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int i = scanner.nextInt();

			if (i > 0 && i <= 999999999) {
				System.out.println(i);
				System.out.println(numberToTextConvert(i));
				scanner.close();
			} else {
				System.out.println("Sorry, you have entered a wrong number which is out of Limit.");
			}

		} catch (InputMismatchException e) {
			System.out.println("InputMismatchException : " + e);
		} catch (Exception e) {
			System.out.println("Error while converting the number to text :" + e);
		} finally {
			scanner.close();
		}

	}

	/* This method is to Convert the Integer number to Text Value. */
	private static String numberToTextConvert(int number) {
		try {
			String current = "";
			int place = 0;
			do {
				int n = number % 1000;
				if (n != 0) {
					String s = convertLessThanOneThousand(n);
					current = s + miscellaneous[place] + current;
				}
				place++;
				number /= 1000;
			} while (number > 0);

			return (current).trim();
		} catch (Exception e) {
			System.out.println("Error Wile converting to text: " + e);
		}
		return null;
	}

	/* This Method is to Convert the numbers which are less 1000. */
	private static String convertLessThanOneThousand(int number) {

		try {
			String current;
			if (number % 100 < 20) {
				current = numNames[number % 100];
				number /= 100;
			} else {
				current = numNames[number % 10];
				number /= 10;

				current = tensMultiplies[number % 10] + current;
				number /= 10;
			}
			if (number == 0)
				return current;
			return numNames[number] + " hundred" + current;
		} catch (Exception e) {
			System.out.println("Error while converting < 1000 number : " + e);
		}
		return null;
	}

}
