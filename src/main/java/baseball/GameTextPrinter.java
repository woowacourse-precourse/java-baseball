package baseball;

import java.util.Map;

public class GameTextPrinter {
    private static final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    private static final String USER_INPUT_TEXT = "숫자를 입력해주세요 : ";
    private static final String GAME_OVER_TEXT = "개의 숫자를 모두 맞히셨습니다. 게임 종료\n"
            + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printGameStartText() {
        System.out.println(GAME_START_TEXT);
    }

    public static void printUserInputText() {
        System.out.print(USER_INPUT_TEXT);
    }

    public static void printNoting(String noting) {
        System.out.println(noting);
    }

    public static void printCompareResult(Map<String, Integer> result) {
        result.keySet().stream().filter(baseballLingo -> result.get(baseballLingo) > 0).sorted()
                .forEach(baseballLingo -> System.out.print(result.get(baseballLingo) + baseballLingo + " "));
        System.out.println();
    }

    public static void printGameOverText(int requiredStrikeCount) {
        System.out.println(requiredStrikeCount + GAME_OVER_TEXT);
    }
}
