package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
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
}
