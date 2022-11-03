package baseball.util;

import java.util.Scanner;

public class GameScanner {

    private static final GameScanner gameScanner = new GameScanner();
    private final Scanner scanner = new Scanner(System.in);

    private GameScanner() {
    }

    public static GameScanner getInstance() {
        return GameScanner.gameScanner;
    }

    public String next() {
        return scanner.next();
    }
}
