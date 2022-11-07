package baseball.controller;

import baseball.service.GameService;
import baseball.utils.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    final int startNum = 1;
    final int endNum = 9;
    PrintMessage print = new PrintMessage();
    GameService gameService = new GameService();

    public void runGame() throws IllegalArgumentException {
        print.gameStartNotice();
        gameService.playGame(startNum, endNum);
        print.gameFinished();
        print.gameRestartOrNot();
        afterGame();
    }

    private void afterGame() throws IllegalArgumentException{
        if (validateAfterGame() == 1) {
            runGame();
        }
    }

    private int validateAfterGame() throws IllegalArgumentException {
        int input = Integer.parseInt(Console.readLine());

        if (input > 2 || input == 0) {
            throw new IllegalArgumentException();
        }
        return input;
    }

}
