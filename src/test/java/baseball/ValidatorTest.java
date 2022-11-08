package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ValidatorTest {
	@Test
	void doNumberValidation_메소드로_사용자의_입력이_올바른지_확인() {
		assertThatThrownBy(() -> Validator.doNumberValidation("qwe"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 ~ 9 이외의 문자는 허용되지 않습니다.");
		assertThatThrownBy(() -> Validator.doNumberValidation("12.3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 ~ 9 이외의 문자는 허용되지 않습니다.");
		assertThatThrownBy(() -> Validator.doNumberValidation("12"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력은 세 자리 십진수여야 합니다.");
		assertThatThrownBy(() -> Validator.doNumberValidation("1234"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력은 세 자리 십진수여야 합니다.");
		assertThatThrownBy(() -> Validator.doNumberValidation("111"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력의 각 자릿값은 서로 달라야 합니다.");
		assertThatThrownBy(() -> Validator.doNumberValidation("122"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("입력의 각 자릿값은 서로 달라야 합니다.");
	}

	@Test
	void doStatusValidation_메서드로_진행상태와_관련된_입력값이_올바른지_확인() {
		assertThatThrownBy(() -> Validator.doStatusValidation("qwe"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
		assertThatThrownBy(() -> Validator.doStatusValidation(""))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
		assertThatThrownBy(() -> Validator.doStatusValidation("0"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
		assertThatThrownBy(() -> Validator.doStatusValidation("3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("1 또는 2만 입력할 수 있습니다.");
	}
}
