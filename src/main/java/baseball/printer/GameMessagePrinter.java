package baseball.printer;

public class GameMessagePrinter {

    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 압력해주세요 : ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printNumberInputMessage() {
        System.out.println(NUMBER_INPUT_MESSAGE);
    }
}
