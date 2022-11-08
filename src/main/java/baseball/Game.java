package baseball;

import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {

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
        if (strikes == 3) {
            outputView.printGameFinish();
            return;
        }
        continuePlaying();
    }
}
