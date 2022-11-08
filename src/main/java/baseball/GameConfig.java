package baseball;

import java.util.Map;

public class GameConfig {
    public static final int ANSWER_LEN = 3;

    public static final Map<String, String> messages = Map.of(
            "PROGRAM_START", "숫자 야구 게임을 시작합니다.\n",
            "REQUIRE_INPUT", "숫자를 입력해주세요 : ",
            "CORRECT_ANSWER", "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n",
            "ASK_RESTART", "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"
    );
}
