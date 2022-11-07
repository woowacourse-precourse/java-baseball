package baseball.filter;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.restrict.RestrictIntegerConstants;

class BaseballGameUserInputFilterImplTest implements RestrictIntegerConstants {

	@Test
	void checkUserInputTest() {
		boolean checkResult;
		UserInputFilter<Integer> filter = new BaseballGameUserInputFilterImpl();

		Assertions.assertThatThrownBy(
				() -> filter.checkUserInput(null, LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER))
			.isInstanceOf(IllegalArgumentException.class);

		Assertions.assertThatThrownBy(
				() -> filter.checkUserInput("abc", LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER))
			.isInstanceOf(IllegalArgumentException.class);

		Assertions.assertThatThrownBy(
				() -> filter.checkUserInput("112", LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER))
			.isInstanceOf(IllegalArgumentException.class);

		Assertions.assertThatThrownBy(
				() -> filter.checkUserInput("012", LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER))
			.isInstanceOf(IllegalArgumentException.class);

		Assertions.assertThatThrownBy(
				() -> filter.checkUserInput("1234", LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER))
			.isInstanceOf(IllegalArgumentException.class);

		checkResult = filter.checkUserInput("123", LIMIT_LIST_SIZE, MIN_NUMBER, MAX_NUMBER);
		Assertions.assertThat(checkResult).isTrue();
	}

	@Test
	void bindingResultTest() {
		List<Integer> temp;
		List<Integer> bindingResult;
		UserInputFilter<Integer> filter = new BaseballGameUserInputFilterImpl();

		bindingResult = filter.bindingResult(null, 3);
		Assertions.assertThat(bindingResult).isEmpty();

		bindingResult = filter.bindingResult("12", 3);
		Assertions.assertThat(bindingResult).isEmpty();

		temp = List.of(1, 2, 3);
		bindingResult = filter.bindingResult("123", 3);
		Assertions.assertThat(bindingResult).isEqualTo(temp);
	}
}
