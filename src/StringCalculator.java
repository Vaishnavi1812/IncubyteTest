import java.util.ArrayList;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers == null || numbers.trim().length() == 0) {
			return 0;
		}
		String newNumbers = numbers.replace("\n", ",");
		String numbersFromSplittedString[] = newNumbers.split(",");

		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		int sum = 0;
		for (String number : numbersFromSplittedString) {

			if (isLowerCaseAlphabet(number.charAt(0)) == true) {
				Integer numEquivalentOfChar = Integer.valueOf(number.charAt(0)) - 'a' + 1;
				sum += numEquivalentOfChar;

			} else if (!number.trim().isEmpty()) {
				if (Integer.parseInt(number) < 0) {
					negativeNumbers.add(Integer.parseInt(number));
				} else if (Integer.parseInt(number) > 1000) {
					continue;
				}
				sum += Integer.parseInt(number);
			}
		}

		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		}
		return sum;
	}

	private static boolean isLowerCaseAlphabet(char ch) {
		if (ch >= 'a' && ch <= 'z') {
			return true;
		} else if (ch >= 'A' && ch <= 'Z') {
			throw new UnsupportedOperationException("Only lowerCase alphabets allowed");
		}
		return false;
	}
}
