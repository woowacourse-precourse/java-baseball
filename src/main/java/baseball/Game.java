package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    private final List<Integer> computerNum;

    public Game(List<Integer> computerNum) {
        this.computerNum = computerNum;
    }

    public int getStrikeCount(List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < Constants.INPUT_LENGTH; i++) {
            if (computerNum.get(i) == userNum.get(i)) {
                count += 1;
            }
        }
        return count;
    }

    public int getBallCount(List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < Constants.INPUT_LENGTH; i++) {
            if (computerNum.get(i) != userNum.get(i) && computerNum.contains(userNum.get(i))) {
                count += 1;
            }
        }
        return count;
    }

    public String play() {
        boolean gameClear = false;
        int strikeCount = 0;
        int ballCount = 0;
        while (!gameClear) {
            Messages.inputStart();
            String input = Console.readLine();
            List<Integer> userNum = new UserNumGenerator(input).NUMS;
            strikeCount = getStrikeCount(userNum);
            ballCount = getBallCount(userNum);
            gameClear = isClear(strikeCount);
            Messages.printResult(ballCount, strikeCount);
        }
        Messages.gameClear();
        return ballCount + "볼 " + strikeCount + "스트라이크";
    }

    public boolean isClear(int strikeCount) {
        return strikeCount == Constants.MAX_STRIKE;
    }
}

