package baseball.baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.baseball.Digits.DIGIT_COUNT;

public class BaseballGame {

    private int getStrikeCount(Digits digits1, Digits digits2) {
        return (int) IntStream.range(0, DIGIT_COUNT)
                .filter(idx -> digits1.get(idx) == digits2.get(idx))
                .count();
    }

    private int getBallCount(Digits digits1, Digits digits2) {
        Set<Integer> distinctDigits = new HashSet<>(digits1.getList());
        distinctDigits.addAll(digits2.getList());

        int distinctDigitsCount = DIGIT_COUNT * 2 - distinctDigits.size();
        return distinctDigitsCount - getStrikeCount(digits1, digits2);
    }

    public Result match(Digits digits1, Digits digits2) {
        int strikeCount = getStrikeCount(digits1, digits2);
        int ballCount = getBallCount(digits1, digits2);

        return new Result(strikeCount, ballCount);
    }
}
