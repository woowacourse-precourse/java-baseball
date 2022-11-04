package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BallTest {
	@Test
	void 같은_수_같은_자리_스트라이크() {
		Ball ball = Ball.create(1, 0);
		Ball ballToCompare = Ball.create(1, 0);

		assertThat(ball.compare(ballToCompare)).isEqualTo(CompareResult.STRIKE);
	}

	@Test
	void 같은_수_다른_자리_볼() {
		Ball ball = Ball.create(1, 0);
		Ball ballToCompare = Ball.create(1, 1);

		assertThat(ball.compare(ballToCompare)).isEqualTo(CompareResult.BALL);
	}

	@Test
	void 다른_숫자_낫싱() {
		Ball ball = Ball.create(1, 0);
		Ball ballToCompare = Ball.create(2, 0);

		assertThat(ball.compare(ballToCompare)).isEqualTo(CompareResult.NOTHING);
	}
}
