package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseballNumber {
    private final int MAX_SIZE = 3;
    private List<Integer> baseballNumber;

    public BaseballNumber() {
        baseballNumber = new ArrayList<>(MAX_SIZE);
        Set<Integer> set = new HashSet<>();
        while (baseballNumber.size() < MAX_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!set.contains(randomNumber)) {
                baseballNumber.add(randomNumber);
                set.add(randomNumber);
            }
        }
    }

    public BaseballNumber(String input) {
        baseballNumber = input.chars().map(c -> c - '0').boxed().collect(Collectors.toList());
    }
}
