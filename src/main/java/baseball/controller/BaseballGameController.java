package baseball.controller;

import baseball.model.Umpire;
import baseball.service.BaseballGameService;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();

    public void startGame() {
        GameScreen.printGameStart();
        GameScreen.printUserInput();
        String playerInputNumbers = Console.readLine();

        baseballGameService.newGame();
        Umpire umpire = baseballGameService.playGame(playerInputNumbers);
        GameScreen.printGameResult(umpire);
    }

}
