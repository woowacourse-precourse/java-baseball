package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class BallTest {

	@DisplayName("Ball 매개변수의 범위 검증")
	@Test
	void ball_매개변수_범위_검증() {
		assertThatThrownBy(
			() -> new Ball(0)
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> new Ball(10)
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Ball(1)).isNotNull();
	}

}
