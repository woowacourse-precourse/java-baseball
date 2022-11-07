package baseball.domain;


import java.util.Arrays;

public enum Command {

    RESTART("1"),
    EXIT("2");

    private final String number;

    Command(final String number) {
        this.number = number;
    }

    public static boolean hasValue(String num) {
        return Arrays.stream(Command.values())
                .anyMatch(x -> x.commandNum().equals(num));
    }

    public static boolean isExit(String input) {
        return input.equals(EXIT.number);
    }

    public static boolean isRestart(String input) {
        return input.equals(RESTART.number);
    }

    public String commandNum() {
        return number;
    }
}
