package baseball.view;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.message.MessageConstants;
import baseball.restrict.RestrictIntegerConstants;

class TotalViewImplTest implements RestrictIntegerConstants, MessageConstants {

	private OutputStream output;
	private static final TotalViewImpl view = new TotalViewImpl();

	@BeforeEach
	void setOutputStream() {
		output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
	}

	@AfterEach
	void resetOutputStream() throws IOException {
		System.setOut(System.out);
		output.close();
	}

	@Test
	void printStartMessageTest() {
		view.printStartMessage();
		Assertions.assertThat(output.toString()).isEqualTo(START_MESSAGE);
	}

	@Test
	void printInputMessageTest() {
		view.printInputMessage();
		Assertions.assertThat(output.toString()).isEqualTo(INPUT_MESSAGE);
	}

	@Test
	void printStrikeMessageTest() {
		view.printStrikeMessage(1);
		Assertions.assertThat(output.toString()).isEqualTo("1스트라이크\n");
	}

	@Test
	void printBallMessageTest() {
		view.printBallMessage(1);
		Assertions.assertThat(output.toString()).isEqualTo("1볼\n");
	}

	@Test
	void printBallAndStrikeMessageTest() {
		view.printBallAndStrikeMessage(1, 1);
		Assertions.assertThat(output.toString()).isEqualTo("1볼 1스트라이크\n");
	}

	@Test
	void printNothingMessageTest() {
		view.printNothingMessage();
		Assertions.assertThat(output.toString()).isEqualTo(NOTHING_MESSAGE);
	}

	@Test
	void printAnswerMessage() {
		view.printAnswerMessage();
		Assertions.assertThat(output.toString()).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
	}

	@Test
	void printEndMessageTest() {
		view.printEndMessage();
		Assertions.assertThat(output.toString()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
	}
}
