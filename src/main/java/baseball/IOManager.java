package baseball;

import java.util.Map;

public class IOManager {
    private static final Map<String, String> messages = Map.of(
            "PROGRAM_START", "숫자 야구 게임을 시작합니다."
    );
    public static void printProgramStartMessage() {
        System.out.println(messages.get("PROGRAM_START"));
    }
}
