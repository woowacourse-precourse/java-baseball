package baseball.service;

import baseball.model.Computer;
import baseball.model.User;
import baseball.view.Messages;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

import static baseball.model.Constants.*;

public class Game {
    public List<Integer> computerNum;

    public Game() {
        this.computerNum = new Computer().computerNum;
    }

    public void play() {
        boolean gameClear = false;
        while (!gameClear) {
            List<Integer> userNum = inputStartAndGenerateUserNum();
            gameClear = isClear(getStrikeCount(userNum));
            Messages.printResult(getBallCount(userNum), getStrikeCount(userNum));
        }
        Messages.gameClear();
    }

    public List<Integer> inputStartAndGenerateUserNum() {
        Messages.inputStart();
        String input = Console.readLine();
        return new User(input).NUMS;
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

    public boolean isClear(int strikeCount) {
        return strikeCount == MAX_STRIKE;
    }
}

