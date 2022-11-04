package baseball;

import java.util.StringJoiner;
import java.util.function.Consumer;

class Printer{
    public static final Consumer<String> PRINTLN = System.out::println;
    public static final Consumer<String> PRINT = System.out::print;
}

public enum Messages {

    ASK(Printer.PRINTLN,
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END(Printer.PRINTLN,
            "3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INIT(Printer.PRINTLN,
            "숫자 야구 게임을 시작합니다."),
    INPUT(Printer.PRINT,
            "숫자를 입력해주세요 : ");

    private final Consumer<String> printer;
    private final String message;

    Messages(Consumer<String> printer, String message) {
        this.printer = printer;
        this.message = message;
    }

    public void printMessage() {
        this.printer.accept(this.message);
    }

    public static void printScore(int balls, int strikes) {
        StringJoiner baseString = new StringJoiner(" ");
        if (balls != 0) {
            baseString.add(String.format("%d볼", balls));
        }
        if (strikes != 0) {
            baseString.add(String.format("%d스트라이크", strikes));
        }
        if (baseString.length() == 0) {
            baseString.add("낫싱");
        }
        System.out.println(baseString);
    }

    public static void main(String[] args) {
        Messages.INPUT.printMessage();
        Messages.END.printMessage();
        Messages.ASK.printMessage();
    }
}
