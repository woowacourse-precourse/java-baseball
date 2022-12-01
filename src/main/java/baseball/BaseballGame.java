package baseball;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGame {
    private final int ORIGINAL_COUNT = 3;
    private final String WIN_CONDITION = "3스트라이크";
    private ComputerNumbers computerNumbers;
    private ScoreBoard scoreBoard;

    public void generateComputerNumbers(ComputerNumberGenerator computerNumberGenerator) {
        computerNumbers = new ComputerNumbers(computerNumberGenerator.generate());
    }

    public String getResult(String playerNumbers) {
        List<String> numbersWithoutStrike = deleteStrike(stringToList(playerNumbers));
        System.out.println(numbersWithoutStrike);
        scoreBoard = new ScoreBoard(getBallCount(numbersWithoutStrike), getStrikeCount(numbersWithoutStrike));
        return scoreBoard.get();
    }

    public boolean isWin() {
        return scoreBoard.get().contains(WIN_CONDITION);
    }

    private List<String> deleteStrike(List<String> playerNumbers) {
        return playerNumbers.stream()
                .filter(number -> !computerNumbers.isStrike(number, playerNumbers.indexOf(number)))
                .collect(Collectors.toList());
    }

    private int getStrikeCount(List<String> strikeDeletedNumbers) {
        return ORIGINAL_COUNT - strikeDeletedNumbers.size();
    }

    private int getBallCount(List<String> strikeDeletedNumbers) {
        int ball = 0;
        for (String number : strikeDeletedNumbers) {
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