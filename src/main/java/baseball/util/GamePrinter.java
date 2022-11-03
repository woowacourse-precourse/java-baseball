package baseball.util;

public class GamePrinter {

    private static final GamePrinter gamePrinter = new GamePrinter();

    private GamePrinter() {
    }

    public static GamePrinter getInstance() {
        return GamePrinter.gamePrinter;
    }

    public void print(String message) {
        System.out.print(message);
    }

    public void println(String message) {
        System.out.println(message);
    }

}
