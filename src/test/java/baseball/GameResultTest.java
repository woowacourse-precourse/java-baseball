package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameResultTest {
	@Test
	void 게임_결과를_볼_스트라이크_개수로_표시하는_기능() {
		Balls userBalls = Balls.create("123");
		Balls computerBallsA = Balls.create("123");
		Balls computerBallsB = Balls.create("312");
		Balls computerBallsC = Balls.create("132");
		Balls computerBallsD = Balls.create("456");

		GameResult strikeOut = userBalls.getGameResultVersus(computerBallsA);
		GameResult threeBall = userBalls.getGameResultVersus(computerBallsB);
		GameResult oneStrikeTwoBall = userBalls.getGameResultVersus(computerBallsC);
		GameResult nothing = userBalls.getGameResultVersus(computerBallsD);

		assertThat(strikeOut.toString()).isEqualTo("3스트라이크");
		assertThat(threeBall.toString()).isEqualTo("3볼");
		assertThat(oneStrikeTwoBall.toString()).isEqualTo("2볼 1스트라이크");
		assertThat(nothing.toString()).isEqualTo("낫싱");
	}
}
