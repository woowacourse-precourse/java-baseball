package baseball.game.number;

import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbers {
    private static int head;
    private static int middle;
    private static int tail;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    public static List<Integer> createThreeRandomNumbers() {
        head = createRandomNumbers();
        middle = createRandomNumbers(List.of(head));
        tail = createRandomNumbers(List.of(head, middle));

        return List.of(head, middle, tail);
    }

    public static int createRandomNumbers() {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public static int createRandomNumbers(List<Integer> existedNumberList) {
        int candidateNumber = createRandomNumbers();
        while (isUniqueNumber(candidateNumber, existedNumberList)) {
            candidateNumber = createRandomNumbers();
        }
        return candidateNumber;
    }

    public static boolean isUniqueNumber(int candidateNumber, List<Integer> existedNumberList) {
        return existedNumberList.contains(candidateNumber);
    }
}
