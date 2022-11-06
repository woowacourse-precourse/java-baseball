package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RandomNumberProvider {

    public static final int START = 1;
    public static final int END = 9;
    public static final int MAX_SIZE_OF_LIST = 3;


    private static Integer generateRandomInt() {
        return Randoms.pickNumberInRange(START, END);
    }

    public static List<Integer> generateRandomIntList() {
        Set<Integer> RandomInts = new HashSet<>();

        while (RandomInts.size() < MAX_SIZE_OF_LIST) {
            RandomInts.add(generateRandomInt());
        }

        return RandomInts.stream().collect(Collectors.toList());
    }
}
