package baseball;

import static baseball.Player.DIGIT;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StateCode {

    final static int DIGIT = 3;

    final static int GAME_PLAYING = 1;
    final static int GAME_END = 2;
    final static HashSet<Integer> GAME_STATES = new HashSet<>(Arrays.asList(GAME_PLAYING, GAME_END));

    final static int ERROR_OUT_OF_DIGIT = 0;
    final static int ERROR_DUPLICATE_BALL = 1;
    final static int ERROR_INVALID_BALL = 2;
    final static int ERROR_NOT_INTEGER = 3;
    final static int ERROR_NONE_EXIST_GAME_STATE = 4;

    final static HashMap<Integer, String> ERRORS = new HashMap<>() {{
        put(ERROR_OUT_OF_DIGIT, "[Input] 입력의 길이는 "+DIGIT+"만 가능");
        put(ERROR_DUPLICATE_BALL, "[Input] 서로 다른 숫자만 입력 가능");
        put(ERROR_INVALID_BALL, "[Input] 1~9 사이 숫자만 입력 가능");
        put(ERROR_NOT_INTEGER, "[Input] Integer가 아닙니다.");
        put(ERROR_NONE_EXIST_GAME_STATE, "[INPUT] GAME - STATES에 존재하지 않는 상태입니다.");

    }};

    public void ThrowError(int ErrorState){
        throw new IllegalArgumentException(ERRORS.get(ErrorState));
    }

}
