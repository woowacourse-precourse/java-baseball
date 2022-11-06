package baseball;

public class BallStrikeChecker {  // 이 클래스에서 모든 판단을 끝내는걸로?

    public int countSumOfBallAndStrike(String randomNumber, String playerNumber) {
        int sumOfBallAndStrike = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber.contains(playerNumber.substring(i, i+1))) { // playerNumber.charAt(i)은 왜 안되지?
                sumOfBallAndStrike++;
            }
        }
        return sumOfBallAndStrike;
    }

    public int countStrike(String randomNumber, String playerNumber) {

    }

    public int countBall(String randomNumber, String playerNumber) {
        int sumOfBallAndStrike = countSumOfBallAndStrike(randomNumber, playerNumber);
        int strike = countStrike(randomNumber, playerNumber);
        int ball = sumOfBallAndStrike - strike;
        return ball;
    }

}
