package baseball.game.config;

public class constants {
    public static class GameManagerMessage{
        public static final String ASK_GAME_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    }

    public static class GameMessage{
        public static final String THREE_OUT_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String REQUEST_NUMBER = "숫자를 입력해주세요 : ";
    }

    public static class IntegerValidatorMessage{
        public static final String NOT_IN_OPTION = "선택 옵션에 없는 숫자입니다.";
        public static final String SIZE_ERROR = "자리 숫자만 입력할 수 있습니다.";
        public static final String FORBID_DUPLICATED = "중복된 숫자를 포함할 수 없습니다.";
    }

    public static class StringConverterMessage{
        public static final String ONLY_ONE_WORD_LIMIT = "1글자만 입력할 수 있습니다.";
        public static final String ONLY_NUMBER = "숫자만 입력할 수 있습니다.";
    }
}
