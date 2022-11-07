package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

	@ParameterizedTest(name = "야구공 유효성 테스트 {index}")
	@CsvSource({"1, 0, false", "1, 2, false",
		"9, 0, false", "9, 2, false",
		"0, 0, true", "1, 3, true",
		"10, 0, true", "10, 3, true"})
	public void 야구공_유효성_검증(int ballNumber, int ballIndex, boolean isError) {
		if (!isError) {
			Ball ball = new Ball(ballNumber, ballIndex);
			assertThat(ball).isNotNull();
		}
		if (isError) {
			assertThatThrownBy(() -> new Ball(ballNumber, ballIndex))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
