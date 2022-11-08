package baseball;

import java.util.ArrayList;

public class Game {
    private Computer computer;
    private Referee referee;

    public Game() {
        computer = new Computer(new ArrayList<>());
        computer.generateRandomNumbers();
        referee = new Referee(computer);
    }

    public void play() {
        do {
            String input = InputView.inputNumbers();
            Validator.validateInputLength(input);

            referee.compareComputerWith(Translator.translateStringToIntegerList(input));

            printHint(referee.getBallCount(), referee.getStrikeCount());
        } while (referee.getStrikeCount() != 3);

        OutputView.showVictoryMessage();
    }

    private void printHint(int ball, int strike) {
        if (ball == 4) {
            OutputView.showFourBallResult();
        } else if (ball > 0 && strike == 0) {
            OutputView.showOnlyBallResult(ball);
        } else if (ball == 0 && strike > 0) {
            OutputView.showOnlyStrikeResult(strike);
        } else if (ball > 0 && strike > 0) {
            OutputView.showBallAndStrikeResult(ball, strike);
        } else if (ball == 0 && strike == 0) {
            OutputView.showBallAndStrikeNothing();
        }
    }
}
