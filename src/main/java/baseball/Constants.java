package baseball;

public class Constants {
    public static final int RESTART_NUM = 1;
    public static final int END_NUM = 2;
    public static final int GAME_INPUT_LENGTH = 3;
    public static final int RESTART_INPUT_LENGTH = 1;

    public static class Message {
        public static final String START_MSG = "숫자 야구 게임을 시작합니다.";
        public static final String INPUT_MSG = "숫자를 입력해주세요 : ";
        public static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String RESTART_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        public static final String ERROR_MSG = "잘못된 입력입니다.";
    }

    public static class Result {
        public static final String BALL_WORD = "볼";
        public static final String STRIKE_WORD = "스트라이크";
        public static final String NOTHING_WORD = "낫싱";
    }
}