package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GenerateGameNumber {
    private static final int RANGE_MIN_NUM = 1;
    private static final int RNAGE_MAX_NUM = 9;

    private static final int GAME_MIN_NUM = 0;
    private static final int GAME_MAX_NUM = 3;

    private static List<Integer> computerNumber = new ArrayList<>();

    public void GenerateGameNumber() {
    }

    public List<Integer> getGenerateNumerList() {
        while(computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_MIN_NUM, RNAGE_MAX_NUM);
            if(!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        return computerNumber;
    }
}
