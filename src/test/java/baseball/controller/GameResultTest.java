package baseball.controller;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {
	@Test
	@DisplayName("볼인 경우")
	public void gameResultTest1() {
		List<Integer> playerNumbers = Arrays.asList(4, 3, 9);
		List<Integer> randomNumbers = Arrays.asList(1, 4, 7);
		GameResult gameResult = new GameResult(playerNumbers, randomNumbers);

		int ballCount = 1;
		int strikeCount = 0;

		assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
		assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
	}

	@Test
	@DisplayName("볼, 스트라이크인 경우")
	public void gameResultTest2() {
		List<Integer> playerNumbers = Arrays.asList(3, 4, 9);
		List<Integer> randomNumbers = Arrays.asList(4, 3, 9);
		GameResult gameResult = new GameResult(playerNumbers, randomNumbers);

		int ballCount = 2;
		int strikeCount = 1;

		assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
		assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
	}

	@Test
	@DisplayName("낫싱인 경우")
	public void gameResultTest3() {
		List<Integer> playerNumbers = Arrays.asList(2, 5, 8);
		List<Integer> randomNumbers = Arrays.asList(4, 3, 9);
		GameResult gameResult = new GameResult(playerNumbers, randomNumbers);

		int ballCount = 0;
		int strikeCount = 0;

		assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
		assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
	}

	@Test
	@DisplayName("3스트라이크인 경우")
	public void gameResultTest4() {
		List<Integer> playerNumbers = Arrays.asList(4, 3, 9);
		List<Integer> randomNumbers = Arrays.asList(4, 3, 9);
		GameResult gameResult = new GameResult(playerNumbers, randomNumbers);

		int ballCount = 0;
		int strikeCount = 3;

		assertThat(gameResult.getBallCount()).isEqualTo(ballCount);
		assertThat(gameResult.getStrikeCount()).isEqualTo(strikeCount);
	}
}
