package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class BallTest {

	private static final String NUMBER_LENGTH_ERR_MESSAGE
		= "야구 숫자는 1~9까지만 가능합니다.";

	@DisplayName("Ball 매개변수의 범위 검증")
	@Test
	void ball_매개변수_범위_검증() {
		assertThatThrownBy(
			() -> new Ball(0, 1)
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NUMBER_LENGTH_ERR_MESSAGE);

		assertThatThrownBy(
			() -> new Ball(10, 1)
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(NUMBER_LENGTH_ERR_MESSAGE);

		assertDoesNotThrow(() -> new Ball(1, 1));
	}

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
