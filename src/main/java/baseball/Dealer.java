package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dealer {
    private boolean isGameGoing = true;
    private List<Integer> threeDifferentNumbers;

    public List<Integer> createThreeDifferentNumbers() {
        threeDifferentNumbers = new ArrayList<>();
        Set<Integer> pickedNumbers = new HashSet<>();

        while (pickedNumbers.size() < 3) {
            Integer number = Randoms.pickNumberInRange(1, 9);
            pickedNumbers.add(number);
        }
        threeDifferentNumbers.addAll(pickedNumbers);
        Collections.shuffle(threeDifferentNumbers); // Unless the numbers will be arranged in ascending order.
        return threeDifferentNumbers;
    }
}
