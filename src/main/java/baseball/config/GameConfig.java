package baseball.config;

import baseball.controller.GameCenterController;
import baseball.controller.GameEndController;
import baseball.controller.GameStartController;
import baseball.service.UserBallService;
import baseball.util.InputValidUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameConfig {

	public GameCenterController config() {

		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		GameStartController gameStartController = new GameStartController(inputView);
		InputValidUtil inputValidUtil = new InputValidUtil();
		UserBallService userBallService = new UserBallService();
		GameEndController gameEndController = new GameEndController(outputView, inputView);

		return new GameCenterController(gameStartController, userBallService, gameEndController, inputValidUtil);
	}

}
