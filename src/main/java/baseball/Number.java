package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Number {
    private static final int DIGIT_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    public List randomNumber() {
        Set<Integer> digitNumberSet = new HashSet<>();

        while(digitNumberSet != null && digitNumberSet.size() < DIGIT_NUMBER) {
            digitNumberSet.add(pickRandomDigitNumber());
        }

        List<Integer> digits = new ArrayList<>(digitNumberSet);

        return digits;
    }

    private int pickRandomDigitNumber() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

}
