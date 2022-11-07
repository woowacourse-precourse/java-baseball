package baseball.util;

import java.util.Arrays;
import java.util.List;

public interface Constant {
    String BLANK = " ";
    String NEWLINE = "\n";

    String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다." + NEWLINE;
    String USER_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    String THREE_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + NEWLINE;
    String GAME_RESTART_OR_TERMINATE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + NEWLINE;
    String STRIKE_MESSAGE = "스트라이크";
    String BALL_MESSAGE = "볼";
    String NOTHING_MESSAGE = "낫싱";

    int GAME_RESTART_VALUE = 1;
    int GAME_TERMINATE_VALUE = 2;
    int NUMBER_LENGTH = 3;
    int MIN_NUMBER_VALUE = 1;
    int MAX_NUMBER_VALUE = 9;

    int BALL_INDEX = 0;
    int STRIKE_INDEX = 1;

    List<Integer> THREE_STRIKE = Arrays.asList(0, 3);

    String EXCEPTION_INVALID_INPUT = "올바르지 않은 입력입니다.";
    String EXCEPTION_INVALID_NUMBER = "숫자 형식이 올바르지 않습니다.";
}
