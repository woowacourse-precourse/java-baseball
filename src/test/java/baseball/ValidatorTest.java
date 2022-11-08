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
}
