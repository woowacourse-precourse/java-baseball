package baseball;

public class Application {
    public static void main(String[] args) {
        NumberMaker numberMaker = new NumberMaker();
        String randomNumber = numberMaker.makeRandomNumber();
        String playerNumber = numberMaker.makePlayerNumber();

        int ball;
        int strike;
        // 완전히 동일한 경우
        if (randomNumber.equals(numberMaker)) {

        } else {

        }
        // while문 들어가야 함
        BallStrikeChecker ballStrikeChecker = new BallStrikeChecker();
        ball = ballStrikeChecker.countBall(randomNumber, playerNumber);
        strike = ballStrikeChecker.countStrike(randomNumber, playerNumber);

    }
}
