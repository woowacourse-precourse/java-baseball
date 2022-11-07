package baseball;

import java.util.ArrayList;
import java.util.List;

public class ConstantAndMessage {

    public static final int NUMBER_LENGTH = 3;
    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 9;
    public static final List<Integer> ALLOWED_INPUT_NUMBERS = allowedNumbers();
    private static List<Integer> allowedNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = START_NUMBER; i <= END_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String GETTING_USER_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_END_MESSAGE = NUMBER_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
}
