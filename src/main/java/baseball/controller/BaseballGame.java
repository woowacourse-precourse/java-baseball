package baseball.controller;

import baseball.view.UserInput;
import baseball.model.DefenseNumberGenerator;
import baseball.model.Judgement;
import baseball.model.OffenseNumberGenerator;
import baseball.view.Display;

import java.util.List;

public class BaseballGame {
    private static final DefenseNumberGenerator defenseNumberGenerator = DefenseNumberGenerator.getInstance();
    private static final OffenseNumberGenerator offenseNumberGenerator = OffenseNumberGenerator.getInstance();
    private static final Display display = Display.getInstance();
    private static final UserInput userInput = UserInput.getInstance();

    public void playBaseballGame() {
        List<Integer> defenseNumbers = defenseNumberGenerator.createDefenseNumbers();
        Judgement judgement = Judgement.from(defenseNumbers);

        offense(judgement);
    }

    private void offense(Judgement judgement) {
        List<Integer> offenseNumbers;
        do {
            offenseNumbers = createOffenseNumbers();

            int strikeCount = judgement.countStrike(offenseNumbers);
            int ballCount = judgement.countBall(offenseNumbers);

            printJudgement(ballCount, strikeCount);
        } while (judgement.isFailureOffense(offenseNumbers));
    }

    private List<Integer> createOffenseNumbers() {
        display.printInputOffenseNumber();

        String input = userInput.input();
        return offenseNumberGenerator.generateOffenseNumbers(input);
    }


    private void printJudgement(int ballCount, int strikeCount) {
        if (strikeCount == 3) {
            display.printThreeStrike();
        } else if (strikeCount == 0 && ballCount == 0) {
            display.printNothing();
        } else if (ballCount == 0) {
            display.printStrikeOnly(strikeCount);
        } else if (strikeCount == 0) {
            display.printBallOnly(ballCount);
        } else {
            display.printBallAndStrike(ballCount, strikeCount);
        }
    }
}
