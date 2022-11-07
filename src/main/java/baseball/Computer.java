package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int NUMBER_SIZE = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    private List<Integer> numbers;

    public Computer() {}

    public void setNumbers() {
        Set<Integer> numbersSet = new HashSet<>();
        while(numbersSet != null && numbersSet.size() < NUMBER_SIZE) {
            numbersSet.add(Randoms.pickNumberInRange(MINIMUM_NUMBER,MAXIMUM_NUMBER));
        }
        setToArrayList(numbersSet);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void setToArrayList(Set<Integer> numbersSet) {
        numbers = new ArrayList<>(numbersSet);
    }
}
