package baseball.view;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

	private InputView inputView = new InputView();
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	void printGameStart() {
		inputView.printGameStart();
		assertThat(outContent.toString()).contains("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ");
	}

	@Test
	void printGameRestart() {
		inputView.printGameRestart();
		assertThat(outContent.toString()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}
}
