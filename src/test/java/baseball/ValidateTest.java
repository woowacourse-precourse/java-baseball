package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateTest {


	@Test
	void isNumeric_메서드가_숫자가_아닌_값에_대해_false_리턴(){
		String input = "1가3";
		assertThat(Validate.isNumeric(input)).isEqualTo(false);
	}

	@Test
	void isNumeric_메서드가_숫자에_대해_true_리턴(){
		String input = "123";
		assertThat(Validate.isNumeric(input)).isEqualTo(true);
	}

	@Test
	void isNumeric_메서드가_숫자에_대해_true_리턴_실패(){
		String input = "123ab";
		assertThat(Validate.isNumeric(input)).isEqualTo(true);
	}
}
