package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class FunctionTest {

	@Test						/* 컴퓨터 숫자 생성 테스트 */
	void randomGeneratingTest() {
		List<Integer> generatedNumbers = Application.setComputersNumbers();

		assertThat(generatedNumbers.size() == 3);
		for (int number : generatedNumbers) {
			assertThat(number > 0 && number < 10);
		}
	}

	@Test						/* 유저 인풋/유효성 검사 테스트 */
	void userInputTest() {
		assertThatThrownBy(() -> Application.validateInputPattern("as"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> Application.validateInputPattern("asd"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> Application.validateInputPattern("asdf"))
				.isInstanceOf(IllegalArgumentException.class);

		assertThatThrownBy(() -> Application.validateDuplication("11"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> Application.validateDuplication("111"))
				.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> Application.validateDuplication("1111"))
				.isInstanceOf(IllegalArgumentException.class);
	}
}
