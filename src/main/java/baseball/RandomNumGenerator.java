package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class RandomNumGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private RandomNumGenerator() {
    }

    private static int makeRandomDigit() {
        int test = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        return test;
    }
    public static int makeRandomNumWithGameDigits() {
        HashSet<Integer> forDeleteDuplication = new HashSet<>();
        while(forDeleteDuplication.size() < SystemConstant.GAME_DIGIT) {
            int randomDigit = makeRandomDigit();
            forDeleteDuplication.add(randomDigit);
        }
        List<Integer> resultList = new ArrayList<>(forDeleteDuplication);
        return resultList
                .stream()
                .reduce((x, y) -> x * 10 + y)
                .get();
    }
}
