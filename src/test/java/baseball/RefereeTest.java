package baseball;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RefereeTest {
	private final Computer computer = new Computer();
	private final Referee referee = new Referee();
	private final List<Integer> allBall = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

	private List<Integer> computerBalls;
	private List<Integer> playerBalls;

	@BeforeEach
	@Test
	void 테스트마다_컴퓨터와_플레이어는_공을던짐() {
		// given
		computer.pitchThreeUniqueBalls();
		computerBalls = computer.getComputerBalls();

		playerBalls = new LinkedList<>();
		playerBalls.addAll(allBall);
		Collections.shuffle(playerBalls);
	}

	@Nested
	@DisplayName("낫싱 테스트")
	class NothingTest {

		@Nested
		class SuccessTest {
			@Test
			@DisplayName("낫싱 성공 테스트: 일치하는공이 없을 때 낫싱 성공")
			void 일치하는공이_없을_때_낫싱_성공() {
				// when
				playerBalls = makeBallsWithoutComputerBalls(computerBalls, playerBalls);

				String expectedGameResult = "낫싱";
				String gameResult = referee.judge(computerBalls, playerBalls);

				// then
				Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
			}

			private List<Integer> makeBallsWithoutComputerBalls(List<Integer> computerBalls,
					List<Integer> playerBalls) {
				playerBalls.removeAll(computerBalls);
				return playerBalls.subList(0, 3);
			}
		}

		@Nested
		class FailTest {
			@Test
			@DisplayName("낫싱 실패 테스트1: 일치하는공 하나일 때 낫싱 실패")
			void 일치하는공_하나일_때_낫싱_실패() {
				// when
				playerBalls = makeOneSameBalls(computerBalls, playerBalls);
				Collections.shuffle(playerBalls);

				String expectedGameResult = "낫싱";
				String gameResult = referee.judge(computerBalls, playerBalls);

				// then
				Assertions.assertThat(gameResult).isNotEqualTo(expectedGameResult);
			}

			private List<Integer> makeOneSameBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
				playerBalls.removeAll(computerBalls);
				playerBalls.add(0, computerBalls.get(0));
				return playerBalls.subList(0, 3);
			}

			@Test
			@DisplayName("낫싱 실패 테스트2: 일치하는공 두개일 때 낫싱 실패")
			void 일치하는공_두개일_때_낫싱_실패() {
				// when
				playerBalls = makeTwoSameBalls(computerBalls, playerBalls);
				Collections.shuffle(playerBalls);

				String expectedGameResult = "낫싱";
				String gameResult = referee.judge(computerBalls, playerBalls);

				// then
				Assertions.assertThat(gameResult).isNotEqualTo(expectedGameResult);
			}

			private List<Integer> makeTwoSameBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
				playerBalls.removeAll(computerBalls);
				playerBalls.add(0, computerBalls.get(0));
				playerBalls.add(0, computerBalls.get(1));
				return playerBalls.subList(0, 3);
			}

			@Test
			@DisplayName("낫싱 실패 테스트3: 일치하는공 세개일 때 낫싱 실패")
			void 일치하는공_세개일_때_낫싱_실패() {
				// when
				makeAllSameBalls(computerBalls, playerBalls);
				Collections.shuffle(playerBalls);

				String expectedGameResult = "낫싱";
				String gameResult = referee.judge(computerBalls, playerBalls);

				// then
				Assertions.assertThat(gameResult).isNotEqualTo(expectedGameResult);
			}

			private void makeAllSameBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
				playerBalls.retainAll(computerBalls);
			}
		}
	}

	@Nested
	@DisplayName("볼만 있는 경우 테스트")
	class OnlyBallTest {

		@Test
		@DisplayName("3볼 테스트")
		void 쓰리_볼_테스트() {
			// given
			List<Integer> computerBalls = List.of(1, 4, 9);
			List<Integer> playerBalls = List.of(9, 1, 4);

			// when
			String expectedGameResult = "3볼";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
		}

		@Test
		@DisplayName("2볼 테스트")
		void 투_볼_테스트() {
			// given
			List<Integer> computerBalls = List.of(1, 4, 9);
			List<Integer> playerBalls = List.of(7, 9, 4);

			// when
			String expectedGameResult = "2볼";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
		}

		@Test
		@DisplayName("1볼 테스트")
		void 원_볼_테스트() {
			// given
			List<Integer> computerBalls = List.of(1, 4, 9);
			List<Integer> playerBalls = List.of(6, 1, 7);

			// when
			String expectedGameResult = "1볼";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
		}
	}

	@Nested
	@DisplayName("스트라이크만 있는 경우 테스트")
	class OnlyStrikeTest {

		@Test
		@DisplayName("1스트라이크 테스트")
		void 원_스트라이크_테스트() {
			// when
			int expectedStrikeNum = 1;
			playerBalls = makeOnlyStrikeBalls(computerBalls, playerBalls, expectedStrikeNum);

			String expectedGameResult = "1스트라이크";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
		}

		@Test
		@DisplayName("2스트라이크 테스트")
		void 투_스트라이크_테스트() {
			// when
			int expectedStrikeNum = 2;
			playerBalls = makeOnlyStrikeBalls(computerBalls, playerBalls, expectedStrikeNum);

			String expectedGameResult = "2스트라이크";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);

		}

		@Test
		@DisplayName("3스트라이크 테스트")
		void 쓰리_스트라이크_테스트() {
			// when
			int expectedStrikeNum = 3;
			playerBalls = makeOnlyStrikeBalls(computerBalls, playerBalls, expectedStrikeNum);

			String expectedGameResult = "3스트라이크";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);

		}

		private List<Integer> makeOnlyStrikeBalls(List<Integer> computerBalls, List<Integer> playerBalls,
				int wantStrikeNum) {
			playerBalls.removeAll(computerBalls);
			for (int ballIdx = 0; ballIdx < wantStrikeNum; ballIdx++) {
				playerBalls.add(ballIdx, computerBalls.get(ballIdx));
			}
			
			return playerBalls.subList(0, 3);
		}
	}

	@Nested
	@DisplayName("볼과 스트라이크 함께있는 경우 테스트")
	class BallAndStrikeTest {

		@Test
		@DisplayName("2볼 1스트라이크 테스트")
		void 투_볼_원_스트라이크_테스트() {
			// given
			List<Integer> computerBalls = List.of(1, 4, 9);
			List<Integer> playerBalls = List.of(1, 9, 4);

			// when
			String expectedGameResult = "2볼 1스트라이크";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
		}

		@Test
		@DisplayName("1볼 1스트라이크 테스트")
		void 원_볼_원_스트라이크_테스트() {
			// given
			List<Integer> computerBalls = List.of(1, 4, 9);
			List<Integer> playerBalls = List.of(3, 1, 9);

			// when
			String expectedGameResult = "1볼 1스트라이크";
			String gameResult = referee.judge(computerBalls, playerBalls);

			// then
			Assertions.assertThat(gameResult).isEqualTo(expectedGameResult);
		}
	}
}
