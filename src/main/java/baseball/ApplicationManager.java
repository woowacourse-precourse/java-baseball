package baseball;

import java.util.List;

public class ApplicationManager {

    public void play() {
        Output.printStartMessage();
        List<Integer> computerNumbers = ComputerRandomNumbersFactory.createComputerRandomNumber();
        UserNumber userNumber = new UserNumber(Input.inputUserNumber());

        while (true) {
            int total = Comparison.compare(userNumber, computerNumbers);
            int strike = Comparison.findStrike(userNumber, computerNumbers);
            int ball = total - strike;

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
        }

    }



}
