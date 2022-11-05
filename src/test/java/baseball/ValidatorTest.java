package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ValidatorTest {
	@Test
	void 숫자가_아닌_값이_포함된_경우_예외처리() {
		assertThatIllegalArgumentException().isThrownBy(() -> Validator.validate("1f3"));
	}
}
