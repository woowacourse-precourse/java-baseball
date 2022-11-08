package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
	@Test
	void 숫자가_아닌_값이_포함된_경우_예외처리() {
		assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateBallsInput("1f3"));
	}

	@Test
	void 입력된_숫자가_세자리가_아닐_경우_예외처리() {
		assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateBallsInput("1234"));
	}

	@Test
	void 입력된_숫자가_중복될_경우() {
		assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateBallsInput("112"));
	}

	@Test
	void 종료와_재시작을_구분하는_입력값은_반드시_1_또는_2() {
		assertThatIllegalArgumentException().isThrownBy(() -> Validator.validateQuitOrRestartInput(""));
	}
}
