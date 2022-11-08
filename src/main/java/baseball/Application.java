package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;



public class Application {
    private static final String GAME_RESTART = "1";
    private static final String GAME_END = "2";


    public static boolean isExit(String command) {
        if (command.equals(GAME_RESTART)) {
            return false;
        }
        if (command.equals(GAME_END)) {
            return true;
        }

        GameMessagePrinter.printInvalidInput();
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        GameSystem game = new GameSystem();
        String command;

        do {
            GameMessagePrinter.printGameStart();
            game.run();
            GameMessagePrinter.printGameWin();

            command = readLine();
        } while(!isExit(command));
    }
}
