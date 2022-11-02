package baseball.views;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PrinterTest {
	private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUpStreams() {
		System.setOut(new PrintStream(outputStream)); // 테스트용 output stream 으로 교체
	}

	@AfterEach
	void restoreStreams() {
		System.setOut(System.out); // 원상복구
		outputStream.reset();
	}

	@DisplayName("게임 시작 문구 테스트")
	@Test
	void printGameStartMessageTest() {
		Printer.printGameStartMessage();

		final String EXPECTED_MESSAGE = "숫자 야구 게임을 시작합니다.\n";
		assertThat(outputStream.toString()).isEqualTo(EXPECTED_MESSAGE);
	}

	@DisplayName("숫자야구 입력 문구 테스트")
	@Test
	void printEnterTheBaseballNumberMessageTest() {
		Printer.printPlzEnterTheBaseballNumberMessage();

		final String EXPECTED_MESSAGE = "숫자를 입력해주세요 : ";
		assertThat(outputStream.toString()).isEqualTo(EXPECTED_MESSAGE);
	}

	@DisplayName("게임 종료 문구 테스트")
	@Test
	void printGameEndingMessageTest() {
		Printer.printGameEndingMessage();

		final String EXPECTED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
		assertThat(outputStream.toString()).isEqualTo(EXPECTED_MESSAGE);
	}

	@DisplayName("게임 한번 더 할 것인지 묻는 문구 테스트")
	@Test
	void printGameContinueQuestionMessageTest() {
		Printer.printGameContinueQuestionMessage();

		final String GAME_CONTINUE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
		assertThat(outputStream.toString()).isEqualTo(GAME_CONTINUE_MESSAGE);
	}

	@ParameterizedTest(name = "결과가 볼만 나왔을 때 스트라이크는 문구에서 없어야 한다.")
	@MethodSource("generateOnlyBallCntHintMessage")
	void printBallCountHintMessageTest(int ballCnt, int strikeCnt) {
		Printer.printHintCountMessage(ballCnt, strikeCnt);

		final String expected = "볼";
		final String unexpected = "스트라이크";
		assertThat(outputStream.toString()).contains(expected);
		assertThat(outputStream.toString()).doesNotContain(unexpected);
	}

	private static Stream<Arguments> generateOnlyBallCntHintMessage() {
		final int NO_STRIKE_CNT = 0;
		return Stream.of(
				Arguments.of(1, NO_STRIKE_CNT),
				Arguments.of(2, NO_STRIKE_CNT),
				Arguments.of(3, NO_STRIKE_CNT)
		);
	}

	@ParameterizedTest(name = "결과가 스트라이크만 나왔을 때 볼은 문구에서 없어야 한다.")
	@MethodSource("generateOnlyStrikeCntHintMessage")
	void printStrikeCountHintMessageTest(int ballCnt, int strikeCnt) {
		Printer.printHintCountMessage(ballCnt, strikeCnt);

		final String expected = "스트라이크";
		final String unexpected = "볼";
		assertThat(outputStream.toString()).contains(expected);
		assertThat(outputStream.toString()).doesNotContain(unexpected);
	}

	private static Stream<Arguments> generateOnlyStrikeCntHintMessage() {
		final int NO_BALL_CNT = 0;
		return Stream.of(
				Arguments.of(NO_BALL_CNT, 1),
				Arguments.of(NO_BALL_CNT, 2),
				Arguments.of(NO_BALL_CNT, 3)
		);
	}

	@DisplayName("결과가 스트라이크와 볼 둘 다 나왔을 때 테스트")
	@Test
	void printBallAndStrikeCountHintMessageTest() {
		// given : 스트라이크, 볼 둘 다 힌트로 존재할 때
		final int STRIKE_CNT = 1;
		final int BALL_CNT = 1;

		// when : hint message 를 출력
		Printer.printHintCountMessage(BALL_CNT, STRIKE_CNT);

		// then : 둘 다 포함되어 있어야 한다
		final String expected = BALL_CNT + "볼 " + STRIKE_CNT + "스트라이크\n";
		assertThat(outputStream.toString()).isEqualTo(expected);
	}

	@DisplayName("결과가 스트라이크와 볼 둘다 없을 때 낫싱 문구 출력 테스트")
	@Test
	void printNothingHintMessageTest() {
		// given : 스트라이크, 볼 둘 다 없을 때

		// when : nothing hint message 를 출력
		Printer.printHintNothingMessage();

		// then : '낫싱' 이 나와야 한다.
		final String expected = "낫싱\n";
		assertThat(outputStream.toString()).isEqualTo(expected);
	}
}