package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseballGame {
    private final int ORIGINAL_COUNT = 3;
    private final String WIN_CONDITION = "3스트라이크";
    private final ComputerNumbers computerNumbers;

    BaseballGame() {
        ComputerNumberGenerator computerNumberGenerator = new ComputerNumberGenerator();
        computerNumbers = new ComputerNumbers(computerNumberGenerator.generate());
    }

    public ScoreBoard getResult(String playerNumbers) {
        List<String> strikeDeletedNumbers = computerNumbers.deleteStrike(stringToList(playerNumbers));
        int strike = getStrikeCount(strikeDeletedNumbers);
        int ball = getBallCount(strikeDeletedNumbers);
        return new ScoreBoard(ball, strike);
    }

    public boolean isWin(ScoreBoard scoreBoard) {
        return scoreBoard.get().equals(WIN_CONDITION);
    }

    private int getStrikeCount(List<String> strikeDeletedNumbers) {
        return ORIGINAL_COUNT - strikeDeletedNumbers.size();
    }

    private int getBallCount(List<String> playerNumbers) {
        int ball = 0;
        for (String number : playerNumbers) {
            if (computerNumbers.isBall(number)) {
                ball++;
            }
        }
        return ball;
    }

    private ArrayList<String> stringToList(String playerNumbers) {
        return new ArrayList<>(Arrays.asList(playerNumbers.split("")));
    }
}