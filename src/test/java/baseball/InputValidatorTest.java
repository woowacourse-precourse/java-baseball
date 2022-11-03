package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

	@Test
	@DisplayName("입력 오류 3자리 초과")
	void 사용자_입력_오류1(){
		String userInput = "1234";
		assertThrows(IllegalArgumentException.class,
			() -> InputValidator.checkUserBallInput(userInput)
		);
	}

	@Test
	@DisplayName("입력 오류 3자리 미만")
	void 사용자_입력_오류2(){
		String userInput = "1";
		assertThrows(IllegalArgumentException.class,
			() -> InputValidator.checkUserBallInput(userInput)
		);
	}

	@Test
	@DisplayName("입력 오류 0자리")
	void 사용자_입력_오류3(){
		String userInput = "";
		assertThrows(IllegalArgumentException.class,
			() -> InputValidator.checkUserBallInput(userInput)
		);
	}
}