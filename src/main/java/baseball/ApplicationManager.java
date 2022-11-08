package baseball;

import java.util.List;

public class ApplicationManager {

    private static final String RESTART = "1";

    public void play() {
        Output.printStartMessage();
        boolean isRestart = true;
        while (isRestart) {
            boolean again = true;
            List<Integer> computerNumbers = ComputerRandomNumbersFactory.createComputerRandomNumber();
            while (again) {
                UserNumber userNumber = new UserNumber(Input.inputUserNumber());
                int total = MatchCounter.countAllMatched(userNumber, computerNumbers);
                int strike = MatchCounter.countStrike(userNumber, computerNumbers);
                int ball = total - strike;
                again = isResult(total, strike, ball);
            }
            isRestart = isPlayAgain();
        }
    }

    private boolean isResult(int total, int strike, int ball) {
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
        return Input.inputRestartNumber().equals(RESTART);
    }

}
