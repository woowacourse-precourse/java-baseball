package baseball.config;

import baseball.controller.FrontController;
import baseball.service.GameStartService;
import baseball.service.UserBallService;
import baseball.util.InputValidUtil;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameConfig {

	public FrontController config() {

		InputView inputView = new InputView();
		OutputView outputView = new OutputView();

		GameStartService gameStartService = new GameStartService(inputView);
		InputValidUtil inputValidUtil = new InputValidUtil();
		UserBallService userBallService = new UserBallService(outputView, inputView);

		return new FrontController(gameStartService, userBallService, inputValidUtil);
	}

}
