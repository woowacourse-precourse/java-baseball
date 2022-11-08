package baseball.util;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class Constant {
    public static int RESTART_NUMBER = 1;   // 재시작 명령어
    public static int STOP_NUMBER = 2;  // 멈춤 명령어
    public static int LENGTH_OF_NUMBER = 3; // 정답의 길이
    public static int ANSWER_MIN_DIGIT = 1; // 정답 숫자 범위 중 작은 값
    public static int ANSWER_MAX_DIGIT = 9; // 정답 숫자 범위 중 큰 값
    public static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static String FINISH_MESSAGE = LENGTH_OF_NUMBER + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String RESTART_COMMENT = "게임을 새로 시작하려면 "+ RESTART_NUMBER +", 종료하려면 "+ STOP_NUMBER +"를 입력하세요.";
}
