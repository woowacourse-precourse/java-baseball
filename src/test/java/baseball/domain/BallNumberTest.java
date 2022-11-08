package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallNumberTest {

	@ParameterizedTest(name = "{index} : 야구공 유효성 테스트 (에러 존재 : {1})")
	@CsvSource({"1, false", "9, false", "0, true", "10, true"})
	public void 야구공_유효성_검증(int ballNumber, boolean hasError) {
		if (!hasError) {
			BallNumber ball = new BallNumber(ballNumber);
			assertThat(ball).isNotNull();
		}
		if (hasError) {
			assertThatThrownBy(() -> new BallNumber(ballNumber))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}
}
