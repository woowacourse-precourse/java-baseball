package baseball;

import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;

import static baseball.Constants.INPUT_LENGTH;
import static baseball.Constants.MAX_STRIKE;

public class Game {
    private final List<Integer> computerNum;

    public Game(List<Integer> computerNum) {
        this.computerNum = computerNum;
    }

    public int getStrikeCount(List<Integer> userNum) {
        return (int) Stream.iterate(0, i -> i < INPUT_LENGTH, i -> i + 1)
                .filter(i -> userNum.get(i) == computerNum.get(i))
                .count();
    }

    public int getBallCount(List<Integer> userNum) {
        return (int) Stream.iterate(0, i -> i < INPUT_LENGTH, i -> i + 1)
                .filter(i -> computerNum.contains(userNum.get(i)))
                .count();
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
        return strikeCount == MAX_STRIKE;
    }
}

