package baseball;

import java.util.List;

public class Game {

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
}
