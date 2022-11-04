package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

import static baseball.Digits.DIGIT_COUNT;

public class BaseballGame {

    public BaseballGame() {

    }

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

    public Digits createRandomDigits() {
        return new Digits(Randoms.pickUniqueNumbersInRange(1, 9, DIGIT_COUNT));
    }
}
