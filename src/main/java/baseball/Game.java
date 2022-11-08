package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private static final int NUMBERS_SIZE = 3;
    private static Map<Integer, Integer> numbersMap;
    public static void start() {
        initialize();
    }

    private static void initialize() {
        generateNumbers();
    }

    private static void generateNumbers() {
        int index = 0;
        numbersMap = new HashMap<>();

        while (index < NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbersMap.containsKey(randomNumber)) {
                numbersMap.put(randomNumber, index++);
            }
        }
    }
}
