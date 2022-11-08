package baseball.controller;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.UserBall;
import baseball.view.InputView;
import baseball.view.OutputView;

class GameEndControllerTest {

	private OutputView outputView = new OutputView();
	private InputView inputView = new InputView();
	private GameEndController gameEndController = new GameEndController(outputView, inputView);

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@BeforeEach
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@ParameterizedTest(name = "스트라이크 개수가 3이면 isAnswer 메서드에서 true 반환 아니면, false 를 반환한다")
	@CsvSource(value = {"3, true", "2, false"})
	void isAnswer(Integer strikeCount, boolean expected) {
		UserBall userBall = UserBall.createUserBall();
		userBall.updateStrikeCount(strikeCount);
		userBall.updateStatus();

		Assertions.assertThat(gameEndController.isAnswer(userBall)).isEqualTo(expected);
	}

	@DisplayName("gameEndController 의 isAnswer 호출하고 정답일 때, 올바른 출력문 확인 테스트")
	@Test
	void printSuccessResultTest() {
		UserBall userBall = UserBall.createUserBall();
		userBall.updateStrikeCount(3);
		userBall.updateStatus();

		gameEndController.isAnswer(userBall);

		assertThat(outContent.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
	}

}
