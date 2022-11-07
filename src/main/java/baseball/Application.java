package baseball;

import baseball.service.BaseballGameServiceImpl;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
		GameService baseballGameService = new BaseballGameServiceImpl();

		baseballGameService.startGame();
    }
}
