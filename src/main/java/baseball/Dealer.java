package baseball;

import static baseball.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dealer {
    private List<Integer> threeDifferentNumbers;

    public List<Integer> createThreeDifferentNumbers() {
        threeDifferentNumbers = new ArrayList<>();
        Set<Integer> pickedNumbers = new HashSet<>();

        while (pickedNumbers.size() < THREE_DIGITS) {
            Integer number = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            pickedNumbers.add(number);
        }
        threeDifferentNumbers.addAll(pickedNumbers);
        Collections.shuffle(threeDifferentNumbers); // Unless the numbers will be arranged in ascending order.
        System.out.println(threeDifferentNumbers);
        return threeDifferentNumbers;
    }
}
