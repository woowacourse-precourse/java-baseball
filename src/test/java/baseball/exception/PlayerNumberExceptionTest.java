package baseball.exception;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerNumberExceptionTest {
	@Nested
	@DisplayName("numberBoundary")
	class numberBoundary {
		@Test
		@DisplayName("제한된 숫자 범위를 넘어가는 경우")
		public void validateNumberBoundaryTest1() {
			String playerNumber = "092";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				PlayerNumberException.validateNumberBoundary(playerNumber);
			});
		}

		@Test
		@DisplayName("알파벳이 들어가는 경우")
		public void validateNumberBoundaryTest2() {
			String playerNumber = "98a";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				PlayerNumberException.validateNumberBoundary(playerNumber);
			});
		}

		@Test
		@DisplayName("공백이 들어가는 경우")
		public void validateNumberBoundaryTest3() {
			String playerNumber = " 897";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				PlayerNumberException.validateNumberBoundary(playerNumber);
			});
		}

		@Test
		@DisplayName("특수기호가 들어가는 경우")
		public void validateNumberBoundaryTest4() {
			String playerNumber = "8@5";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				PlayerNumberException.validateNumberBoundary(playerNumber);
			});
		}
	}

	@Test
	@DisplayName("제한된 숫자 개수를 넘어가는 경우")
	public void validateNumberLengthTest1() {
		String playerNumber = "9358";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PlayerNumberException.validateNumberLength(playerNumber);
		});
	}

	@Test
	@DisplayName("제한된 숫자 개수보다 적은 경우")
	public void validateNumberLengthTest2() {
		String playerNumber = "93";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PlayerNumberException.validateNumberLength(playerNumber);
		});
	}

	@Test
	@DisplayName("증복된 숫자가 포함되는 경우")
	public void validateOverlapNumber() {
		String playerNumber = "889";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			PlayerNumberException.validateOverlapNumber(playerNumber);
		});
	}
}
