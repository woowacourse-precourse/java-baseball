package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static baseball.Result.*;
import static baseball.Trial.*;

public class Game {
    private static final int NUMBERS_SIZE = 3;
    private static Map<Integer, Integer> numbersMap;
    public static void start() {
        // 1. 게임을 시작할 때 3자리 숫자를 생성
        generateNumbers();

        // 2. 3 스트라이크 일때 까지 게임을 진행
        proceed();
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

    private static void proceed() {
        Result result = NOTHING;

        while (result != THREESTRIKE) {
            result = getResultByScore(getScore(numbersMap, inputNumbers()));
            System.out.println(result.getMessage());
        }
    }
}
