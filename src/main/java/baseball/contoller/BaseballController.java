package baseball.contoller;

import baseball.service.BaseballService;
import baseball.utils.Constant;

public class BaseballController {

    private final BaseballService baseballService;

    public BaseballController() {
        baseballService = new BaseballService();
    }

    public void Start() {
        System.out.println(Constant.START_GAME.getMessage());
        baseballService.createRandomNumbers();
        while (baseballService.getGameStatus()) {
            baseballService.getUserNumbers();
            outputHint(computer.randomNumbers, user.userNumbers);
            if (isAnswer(strike)) {
                outputRestart();
            }
        }
    }
}
