package baseball;

import java.util.List;

public class BaseballGame {
    ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
    Input input = new Input();
    Output output = new Output();
    Decision decision = new Decision();

    public void play() {
        output.printStartingMessage();

        List<Integer> computerNumbers = computerNumberGenerator.generateComputerNumber();
        boolean isCorrect;

        do {
            String inputUserNumber = input.inputUserNumber();
            input.inputUserNumberValid(inputUserNumber);
            List<Integer> userNumbers = input.inputToList(inputUserNumber);

            int strike = decision.countStrike(userNumbers, computerNumbers);
            int ball = decision.countBall(userNumbers, computerNumbers);
            output.printDecisionResult(strike, ball);

            isCorrect = decision.isThreeStrike(strike);

        } while (!isCorrect);

        output.printEndingMessage();
    }
}
