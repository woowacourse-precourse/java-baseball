package baseball.core;

import baseball.type.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameInitializer {

    private static final int DEFAULT_VALUE_OF_BALL = 0;
    private static final int DEFAULT_VALUE_OF_STRIKE = 0;

    protected static BaseballNumber initBaseballNumber() {
        return new BaseballNumber(createTargetNumber());
    }

    protected static GameStatusOperator initGameStatusOperator() {
        return new GameStatusOperator(GameStatus.START, DEFAULT_VALUE_OF_BALL, DEFAULT_VALUE_OF_STRIKE);
    }

    // TODO : distinct digits을 만들기 위한 깔끔한 로직 필요
    // 정답 숫자 생성 (서로 다른 3개의 숫자)
    private static String createTargetNumber() {
        List<Integer> listOfDigits = new ArrayList<>();
        String targetNumber;
        while (listOfDigits.size() != 3) {
            int digit = Randoms.pickNumberInRange(1, 9);
            if (!listOfDigits.contains(digit)) listOfDigits.add(digit);
        }
        targetNumber = listOfDigits.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());

        return targetNumber;
    }
}
