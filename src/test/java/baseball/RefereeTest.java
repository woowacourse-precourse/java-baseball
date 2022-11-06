package baseball;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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

	@Test
	@DisplayName("낫싱 성공 테스트: 일치하는공이 없을 때 낫싱 성공")
	void 일치하는공이_없을_때_낫싱_성공() {
		// when
		playerBalls = makeBallsWithoutComputerBalls(computerBalls, playerBalls);

		// then
		boolean nothing = referee.isNothing(computerBalls, playerBalls);
		Assertions.assertThat(nothing).isEqualTo(true);
	}

	private static List<Integer> makeBallsWithoutComputerBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
		playerBalls.removeAll(computerBalls);
		return playerBalls.subList(0, 3);
	}

	@Test
	@DisplayName("낫싱 실패 테스트1: 일치하는공 하나일 때 낫싱 실패")
	void 일치하는공_하나일_때_낫싱_실패() {
		// when
		playerBalls = makeOneSameBalls(computerBalls, playerBalls);
		Collections.shuffle(playerBalls);

		// then
		boolean nothing = referee.isNothing(computerBalls, playerBalls);
		Assertions.assertThat(nothing).isEqualTo(false);
	}

	private static List<Integer> makeOneSameBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
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

		// then
		boolean nothing = referee.isNothing(computerBalls, playerBalls);
		Assertions.assertThat(nothing).isEqualTo(false);
	}

	private static List<Integer> makeTwoSameBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
		playerBalls.removeAll(computerBalls);
		playerBalls.add(0, computerBalls.get(0));
		playerBalls.add(0, computerBalls.get(1));
		return playerBalls.subList(0, 3);
	}
}
