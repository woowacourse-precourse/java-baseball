package baseball;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RefereeTest {

	@Test
	@DisplayName("낫싱 성공 테스트")
	void 일치하는공이_없을_때_낫싱_성공() {
		// given
		Computer computer = new Computer();
		Referee referee = new Referee();
		List<Integer> allBall = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		computer.pitchThreeUniqueBalls();
		List<Integer> computerBalls = computer.getComputerBalls();

		List<Integer> playerBalls = new LinkedList<>();
		playerBalls.addAll(allBall);
		Collections.shuffle(playerBalls);

		// when
		playerBalls = makeBallsWithoutComputerBalls(computerBalls, playerBalls);

		// then
		boolean nothing = referee.isNothing(computerBalls, playerBalls);
		Assertions.assertThat(nothing).isEqualTo(true);
	}

	@Test
	@DisplayName("낫싱 실패 테스트")
	void 일치하는공_하나일_때_낫싱_실패() {
		// given
		Computer computer = new Computer();
		Referee referee = new Referee();
		List<Integer> allBall = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);

		computer.pitchThreeUniqueBalls();
		List<Integer> computerBalls = computer.getComputerBalls();

		List<Integer> playerBalls = new LinkedList<>();
		playerBalls.addAll(allBall);
		Collections.shuffle(playerBalls);

		// when
		playerBalls = makeOneSameBalls(computerBalls, playerBalls);

		// then
		boolean nothing = referee.isNothing(computerBalls, playerBalls);
		System.out.println(computerBalls);
		System.out.println("한개 같은 공: " + playerBalls);
		Assertions.assertThat(nothing).isEqualTo(false);
	}

	private static List<Integer> makeBallsWithoutComputerBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
		playerBalls.removeAll(computerBalls);
		return playerBalls.subList(0, 3);
	}

	private static List<Integer> makeOneSameBalls(List<Integer> computerBalls, List<Integer> playerBalls) {
		playerBalls.removeAll(computerBalls);
		playerBalls.add(0, computerBalls.get(0));
		return playerBalls.subList(0, 3);
	}
}
