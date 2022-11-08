package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Computer {
    private Computer() {}

    public static String getRandomNumberString() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);

        return randomNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
