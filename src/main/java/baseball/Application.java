package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Application {

    private static final String GAME_START_SIGN = "숫자 야구 게임을 시작합니다.";
    private static final int START_VALUE = 1;
    private static final int END_VALUE = 9;
    private static final int NUMBER_COUNT = 3;

    public static void main(String[] args) {
        notifyGameStart();
        List<Integer> computerNumbers = createComputerNumbers();
    }

    public static List<Integer> createComputerNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_VALUE, END_VALUE, NUMBER_COUNT);
    }

    public static void notifyGameStart() {
        System.out.println(GAME_START_SIGN);
    }
}
