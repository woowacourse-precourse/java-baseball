package baseball.controller.user;

import baseball.controller.error.UserError;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class UserErrorTest {

	@DisplayName("유저가 입력한 숫자의 중복 여부를 확인한다")
	@Test
	void testUserInputDuplication() {
		Assertions.assertThat(UserError.hasDuplication("221")).isTrue();
	}


	@DisplayName("유저가 입력한 숫자의 길이가 설정된 숫자와 같은지 확인한다")
	@Test
	void testUserInputLength() {
		Assertions.assertThat(UserError.followDigitRule("591", 3)).isTrue();
	}

	@DisplayName("유저의 입력이 숫자로만 구성되어 있는지 확인한다")
	@Test
	void testUserInputIsNumberOnly() {
		Assertions.assertThat(UserError.followNumberOnlyRule("591")).isTrue();
		Assertions.assertThat(UserError.followNumberOnlyRule("ad3")).isFalse();
	}


	@DisplayName("유저 guessing number 입력 오류시 예외 처리가 작동하는지 확인한다")
	@Test
	void testUserGuessingHandleException() {
		Assertions.assertThatCode(() -> UserError.handleGuessingError("222"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("잘못입력하였습니다. 프로그램을 종료합니다.");
	}

	@DisplayName("유저 intention 입력 오류시 예외 처리가 작동하는지 확인한다")
	@ParameterizedTest
	@ValueSource(strings = {"3", "abc", "25"})
	void testUserIntentionHandleException(String input) {
		Assertions.assertThatCode(() -> UserError.handleIntentionError(input))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("잘못입력하였습니다. 프로그램을 종료합니다.");
	}
}
