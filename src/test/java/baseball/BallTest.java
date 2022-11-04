package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BallTest {
	@Test
	void 같은_수_같은_자리_스트라이크() {
		Ball ball = new Ball(1, 0);
		Ball ballToCompare = new Ball(1, 0);

		assertThat(ball.compare(ballToCompare)).isEqualTo(CompareResult.STRIKE);
	}
}
