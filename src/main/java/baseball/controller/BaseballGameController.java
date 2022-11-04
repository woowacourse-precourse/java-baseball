package baseball.controller;

import baseball.service.BaseballGameService;
import baseball.view.GameScreen;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class BaseballGameController {

    private final BaseballGameService baseballGameService = new BaseballGameService();

    public void startGame() {
        GameScreen.printGameStart();
        GameScreen.printUserInput();
        String playerInputNumbers = Console.readLine();

        baseballGameService.newGame();
        List<Integer> gameResult = baseballGameService.playGame(playerInputNumbers);
        GameScreen.printGameResult(gameResult);
    }

}
