package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private static final int NUMBERS_SIZE = 3;
    private static List<Integer> numbers;
    public static void start() {
        initialize();
    }

    private static void initialize() {
        generateNumbers();
    }

    private static void generateNumbers() {
        numbers = new ArrayList<>();

        while (numbers.size() < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
