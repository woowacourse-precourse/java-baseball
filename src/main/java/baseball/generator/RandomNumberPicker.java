package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberPicker implements NumberPicker {

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    @Override
    public int pickNumberInRange(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }

    @Override
    public String pickRandomThreeBalls() {
        Set<Integer> computer = new HashSet<>();
        while (computer.size() < 3) {
            computer.add(pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE));
        }

        return computer.stream()
            .map(Object::toString)
            .collect(Collectors.joining(""));
    }
}
