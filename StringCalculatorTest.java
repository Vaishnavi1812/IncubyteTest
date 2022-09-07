import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

//	@Test
//	void test() {
//		StringCalculator.add("0");
//		Assertions.assertTrue(true);
//	}

	@Test
	public void SampleTestCasePassingNull() {
		Assertions.assertEquals(0, StringCalculator.add(""));
	}

	@Test
	public void SampleTestCasePassingSingleNumberInString() {
		Assertions.assertEquals(1, StringCalculator.add("1"));
	}

	@Test
	public void SampleTestCasePassingTwoNumbersInString() {
		Assertions.assertEquals(3, StringCalculator.add("1,2"));
	}

	@Test
	public void SampleTestCasePassingUnknownAmountOfNumbersInString() {
		Assertions.assertEquals(220, StringCalculator
				.add("1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10"));
	}

}
