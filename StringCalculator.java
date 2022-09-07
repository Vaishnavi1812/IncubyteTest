import java.util.ArrayList;

public class StringCalculator {

	public static int add(String numbers) {
		ArrayList<Integer> numbersFromString = new ArrayList<Integer>();
		ArrayList<Integer> negativeNumbers = new ArrayList<Integer>();
		String num = "";
		for (int i = 0; i < numbers.length(); i++) {
			if (numbers.charAt(i) >= 'a' && numbers.charAt(i) <= 'z') {

				Integer n = Integer.valueOf(numbers.charAt(i)) - 'a' + 1;
				numbersFromString.add(n);
			} else if (numbers.charAt(i) != ',') {
				String negNum = "";
				if (numbers.charAt(i) == '-') {
					while (numbers.charAt(i + 1) != ',' && i != numbers.length() - 1) {
						negNum += numbers.charAt(i + 1);
						i++;
					}
					negativeNumbers.add(-1 * (Integer.parseInt(negNum)));
				} else {
					num += numbers.charAt(i);
				}
			} else {
				if (num != "") {
					Integer integerNum = Integer.parseInt(num);
					if (integerNum <= 1000) {
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
		int sum = 0;
		for (int i = 0; i < numbersFromString.size(); i++) {
			sum += numbersFromString.get(i);
		}
		if (negativeNumbers.size() > 0) {
			throw new RuntimeException("Negatives not allowed: " + negativeNumbers.toString());
		}
		return sum;
	}
}
