package baseball.service;

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
}
