package baseball.config;

import baseball.ballnumber.InputBallNumber;
import baseball.ballnumber.RandomBallNumber;
import baseball.controller.PlayGameController;
import baseball.service.GameService;
import baseball.view.OutputView;

public class Config {
    public static PlayGameController playGameController() {
        return new PlayGameController(new GameService(new InputBallNumber(), new RandomBallNumber()), new OutputView());
    }
}
