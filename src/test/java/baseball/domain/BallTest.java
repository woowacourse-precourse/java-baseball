package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class BallTest {

	@DisplayName("숫자 비교 테스트 - 낫싱")
	@Test
	void compareTo_숫자_비교_낫싱() {
		Ball ball = new Ball(1, 1);
		BallStatus status = ball.compareTo(new Ball(2, 1));
		assertThat(status).isEqualTo(BallStatus.NOTHING);
	}

	@DisplayName("숫자 비교 테스트 - 스트라이크")
	@Test
	void compareTo_숫자_비교_스트라이크() {
		Ball ball = new Ball(1, 1);
		BallStatus status = ball.compareTo(new Ball(1, 1));
		assertThat(status).isEqualTo(BallStatus.STRIKE);
	}

	@DisplayName("숫자 비교 테스트 - 볼")
	@Test
	void compareTo_숫자_비교_볼() {
		Ball ball = new Ball(1, 1);
		BallStatus status = ball.compareTo(new Ball(1, 2));
		assertThat(status).isEqualTo(BallStatus.BALL);
	}
}
