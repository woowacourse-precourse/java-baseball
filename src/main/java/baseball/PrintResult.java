package baseball;

public class PrintResult {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printLine(String line) {
        System.out.println(line);
    }
}
