package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallsTest {

	@ParameterizedTest(name = "{index} : 야구공 3개 유효성 테스트 (에러 존재 : {3})")
	@CsvSource({"123, false", "122, true", "1012, true"})
	public void 야구공_3_유효성_테스트(String numbers, boolean hasError) {
		if (!hasError) {
			Balls balls = new Balls(numbers);
			assertThat(balls).isNotNull();
		}
		if (hasError) {
			assertThatThrownBy(() -> new Balls(numbers))
				.isInstanceOf(IllegalArgumentException.class);
		}
	}

	@Test
	public void 야구공_3_비교_테스트() {
		//given
		Balls computerBalls = new Balls("123");
		Balls playerBalls = new Balls("134");
		//when
		List<BallStatus> actual = computerBalls.compare(playerBalls);
		//then
		assertThat(actual).isEqualTo(
			Arrays.asList(BallStatus.STRIKE, BallStatus.BALL, BallStatus.NOTHING));
	}
}
