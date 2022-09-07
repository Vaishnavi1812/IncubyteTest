import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@Test
	public void SampleTestCasePassingNull() {
		StringCalculator.add("");
		Assertions.assertTrue(true);
	}

	@Test
	public void SampleTestCasePassingSingleNumberInString() {
		StringCalculator.add("1");
		Assertions.assertTrue(true);
	}

	@Test
	public void SampleTestCasePassingTwoNumbersInString() {
		StringCalculator.add("1,2");
		Assertions.assertTrue(true);
	}

}
