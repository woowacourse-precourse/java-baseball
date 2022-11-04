package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BallsTest {
	@Test
	void 모든_숫자와_위치가_동일하면_3_strike() {
		Balls balls = new Balls(1, 2, 3);
		Balls ballsToCompare = new Balls(1, 2, 3);

		assertThat(balls.getGameResult(ballsToCompare)).isEqualTo(new GameResult(3, 0));
	}

	@Test
	void 모든_숫자가_동일하고_모든_위치가_다를때_3_ball() {
		Balls balls = new Balls(1, 2, 3);
		Balls ballsToCompare = new Balls(3, 1, 2);

		assertThat(balls.getGameResult(ballsToCompare)).isEqualTo(new GameResult(0, 3));
	}

	@Test
	void 모든_숫자가_다를때_낫싱() {
		Balls balls = new Balls(1, 2, 3);
		Balls ballsToCompare = new Balls(4, 5, 6);

		assertThat(balls.getGameResult(ballsToCompare)).isEqualTo(new GameResult(0, 0));
	}
}
