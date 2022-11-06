package baseball;

import java.util.HashMap;
import java.util.StringJoiner;
import java.util.function.Consumer;

public enum Messages{

    ASK("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    INIT("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : ", System.out::print);

    private final String message;
    private final Consumer<String> printer;

    Messages(String message) {
        this.message = message;
        this.printer = System.out::println;
    }
    Messages(String message, Consumer<String> printer) {
        this.message = message;
        this.printer = printer;
    }

    public void printMessage() {
        this.printer.accept(this.message);
    }

    public static void printScore(HashMap<Result, Integer> turnResult) {
        int balls = turnResult.getOrDefault(Result.BALL, 0);
        int strikes = turnResult.getOrDefault(Result.STRIKE, 0);

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
}
