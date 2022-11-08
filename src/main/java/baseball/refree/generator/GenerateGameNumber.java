package baseball.refree.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateGameNumber {

    private static final int RANGE_MIN_NUM = 1;
    private static final int RNAGE_MAX_NUM = 9;

    private static List<Integer> computerNumber;

    public void GenerateGameNumber() {
    }

    public List<Integer> getGenerateNumerList() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN_NUM, RNAGE_MAX_NUM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
