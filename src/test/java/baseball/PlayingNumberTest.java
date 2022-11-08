package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayingNumberTest {
	@Nested
	class ValidateSizeTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("4321");
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("17");
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("");
			});
			assertEquals("3자리 숫자만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class ValidateDuplicateTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("116");
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("188");
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("999");
			});
			assertEquals("서로 다른 숫자들만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class ValidateREGEXTest {
		@Test
		void case1() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("016");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case2() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("108");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case3() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("970");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case4() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("하이루");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}

		@Test
		void case5() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				PlayingNumber playingNumber = new PlayingNumber("abc");
			});
			assertEquals("1 ~ 9 사이의 자연수만 입력해주세요.", exception.getMessage());
		}
	}

	@Nested
	class GetPlayingNumberTest {
		@Test
		void case1() {
			String playingNumber = "369";
			PlayingNumber player = new PlayingNumber(playingNumber);
			assertEquals(player.getPlayingNumber(), Integer.parseInt(playingNumber));
		}

		@Test
		void case2() {
			String playingNumber = "716";
			PlayingNumber player = new PlayingNumber(playingNumber);
			assertEquals(player.getPlayingNumber(), Integer.parseInt(playingNumber));
		}

		@Test
		void case3() {
			String playingNumber = "486";
			PlayingNumber player = new PlayingNumber(playingNumber);
			assertEquals(player.getPlayingNumber(), Integer.parseInt(playingNumber));
		}
	}

	@Nested
	class GetPlayingNumbersTest {
		@Test
		void case1() {
			String playingNumber = "369";
			List<Integer> playingNumbers = List.of(3, 6, 9);
			PlayingNumber player = new PlayingNumber(playingNumber);
			assertEquals(player.getPlayingNumbers(), playingNumbers);
		}

		@Test
		void case2() {
			String playingNumber = "716";
			List<Integer> playingNumbers = List.of(7, 1, 6);
			PlayingNumber player = new PlayingNumber(playingNumber);
			assertEquals(player.getPlayingNumbers(), playingNumbers);
		}

		@Test
		void case3() {
			String playingNumber = "486";
			List<Integer> playingNumbers = List.of(4, 8, 6);
			PlayingNumber player = new PlayingNumber(playingNumber);
			assertEquals(player.getPlayingNumbers(), playingNumbers);
		}
	}

}
