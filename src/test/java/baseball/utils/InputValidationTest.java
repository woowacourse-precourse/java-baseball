package baseball.utils;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidationTest {

	@DisplayName("숫자만으로 이루어진 입력인지 검증")
	@ParameterizedTest
	@ValueSource(strings = {"abc", "가나다라마바사", "◀▲▶▼⇓①◦→⁍•⁸⅕⅔", "\uD83D\uDCEE\uD83D\uDD0D"})
	void 숫자_입력_검증(final String userInput) {
		assertThatThrownBy(
			() -> InputValidation.validateIsAllDigit(userInput)
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("숫자만 입력가능합니다.");
	}
}
