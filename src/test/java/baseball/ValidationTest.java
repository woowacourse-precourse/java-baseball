package baseball;

import static baseball.Validation.validateAnswer;
import static baseball.Validation.validateOneOrTwo;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

// private 메소드를 직접 테스트하는 방법도 있지만, 우회적인 테스트를 구현했다.
class ValidationTest {

	@Test
	void 입력값의_요구사항_준수_여부에_따른_예외발생_테스트() {
		assertThrows(IllegalArgumentException.class, () -> validateAnswer("1가2"));
		assertThrows(IllegalArgumentException.class, () -> validateAnswer("1234"));
		assertThrows(IllegalArgumentException.class, () -> validateAnswer("709"));
		assertThrows(IllegalArgumentException.class, () -> validateAnswer("858"));

		assertDoesNotThrow(() -> validateAnswer("123"));
	}

	@Test
	void 재시작_종료_여부에_대한_입력값에_따른_예외발생_테스트() {
		assertThrows(IllegalArgumentException.class, () -> validateOneOrTwo("가"));
		assertThrows(IllegalArgumentException.class, () -> validateOneOrTwo("3"));

		assertDoesNotThrow(() -> validateOneOrTwo("1"));
		assertDoesNotThrow(() -> validateOneOrTwo("2"));
	}
}
