package baseball;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class OutputHandlerTest {

	final OutputHandler io = new OutputHandler();
	final OutputStream outputStream = new ByteArrayOutputStream();

	@BeforeEach
	void setUp() {
		System.setOut(new PrintStream(outputStream));
	}

	@AfterEach
	void tearDown() {
		System.setOut(System.out);
	}

	@Test
	void printInitMessageTest() {
		String initMessage = "숫자 야구 게임을 시작합니다.\n";
		io.printInitMessage();
		assertThat(outputStream.toString()).isEqualTo(initMessage);
	}

	@Test
	void printInputMessageTest() {
		String initMessage = "숫자를 입력해주세요 : ";
		io.printInputMessage();
		assertThat(outputStream.toString()).isEqualTo(initMessage);
	}

	@Nested
	class printScoreTest {

		@Test
		void 맞춘게_하나도_없는_경우_낫싱을_출력() {
			String nothingMessage = "낫싱\n";
			Score score = new Score(0, 0);
			io.printScore(score);
			assertThat(outputStream.toString()).isEqualTo(nothingMessage);
		}

		@Test
		void 볼만_있는_경우_n볼_출력() {
			String nothingMessage = "2볼\n";
			Score score = new Score(2, 0);
			io.printScore(score);
			assertThat(outputStream.toString()).isEqualTo(nothingMessage);
		}

		@Test
		void 스트라이크만_있는_경우_n스트라이크_출력() {
			String nothingMessage = "1스트라이크\n";
			Score score = new Score(0, 1);
			io.printScore(score);
			assertThat(outputStream.toString()).isEqualTo(nothingMessage);
		}

		@Test
		void 볼과_스트라이크가_모두_있는_경우() {
			String nothingMessage = "2볼 1스트라이크\n";
			Score score = new Score(2, 1);
			io.printScore(score);
			assertThat(outputStream.toString()).isEqualTo(nothingMessage);
		}
	}

	@Test
	void printGameEndMessageTest() {
		String initMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
			+ "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
		io.printGameEndMessage();
		assertThat(outputStream.toString()).isEqualTo(initMessage);
	}
}
