package baseball.filter;

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
}
