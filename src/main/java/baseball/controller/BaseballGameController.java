package baseball.controller;

import baseball.printer.GameGuidePrinter;
import baseball.service.BaseballGameService;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGameController {

    private BaseballGameService baseballGameService = new BaseballGameService();

    private final int START = 1;
    private final int END = 9;
    private final int SIZE = 3;

    private void init() {
        baseballGameService.initGame(START, END, SIZE);
    }

    public void run() throws IllegalArgumentException{
        init();
        start();
        end();
        retry();
    }

    private void start() throws IllegalArgumentException{
        baseballGameService.playGame();
    }

    private void end() {
        GameGuidePrinter.endGameMessage();
    }

    private void retry() throws IllegalArgumentException{
        GameGuidePrinter.retryGameMessage();
        if (getInputNumber() == 1) {
            run();
        }
    }

    private int getInputNumber() throws IllegalArgumentException{
        String input = Console.readLine();

        if (input.length() != 1) {
            throw new IllegalArgumentException();
        }
        if (input.charAt(0) != '1' && input.charAt(0) != '2') {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(input);
    }

}
