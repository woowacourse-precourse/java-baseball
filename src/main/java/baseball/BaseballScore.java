package baseball;

import java.util.List;

import static constant.BaseballConstant.*;

public class BaseballScore {

    private int strike;
    private int ball;

    public BaseballScore() {
        strike = 0;
        ball = 0;
    }

    public void compareComputerAndUser(List<Integer> computerNumbers, String userNumber) {
        for (int index = 0; index < NUMBER_LENGTH; index++) {
            if (isStrike(computerNumbers, userNumber, index)) {
                strike++;
            } else if (isBall(computerNumbers, userNumber, index)) {
                ball++;
            }
        }
    }

    private boolean isStrike(List<Integer> computerNumbers, String userNumber, int index) {
        return userNumber.charAt(index) - '0' == computerNumbers.get(index);
    }

    private boolean isBall(List<Integer> computerNumbers, String userNumber, int index) {
        return computerNumbers.contains(userNumber.charAt(index) - '0');
    }

    public String getResult() {
        String resultMessage = "";
        if (ball == 0 && strike == 0) {
            return NOTHING_MESSAGE;
        }
        if (ball > 0 && strike == 0) {
            resultMessage = ball + BALL_MESSAGE;
        } else if (strike > 0 && ball == 0) {
            resultMessage = strike + STRIKE_MESSAGE;
        } else if (ball > 0 && strike > 0) {
            resultMessage = ball + BALL_MESSAGE + SPACE + strike + STRIKE_MESSAGE;
        }

        return resultMessage;
    }

    public boolean checkCorrect() {
        return strike == NUMBER_LENGTH;
    }

    public void resetResult() {
        ball = 0;
        strike = 0;
    }
}
