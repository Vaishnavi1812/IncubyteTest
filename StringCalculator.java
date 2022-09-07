import java.util.ArrayList;

public class StringCalculator {

	public static int add(String numbers) {
		ArrayList<Integer> numbersFromString = new ArrayList<Integer>();
		Boolean checkForNegatives = false;
		String negNum = "";
		String num = "";
		for (int i = 0; i < numbers.length(); i++) {
			if (numbers.charAt(i) >= 'a' && numbers.charAt(i) <= 'z') {

				Integer n = Integer.valueOf(numbers.charAt(i)) - 'a' + 1;
				numbersFromString.add(n);
			} else if (numbers.charAt(i) != ',') {
				if (numbers.charAt(i) == '-') {
					checkForNegatives = true;
					while (numbers.charAt(i + 1) != ',' && i != numbers.length() - 1) {
						negNum += numbers.charAt(i + 1);
						i++;
					}
				}
				num += numbers.charAt(i);

			} else {
				if (num != "") {
					Integer integerNum = Integer.parseInt(num);
					numbersFromString.add(integerNum);
					num = "";
				}
			}
		}
		if (num != "") {
			Integer integerNum = Integer.parseInt(num);
			numbersFromString.add(integerNum);
		}
		int sum = 0;
		for (int i = 0; i < numbersFromString.size(); i++) {
			sum += numbersFromString.get(i);
		}
		if (checkForNegatives == true) {
			throw new RuntimeException("Negatives not allowed: " + negNum);
		}
		return sum;
	}
}
