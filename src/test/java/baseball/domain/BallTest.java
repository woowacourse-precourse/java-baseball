package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

	@ParameterizedTest(name = "{index} : 야구공 유효성 테스트 (에러 존재 : {2})")
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

	@ParameterizedTest(name = "{index} : 야구공 비교 테스트 ({2})")
	@CsvSource({"8, 1, STRIKE", "8, 0, BALL", "7, 1, NOTHING"})
	public void 야구공_비교_테스트(int ballNumber, int ballIndex, BallStatus ballStatus) {
		//given
		Ball playerBall = new Ball(ballNumber, ballIndex);
		Ball computerBall = new Ball(8, 1);
		//when
		BallStatus actual = playerBall.compare(computerBall);
		//then
		assertThat(actual).isEqualTo(ballStatus);
	}
}
