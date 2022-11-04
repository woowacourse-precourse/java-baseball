package baseball.service;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class JudgmentTest {

	private static ByteArrayOutputStream outputMessage;
	private List<Integer> computerNumber;
	private Judgment judgment;

	@BeforeEach
	void setupTest() {
		outputMessage = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputMessage));
		judgment = new Judgment();
		computerNumber = Arrays.asList(1, 2, 3);
	}

	@AfterEach
	void restoreStream() {
		System.setOut(System.out);
	}

	@Test
	void nothingTest() {
		List<Integer> userNumber = Arrays.asList(6, 4, 5);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("낫싱").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	void oneBallTest() {
		List<Integer> userNumber = Arrays.asList(2, 4, 5);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("1볼").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	void twoBallTest() {
		List<Integer> userNumber = Arrays.asList(2, 1, 5);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("2볼").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	void threeBallTest() {
		List<Integer> userNumber = Arrays.asList(3, 1, 2);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("3볼").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	void oneBallOneStrikeTest() {
		List<Integer> userNumber = Arrays.asList(1, 4, 2);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("1볼 1스트라이크").isEqualTo(outputMessage.toString().trim());
	}

	/*
	 ** 1볼 2스트라이크는 있을 수 없음! ex) userNumber -> 1, 2, 3 : computerNumber -> 1,2, ?
	 */

	@Test
	void twoBallOneStrikeTest() {
		List<Integer> userNumber = Arrays.asList(1, 3, 2);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("2볼 1스트라이크").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	void oneStrikeTest() {
		List<Integer> userNumber = Arrays.asList(1, 4, 5);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("1스트라이크").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	void twoStrikeTest() {
		List<Integer> userNumber = Arrays.asList(1, 2, 5);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("2스트라이크").isEqualTo(outputMessage.toString().trim());
	}

	@Test
	@DisplayName("threeStrike() 기능은 3스트라이크일 경우 게임 종료를 위해 false 출력 - 성공")
	void threeStrikeTest() {
		List<Integer> userNumber = Arrays.asList(1, 2, 3);
		judgment.compareNumber(userNumber, computerNumber);
		assertThat("3스트라이크").isEqualTo(outputMessage.toString().trim());
		assertThat(judgment.threeStrike()).isEqualTo(false);
	}
}
