package baseball.config;

import baseball.number.InputNumber;
import baseball.number.RandomNumber;
import baseball.controller.PlayGameController;
import baseball.service.GameService;
import baseball.view.OutputView;

public class Config {
    public static GameService gameService() {
        return new GameService(new InputNumber(), new RandomNumber());
    }
    public static PlayGameController playGameController() {
        return new PlayGameController(gameService(), new OutputView());
    }
}
