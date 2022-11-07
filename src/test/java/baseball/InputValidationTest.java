package baseball;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

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
			.hasMessageContaining("1에서 9까지의 숫자만 입력가능합니다.");
	}

	@DisplayName("게임 재시작 옵션 입력 검증 - 예외")
	@ParameterizedTest
	@ValueSource(strings = {"0", "3", "4", "5"})
	void validateOption_게임_재시작_옵션_입력_예외_검증(final String option) {
		assertThatThrownBy(
			() -> InputValidation.validateOption(option)
		).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("잘못된 옵션을 입력하셨습니다.");
	}

	@DisplayName("게임 재시작 옵션 입력 검증")
	@ParameterizedTest
	@ValueSource(strings = {"1", "2"})
	void validateOption_게임_재시작_옵션_입력_검증(final String option) {
		assertDoesNotThrow(
			() -> InputValidation.validateOption(option)
		);
	}
}
