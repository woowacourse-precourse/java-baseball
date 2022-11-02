package baseball.validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {
	@ParameterizedTest(name = "''''{0}'''' 옳바른 baseballNumber 이기에 예외를 던지지 않는다")
	@ValueSource(strings = {"123", "435", "954", "672", "543"})
	void validBaseballInputNumberTest(String validBaseballNumber) {
		assertThatNoException().isThrownBy(() -> Validator.validateBaseballNumber(validBaseballNumber));
	}

	@ParameterizedTest(name = "''''{0}'''' 길이가 3이 아니면 발생하는 에러")
	@ValueSource(strings = {"", "  ", "1", "12", "1234", "a", "ab", "abcd", "@P~M#PM"})
	void invalidBaseballInputLengthTest(String baseballNumber) {
		assertThatThrownBy(() -> Validator.validateBaseballNumber(baseballNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[Error] 유효하지 않은 입력 길이입니다. 서로 다른 숫자 3개를 입력해주세요");
	}

	@ParameterizedTest(name = "''''{0}'''' 길이는 3인데 모두 숫자가 아니면 발생하는 에러")
	@ValueSource(strings = {"afn", "   ", "1a0", "1P2", "!34", "9`9", "abf", "acd"})
	void invalidBaseballInputElementsTest(String baseballNumber) {
		assertThatThrownBy(() -> Validator.validateBaseballNumber(baseballNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[Error] 숫자만 입력해주세요");
	}

	@ParameterizedTest(name = "''''{0}'''' 숫자 3개인데 겹치는 수가 있으면 발생하는 에러")
	@ValueSource(strings = {"113", "133", "999", "001", "101"})
	void invalidBaseballInputUniqueElementsTest(String baseballNumber) {
		assertThatThrownBy(() -> Validator.validateBaseballNumber(baseballNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[Error] 서로다른 숫자 3개를 입력해주세요.");
	}

	@ParameterizedTest(name = "''''{0}'''' 서로다른 3개 숫자인데 0을 포함하면 나타나는 에러")
	@ValueSource(strings = {"012", "702", "960", "804", "430"})
	void invalidBaseballNumberInputZeroValueTest(String baseballNumber) {
		assertThatThrownBy(() -> Validator.validateBaseballNumber(baseballNumber))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[Error] 0이라는 숫자는 포함되면 안됩니다.");
	}

}