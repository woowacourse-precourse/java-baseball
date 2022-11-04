package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomUtil {

    public static int createRandomNumber() {
        Set<Integer> randomNumbers = new HashSet<>();
        while(randomNumbers.size() != 3) {
            randomNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        List<String> stringRandomNumbers = randomNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return Integer.parseInt(String.join("", stringRandomNumbers));
    }
}
