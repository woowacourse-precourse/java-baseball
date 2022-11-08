package baseball.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidUtilTest {

	private InputValidUtil inputValidUtil = new InputValidUtil();

	@Test
	@DisplayName("숫자가 아닌 입력을 받은 경우")
	void valid_isNumber() {
		Assertions.assertAll(
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid(" 1 "))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("ㅠㅊㅇ"))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("^^^"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("서로 다른 숫자인 경우")
	void valid_hasDifferentNumber() {
		Assertions.assertAll(
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("111"))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("112"))
				.isInstanceOf(IllegalArgumentException.class),
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("211"))
				.isInstanceOf(IllegalArgumentException.class)
		);
	}

	@Test
	@DisplayName("3자리 숫자가 아닌 경우")
	void valid_has3Length() {
		Assertions.assertAll(
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("12")),
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid("1234  ")),
			() -> assertThatThrownBy(() -> inputValidUtil.checkInputValid(""))
		);
	}

	@ParameterizedTest(name = "정상적으로 입력한 경우")
	@ValueSource(strings = {"513", "153", "317", "157", "135"})
	void valid_input(String text) {
		Assertions.assertDoesNotThrow(() -> inputValidUtil.checkInputValid(text));
	}

}
