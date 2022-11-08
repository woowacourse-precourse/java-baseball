package baseball.view;

import baseball.model.strikeandball.StrikeAndBall;
import baseball.utills.constants.Constants;

public class ConsoleOutput implements Output{

    @Override
    public void printStrikeandBall(StrikeAndBall result) {
        int strikeNumber = result.getStrike();
        int ballNumber = result.getBall();

        if (strikeNumber == 0 && ballNumber == 0) {
            System.out.println(Constants.NOTHING);
        }
        if (strikeNumber > 0 && ballNumber == 0) {
            System.out.println(strikeNumber + Constants.STRIKE);
        }
        if (strikeNumber == 0 && ballNumber > 0) {
            System.out.println(ballNumber + Constants.BALL);
        }
        if (strikeNumber > 0 && ballNumber > 0) {
            System.out.println(ballNumber + Constants.BALL + " " + strikeNumber + Constants.STRIKE);
        }
        if (strikeNumber == 3 && ballNumber == 0) {
            System.out.println(Constants.END_MESSAGE);
        }
    }

    @Override
    public void printInit() {
        System.out.println(Constants.START_MESSAGE);
    }
}
