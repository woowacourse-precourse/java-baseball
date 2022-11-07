package baseball;

import java.util.List;

public class Game {

    private static final String THREE_STRIKE = "3스트라이크";

    public static void start() {
        Player computer = new Player();
        computer.setComputerNumbers();
        List<Integer> computerNumbers = computer.getNumbers();

        String answer = "";
        Player user = new Player();
        while (!answer.equals(THREE_STRIKE)) {
            user.input();
            List<Integer> userNumbers = user.getNumbers();
            answer = Game.calculateNumberOfGameScore(computerNumbers, userNumbers);
            System.out.println(answer);
        }
    }

    public static String calculateNumberOfGameScore(List<Integer> computer, List<Integer> player) {
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

    public static boolean isPlayAgain() {
        Player player = new Player();
        int input = player.gameOverInput();
        return input == 1;
    }
}
