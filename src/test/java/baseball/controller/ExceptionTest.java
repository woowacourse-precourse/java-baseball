package baseball.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExceptionTest {
	@Test
	public void validOnlyOneToNineTest() {
		String inputGameNumber = "0358";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Exception.validOnlyOneToNine(inputGameNumber);
		});
	}

	@Test
	public void validNumberLengthTest() {
		String inputGameNumber = "0358";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Exception.validNumberLength(inputGameNumber);
		});
	}

	@Test
	public void validOverlapNumber() {
		String inputGameNumber = "889";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Exception.validOverlapNumber(inputGameNumber);
		});
	}
}
