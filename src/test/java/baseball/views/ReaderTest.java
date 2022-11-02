package baseball.views;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ReaderTest {
	public static InputStream generateInputStream(String input) {
		return new ByteArrayInputStream(input.getBytes());
	}

	@ParameterizedTest(name = "valid input:''''{0}'''' << 사용자가 정상적인 숫자야구 값을 입력하는 경우 테스트")
	@ValueSource(strings = {"143", "213", "987"})
	void getUserBaseballNumberInputTest(String userInput) {
		// given : 사용자가 넣은 옳은 입력이 주어질 때
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when : Reader 로 사용자가 숫자야구 관련 번호를 입력했을 때
		String userBaseBallNumber = Reader.getUserBaseBallNumber();
		System.out.println("userBaseBallNumber = " + userBaseBallNumber);

		// then : userInput 과 userBaseballNumber 가 서로 같은지 확인
		assertThat(userBaseBallNumber).isEqualTo(userInput);
	}

	@ParameterizedTest(name = "invalid input:''''{0}'''' << 사용자가 적절하지 않은 숫자야구 값을 입력하는 경우 테스트")
	@ValueSource(strings = {"111", "122", "0123", "012", " 12", " 123", "a123", "abc", "   "})
	void getUserBaseballNumberInputExceptionTest(String userInput) {
		// given : 사용자가 넣은 틀린 입력이 주어질 때
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when, then : 틀린 입력에 대해 예외처리가 된다. => throw IllegalArgumentException
		assertThatThrownBy(Reader::getUserBaseBallNumber)
				.isInstanceOf(IllegalArgumentException.class);
	}

	@ParameterizedTest(name = "valid input:''''{0}'''' << 사용자가 정상적인 종료/재시작 값을 입력하는 경우 테스트")
	@ValueSource(strings = {"1", "2"})
	void getUserValidGameProceedNumberInputTest(String userInput) {
		// given : 사용자가 넣은 옳은 입력이 주어질 때(1, 2 둘 중 하나일 때)
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when : Reader 로 사용자가 게임 재시작/종료 관련 번호를 입력했을 때
		String userGameProceedNumber = Reader.getUserGameProceedNumber();

		// then : userInput 과 userGameProceedNumber 가 서로 같은지 확인
		assertThat(userGameProceedNumber).isEqualTo(userInput);
	}

	@ParameterizedTest(name = "invalid input:''''{0}'''' << 사용자가 비정상적인 종료/재시작 값을 입력하는 경우 테스트")
	@ValueSource(strings = {"111", "122", "0123", "012", " 12", " 123", "a123", "abc", "   "})
	void getUserInvalidGameProceedNumberInputTest(String userInput) {
		// given : 사용자가 넣은 틀린 입력이 주어질 때 (1, 2가 아닌 경우)
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when, then : 틀린 입력에 대해 예외처리가 된다. => throw IllegalArgumentException
		assertThatThrownBy(Reader::getUserGameProceedNumber)
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("사용자의 입력이 없을 경우 IllegalArgumentException 발생")
	@Test
	void getUserInvalidGameProceedNumberEmptyInputTest() {
		// given : 사용자가 넣은 틀린 입력이 주어질 때 ""
		final String userInput = "";
		InputStream inputStream = generateInputStream(userInput);
		System.setIn(inputStream);

		// when, then : 틀린 입력에 대해 예외처리가 된다. => throw IllegalArgumentException
		assertThatThrownBy(Reader::getUserGameProceedNumber)
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("[Error] 아무것도 아닌 입력은 입력이 될 수 없습니다.");
	}
}