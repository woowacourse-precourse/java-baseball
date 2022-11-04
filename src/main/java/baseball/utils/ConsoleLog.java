package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import static baseball.enums.ErrorMessage.IS_BLANK;

public class ConsoleLog {
    private ConsoleLog() {
    }

    private static class LazyHolder {
        private static final ConsoleLog INSTANCE = new ConsoleLog();
    }

    public static ConsoleLog getInstance() {
        return LazyHolder.INSTANCE;
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

    public String input() {
        try {
            return Console.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException(IS_BLANK.message());
        }
    }
}
