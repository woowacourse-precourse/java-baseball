package baseball.game;

public class EndGame {
    private static final Integer RESTART = 1;
    private static final Integer END = 2;

    public static Boolean isRestart(Integer userInput) {

        checkInputRange(userInput);
        return userInput == RESTART;
    }

    private static void checkInputRange(Integer input) {

        if (input != RESTART && input != END) {
            throw new IllegalArgumentException("Argument length out of range");
        }
    }
}
