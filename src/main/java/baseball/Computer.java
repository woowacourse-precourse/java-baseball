package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    public static final int NUMBER_LENGTH = 3;
    public static final int NUMBER_MIN = 1;
    public static final int NUMBER_MAX = 9;

    private List<Integer> ballNumber;

    public List<Integer> getBallNumber() {
        return ballNumber;
    }

    public void throwTheBall() {
        Set<Integer> randomNumbers = new HashSet<>();

        while (randomNumbers.size() < NUMBER_LENGTH) {
            int num = Randoms.pickNumberInRange(NUMBER_MIN, NUMBER_MAX);
            if (!randomNumbers.contains(num)) {
                randomNumbers.add(num);
            }
        }

        ballNumber = randomNumbers.stream().collect(Collectors.toList());
    }
}
