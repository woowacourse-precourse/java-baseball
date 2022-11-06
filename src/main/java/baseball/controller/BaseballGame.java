package baseball.controller;

import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    public static void play() {
        OutputView.init();

        do {
            playAGame();
        } while (InputView.isRematch());
    }

    private static void playAGame() {
        Balls computer = Computer.generateBalls();
        Result result;

        do {
            Balls user = InputView.input();
            result = computer.getResult(user);
            OutputView.print(result);
        } while (!result.isGameEnd());
    }
}
