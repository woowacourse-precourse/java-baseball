package baseball.printer;

public class NumberInputMessagePrinter implements MessagePrinter {


    public static final String NUMBER_INPUT_MESSAGE = "숫자를 압력해주세요 : ";

    @Override
    public void printMessage() {
        System.out.print(NUMBER_INPUT_MESSAGE);
    }
}
