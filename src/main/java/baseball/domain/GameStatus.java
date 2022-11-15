package baseball.domain;


import java.util.Arrays;

public enum GameStatus {

    PROGRESS("0"),
    RESTART("1"),
    EXIT("2");

    private final String number;

    GameStatus(final String number) {
        this.number = number;
    }

    public static boolean hasValue(String num) {
        return Arrays.stream(GameStatus.values())
                .anyMatch(x -> x.number().equals(num));
    }

    public static boolean isRestart(String input) {
        return input.equals(RESTART.number);
    }

    public static boolean isExit(String input) {
        return input.equals(EXIT.number);
    }

    public String number() {
        return number;
    }
}
