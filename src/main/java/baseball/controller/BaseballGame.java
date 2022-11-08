package baseball.controller;

import baseball.model.NumberValidator;
import baseball.model.ValidateNumberLength;

import java.util.List;
import java.util.stream.IntStream;

import static baseball.model.ValidateNumberLength.NUMBER_LENGTH;

public class BaseballGame {
    public final int STRIKE_COUNT;
    public final int BALL_COUNT;

    public BaseballGame(List<Integer> userNum, List<Integer> computerNum) {
        this.STRIKE_COUNT = setStrikeCount(userNum, computerNum);
        this.BALL_COUNT = setBallCount(userNum, computerNum);
    }

    private int setStrikeCount(List<Integer> userNum, List<Integer> computerNum) {
        return (int) IntStream.iterate(0, i -> i + 1)
                .limit(NUMBER_LENGTH.getNumber())
                .filter(i -> userNum.get(i).equals(computerNum.get(i)))
                .count();
    }

    private int setBallCount(List<Integer> userNum, List<Integer> computerNum) {
        return (int) IntStream.iterate(0, i -> i + 1)
                .limit(NUMBER_LENGTH.getNumber())
                .filter(i -> !userNum.get(i).equals(computerNum.get(i)))
                .filter(i -> NumberValidator.isNumberExistInList(userNum.get(i), computerNum))
                .count();
    }
}
