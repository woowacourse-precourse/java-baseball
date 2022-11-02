package baseball.views;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ReaderTest {
	@ParameterizedTest(name = "valid input:''''{0}'''' << 사용자가 정상적인 숫자야구 값을 입력하는 경우 테스트")
	@ValueSource(strings = {"143", "213", "987"})
	void getUserBaseballNumberInputTest(String userInput) {
		// given : 사용자가 넣은 옳은 입력이 주어질 때
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when : Reader 로 사용자가 숫자야구 관련 번호를 입력했을 때
		String userBaseBallNumber = Reader.getUserBaseBallNumber();

		// then : userInput 과 userBaseballNumber 가 서로 같은지 확인
		assertThat(userBaseBallNumber).isEqualTo(userInput);
	}

	@ParameterizedTest(name = "invalid input:''''{0}'''' << 사용자가 적절하지 않은 숫자야구 값을 입력하는 경우 테스트")
	@ValueSource(strings = {"111", "122", "0123", "012", " 12", " 123", "a123", "abc", "   ", "\n123"})
	void getUserBaseballNumberInputExceptionTest(String userInput) {
		// given : 사용자가 넣은 틀린 입력이 주어질 때
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when, then : 틀린 입력에 대해 예외처리가 된다. => throw IllegalArgumentException
		assertThatThrownBy(Reader::getUserBaseBallNumber)
				.isInstanceOf(IllegalArgumentException.class);
	}

	public static InputStream generateInputStream(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}
}