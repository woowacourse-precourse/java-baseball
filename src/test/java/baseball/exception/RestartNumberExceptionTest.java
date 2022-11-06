package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RestartNumberExceptionTest {
	@Test
	@DisplayName("정해진 숫자외 다른 숫자가 들어가는 경우")
	public void validateRestartNumberTest1() {
		int restartNumber = 1;
		int exitNumber = 2;
		String inputRestartNumber = "3";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RestartNumberException.validateRestartNumber(inputRestartNumber, restartNumber, exitNumber);
		});
	}

	@Test
	@DisplayName("숫자 이외의 다른 문자가 들어가는 경우")
	public void validateRestartNumberTest2() {
		int restartNumber = 1;
		int exitNumber = 2;
		String inputRestartNumber = "@a";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			RestartNumberException.validateRestartNumber(inputRestartNumber, restartNumber, exitNumber);
		});
	}
}
