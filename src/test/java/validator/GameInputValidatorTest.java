package validator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.validator.GameInputValidator;

public class GameInputValidatorTest {

	@Test
	@DisplayName("재시작 여부를 물었을 때 규칙에 맞지 않은 입력을 테스트")
	void validateWrongInputWhenAskRestartGame() {
		// given
		String input = "test";

		// when, then
		assertThatThrownBy(() -> GameInputValidator.validateRestartInput(input))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("재시작 여부를 물었을 때 정상적인 입력을 테스트")
	void validateCorrectInputWhenAskRestartGame() {
		// given
		String input = "1";

		// when, then
		assertThatCode(() -> GameInputValidator.validateRestartInput(input)).doesNotThrowAnyException();
	}
}
