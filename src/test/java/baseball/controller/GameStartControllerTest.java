package baseball.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.view.InputView;

class GameStartControllerTest {

	private InputView inputView = new InputView();
	private GameStartController gameStartController = new GameStartController(inputView);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@DisplayName("gameStartController 의 initGame 호출시 올바른 출력문 확인 테스트")
	@Test
	void check_printGameStart() {
		gameStartController.initGame();
		assertThat(outContent.toString()).contains("숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ");
	}

	@DisplayName("gameStartController 의 initGame 의 반환된 랜덤 정답값이 올바른 범위의 숫자인지 확인 테스트")
	@Test
	void check_makeAnswerNumber() {
		List<Integer> answerNumber = gameStartController.initGame();
		long validNumberCount = answerNumber.stream()
			.filter(number -> (number >= 1) && (number <= 9))
			.count();
		Assertions.assertAll(
			() -> assertThat(validNumberCount).isEqualTo(3)
		);
	}

}
