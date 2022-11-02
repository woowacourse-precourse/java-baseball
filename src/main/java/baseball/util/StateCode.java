package baseball.util;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class StateCode {

    final public static int DIGIT = 3;

    final public static int GAME_PLAYING = 1;
    final public static int GAME_END = 2;
    final public static HashSet<Integer> GAME_STATES = new HashSet<>(Arrays.asList(GAME_PLAYING, GAME_END));


    final public static int ERROR_INCORRECT_LENGTH_DIGIT = 0;
    final public static int ERROR_DUPLICATE_BALL = 1;
    final public static int ERROR_INVALID_BALL = 2;
    final public static int ERROR_INVALID_INPUT = 3;
    final public static int ERROR_NONE_EXIST_GAME_STATE = 4;

    final static HashMap<Integer, String> ERRORS = new HashMap<>() {{
        put(ERROR_INCORRECT_LENGTH_DIGIT, "[Input] 입력의 길이는 "+DIGIT+"만 가능");
        put(ERROR_DUPLICATE_BALL, "[Input] 서로 다른 숫자만 입력 가능");
        put(ERROR_INVALID_BALL, "[Input] 1~9 사이 숫자만 입력 가능");
        put(ERROR_INVALID_INPUT, "[Input] 올바르지 않은 Input입니다.");
        put(ERROR_NONE_EXIST_GAME_STATE, "[INPUT] GAME - STATES에 존재하지 않는 상태입니다.");
    }};


    public static void ThrowError(int ErrorState){
        throw new IllegalArgumentException(ERRORS.get(ErrorState));
    }

}
