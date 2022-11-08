package baseball.util;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidatorTest {

	@Test
	void 재시작_여부에_대한_유효하지_않은_입력_예외_처리() {
		//given
		String input = "3";

		//when, then
		assertThatThrownBy(() -> Validator.validateRestartOrNotInput(input)).isInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	void 유효하지_않은_길이의_입력에_대한_예외_처리() {
		//given
		String input = "1243";

		//when, then
		assertThatThrownBy(() -> Validator.validateNumberInput(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 유효하지_않은_글자를_입력하는_예외_처리() {
		//given
		String input = "2a3";

		//when, then
		assertThatThrownBy(() -> Validator.validateNumberInput(input)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	void 중복된_숫자를_입력하는_예외_처리() {
		//given
		String input = "233";

		//when, then
		assertThatThrownBy(() -> Validator.validateNumberInput(input)).isInstanceOf(IllegalArgumentException.class);
	}
}