package baseball;

import java.util.List;

public class ApplicationManager {

    public void play() {
        Output.printStartMessage();
        boolean isRestart = true;
        while (isRestart) {
            boolean again = true;
            List<Integer> computerNumbers = ComputerRandomNumbersFactory.createComputerRandomNumber();
            while (again) {
                UserNumber userNumber = new UserNumber(Input.inputUserNumber());
                int total = Comparison.compare(userNumber, computerNumbers);
                int strike = Comparison.findStrike(userNumber, computerNumbers);
                int ball = total - strike;
                again = findResults(total, strike, ball);
            }
            isRestart = isPlayAgain();
        }
    }

    private boolean findResults(int total, int strike, int ball) {
        if (Results.isThreeStrike(strike)) {
            Output.printStrike(strike);
            Output.printEndMessage();
            return false;
        }
        if(Results.isNothing(total)){
            Output.printNothing();
        }
        if(Results.isBall(total, strike)){
            Output.printBall(ball);
        }
        if(Results.isStrike(total, ball)){
            Output.printStrike(strike);
        }
        if (Results.isBallStrike(total, ball, strike)){
            Output.printBallStrike(ball, strike);
        }
        return true;
    }

    private boolean isPlayAgain() {
        return Input.inputRestartNumber().equals("1");
    }

}
