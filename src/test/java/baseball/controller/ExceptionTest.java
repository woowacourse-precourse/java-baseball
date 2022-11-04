package baseball.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ExceptionTest {
	@Nested
	@DisplayName("validatePlayerNumber test")
	class validatePlayerNumberTest {
		@Nested
		@DisplayName("numberBoundary")
		class numberBoundary {
			@Test
			@DisplayName("제한된 숫자 범위를 넘어가는 경우")
			public void validateNumberBoundaryTest1() {
				String playerNumber = "092";
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					Exception.validateNumberBoundary(playerNumber);
				});
			}

			@Test
			@DisplayName("알파벳이 들어가는 경우")
			public void validateNumberBoundaryTest2() {
				String playerNumber = "98a";
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					Exception.validateNumberBoundary(playerNumber);
				});
			}

			@Test
			@DisplayName("공백이 들어가는 경우")
			public void validateNumberBoundaryTest3() {
				String playerNumber = " 897";
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					Exception.validateNumberBoundary(playerNumber);
				});
			}

			@Test
			@DisplayName("특수기호가 들어가는 경우")
			public void validateNumberBoundaryTest4() {
				String playerNumber = "8@5";
				Assertions.assertThrows(IllegalArgumentException.class, () -> {
					Exception.validateNumberBoundary(playerNumber);
				});
			}
		}

		@Test
		@DisplayName("제한된 숫자 개수를 넘어가는 경우")
		public void validateNumberLengthTest1() {
			String playerNumber = "9358";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				Exception.validateNumberLength(playerNumber);
			});
		}

		@Test
		@DisplayName("제한된 숫자 개수보다 적은 경우")
		public void validateNumberLengthTest2() {
			String playerNumber = "93";
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

	@Nested
	@DisplayName("validateRestartNumber test")
	class validateRestartNumberTest {
		@Test
		@DisplayName("정해진 숫자외 다른 숫자가 들어가는 경우")
		public void validateRestartNumberTest1() {
			String inputRestartNumber = "3";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				Exception.validateRestartNumber(inputRestartNumber);
			});
		}

		@Test
		@DisplayName("숫자 이외의 다른 문자가 들어가는 경우")
		public void validateRestartNumberTest2() {
			String inputRestartNumber = "@a";
			Assertions.assertThrows(IllegalArgumentException.class, () -> {
				Exception.validateRestartNumber(inputRestartNumber);
			});
		}
	}
}
