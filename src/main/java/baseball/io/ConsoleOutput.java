package baseball.io;

public class ConsoleOutput implements Output {
    private static final String START_TEXT = "숫자 야구 게임을 시작합니다.";

    @Override
    public void printStartText() {
        System.out.println(START_TEXT);
    }
}
