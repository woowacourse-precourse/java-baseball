package baseball;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidateTest {

	@Test
	void checkCorrectInput_메서드_비정상_입력_에러_발생(){
		String notNumber = "abcd";
		assertThatThrownBy(() -> Validate.checkCorrectInput(notNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(Message.USER_INPUT_NOT_NUMBER.getMsg() + Message.INVALID_INPUT_END_GAME.getMsg());

		String lengthBiggerThanThree = "1234";
		assertThatThrownBy(() -> Validate.checkCorrectInput(lengthBiggerThanThree))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(
				Message.USER_INPUT_LENGTH_INVALID.getMsg() +
				Message.INVALID_INPUT_END_GAME.getMsg());

		String duplicateNumber = "113";
		assertThatThrownBy(() -> Validate.checkCorrectInput(duplicateNumber))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(
				Message.USER_INPUT_DUPLICATED.getMsg() +
					Message.INVALID_INPUT_END_GAME.getMsg());

		String numberHasZero = "012";
		assertThatThrownBy(() -> Validate.checkCorrectInput(numberHasZero))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining(
				Message.USER_INPUT_NUMBER_RANGE_INVALID.getMsg() +
					Message.INVALID_INPUT_END_GAME.getMsg());
	}

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
		assertThat(Validate.isNumeric(input)).isEqualTo(false);
	}

	@Test
	void isNumberLengthLegal_메서드_세자리_입력_true_리턴(){
		String input = "567";
		assertThat(Validate.isNumberLengthLegal(input)).isEqualTo(true);
	}

	@Test
	void isNumberLengthLegal_메서드_세자리_아닌_입력_false_리턴(){
		String input = "56789";
		assertThat(Validate.isNumberLengthLegal(input)).isEqualTo(false);
	}

	@Test
	void isDuplicated_메서드_중복된_숫자_true_리턴(){
		String input = "113";
		assertThat(Validate.isDuplicated(input)).isEqualTo(true);
	}

	@Test
	void isDuplicated_메서드_중복없는_숫자_false_리턴(){
		String input = "123";
		assertThat(Validate.isDuplicated(input)).isEqualTo(false);
	}

	@Test
	void isNumberNotInRange_메서드_0이_존재하면_true_리턴(){
		String input = "012";
		assertThat(Validate.isNumberNotInRange(input)).isEqualTo(true);
	}

	@Test
	void isNumberNotInRange_메서드_유효한_숫자면_false_리턴(){
		String input = "312";
		assertThat(Validate.isNumberNotInRange(input)).isEqualTo(false);
	}
}
