package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RefereeTest {
	@Nested
	class GetResultMessageTest {
		@Test
		void case1() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(3, 6, 9);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("3스트라이크");
		}

		@Test
		void case2() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(2, 4, 8);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("낫싱");
		}

		@Test
		void case3() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(6, 9, 3);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("3볼");
		}

		@Test
		void case4() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(3, 9, 6);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("2볼 1스트라이크");
		}

		@Test
		void case5() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(2, 9, 6);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("2볼");
		}

		@Test
		void case6() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(7, 9, 2);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("1볼");
		}

		@Test
		void case7() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(3, 7, 1);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("1스트라이크");
		}

		@Test
		void case8() {
			List<Integer> pitcherPlayingNumbers = List.of(3, 6, 9);
			List<Integer> batterPlayingNumbers = List.of(3, 6, 1);
			Referee referee = new Referee(pitcherPlayingNumbers, batterPlayingNumbers);
			assertThat(referee.getResultMessage()).isEqualTo("2스트라이크");
		}

	}
}
