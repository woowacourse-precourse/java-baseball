package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RandomUtil {

    public static int createRandomNumber() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 9, 3);
        List<String> stringRandomNumbers = randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return Integer.parseInt(String.join("", stringRandomNumbers));
    }
}
