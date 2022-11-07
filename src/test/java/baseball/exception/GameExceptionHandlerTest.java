package baseball.exception;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("예외 처리 테스트")
public class GameExceptionHandlerTest {
	@Test
	@DisplayName("공통 예외 - 숫자가 아닌 경우")
	void handleNotNumberExceptionTest() {
		String alphabetInput = "abc";
		String markInput = "!@#";

		assertThatThrownBy(() -> {
			GameExceptionHandler.handleNotNumberException(alphabetInput);
		}).isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> {
			GameExceptionHandler.handleNotNumberException(markInput);
		}).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("공통 예외 - 입력이 비어있는 경우")
	void handleEmptyExceptionTest() {
		String emptyString = "";

		assertThatThrownBy(() -> {
			GameExceptionHAndler.handleEmptyException(emptyString);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
