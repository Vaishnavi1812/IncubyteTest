import java.util.ArrayList;

public class StringCalculator {

	public static int add(String numbers) {
		if (numbers == null || numbers.trim().length() == 0) {
			return 0;
		}
		String newNumbers = numbers.replace("\n", ",");
//		String numbersFromSplittedString[]= newNumbers.split(",");
//		int sum=0;
//		 for (String number : numbersFromSplittedString) {
//		        if (!number.trim().isEmpty()) { 
//		            sum += Integer.parseInt(number);
//		        }
//		    }
		ArrayList<Integer> numbersFromString = new ArrayList<Integer>();
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		String num = "";
		for (int i = 0; i < newNumbers.length(); i++) {
			if (isLowerCaseAlphabet(newNumbers.charAt(i)) == true) {

				Integer n = Integer.valueOf(newNumbers.charAt(i)) - 'a' + 1;
				numbersFromString.add(n);
			} else if (newNumbers.charAt(i) != ',') {
				num += newNumbers.charAt(i);
			} else {
				if (num != "") {
					Integer integerNum = Integer.parseInt(num);
					if (integerNum < 0) {
						negativeNumbers.add(integerNum);
					} else if (integerNum <= 1000) {
						numbersFromString.add(integerNum);
					}
					num = "";
				}
			}
		}
		if (num != "") {
			Integer integerNum = Integer.parseInt(num);
			numbersFromString.add(integerNum);
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		}

		return calculateSum(numbersFromString);
	}

	private static int calculateSum(ArrayList<Integer> numbersFromString) {
		int sum = 0;
		for (int i = 0; i < numbersFromString.size(); i++) {
			sum += numbersFromString.get(i);
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
