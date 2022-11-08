package baseball.constValue;

public final class Constants {


    public static final int MIN_RANGE_NUMBER=1;
    public static final int MAX_RANGE_NUMBER = 9;
    public static final int COMPUTER_NUMBER_SIZE=3;
    public static final int BALL_LEN=3;

    public class RestartOrExitInfo {
        public static final String RESTART_NUMBER = "1";
        public static final String EXIT_NUMBER = "2";
    }


    public class ExceptionMessage{
        public static final String RESTART_INPUT_ERROR_MESSAGE = "재시작 여부 숫자는 1,2만 가능합니다.";
        public static final String INPUT_NUM_OR_SIZE_ERROR_MESSAGE = "야구 게임은 3자리의 숫자만 가능합니다.";
        public static final String INPUT_DUPLICATE_ERROR_MESSAGE = "입력된 숫자가 중복입니다.";
    }

    public class InputMessage {
        public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
        public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    }

    public class OutputMessage {
        public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    }


}
