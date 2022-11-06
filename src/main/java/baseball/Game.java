package baseball;

import java.util.List;

public class Game {

    public static String start(List<Integer> computer, List<Integer> player) {
        GameScore gameScore = getBallAndStrikeCount(computer, player);
        return getPrintString(gameScore);
    }

    private static GameScore getBallAndStrikeCount(List<Integer> computer, List<Integer> player) {
        GameScore gameScore = new GameScore();
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (computer.get(i).equals(player.get(i))) {
                strike++;
            } else if (computer.contains(player.get(i))) {
                ball++;
            }
        }
        gameScore.setBall(ball);
        gameScore.setStrike(strike);
        return gameScore;
    }

    private static String getPrintString(GameScore gameScore) {
        int ball = gameScore.getBall();
        int strike = gameScore.getStrike();

        if (ball == 0 && strike != 0) {
            return strike + BallStatus.STRIKE.getValue();
        }
        if (ball != 0 && strike == 0) {
            return ball + BallStatus.BALL.getValue();
        }
        if (ball != 0 && strike != 0) {
            return ball + BallStatus.BALL.getValue() + " " + strike + BallStatus.STRIKE.getValue();
        }
        return BallStatus.NOTHING.getValue();
    }

}
