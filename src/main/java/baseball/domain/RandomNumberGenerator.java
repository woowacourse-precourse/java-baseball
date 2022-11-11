package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static final int SIZE = 3;
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;

    private final List<Integer> threeUniqueNumbers = new ArrayList<>(SIZE);

    public List<Integer> getNumbers() {
        return getThreeUniqueNumbers();
    }

    private List<Integer> getThreeUniqueNumbers() {
        int randomNumber;

        while (threeUniqueNumbers.size() < SIZE) {
            randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);

            if (threeUniqueNumbers.contains(randomNumber)) {
                continue;
            }

            threeUniqueNumbers.add(randomNumber);
        }

        return threeUniqueNumbers;
    }

}
