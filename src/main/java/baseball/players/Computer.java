package baseball.players;

import static baseball.settings.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    public List<Integer> createThreeDifferentNumbers() {
        List<Integer> threeDifferentNumbers = new ArrayList<>();

        while (threeDifferentNumbers.size() < THREE_DIGITS) {
            addDigit(threeDifferentNumbers);
        }
        return threeDifferentNumbers;
    }

    public void addDigit(List<Integer> numbers) {
        int digit = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        numbers.add(digit);
        numbers.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
