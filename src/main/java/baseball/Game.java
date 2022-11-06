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
                .filter(i -> computerNum.contains(userNum.get(i)) && userNum.get(i) != computerNum.get(i))
                .count();
    }

    public List<Integer> inputStartAndGenerateNum() {
        Messages.inputStart();
        String input = Console.readLine();
        return new UserNumGenerator(input).NUMS;
    }

    public void play() {
        boolean gameClear = false;
        while (!gameClear) {
            List<Integer> userNum = inputStartAndGenerateNum();
            gameClear = isClear(getStrikeCount(userNum));
            Messages.printResult(getBallCount(userNum), getStrikeCount(userNum));
        }
        Messages.gameClear();
    }

    public boolean isClear(int strikeCount) {
        return strikeCount == MAX_STRIKE;
    }
}

