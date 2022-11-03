package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@Nested
	class ValidateSizeTest {
		@Test
		void case1() {
			List<Integer> fourDigits = List.of(1, 8, 6, 7);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(fourDigits);
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			List<Integer> twoDigits = List.of(1, 8);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(twoDigits);
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			List<Integer> zeroDigits = Collections.emptyList();
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(zeroDigits);
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class validateDuplicateTest {
		@Test
		void case1() {
			List<Integer> threeDigits = List.of(1, 1, 6);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(threeDigits);
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			List<Integer> threeDigits = List.of(1, 8, 8);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(threeDigits);
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			List<Integer> threeDigits = List.of(9, 9, 9);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(threeDigits);
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class validateZeroExceptionTest {
		@Test
		void case1() {
			List<Integer> threeDigits = List.of(0, 1, 6);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(threeDigits);
			});
			assertEquals("0은 포함될 수 없습니다.", exception.getMessage());
		}

		@Test
		void case2() {
			List<Integer> threeDigits = List.of(1, 0, 8);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(threeDigits);
			});
			assertEquals("0은 포함될 수 없습니다.", exception.getMessage());
		}

		@Test
		void case3() {
			List<Integer> threeDigits = List.of(9, 7, 0);
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player(threeDigits);
			});
			assertEquals("0은 포함될 수 없습니다.", exception.getMessage());
		}
	}
}
