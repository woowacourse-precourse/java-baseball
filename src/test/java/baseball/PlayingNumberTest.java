package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayerTest {
	@Nested
	class ValidateSizeTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("4321");
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("17");
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("");
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class validateDuplicateTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("116");
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("188");
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("999");
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class validateZeroExceptionTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("016");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("108");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("970");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("하이루");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				Player player = new Player("abc");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class GetPlayingNumberTest {
		@Test
		void case1() {
			String playingNumber = "369";
			Player player = new Player(playingNumber);
			assertEquals(player.getPlayingNumber(), Integer.parseInt(playingNumber));
		}

		@Test
		void case2() {
			String playingNumber = "716";
			Player player = new Player(playingNumber);
			assertEquals(player.getPlayingNumber(), Integer.parseInt(playingNumber));
		}

		@Test
		void case3() {
			String playingNumber = "486";
			Player player = new Player(playingNumber);
			assertEquals(player.getPlayingNumber(), Integer.parseInt(playingNumber));
		}
	}

	@Nested
	class GetPlayingNumbersTest {
		@Test
		void case1() {
			String playingNumber = "369";
			List<Integer> playingNumbers = List.of(3, 6, 9);
			Player player = new Player(playingNumber);
			assertEquals(player.getPlayingNumbers(), playingNumbers);
		}

		@Test
		void case2() {
			String playingNumber = "716";
			List<Integer> playingNumbers = List.of(7, 1, 6);
			Player player = new Player(playingNumber);
			assertEquals(player.getPlayingNumbers(), playingNumbers);
		}

		@Test
		void case3() {
			String playingNumber = "486";
			List<Integer> playingNumbers = List.of(4, 8, 6);
			Player player = new Player(playingNumber);
			assertEquals(player.getPlayingNumbers(), playingNumbers);
		}
	}

}
