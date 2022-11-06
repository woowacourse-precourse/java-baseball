package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(
	DisplayNameGenerator.ReplaceUnderscores.class
)
public class BallsTest {

	@DisplayName("balls 길이 검증 테스트")
	@Test
	void balls_길이_검증() {
		assertThatThrownBy(
			() -> new Balls(List.of(1, 2, 3, 4))
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> new Balls(List.of(1, 2))
		).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(
			() -> new Balls(List.of(1))
		).isInstanceOf(IllegalArgumentException.class);

		assertThat(new Balls(List.of(1, 2, 3))).isNotNull();
	}

}
