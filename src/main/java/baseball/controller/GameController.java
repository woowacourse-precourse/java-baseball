package baseball.controller;

import baseball.model.Computer;
import baseball.model.Judge;
import baseball.model.Player;
import baseball.model.Validator;
import baseball.view.InputView;
import baseball.view.OutputView;

import static baseball.model.GameCommand.REPLAY;

public class GameController {

    private Judge judge = new Judge();
    private String gameCommand = "";

    public void startGame() {
        Computer computer = new Computer();
        while (!judge.gameSucceeded()) {
            judge = new Judge();
            guess(computer, judge);
        }
        OutputView.printInputGameCommandMessage();
        gameCommand = InputView.readGameCommand();
        Validator.validateGameCommand(gameCommand);
    }

    public void guess(Computer computer, Judge judge) {
        OutputView.printInputPlayerNumMessage();
        Player player = new Player(InputView.readPlayerNum());
        judge.compareNumbers(computer.get(), player.get());
        OutputView.printResult(judge.setResult().toString());
    }

}