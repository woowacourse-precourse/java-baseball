package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import static baseball.enums.ErrorMessage.BLANK_INPUT;

public class GameConsole {
    private GameConsole() {
    }

    private static class LazyHolder {
        private static final GameConsole INSTANCE = new GameConsole();
    }

    public static GameConsole getInstance() {
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
            throw new IllegalArgumentException(BLANK_INPUT.message());
        }
    }
}
