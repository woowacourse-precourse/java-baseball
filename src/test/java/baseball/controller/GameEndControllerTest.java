package baseball.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.domain.UserBall;
import baseball.view.InputView;
import baseball.view.OutputView;

class GameEndControllerTest {

	private OutputView outputView = new OutputView();
	private InputView inputView = new InputView();
	private GameEndController gameEndController = new GameEndController(outputView, inputView);

	@Test
	void isAnswer() {

		UserBall userBall1 = UserBall.createUserBall();
		userBall1.updateStrikeCount(3);
		userBall1.updateStatus();
		Assertions.assertTrue(gameEndController.isAnswer(userBall1));

		UserBall userBall2 = UserBall.createUserBall();
		userBall2.updateStrikeCount(2);
		userBall2.updateStatus();

		Assertions.assertFalse(gameEndController.isAnswer(userBall2));

	}
}
