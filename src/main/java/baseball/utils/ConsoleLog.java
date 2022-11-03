package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

import static baseball.enums.ErrorMessage.IS_BLANK;

public class ConsoleLog {
    private static ConsoleLog instance;

    private ConsoleLog() {
    }

    public static ConsoleLog getInstance() {
        if(Objects.isNull(instance)) {
            instance = new ConsoleLog();
        }
        return instance;
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
