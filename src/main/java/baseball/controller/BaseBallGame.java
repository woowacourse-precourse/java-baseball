package baseball.controller;

import baseball.model.Judgement;
import baseball.model.NumberGenerator;
import baseball.model.OffenseNumberGenerator;
import baseball.view.Display;
import baseball.view.UserInput;

import java.util.List;


public class BaseBallGame {
    private boolean repeatFlag;

    private NumberGenerator numberGenerator;
    private OffenseNumberGenerator offenseNumberGenerator;

    private Display display;
    private UserInput userInput;

    public BaseBallGame() {
        repeatFlag = true;
        numberGenerator = new NumberGenerator();
        offenseNumberGenerator = new OffenseNumberGenerator();
        display = new Display();
        userInput = new UserInput();
    }

    public void startGame() {
        display.printStartGame();
        repeatGame();
    }

    public void repeatGame() {
        while (repeatFlag) {
            createNewGame();
        }
    }

    private boolean createNewGame() {
        List defenseNumbers = numberGenerator.createDefenseNumbers();
        offense(defenseNumbers);

        String inputContinueGame = askContinueGame();

        // TODO: 대답에 따라 게임을 계속할지 판단하는 기능
        return false;
    }

    private void offense(List<Integer> defenseNumbers) {
        Judgement judgement = new Judgement(defenseNumbers);
        boolean offenseFailure = true;

        while (offenseFailure) {
            display.printInputOffenseNumber();

            List<Integer> offenseNumbers = offenseNumberGenerator.generateOffenseNumbers();

            offenseFailure = !judgement.isThreeStrike(offenseNumbers);
            List<Integer> resultOfJudgement = judgement.judgeOffenseNumbers(offenseNumbers);

            printJudgement(resultOfJudgement);
        }
    }

    private void printJudgement(List<Integer> resultOfJudgement) {
        int ballCount = resultOfJudgement.get(0);
        int strikeCount = resultOfJudgement.get(1);

        if (strikeCount == 3) {
            display.printThreeStrike();
        } else if (strikeCount == 0 && ballCount == 0) {
            display.printNothing();
        } else {
            display.printBallAndStrike(ballCount, strikeCount);
        }
    }

    private String askContinueGame() {
        display.printContinueGame();

        String inputContinueGame = userInput.input();
        userInput.validateContinueInput(inputContinueGame);
        return inputContinueGame;
    }
}
