package baseball.printer;

public class StartMessagePrinter implements MessagePrinter {

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    @Override
    public void printMessage() {
        System.out.println(START_MESSAGE);
    }
}
