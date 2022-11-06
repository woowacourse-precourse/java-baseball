package baseball;

public class BallStrikeChecker {  // 이 클래스에서 모든 판단을 끝내는걸로?

    // countSumOfBallAndStrike()는 countBall()에서만 쓰이고, 다른 곳에서는 쓰이지 않을 듯
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
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (randomNumber.charAt(i) == playerNumber.charAt(i)) {
                strike++;
            }
        }
        return strike;
    }

    public int countBall(String randomNumber, String playerNumber) {
        int sumOfBallAndStrike = countSumOfBallAndStrike(randomNumber, playerNumber);
        int strike = countStrike(randomNumber, playerNumber);
        int ball = sumOfBallAndStrike - strike;
        return ball;
    }

}
