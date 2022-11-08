package baseball;

import java.util.List;
import java.util.Objects;

public class Game {
    public static boolean isRestart = false;
    public static boolean isRepeat = false;
    public static final String RESTART_GAME_FLAG = "1";
    public static final String END_GAME_FLAG = "2";

    enum GuideMessage {
        START("숫자 야구 게임을 시작합니다."),
        END("게임 종료"),
        INPUT("숫자를 입력해주세요 : "),
        ANSWER(String.format("%d개의 숫자를 모두 맞히셨습니다!", Number.MAX_SIZE)),
        REPEAT(String.format("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.", RESTART_GAME_FLAG, END_GAME_FLAG));

        private final String message;
        GuideMessage(String message) { this.message = message; }
    }

    public static void start() {

    }

    public static void end() {

    }

    public static void checkRestart(String flag) {

    }

    public static void printCongratsMessage() {

    }

    public static void printInputMessage() {

    }

    public static void printRepeatMessage() {

    }

}
