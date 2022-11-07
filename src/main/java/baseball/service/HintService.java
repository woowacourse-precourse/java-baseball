package baseball.service;

import baseball.constant.Constant;

public class HintService {

    private final StringBuilder sb = new StringBuilder();
    private int strike;
    private int ball;


    public String getHint(String answerNumber, String playerNumber) {

        resetCount();
        countStrike(answerNumber, playerNumber);
        countBall(answerNumber, playerNumber);
        printBallHint(ball, "볼");
        printStrikeHint(strike, "스트라이크");
        nothing();
        return String.valueOf(sb);
    }

    public void countStrike(String answerNumber, String playerNumber) {

        for (int i = 0; i < playerNumber.length(); i++) {
            if (answerNumber.charAt(i) == playerNumber.charAt(i)) {
                strike += 1;
            }
        }
    }

    public void countBall(String answerNumber, String playerNumber) {

        for (int i = 0; i < playerNumber.length(); i++) {
            if (answerNumber.contains(Character.toString(playerNumber.charAt(i)))) {
                ball += 1;
            }
        }
    }

    public void nothing() {

        if (strike == Constant.INITIAL_NUMBER && ball == Constant.INITIAL_NUMBER) {
            sb.append("낫싱");
        }
    }

    public void resetCount() {

        sb.setLength(0);
        strike = Constant.INITIAL_NUMBER;
        ball = Constant.INITIAL_NUMBER;
    }

    public void printStrikeHint(int number, String strike) {

        if (number != 0) {
            sb.append(number).append(strike).append(" ");
        }
    }

    public void printBallHint(int number, String ball) {

        if (number - strike <= 0) {
            return;
        }
        if (number != 0) {
            sb.append(number - strike).append(ball).append(" ");
        }
    }

    public boolean isThreeStrike() {

        return strike == Constant.STRIKE_MAX_NUMBER;
    }
}
