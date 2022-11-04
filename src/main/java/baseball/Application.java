package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;



public class Application {
    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";


    public static boolean isExit(String command) {
        if (command.equals(RESTART_GAME)) {
            return false;
        }
        if (command.equals(END_GAME)) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        GameSystem game = new GameSystem();
        String command;

        do {
            GameMessagePrinter.printStart();
            game.run();
            GameMessagePrinter.printGameWin();

            command = readLine();
        } while(!isExit(command));
    }
}
