package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NUM_START_RANGE = 1;
    private static final int NUM_END_RANGE = 9;
    private final List<Integer> randomNum;

    public Game() {
        randomNum = generateRandomNumber(NUM_START_RANGE, NUM_END_RANGE);
    }

    /**
     * Generates 3-digit random number with no duplicate digit
     * @param start 랜덤 숫자 생성 범위 시작점
     * @param end 랜덤 숫자 생성 범위 끝점
     * @return numbers 랜덤하게 생성한 3자리 수가 들어있는 ArrayList
     */
    static List<Integer> generateRandomNumber(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(start, end);
            if (!numbers.contains(randomNum))
                numbers.add(randomNum);
        }
        return numbers;
    }
}
