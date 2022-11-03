package baseball;

import baseball.config.GameConfig;
import baseball.controller.FrontController;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		FrontController frontController = new GameConfig().config();
		frontController.startApplication();
	}
}
