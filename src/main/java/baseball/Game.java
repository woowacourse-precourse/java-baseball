package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashMap;
import java.util.Map;

import static baseball.Result.*;
import static baseball.Status.*;
import static baseball.Trial.*;

public class Game {
    private static final int NUMBERS_SIZE = 3;
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String FINISH_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String EXIT_MESSAGE = "게임이 종료되었습니다.";
    private static Status status;
    private static Map<Integer, Integer> numbersMap;
    public static void start() {
        try {
            System.out.println(START_MESSAGE);
            status = RUNNING;

            while (status == RUNNING) {
                // 1. 게임을 시작할 때 3자리 숫자를 생성
                generateNumbers();
                System.out.println(numbersMap);
                // 2. 3STRIKE 일때 까지 게임을 진행
                proceed();

                // 3. 게임을 종료하고 재시작 여부를 판단
                finish();
            }

            System.out.println(EXIT_MESSAGE);

        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            throw new IllegalArgumentException();
        }
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

        System.out.println(THREE_STRIKE_MESSAGE);
    }

    private static void finish() {
        System.out.println(FINISH_MESSAGE);

        status = getStatusByOption(inputRestartOption());
    }
}
