package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class RandomNumberGenerator {
    public static Integer generate() {
        return Randoms.pickNumberInList(getCandidateRandomNumbers());
    }

    private static List<Integer> getCandidateRandomNumbers() {
        List<Integer> ret = new ArrayList<>();
        for (int number = 100; number <= 999; ++number)
            if (numberValidator.valid(number))
                ret.add(number);
        return ret;
    }
}
