package baseball;

import baseball.config.GameConfig;
import baseball.controller.GameCenterController;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		GameCenterController gameCenterController = new GameConfig().config();
		gameCenterController.startApplication();
	}
}
