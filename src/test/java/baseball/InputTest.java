package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputTest {
	@ParameterizedTest
	@ValueSource(strings = {"입력 테스트"})
	void 입력_테스트(String input){
		String expectedInput = "입력 테스트";
		assertThat(input).isEqualTo(expectedInput);
	}

}
