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
            referee.compareComputerWith(Translator.translateStringToIntegerList(InputView.inputNumbers()));
            printHint(referee.getBaseballScore());
        } while(referee.getStrikeCount() != 3);
        OutputView.showVictoryMessage();
    }

    private void printHint(BaseballScore baseballScore) {
        if(baseballScore.getBall() == 4) {
            OutputView.showFourBallResult();
        } else if (baseballScore.getStrike() == 0 && baseballScore.getBall() > 0) {
            OutputView.showOnlyBallResult(baseballScore);
        } else if(baseballScore.getStrike() > 0 && baseballScore.getBall() == 0) {
            OutputView.showOnlyStrikeResult(baseballScore);
        } else if(baseballScore.getStrike() > 0 && baseballScore.getBall() > 0) {
            OutputView.showStrikeAndBallResult(baseballScore);
        }
    }
}
