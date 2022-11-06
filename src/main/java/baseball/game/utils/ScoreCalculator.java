package baseball.game.utils;

import baseball.game.utils.ScoreBoard;
import java.util.List;

public class ScoreCalculator {

    public static ScoreBoard calculate(List<Integer> targetNumbers, List<Integer> requestNumbers) {
        ScoreBoard scoreBoard = new ScoreBoard();

        for (int number : requestNumbers) {
            if (targetNumbers.indexOf(number) == requestNumbers.indexOf(number)) {
                scoreBoard.addStrike();
                continue;
            }

            if (targetNumbers.contains(number)) {
                scoreBoard.addBall();
            }
        }

        return scoreBoard;
    }
}
