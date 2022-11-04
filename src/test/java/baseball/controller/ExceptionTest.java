package baseball.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ExceptionTest {
	@Test
	@DisplayName("제한된 숫자 범위를 넘어가는 경우")
	public void validateOnlyOneToNineTest() {
		String playerNumber = "092";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Exception.validateOnlyOneToNine(playerNumber);
		});
	}

	@Test
	@DisplayName("제한된 숫자 개수를 넘어가는 경우")
	public void validateNumberLengthTest() {
		String playerNumber = "9358";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Exception.validateNumberLength(playerNumber);
		});
	}

	@Test
	@DisplayName("증복된 숫자가 포함되는 경우")
	public void validateOverlapNumber() {
		String playerNumber = "889";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Exception.validateOverlapNumber(playerNumber);
		});
	}
}
