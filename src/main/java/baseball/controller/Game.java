package baseball.controller;

import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

    private static final int GAME_FINISH_CRITERIA = 3;

    private final InputView inputView;
    private final OutputView outputView;
    private final Numbers computerNumbers;

    public Game(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computerNumbers = Numbers.randomized();
    }

    public void play() {
        outputView.printGameBegin();
        continuePlaying();
    }

    private void continuePlaying() {
        Numbers userNumbers = Numbers.fromIntegers(inputView.promptNumbers());

        Long balls = userNumbers.countBallsWith(computerNumbers);
        Long strikes = userNumbers.countStrikesWith(computerNumbers);
        outputView.printResult(balls, strikes);
        if (strikes == GAME_FINISH_CRITERIA) {
            outputView.printGameFinish();
            return;
        }
        continuePlaying();
    }
}
