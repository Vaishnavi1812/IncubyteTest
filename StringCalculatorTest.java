import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {

	@Test
	public void SampleTestCasePassingEmptyString() {
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

	@Test
	public void SampleTestCasePassingAlphabets() {
		Assertions.assertEquals(7, StringCalculator.add("1,2,a,c"));
	}

	@Test()
	public void SampleTestCasePassingMultipleNegativeNumbers() {
		RuntimeException exception = null;
		try {
			StringCalculator.add("1,4,-8,7,-9,0");
		} catch (RuntimeException e) {
			exception = e;
		}
		Assertions.assertNotNull(exception);
		Assertions.assertEquals("Negatives not allowed: [-8, -9]", exception.getMessage());
	}

	@Test
	public void SampleTestCasePassingNumbersGreaterThan1000() {
		Assertions.assertEquals(2 + 1001, StringCalculator.add("2,1001"));
	}

	@Test
	public void SampleTestCasePassingSpace() {
		Assertions.assertEquals(0, StringCalculator.add(" "));
	}

	@Test
	public void SampleTestCasePassingNull() {
		Assertions.assertEquals(0, StringCalculator.add(null));
	}

	@Test
	public void SampleTestCasePassingUpperCaseAlphabet() {
		UnsupportedOperationException exception = null;
		try {
			StringCalculator.add("A");
		} catch (UnsupportedOperationException e) {
			exception = e;
		}
		Assertions.assertNotNull(exception);
		// Assertions.assertEquals(exception, UnsupportedOperationException.class);
		Assertions.assertEquals("Only lowerCase alphabets allowed", exception.getMessage());
	}

	@Test
	public void SampleTestCasePassingNewLineDelimiter() {
		Assertions.assertEquals(3, StringCalculator.add("1\n2"));
	}
}
