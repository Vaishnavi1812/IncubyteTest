import java.util.ArrayList;

public class StringCalculator {

	public static int add(String numbers) {
		ArrayList<Integer> numbersFromString = new ArrayList<Integer>();
		String num = "";
		for (int i = 0; i < numbers.length(); i++) {
			num = "";
			if (numbers.charAt(i) != ',') {
				num += numbers.charAt(i);
			} else {
				Integer integerNum = Integer.parseInt(num);
				numbersFromString.add(integerNum);
				num = "";
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
		return sum;
	}
}
