package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomUtil {

    private static final int RANDOM_NUMBER_CORRECT_LENGTH = 3;
    private static final int RANDOM_NUMBER_RANGE_START_NUMBER = 1;
    private static final int RANDOM_NUMBER_RANGE_END_NUMBER = 9;
    private static final String RANDOM_NUMBER_JOIN_DELIMITER = "";

    public static int createRandomNumber() {
        Set<Integer> randomNumbers = new HashSet<>();
        while(randomNumbers.size() !=RANDOM_NUMBER_CORRECT_LENGTH) {
            randomNumbers.add(Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START_NUMBER, RANDOM_NUMBER_RANGE_END_NUMBER));
        }
        List<String> stringRandomNumbers = randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return Integer.parseInt(String.join(RANDOM_NUMBER_JOIN_DELIMITER, stringRandomNumbers));
    }
}
