package baseball.Controller;

import baseball.Service.BaseballService;

public class BaseballController {

    BaseballService baseballService = new BaseballService();

    public void gameStart() {
        baseballService.gameStartMessage();

        int choiceNumber = 0;

        do {
            choiceNumber = baseballService.gameInProgress();
        } while (choiceNumber == 1);

    }
}
