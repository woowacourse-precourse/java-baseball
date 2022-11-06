package baseball.values;

public class Constant {
    public static class Hint {
        public static final String NOTING = "낫싱";
        public static final String STRIKE = "스트라이크";
        public static final String BALL = "볼";
        public static final String SPACE = " ";
    }

    public static class Console {
        public static final String START_GAME = "숫자 야구 게임을 시작합니다.";
        public static final String END_GAME = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String ASK_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        public static final String RESTART = "1";
    }

    public static class Digit {
        public static final int TOTAL_BALL_CNT = 3;
        public static final int MAX_STRIKE_CNT = 3;
    }
}
