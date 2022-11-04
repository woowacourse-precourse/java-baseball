package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionTest {
	@Test						/* 컴퓨터 숫자 생성 테스트 */
	void randomGeneratingTest() {
		List<Integer> generatedNumbers = Application.setComputersNumbers();

		assertThat(generatedNumbers.size() == 3);
		for(int number : generatedNumbers) {
			assertThat(number > 0 && number < 10);
		}
	}
	@Test						/* 유저 인풋 테스트 */
	void userInputTest() {
		String userInputNumbers;
		assertThat(userInputNumbers = "123");
		Application.validateInputPattern(userInputNumbers);
		final List<Integer> USERS_NUMBERS = List.copyOf(Application.validateDuplication(userInputNumbers));
	}
}
