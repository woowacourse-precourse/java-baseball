package baseball;

import baseball.cli.ConsoleReader;
import baseball.cli.ConsoleWriter;
import baseball.domain.NumberBaseball;
import baseball.utils.Validator;

public class Application {
    public static void main(String[] args) {
        NumberBaseball game = new NumberBaseball();
        ConsoleWriter.printHeader();
        while (true) {
            startGame(game);
            if (!isResumed())
                break;
            game.resetGame();
        }
    }

    private static void startGame(NumberBaseball game) {
        while (true) {
            ConsoleWriter.printInputPhrase();
            String userNumber = ConsoleReader.readString();
            Validator.validateUserNumber(userNumber);
            game.compareComputerNumberWith(userNumber);
            ConsoleWriter.printGameResult(game.getGameResult());

            if (game.isEnd()) {
                ConsoleWriter.printFooter();
                break;
            }
        }
    }

    private static boolean isResumed() {
        String input = ConsoleReader.readString();
        Validator.validateResumeNumber(input);
        if (input.equals("1"))
            return true;
        return false;
    }
}
