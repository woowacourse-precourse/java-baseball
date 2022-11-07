package baseball.controller;

import baseball.service.GameService;
import baseball.utils.PrintMessage;
import camp.nextstep.edu.missionutils.Console;

public class Controller {

    PrintMessage print = new PrintMessage();
    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        print.gameStartNotice();
        gameService.playGame();
        print.gameFinished();
        afterGame();
    }

    private void afterGame() throws IllegalArgumentException{
        if (validateAfterGame() == 1) {
            run();
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
